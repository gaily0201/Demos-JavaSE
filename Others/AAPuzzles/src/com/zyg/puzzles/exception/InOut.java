package com.zyg.puzzles.exception;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InOut {
	static void copy(String src, String dest) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int n;
			while ((n = in.read(buf)) > 0)
				out.write(buf, 0, n);
		} finally {
			/*if (in != null)
				in.close();
			if (out != null)
				out.close();*/ //对close 的调用可能会导致finally 语句块意外结束
			
			//方案1
			/*if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					// There is nothing we can do if close fails
				}
				if (out != null)
					try {
						out.close();
					} catch (IOException ex) {
						// There is nothing we can do if close fails
					}
			}*/
			//方案2
			closeIgnoringException(in);
			closeIgnoringException(out);
			
		}
	}
	
	private static void closeIgnoringException(Closeable c) {
		if (c != null) {
			try {
				c.close();
			} catch (IOException ex) {
				// There is nothing we can do if close fails
			}
		}
	}
}
