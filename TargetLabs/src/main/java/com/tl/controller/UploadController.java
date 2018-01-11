package com.tl.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tl.common.ApplicationConstant;
import com.tl.service.UploadService;
import com.tl.vo.UploadResponse;

@RestController
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	
	@PostMapping("/upload")
	public UploadResponse<MultipartFile> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("file name is " +file.getOriginalFilename());
		UploadResponse<MultipartFile> multiFile = new UploadResponse<>();
		try {
			if(file.isEmpty()) {
				multiFile.setStatus(false);
				multiFile.setMessage(ApplicationConstant.ResponseMessage);
				return multiFile;
			}
			uploadService.saveUpload(Arrays.asList(file));
			multiFile.setStatus(true);
			multiFile.setMessage(file.getOriginalFilename()+ApplicationConstant.ResponseSuccessMsg);
		}catch(IOException e) {
			e.printStackTrace();
			multiFile.setMessage(e.getMessage());
		}
		return multiFile;
	}

}
