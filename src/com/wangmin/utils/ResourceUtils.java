package com.wangmin.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ResourceUtils {
	public static BufferedImage loadBufferedImageLocation(String name){
		InputStream resourceAsStream = HttpUtils.class.getClassLoader().getResourceAsStream(name);
		if(resourceAsStream == null){
			throw new RuntimeException(name+"资源找不到");
		}
		BufferedImage read = null;
		try{
			read = ImageIO.read(resourceAsStream);
		}catch (Exception e) {
			throw new RuntimeException(name+"资源不是图片资源"+e.getMessage());
		}finally{
			IOutils.closeResource(resourceAsStream);
		}
		return read;
	}
	
	public static byte[] loadImage(String name){
		InputStream resourceAsStream = HttpUtils.class.getClassLoader().getResourceAsStream(name);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try{
			byte b[] = new byte[1024];
			int leng = -1;
			while((leng = bufferedInputStream.read(b))!=-1){
				byteArrayOutputStream.write(b, 0, leng);
				byteArrayOutputStream.flush();
			}
			return byteArrayOutputStream.toByteArray();
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			IOutils.closeResource(bufferedInputStream);
			IOutils.closeResource(byteArrayOutputStream);
		}
	}
}
