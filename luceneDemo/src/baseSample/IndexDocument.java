package baseSample;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class IndexDocument {
	
	public static Directory getIndexDirectory(Directory directory,Analyzer analyzer) throws CorruptIndexException, LockObtainFailedException, IOException{
		IndexWriter iwriter = new IndexWriter(directory , analyzer, true,new IndexWriter.MaxFieldLength(25000));
		//索引过程的调优
//		iwriter.setMergeFactor(10);//激励因子
//		iwriter.setMaxMergeDocs(2000);//segment最大文档数量
//		iwriter.setMaxBufferedDocs(1);//内存文档数量
		//news Fields
		Field newsId = null;
		Field newsName = null;
		Field publishDate = null;
		Field newsSource = null;
		Field newssummay = null;
		//第1篇新闻
		Document doc1 = new Document();
		newsId = new Field("newsId","aaaa",Field.Store.YES,Field.Index.NOT_ANALYZED);
		newsName = new Field("newsName", "江苏常州曝疫苗造假大案7人被捕超百万人受害", Field.Store.YES, Field.Index.ANALYZED);
		publishDate = new Field("publishDate", "2010/3/30", Field.Store.YES, Field.Index.NOT_ANALYZED);
		newsSource = new Field("newsSource","网易新闻频道",Field.Store.YES,Field.Index.ANALYZED);
		newssummay = new Field("newssummay", "据香港明报报道，江苏常州爆出疫苗造假大案。当地著名疫苗生产商江苏延申生物科技股份有限公司（简称“江苏延申”）被国家药监局查实在疫苗生产过程中长期故意造假，导致大量问题疫苗流向市场，受害者最少超过100万人。", 
								Field.Store.YES, Field.Index.ANALYZED);
		doc1.add(newsId);
		doc1.add(newsName);
		doc1.add(publishDate);
		doc1.add(newsSource);
		doc1.add(newssummay);
		
		iwriter.addDocument(doc1);
		//第2篇新闻
		Document doc2 = new Document();
		newsId = new Field("newsId","bbbb",Field.Store.YES,Field.Index.NOT_ANALYZED);
		newsName = new Field("newsName", "富士康一月内发生三起坠楼案", Field.Store.YES, Field.Index.ANALYZED);
		publishDate = new Field("publishDate", "2010/3/30", Field.Store.YES, Field.Index.NOT_ANALYZED);
		newsSource = new Field("newsSource","广州日报",Field.Store.YES,Field.Index.ANALYZED);
		newssummay = new Field("newssummay", "昨日凌晨3时左右，富士康科技集团龙华厂区的一名23岁湖南籍男性员工从宿舍楼上坠下，当场死亡", 
								Field.Store.YES, Field.Index.ANALYZED);
		doc2.add(newsId);
		doc2.add(newsName);
		doc2.add(publishDate);
		doc2.add(newsSource);
		doc2.add(newssummay);
		iwriter.addDocument(doc2);
		
		//第3篇新闻
		Document doc3 = new Document();
		newsId = new Field("newsId","cccc",Field.Store.YES,Field.Index.NOT_ANALYZED);
		newsName = new Field("newsName", "普京称要消灭掉制造地铁爆炸案恐怖分子", Field.Store.YES, Field.Index.ANALYZED);
		publishDate = new Field("publishDate", "2010/3/30", Field.Store.YES, Field.Index.NOT_ANALYZED);
		newsSource = new Field("newsSource","网易新闻频道",Field.Store.YES,Field.Index.ANALYZED);
		newssummay = new Field("newssummay", "据外电报道，俄罗斯总理普京29日表示，当天制造莫斯科地铁连环爆炸案的恐怖分子一定会被抓到，并被消灭掉。", 
								Field.Store.YES, Field.Index.ANALYZED);
		doc3.add(newsId);
		doc3.add(newsName);
		doc3.add(publishDate);
		doc3.add(newsSource);
		doc3.add(newssummay);
		//doc3.setBoost(2);
		iwriter.addDocument(doc3);
		
		//第4篇新闻
		Document doc4 = new Document();
		newsId = new Field("newsId","cccc",Field.Store.YES,Field.Index.NOT_ANALYZED);
		newsName = new Field("newsName", "最天使", Field.Store.YES, Field.Index.ANALYZED);
		publishDate = new Field("publishDate", "2009/3/30", Field.Store.YES, Field.Index.NOT_ANALYZED);
		newsSource = new Field("newsSource","易",Field.Store.YES,Field.Index.ANALYZED);
		newssummay = new Field("newssummay", "长肥了", 
								Field.Store.YES, Field.Index.ANALYZED);
		doc4.add(newsId);
		doc4.add(newsName);
		doc4.add(publishDate);
		doc4.add(newsSource);
		doc4.add(newssummay);
		iwriter.addDocument(doc4);
		
		iwriter.close();
		
		return directory;
	}

}
