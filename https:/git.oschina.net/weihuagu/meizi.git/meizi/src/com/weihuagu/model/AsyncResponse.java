package com.weihuagu.model;

public interface AsyncResponse {
	void onDataReceivedSuccess(String[] accouts);
   void onDataReceivedFailed();
}
