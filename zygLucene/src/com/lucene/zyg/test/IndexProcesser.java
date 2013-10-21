package com.lucene.zyg.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//import javax.swing.filechooser.FileFilter;
import jeasy.analysis.MMAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

public class IndexProcesser {
    // ��Ա�����洢�����������ļ���ŵ�λ��
    private String INDEX_STORE_PATH = "d:\\search\\index";

    public static void main(String[] args) {
       IndexProcesser processor = new IndexProcesser();
       processor.createIndex("d:\\search\\testfolder");
    }
    
    // ��������
    public void createIndex(String inputDir) {
       try {
           // MMAnalyzer��Ϊ�ִʹ��ߴ���һ��IndexWriter
           IndexWriter writer = new IndexWriter(INDEX_STORE_PATH,
                  new MMAnalyzer(), true);
           File filesDir = new File(inputDir);
           // ȡ��������Ҫ�����������ļ�����
           File[] files = filesDir.listFiles();
           // ��������
           for (int i = 0; i < files.length; i++) {
              // ��ȡ�ļ���
              String fileName = files[i].getName();
              // �ж��ļ��Ƿ�Ϊtxt���͵��ļ�
              if (fileName.substring(fileName.lastIndexOf("."))
                     .equals(".txt")) {
                  // ����һ���µ�Document
                  Document doc = new Document();
                  // Ϊ�ļ�������һ��Field
                  Field field = new Field("filename", files[i].getName(),
                         Field.Store.YES, Field.Index.TOKENIZED);
                  doc.add(field);
                  // Ϊ�ļ����ݴ���һ��Filed
                  field = new Field("content", loadFileToString(files[i]),
                         Field.Store.NO, Field.Index.TOKENIZED);
                  doc.add(field);
                  // ��Document����IndexWriter
                  writer.addDocument(doc);
              }
           }
           // �ر�IndexWriter
           writer.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
    
    public String loadFileToString(File file) {
       try {
           BufferedReader br = new BufferedReader(new FileReader(file));
           StringBuffer sb = new StringBuffer();
           String line = br.readLine();
           while (line != null) {
              sb.append(line);
              line = br.readLine();
           }
           br.close();
           return sb.toString();
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
    }
}

