package com.lucene.zyg.test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryParser.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;

/**
 * @author Administrator
 * 效率分析
 */
public class EfficiencyTest {
	public static String IndexPath = "D:\\TestLucene\\EfficiencyTest";

	public static void main(String[] args) throws Exception {
		IndexWriter writer = new IndexWriter(IndexPath, new StandardAnalyzer(),
				true);
		Document doc = null;
		Field field = new Field("bookname", "美女与野兽", Field.Store.YES,
				Field.Index.TOKENIZED);
		for (int i = 1; i <= 100000; i++) {
			doc = new Document();
			doc.add(field);
			writer.addDocument(doc);
		}
		writer.close();
		
		IndexSearcher searcher = new IndexSearcher(IndexPath);
		Query query = new TermQuery(new Term("bookname", "女"));

		Hits hits = searcher.search(query);
		//计算第10个搜索结果所花费的时间
		Date start = new Date();

		Document d1 = hits.doc(10);
		
		System.out.println(d1);
		System.out.println(hits.id(10));
		System.out.println(d1.get("bookname"));

		Date end = new Date();

		System.out.println("cost time:" + (end.getTime() - start.getTime())
				+ "ms");

		//计算第100个搜索结果所花费的时间
		start = new Date();
		d1 = hits.doc(100);
		System.out.println(d1);
		System.out.println(hits.id(100));
		System.out.println(d1.get("bookname"));
		end = new Date();
		System.out.println("cost time:" + (end.getTime() - start.getTime())
				+ "ms");
		
		//计算第1000个搜索结果所花费的时间
		start = new Date();
		d1 = hits.doc(1000);
		System.out.println(d1);
		System.out.println(hits.id(1000));
		System.out.println(d1.get("bookname"));
		end = new Date();
		System.out.println("cost time:" + (end.getTime() - start.getTime())
				+ "ms");
		
		//计算第10000个搜索结果所花费的时间
		start = new Date();
		d1 = hits.doc(10000);
		System.out.println(d1);
		System.out.println(hits.id(10000));
		System.out.println(d1.get("bookname"));
		end = new Date();
		System.out.println("cost time:" + (end.getTime() - start.getTime())
				+ "ms");

		//计算第99999个搜索结果所花费的时间
		start = new Date();
		d1 = hits.doc(99999);
		System.out.println(d1);
		System.out.println(hits.id(99999));
		System.out.println(d1.get("bookname"));
		end = new Date();
		System.out.println("cost time:" + (end.getTime() - start.getTime())
				+ "ms");
		searcher.close();
	}
}
