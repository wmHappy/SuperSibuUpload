package com.wangmin.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
public class IOutils {
	public static String getString(BufferedReader bufferedReader,boolean close) throws IOException{
		try{
			String sh = null;
			StringBuffer sBuffer = new StringBuffer();
			while((sh = bufferedReader.readLine())!=null){
				sBuffer.append(sh);
			}
			return sBuffer.toString();
		}finally{
			if(close){
				closeResource(bufferedReader);
			}
		}
	}
	
	public static void closeResource(Closeable closeable){
		if(closeable!=null){
			try {
				closeable.close();
				closeable = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getText(InputStream inputStream,boolean close,String encode) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,encode));
		return getString(bufferedReader, close);
	}
	
	public static void saveText(BufferedWriter bufferedWriter,boolean close,String text) throws IOException{
		try{
			bufferedWriter.write(text);
			bufferedWriter.flush();
		}finally{
			closeResource(bufferedWriter);
		}
	}
	public static void saveText(OutputStream outputStream,boolean close,String encode,String text) throws IOException{
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,encode));
		saveText(bufferedWriter, close, text);
	}
}
