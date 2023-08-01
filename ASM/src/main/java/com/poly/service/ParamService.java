package com.poly.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	ServletContext app;

	/**
	 * Đọc chuỗi giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	/**
	 * Đọc số nguyên giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public int getInt(String name, int defaultValue) {
		try {
			if(request.getParameter(name) != null)
				return Integer.parseInt(request.getParameter(name));
			else 
				return defaultValue;
		} catch (Exception e) {
			// TODO: handle exception
			return defaultValue;
		}
	}

	/**
	 * Đọc số thực giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public double getDouble(String name, double defaultValue) {
		try {
			if(request.getParameter(name) != null)
				return Double.parseDouble(request.getParameter(name));
			else 
				return defaultValue;
		} catch (Exception e) {
			// TODO: handle exception
			return defaultValue;
		}
	}

	/**
	 * Đọc giá trị boolean của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public boolean getBoolean(String name, boolean defaultValue) {
		try {
			if(request.getParameter(name) != null)
				return true;
			else 
				return defaultValue;
		} catch (Exception e) {
			// TODO: handle exception
			return defaultValue;
		}
	}

	/**
	 * Đọc giá trị thời gian của tham số
	 * 
	 * @param name    tên tham số
	 * @param pattern là định dạng thời gian
	 * @return giá trị tham số hoặc null nếu không tồn tại
	 * @throws RuntimeException lỗi sai định dạng
	 */
	public Date getDate(String name, String pattern) {
		// Dọc giá trị thời gian
		String value = request.getParameter(name);
		if (value == null) {
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(value);
			return new java.sql.Date(date.getTime());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Lưu file upload vào thư mục
	 * 
	 * @param file chứa file upload từ client
	 * @param path đường dẫn tính từ webroot
	 * @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
	 * @throws RuntimeException lỗi lưu file
	 */
	public File save(MultipartFile file, String path) {
		File dir = new File(app.getRealPath(path));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			File saveFile = new File(dir, file.getOriginalFilename());
			file.transferTo(saveFile);
			return saveFile;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}


