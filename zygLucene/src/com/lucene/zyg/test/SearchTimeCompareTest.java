package com.lucene.zyg.test;

public class SearchTimeCompareTest {
	private static String INDEX_STORE_PATH = "D:\\TestLucene\\search\\index";
	private static String SRC_FILE_PATH = "D:\\TestLucene\\search\\files\\�߳��������.txt";
	
	public static void main(String[] args) throws Exception{
		Search search = new Search();
		
		//��������
		search.buildIndex(SRC_FILE_PATH, INDEX_STORE_PATH);
		
		System.out.println("�����������");
		// ͨ�����������ؼ���
		//search.indexSearch(INDEX_STORE_PATH,"title", "����");
		//search.indexSearch2(INDEX_STORE_PATH,"conent", "Ӻ��");
		
		// ͨ��String��API�����ؼ���
		//���밡
		search.StringSearch("����", "D:\\TestLucene\\search\\files");
	}
}
