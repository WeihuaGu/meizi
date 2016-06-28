package com.weihuagu.model;

import java.util.List;

import android.graphics.Bitmap;

public interface BitmapAsyncResponse {
	void onDataReceivedSuccess(Bitmap bitmap);
    void onDataReceivedFailed();
}
