package com.lucene.zyg.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;

/**
 * 
 * @author Administrator
 * hits�Ĳ���
 *
 */
public class HitsTest {
	public static String IndexPath = "D:\\TestLucene\\index2";
	
	public static void main(String[] args) throws Exception {
		// ��������
		buildIndex();
		// ʹ���Ѿ���������Ŀ¼
		Searcher searcher = new IndexSearcher(IndexPath);
		// ʹ�ñ�׼������
		Analyzer aStandardAnalyzer = new StandardAnalyzer();
		// �ӱ�׼�����ȡ��ѯ���ַ���
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out
					.println("-------------------------------------------------");
			System.out.print("Query: ");
			String line = in.readLine();
			// �ж��Ƿ�ֱ������Ļس�
			if (line.length() == 0)
				break;
			// ����Query����
			QueryParser parser = new QueryParser("contents", aStandardAnalyzer);
			Query query = parser.parse(line);
			// ���Ҫ����������
			System.out.println("���� :    " + query.toString("contents"));
			// ʹ��searcher�����search�����������������ص���һ��Hits���͵Ķ���
			Hits hits = searcher.search(query);
			// ʹ��Hits�����length����������������������ĵ�������
			System.out.println("�ܹ��ҵ� " + hits.length() + " ���ĵ�");
			// ����ÿ����ʾ�����������Ŀ
			final int HITS_PER_PAGE = 10;
			// ѭ�����,��ҳ��ʾ
			System.out.println("hits.length:" + hits.length());
			
			for (int start = 0; start < hits.length(); start += HITS_PER_PAGE) {
				int end = Math.min(hits.length(), start + HITS_PER_PAGE);
				for (int i = start; i < end; i++) {
					// ȡ����������е�һ���ĵ�����
					Document doc = hits.doc(i);
					// ����ĵ���ID���
					System.out.println("�ĵ����ڲ�ID��:" + hits.id(i));
					// ����ĵ�������
					System.out.println("�ĵ��ķ�ֵ:" + hits.score(i));
					// ����ĵ��Ĵ��·��
					String path = doc.get("path");
					if (path != null) {
						System.out.println("·��Ϊ��" + path);
					}
					System.out.println("******************************************");
				}
				// �ж��Ƿ��н��δ���
				if (hits.length() > end) {
					System.out.print("more (y/n) ? ");
					line = in.readLine();
					if (line.length() == 0 || line.charAt(0) == 'n')
						break;
				}
			}
		}
		searcher.close();
	}

	public static void buildIndex() throws Exception {

		Document doc1 = new Document();
		doc1.add(new Field("contents", "word1 word", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc1.add(new Field("path", "path\\document1.txt", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc1.setBoost(1.0f);
		
		Document doc2 = new Document();
		doc2.add(new Field("contents", "word2 word", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc2.add(new Field("path", "path\\document2.txt", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc2.setBoost(0.1f);

		Document doc3 = new Document();
		doc3.add(new Field("contents", "word3 word", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc3.add(new Field("path", "path\\document3.txt", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc3.setBoost(0.5f);

		Document doc4 = new Document();
		doc4.add(new Field("contents", "word4 word", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc4.add(new Field("path", "path\\document4.txt", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc4.setBoost(0.2f);

		Document doc5 = new Document();
		doc5.add(new Field("contents", "word5 word", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc5.add(new Field("path", "path\\document5.txt", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc5.setBoost(0.8f);
		
//		Document doc6 = new Document();
//		doc6.add(new Field("contents", "word6 word", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc6.add(new Field("path", "path\\document6.txt", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc6.setBoost(0.1f);
//		
//		Document doc7 = new Document();
//		doc7.add(new Field("contents", "word7 word", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc7.add(new Field("path", "path\\document7.txt", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc7.setBoost(0.5f);
//
//		Document doc8 = new Document();
//		doc8.add(new Field("contents", "word8 word", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc8.add(new Field("path", "path\\document8.txt", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc8.setBoost(0.7f);
//
//		Document doc9 = new Document();
//		doc9.add(new Field("contents", "word9 word", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc9.add(new Field("path", "path\\document9.txt", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc9.setBoost(0.2f);
//
//		Document doc10 = new Document();
//		doc10.add(new Field("contents", "word10 word", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc10.add(new Field("path", "path\\document10.txt", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc10.setBoost(0.4f);
//
//		Document doc11 = new Document();
//		doc11.add(new Field("contents", "word11 word", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc11.add(new Field("path", "path\\document11.txt", Field.Store.YES,
//				Field.Index.TOKENIZED));
//
//		Document doc12 = new Document();
//
//		doc12.add(new Field("contents", "word12 word", Field.Store.YES,
//				Field.Index.TOKENIZED));
//		doc12.add(new Field("path", "path\\document12.txt", Field.Store.YES,
//				Field.Index.TOKENIZED));
		
		IndexWriter writer = new IndexWriter(IndexPath,new StandardAnalyzer(), true);
		
		writer.addDocument(doc1);
		writer.addDocument(doc2);
		writer.addDocument(doc3);
		writer.addDocument(doc4);
		writer.addDocument(doc5);
//		writer.addDocument(doc6);
//		writer.addDocument(doc7);
//		writer.addDocument(doc8);
//		writer.addDocument(doc9);
//		writer.addDocument(doc10);
//		writer.addDocument(doc11);
//		writer.addDocument(doc12);
		writer.optimize();
		writer.close();
	}
}
