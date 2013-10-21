package com.lucene.zyg.test;

public class SearchTimeCompareTest {
	private static String INDEX_STORE_PATH = "D:\\TestLucene\\search\\index";
	private static String SRC_FILE_PATH = "D:\\TestLucene\\search\\files\\走出软件作坊.txt";
	
	public static void main(String[] args) throws Exception{
		Search search = new Search();
		
		//创建索引
		search.buildIndex(SRC_FILE_PATH, INDEX_STORE_PATH);
		
		System.out.println("索引创建完毕");
		// 通过索引搜索关键词
		//search.indexSearch(INDEX_STORE_PATH,"title", "作坊");
		//search.indexSearch2(INDEX_STORE_PATH,"conent", "雍正");
		
		// 通过String的API搜索关键词
		//乱码啊
		search.StringSearch("作坊", "D:\\TestLucene\\search\\files");
	}
}
