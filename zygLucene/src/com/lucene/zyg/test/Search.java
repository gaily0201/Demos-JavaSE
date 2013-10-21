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
			// 根据索引位置建立IndexSearcher
			IndexSearcher searcher = new IndexSearcher(IndexPath);
			// 使用标准分析器
			Analyzer aStandardAnalyzer = new StandardAnalyzer();
			// 构造Query对象
			QueryParser parser = new QueryParser(searchType, aStandardAnalyzer);
			Query query = parser.parse(searchKey);
			
			// 输出要搜索的内容
			System.out.println("查找:" + query.toString(searchType));
			
			// 搜索开始时间
			Date beginTime = new Date();
			
			// 使用searcher对象的search方法进行搜索，返回的是一个Hits类型的对象
			Hits hits = searcher.search(query);
			// 使用Hits对象的length（）方法，输出搜索到的文档的数量
			System.out.println("总共找到 " + hits.length() + " 个文档");
			
			for (int i = 0; i < hits.length(); i++) {
				// 取得搜索结果中的一个文档对象
				Document doc = hits.doc(i);
				// 输出文档的ID编号
				System.out.println("文档的内部ID号:" + hits.id(i));
				// 输出文档的评分
				System.out.println("文档的分值:" + hits.score(i));
				// 输出文档的内容
				String content = doc.get("content");
				if (content != null) {
					System.out.println("内容为：" + content);
				}
				System.out.println("******************************************");
			}
		
			// 搜索完成时间
			Date endTime = new Date();
			// 搜索所耗时间
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
			// 根据索引位置建立IndexSearcher
			IndexSearcher searcher = new IndexSearcher(IndexPath);
			// 建立搜索单元，searchType代表要搜索的Filed，searchKey代表关键字
			Term t = new Term(searchType, searchKey);

			System.out.println(t.toString());
			// 由Term生成一个Query
			//Query q = new TermQuery(t);

			// 搜索开始时间
			Date beginTime = new Date();
			// 获取一个<document, frequency>的枚举对象TermDocs
			TermDocs termDocs = searcher.getIndexReader().termDocs(t);

			while (termDocs.next()) {
				// 输出在文档中出现关键词的次数
				System.out.println(termDocs.freq());
				// 输出搜索到关键词的文档
				System.out.println(searcher.getIndexReader().document(
						termDocs.doc()));
			}

			// 搜索完成时间
			Date endTime = new Date();
			// 搜索所耗时间
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
		doc1.add(new Field("title", "走出软件作坊", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc1.add(new Field("content", "我要走出软件作坊啊", Field.Store.YES,
				Field.Index.TOKENIZED));
		
		Document doc2 = new Document();
		doc2.add(new Field("title", "张燕广走出软件作坊", Field.Store.YES,
				Field.Index.TOKENIZED));
		doc2.add(new Field("content", "张燕广要走出软件作坊啊", Field.Store.YES,
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
		// 返回目录文件夹所有文件数组
		File[] files = filesDir.listFiles();
		System.out.println("文件个数："+files.length);
		// HashMap保存文件名和匹配次数对
		Map rs = new HashMap();
		// 记录搜索开始时间
		Date beginTime = new Date();
		// 遍历所有文件

		for (int i = 0; i < files.length; i++) {
			// 初始化匹配次数
			int hits = 0;
			try {
				//System.out.println(files[i].toString());
				// 读取文件内容
				BufferedReader br = new BufferedReader(new FileReader(files[i]));
				StringBuffer sb = new StringBuffer();
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					line = br.readLine();
				}
				br.close();

				// 将StringBuffer转化成String，以便于搜索
				String stringToSearch = sb.toString();
				//System.out.println(stringToSearch);
				// 初始化fromIndex
				int fromIndex = -keyword.length();
				// 逐个匹配关键词
				while ((fromIndex = stringToSearch.indexOf(keyword, fromIndex+ keyword.length())) != -1) {
					hits++;
				}
				// 将文件名和匹配次数加入HashMap
				rs.put(files[i].getName(), new Integer(hits));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 输出查询结果
		Iterator it = rs.keySet().iterator();
		while (it.hasNext()) {
			String fileName = (String) it.next();
			Integer hits = (Integer) rs.get(fileName);
			System.out.println("find " + hits.intValue() + " matches in "

			+ fileName);
		}

		// 记录结束时间
		Date endTime = new Date();
		// 得到搜索耗费时间
		long timeOfSearch = endTime.getTime() - beginTime.getTime();
		System.out.println("The time For string search is " + timeOfSearch
				+ " ms");
	}
}
