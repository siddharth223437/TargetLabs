package com.tl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	
	public void saveUpload(List<MultipartFile> files) throws IOException;

}
