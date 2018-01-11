package com.tl.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tl.common.ApplicationConstant;

@Service
public class UploadServiceImpl implements UploadService {

	@Override
	public void saveUpload(List<MultipartFile> files) throws IOException {
		
		for(MultipartFile file : files) {
			if(file.isEmpty()) {
				continue;
			}
			byte[] bytes = file.getBytes();
            Path path = Paths.get(ApplicationConstant.UploadFolder + file.getOriginalFilename());
            Files.write(path, bytes);
		}
	}

}
