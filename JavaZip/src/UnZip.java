import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

/**
 * @author ourife
 * @version 创建时间：Jun 29, 2007 11:51:52 AM 
 *  解压缩文件
 */
public class UnZip {

    public static void main(String argv[]) {
        try {
            String outputDirectory = "D:/testzip/";
            ZipFile zipFile = new ZipFile("D:/testzip/test.zip");
            Enumeration e = zipFile.getEntries();
            ZipEntry zipEntry = null;
            createDirectory(outputDirectory, "");
            while (e.hasMoreElements()) {
                zipEntry = (ZipEntry) e.nextElement();
                System.out.println("unziping " + zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    String name = zipEntry.getName();
                    name = name.substring(0, name.length() - 1);
                    File f = new File(outputDirectory + File.separator + name);
                    f.mkdir();
                } else {
                    String fileName = zipEntry.getName();
                    fileName = fileName.replace('\\', '/');
                    if (fileName.indexOf("/") != -1) {
                        createDirectory(outputDirectory, fileName.substring(0,fileName.lastIndexOf("/")));
                    }

                    File f = new File(outputDirectory
                            + zipEntry.getName());

                    f.createNewFile();
                    InputStream in = zipFile.getInputStream(zipEntry);
                    FileOutputStream out = new FileOutputStream(f);

                    byte[] by = new byte[1024];
                    int c;
                    while ((c = in.read(by)) != -1) {
                        out.write(by, 0, c);
                    }
                    out.close();
                    in.close();
                }
            }
            System.out.println("done!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static void createDirectory(String directory, String subDirectory) {
        String dir[];
        File fl = new File(directory);
        try {
            if (subDirectory == "" && fl.exists() != true)
                fl.mkdir();
            else if (subDirectory != "") {
                dir = subDirectory.replace('\\', '/').split("/");
                for (int i = 0; i < dir.length; i++) {
                    File subFile = new File(directory + File.separator + dir[i]);
                    if (subFile.exists() == false)
                        subFile.mkdir();
                    directory += File.separator + dir[i];
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}