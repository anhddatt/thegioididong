package com.poly.service.impl;

import java.io.File;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.service.FileManagerService;

@Service
public class FileManagerServiceImpl implements FileManagerService {
	/*
	 * @Autowired ServletContext app;
	 * app.getRealPath()
	 */
	
	public File save(MultipartFile file, String folder) {
		String rootPath = System.getProperty("user.dir");
		File dir = new File(Paths.get(rootPath, "src", "main" ,"resources","static","assets", "images", folder).toString());
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File savedFile = new File(dir, name);
			file.transferTo(savedFile);
			System.out.println(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
