package com.wangmin.utils;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import com.wangmin.utils.DialogUtils.DialogType;
public class HttpUtils {
	public static BufferedImage loadImage(String urls){
		HttpURLConnection urlConnection = null;
		BufferedInputStream bufferedInputStream = null;
		try{
			URL url = new URL(urls);
			urlConnection = (HttpURLConnection) url.openConnection();
			bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
			BufferedImage bufferedImage =  ImageIO.read(bufferedInputStream);
			return bufferedImage;
		}catch(Exception e){
			e.printStackTrace();
			return ResourceUtils.loadBufferedImageLocation("loading.jpg");
		}finally{
			IOutils.closeResource(bufferedInputStream);
			if(urlConnection!=null){
				urlConnection.disconnect();
			}
		}
	}
	
	
	
	public static String getJson(Component component,String urls,String encode){
		HttpURLConnection urlConnection = null;
		try{
			URL url = new URL(urls);
			urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),encode));
			return IOutils.getString(bufferedReader,true);
		}catch(Exception e){
			e.printStackTrace();
			DialogUtils.showMessageDialog(component, urls+"获取数据失败    "+e.getMessage(), DialogType.NORMAL);
			return null;
		}
	}

}
