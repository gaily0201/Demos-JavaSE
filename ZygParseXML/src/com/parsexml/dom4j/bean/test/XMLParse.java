package com.parsexml.dom4j.bean.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLParse {

	protected static Logger log = Logger
			.getLogger(XMLParse.class.getName());

	/**
	 * ��ȡ�����ļ��е���Ϣ��������Ϣ����map��
	 */
	public static Map<String, Bean> readXmlFile(String fileName) {
		
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(
				fileName).getPath());
		
		// ��ô���classpath·�����ļ�·��
		fileName = Thread.currentThread().getContextClassLoader().getResource(
				fileName).getPath().substring(1);
		System.out.println("fileName:"+fileName);
		
		log.info("Loading XML bean definitions from file [" + fileName + "]");

		// ��ȡ������ݷŵ����map��
		Map<String, Bean> beansMap = new HashMap<String, Bean>();

		// ���ļ�
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new File(fileName));
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}

		// ��λ���е�bean
		Iterator<?> beanIterator = doc.getRootElement().elementIterator("bean");
		while (beanIterator.hasNext()) {
			Element beanElm = (Element) beanIterator.next();

			// ÿ��bean����Ϣ�ŵ�һ��Bean��
			Bean bean = new Bean();
			String beanId = beanElm.attribute("id").getStringValue();
			String beanType = beanElm.attribute("class").getStringValue();
			bean.setId(beanId);
			bean.setType(beanType);

			Iterator<?> beanProperties = beanElm.elementIterator("bean");
			while (beanProperties.hasNext()) {
				Element beanProperty = (Element) beanProperties.next();
				String name = beanProperty.attributeValue("name");

				// �������ͨ��ֵ value��ʽ
				if (beanProperty.attribute("value") != null) {
					String value = beanProperty.attributeValue("value");
					bean.getProperties().put(name, value);
				}

				// �������������һ��bean��ֵ ref��ʽ
				if (beanProperty.attribute("ref") != null) {
					String[] refString = new String[] { beanProperty
							.attributeValue("ref") };
					bean.getProperties().put(name, refString);
				}

				// ����� List ��ʽ������ ֻ֧��String �� javabean ��ʽ�� List
				if (beanProperty.element("list") != null) {
					List<Object> valuesList = new ArrayList<Object>();
					Element listElement = (Element) beanProperty.elements()
							.get(0);
					Iterator<?> valuesIterator = listElement.elements()
							.iterator();
					while (valuesIterator.hasNext()) {
						Element value = (Element) valuesIterator.next();
						if (value.getName().equals("value")) {
							valuesList.add(value.getText());
						}
						if (value.getName().equals("ref")) {
							valuesList.add(new String[] { value
									.attributeValue("bean") });
						}
					}
					bean.getProperties().put(name, valuesList);
				}

				// ����� map��ʽ��
				if (beanProperty.element("map") != null) {
					Map<String, Object> propertiesMap = new HashMap<String, Object>();
					Element propertiesListMap = (Element) beanProperty
							.elements().get(0);
					Iterator<?> propertiesIterator = propertiesListMap
							.elements().iterator();
					while (propertiesIterator.hasNext()) {
						Element vet = (Element) propertiesIterator.next();
						if (vet.getName().equals("entry")) {
							String key = vet.attributeValue("key");
							Iterator<?> valuesIterator = vet.elements()
									.iterator();
							while (valuesIterator.hasNext()) {
								Element value = (Element) valuesIterator.next();
								if (value.getName().equals("value")) {
									propertiesMap.put(key, value.getText());
								}
								if (value.getName().equals("ref")) {
									propertiesMap.put(key, new String[] { value
											.attributeValue("bean") });
								}
							}
						}
					}
					bean.getProperties().put(name, propertiesMap);
				}
			}
			beansMap.put(beanId, bean);
		}
		return beansMap;
	}
}
