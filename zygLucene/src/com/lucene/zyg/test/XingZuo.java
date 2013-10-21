package com.lucene.zyg.test;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.HasChildFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

public class XingZuo {
	public static void main(String[] args) {
		try {
			while (true) {
				String output;
				String str = "http://astro.sina.com.cn/pc/west/frame0_";
				String input = javax.swing.JOptionPane
						.showInputDialog("������ַhttp://astro.sina.com.cn/pc/west/frame0_7.html\n"
								+ "����0��11֮�������\n"
								+ "0���������\n1�����ţ��\n2����˫����\n3�����з��\n4����ʨ����\n5����Ů��"
								+ "\n6���������\n7������Ы��\n8����������\n9����ħ����\n10����ˮƿ��\n11����˫����");
				str += input + ".html";

				Parser parser = new Parser(str);
				parser.setEncoding("gb2312");
				NodeFilter filter = new AndFilter(new TagNameFilter("span"),
						new HasChildFilter(new TagNameFilter("em")));
				NodeList nodeList = parser.parse(filter);
				Node node = nodeList.elementAt(0);

				// System.out.println(node.toHtml());//<span>������<em>11/23 -
				// 12/21</em></span>
				// System.out.println(node.getFirstChild().toHtml());//������
				// System.out.println(node.getFirstChild().getNextSibling().getNextSibling().toHtml());//11/23
				// - 12/21
				// System.out.println(node.getChildren().elementAt(0).toHtml());//������
				// System.out.println(node.getChildren().elementAt(1).toHtml());//<em>
				// System.out.println(node.getChildren().elementAt(2).toHtml());//11/23
				// - 12/21
				// System.out.println(node.getChildren().elementAt(3).toHtml());//</em>

				String title = node.getFirstChild().toHtml()
						+ " "
						+ node.getFirstChild().getNextSibling()
								.getNextSibling().toHtml();
				// System.out.println(title);
				output = title + "\n";
				filter = new AndFilter(new NodeFilter[] {
						new TagNameFilter("div"),
						new HasAttributeFilter("class", "tab"),
						new HasChildFilter(new TagNameFilter("h4")) });

				parser.reset();
				nodeList = parser.parse(filter);
				int num;
				for (int i = 0; i < 4; i++) {
					node = nodeList.elementAt(i);
					// System.out.print(node.getChildren().elementAt(0).getFirstChild().toHtml()+":");
					output += node.getChildren().elementAt(0).getFirstChild()
							.toHtml()
							+ ":";
					output += node.getChildren().elementAt(1).getChildren()
							.size()
							+ "\n";
				}
				
				for (int i = 4; i < nodeList.size() - 1; i++) {

					// System.out.println(node.getChildren().elementAt(1).getFirstChild().toHtml());
					node = nodeList.elementAt(i);
					output += node.getChildren().elementAt(0).getFirstChild()
							.toHtml()
							+ ":";
					output += node.getChildren().elementAt(1).getFirstChild()
							.toHtml()
							+ "\n";
				}

				filter = new AndFilter(new TagNameFilter("div"),
						new HasAttributeFilter("class", "lotconts"));
				parser.reset();
				nodeList = parser.parse(filter);
				node = nodeList.elementAt(0);
				// System.out.print(node.getFirstChild().toHtml());
				// System.out.println(node.getChildren().elementAt(2).toHtml());
				output += node.getFirstChild().toHtml()
						+ node.getChildren().elementAt(2).toHtml() + "\n";
				javax.swing.JOptionPane.showMessageDialog(null, output, "���",
						javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
