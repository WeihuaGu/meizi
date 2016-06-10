package com.weihuagu.model;

import java.util.List;

public interface AsyncResponse {
	void onDataReceivedSuccess(List<ImageInfo> imagelist);
    void onDataReceivedFailed();
}
