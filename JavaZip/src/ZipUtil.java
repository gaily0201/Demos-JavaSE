import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * @author ourife
 * @version ����ʱ�䣺Jun 29, 2007 11:41:41 AM
 * ѹ���ļ�
 */
public class ZipUtil {
    
    private static List list = new ArrayList();
    
    public static void main(String argv[]) {
        try {
            byte b[] = new byte[512];
            
            //ѹ���ļ��ı���·��
            String zipFile = "D:/ziptest/test.zip";
            
            //ѹ���ļ�Ŀ¼
            String filepath = "D:/ziptest/";
            
            List fileList = allFile(filepath);
            
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            //ʹ����������
            CheckedOutputStream cs = new CheckedOutputStream(fileOutputStream, new CRC32());
            //�������zip��
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
                    cs));
            
            for (int i = 0; i < fileList.size(); i++) {
               InputStream in = new FileInputStream((String)fileList.get(i));
               String fileName = ((String)(fileList.get(i))).replace(File.separatorChar,'/');
               System.out.println("ziping " + fileName);
               fileName = fileName.substring(fileName.indexOf("/")+1);
               ZipEntry e = new ZipEntry(fileName);
               out.putNextEntry(e);
               int len = 0;
               while((len = in.read(b)) != -1) {
                   out.write(b,0,len);
                 }
               out.closeEntry();
            }
            out.close();  
            System.out.println("done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static List allFile(String path)
    {       
        File file = new File(path);
        String[] array = null;
        String sTemp = "";
                

        if(file.isDirectory())
        {
        }else{
            return null;
        }
        array= file.list();
        if(array.length>0)
        {
            for(int i=0;i<array.length;i++)
            {
                sTemp = path+array[i];
                file = new File(sTemp);
                if(file.isDirectory())
                {
                    allFile(sTemp+"/");

                }else{
                    list.add(sTemp);
                }
            }
        }else{
            return null;
        }

        return list;
    }    

}