package com.poly.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagerService {
	public File save(MultipartFile file, String folder);

}
