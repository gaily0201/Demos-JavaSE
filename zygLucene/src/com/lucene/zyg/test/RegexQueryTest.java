package com.lucene.zyg.test;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.regex.RegexQuery;
import org.apache.lucene.store.RAMDirectory;

/**
 * @author Administrator
 * 正在表达式测试
 */
public class RegexQueryTest {

    public static void main(String[] args)throws Exception {
       // TODO Auto-generated method stub
       RAMDirectory ramDir=new RAMDirectory();
       IndexWriter writer=new IndexWriter(ramDir,new StandardAnalyzer(),true);
       writer.setUseCompoundFile(false);//最好用在这里

       Document doc1=new Document();
       Document doc2=new Document();
       Document doc3=new Document();

       Field f1=new Field("url","http://www.abc.com/product?typeid=1&category=10&item=71",
              Field.Store.YES,Field.Index.UN_TOKENIZED);

       Field f2=new Field("url","http://www.abcd.com/product/show?typeid=3&category=10&item=58",
              Field.Store.YES,Field.Index.UN_TOKENIZED);

       Field f3=new Field("url","http://www.ghi.com/product/list?category=4&type=10&order=32",
              Field.Store.YES,Field.Index.UN_TOKENIZED);

       doc1.add(f1);
       doc2.add(f2);
       doc3.add(f3);
       
       writer.addDocument(doc1);
       writer.addDocument(doc2);
       writer.addDocument(doc3);
       writer.close();

       //开始测试查找
       IndexSearcher searcher=new IndexSearcher(ramDir);
//       String regex="http://[a-z]{1,3}\\.abc\\.com/.*";
//       String regex="http://[a-z]{1,3}\\.[a-d]{1,4}\\.com/.*";
//       String regex="http://[a-z]{1,3}\\.zo*\\.com/.*";
       
       String regex="http://[a-z]{1,3}\\.abc([a-z]{1,2}|)\\.com/.*";
       RegexQuery query=new RegexQuery(new Term("url",regex));
       
       Hits hits=searcher.search(query);
       for(int i=0;i<hits.length();i++)
           System.out.println("id:" +hits.id(i)+": " + hits.doc(i));
    }
}


