package baseSample;

import java.io.IOException;

//index store type
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.FSDirectory;

//indexing required
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;

//searching
import org.apache.lucene.queryParser.QueryParser; //单Field查询
import org.apache.lucene.queryParser.MultiFieldQueryParser; //多Field查询
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.IndexSearcher;

import org.apache.lucene.util.Version;

public class SampleSearch{
	public static void main(String arg[]) throws CorruptIndexException, LockObtainFailedException, IOException, ParseException{
		
		//Store the index in memory:
		Directory directory  = new RAMDirectory();
		//To store an index on disk, use this instead:
	    //Directory directory = FSDirectory.open("/path");
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		analyzer = new CJKAnalyzer(Version.LUCENE_CURRENT);
		//Now search the index
		IndexSearcher isearcher = new IndexSearcher(IndexDocument.getIndexDirectory(directory, analyzer), true);
		
		/**
		 * IndexSearcher 的主要检索方法   
		 * isearcher.search(Query query, Collector results);
		 * isearcher.search(Query query,int n);
		 * isearcher.search(Query query, Filter filter, Collector results); 
		 */
		//Term 是查询的基本单位
		//1.termQuery
		Query termQuery = new TermQuery(new Term("newsSource","网易"));
		System.out.println("--- termQuery :"+termQuery.toString());
		
		//2.BooleanQuery ,类似还提供RangeQuery范围搜索; PrefixQuery 前缀搜索 ;FuzzyQuery 模糊搜索 ..etc
		Query a = new TermQuery(new Term("newsSource", "网"));
		Query b = new TermQuery(new Term("newsSource", "易"));
		BooleanQuery booleanQuery = new BooleanQuery();
		booleanQuery.add(a, BooleanClause.Occur.MUST);
		booleanQuery.add(b, BooleanClause.Occur.MUST);
		System.out.println("--- booleanQuery :"+booleanQuery.toString());
		
		//3.用QueryParser 切词出 query
//		QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "newsSource", analyzer);
//		parser.setDefaultOperator(QueryParser.AND_OPERATOR);//默认term之间是or关系
//		Query parserQuery = parser.parse("java lucene");
//		System.out.println("--- parserQuery :"+parserQuery.toString());
		
		//4.利用MultiFieldQueryParser实现对多Field查询
//		String[] fields = {"newsName","newsSource"};
//		MultiFieldQueryParser mparser = new MultiFieldQueryParser(Version.LUCENE_CURRENT, fields, analyzer);
//		Query mQuery = mparser.parse("江苏");
//		System.out.println("---- mQuery :"+mQuery);
		
		ScoreDoc[] docs = isearcher.search(termQuery, 10).scoreDocs;
		for (int i = 0; i < docs.length; i++){   
        	System.out.println(docs[i].doc);
        	System.out.println("searcher score :" + docs[i].score);
            Document hitDoc = isearcher.doc(docs[i].doc);
            System.out.println("--- explain : "+isearcher.explain(termQuery, docs[i].doc));
            System.out.println("boost:" + hitDoc.getBoost());
            System.out.println("newsId:" + hitDoc.get("newsId"));
            System.out.println("newsName:" + hitDoc.get("newsName"));
            System.out.println("publishDate:" + hitDoc.get("publishDate"));
            System.out.println("newsSource:" + hitDoc.get("newsSource"));
            System.out.println("newssummay:" + hitDoc.get("newssummay"));
            System.out.println("------------------------------------------");
		 }   
	}
}
