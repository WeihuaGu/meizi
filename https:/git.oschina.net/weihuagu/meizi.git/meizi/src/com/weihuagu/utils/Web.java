package com.weihuagu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Web {
	public static Bitmap getBitMBitmap(String urlpath) {
		Bitmap map = null;
		try {
			URL url = new URL(urlpath);
			URLConnection conn = url.openConnection();
			conn.connect();
			InputStream in;
			in = conn.getInputStream();
			map = BitmapFactory.decodeStream(in);
			// TODO Auto-generated catch block
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
		
}
