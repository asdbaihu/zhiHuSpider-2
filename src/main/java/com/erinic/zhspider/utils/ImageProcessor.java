package com.erinic.zhspider.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 下载图片的Processor dem
 */
public class ImageProcessor {
	private final static String PATH = "d:\\test\\";
	public static void main(String[] args)  {
		String url = "http://pic.meizitu.com/wp-content/uploads/2015a/10/35/01.jpg";
		try {
			downloadP(url, "没只");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void downloadP(String path,String name) throws IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(path);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		InputStream in = entity.getContent();

		String tempPath;
		if(!PATH.endsWith("\\")){
			tempPath = PATH+"\\";
		}
		tempPath = PATH+"\\";
		try {
			File dirFile = new File(PATH);
			if(!dirFile.exists() && PATH.length()>0){
				dirFile.mkdir();
			}else {
				FileOutputStream fout = new FileOutputStream(new File(tempPath + name + ".png"));
				int l = -1;
				byte[] tmp = new byte[1024];
				while ((l = in.read(tmp)) != -1) {
					fout.write(tmp, 0, l);
				}
				fout.flush();
				fout.close();

				System.err.println("close");
			}
		} finally {
			in.close();
		}
	}
}
