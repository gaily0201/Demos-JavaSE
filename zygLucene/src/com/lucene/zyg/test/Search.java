package com.lucene.zyg.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TermDocs;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

//import org.apache.lucene.search.Query;

//import org.apache.lucene.search.TermQuery;

public class Search {

	public void indexSearch2(String IndexPath, String searchType,
			String searchKey) throws Exception{
		try {
			// ��������λ�ý���IndexSearcher
			IndexSearcher searcher = new IndexSearcher(IndexPath);
			// ʹ�ñ�׼������
			Analyzer aStandardAnalyzer = new StandardAnalyzer();
			// ����Query����
			QueryParser parser = new QueryParser(searchType, aStandardAnalyzer);
			Query query = parser.parse(searchKey);
			
			// ���Ҫ����������
			System.out.println("����:" + query.toString(searchType));
			
			// ������ʼʱ��
			Date beginTime = new Date();
			
			// ʹ��searcher�����search�����������������ص���һ��Hits���͵Ķ���
			Hits hits = searcher.search(query);
			// ʹ��Hits�����length����������������������ĵ�������
			System.out.println("�ܹ��ҵ� " + hits.length() + " ���ĵ�");
			
			for (int i = 0; i < hits.length(); i++) {
				// ȡ����������е�һ���ĵ�����
				Document doc = hits.doc(i);
				// ����ĵ���ID���
				System.out.println("�ĵ����ڲ�ID��:" + hits.id(i));
				// ����ĵ�������
				System.out.println("�ĵ��ķ�ֵ:" + hits.score(i));
				// ����ĵ�������
				String content = doc.get("content");
				if (content != null) {
					System.out.println("����Ϊ��" + content);
				}
				System.out.println("******************************************");
			}
		
			// �������ʱ��
			Date endTime = new Date();
			// ��������ʱ��
			long timeOfSearch = endTime.getTime() - beginTime.getTime();
			System.out.println("The time For indexsearch is " + timeOfSearch
					+ " ms");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void indexSearch(String IndexPath, String searchType,
			String searchKey) {
		try {
			// ��������λ�ý���IndexSearcher
			IndexSearcher searcher = new IndexSearcher(IndexPath);
			// ����������Ԫ��searchType����Ҫ������Filed��searchKey����ؼ���
			Term t = new Term(searchType, searchKey);

			System.out.println(t.toString());
			// ��Term����һ��Query
			//Query q = new TermQuery(t);

			// ������ʼʱ��
			Date beginTime = new Date();
			// ��ȡһ��<document, frequency>��ö�ٶ���TermDocs
			TermDocs termDocs = searcher.getIndexReader().termDocs(t);

			while (termDocs.next()) {
				// ������ĵ��г��ֹؼ��ʵĴ���
				System.out.println(termDocs.freq());
				// ����������ؼ��ʵ��ĵ�
				System.out.println(searcher.getIndexReader().document(
						termDocs.doc()));
			}

			// �������ʱ��
			Date endTime = new Date();
			// ��������ʱ��
			long timeOfSearch = endTime.getTime() - beginTime.getTime();
			System.out.println("The time For indexsearch is " + timeOfSearch
					+ " ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buildIndex(String SrcFilePath, String IndexPath)
			throws Exception {
		Document doc1 = new Document();
		doc1.add(new Field("title", "�߳��������", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc1.add(new Field("content", "��Ҫ�߳����������", Field.Store.YES,
				Field.Index.TOKENIZED));
		
		Document doc2 = new Document();
		doc2.add(new Field("title", "������߳��������", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc2.add(new Field("content", "�����Ҫ�߳����������", Field.Store.YES,
				Field.Index.TOKENIZED));
		
		//System.out.println("SrcFilePath:"+SrcFilePath);
		
		IndexWriter idxWriter = new IndexWriter(IndexPath,
				new StandardAnalyzer(), true);
		
		idxWriter.addDocument(doc1);
		idxWriter.addDocument(doc2);
		
		idxWriter.optimize();
		idxWriter.close();
	}

	public void StringSearch(String keyword, String searchDir) {
		File filesDir = new File(searchDir);
		// ����Ŀ¼�ļ��������ļ�����
		File[] files = filesDir.listFiles();
		System.out.println("�ļ�������"+files.length);
		// HashMap�����ļ�����ƥ�������
		Map rs = new HashMap();
		// ��¼������ʼʱ��
		Date beginTime = new Date();
		// ���������ļ�

		for (int i = 0; i < files.length; i++) {
			// ��ʼ��ƥ�����
			int hits = 0;
			try {
				//System.out.println(files[i].toString());
				// ��ȡ�ļ�����
				BufferedReader br = new BufferedReader(new FileReader(files[i]));
				StringBuffer sb = new StringBuffer();
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					line = br.readLine();
				}
				br.close();

				// ��StringBufferת����String���Ա�������
				String stringToSearch = sb.toString();
				//System.out.println(stringToSearch);
				// ��ʼ��fromIndex
				int fromIndex = -keyword.length();
				// ���ƥ��ؼ���
				while ((fromIndex = stringToSearch.indexOf(keyword, fromIndex+ keyword.length())) != -1) {
					hits++;
				}
				// ���ļ�����ƥ���������HashMap
				rs.put(files[i].getName(), new Integer(hits));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// �����ѯ���
		Iterator it = rs.keySet().iterator();
		while (it.hasNext()) {
			String fileName = (String) it.next();
			Integer hits = (Integer) rs.get(fileName);
			System.out.println("find " + hits.intValue() + " matches in "

			+ fileName);
		}

		// ��¼����ʱ��
		Date endTime = new Date();
		// �õ������ķ�ʱ��
		long timeOfSearch = endTime.getTime() - beginTime.getTime();
		System.out.println("The time For string search is " + timeOfSearch
				+ " ms");
	}
}
