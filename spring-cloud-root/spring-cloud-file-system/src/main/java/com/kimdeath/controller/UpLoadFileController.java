package com.kimdeath.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kimdeath.domain.FeginEntity;

/**
 * 
 * 文件上传下载解决方法
 * @author issuser
 *
 */
@RestController
public class UpLoadFileController {

	
	/**
	 * 文件上传单个文件对象
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/file/UploadSinglefile")
	@ResponseBody
	public String UploadSinglefile(@RequestParam(name="file")MultipartFile file){
		File f = null;
		try {
			byte[] bytes=file.getBytes();
			f = new File(file.getOriginalFilename());
			FileCopyUtils.copy(bytes, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f.getAbsolutePath();
	}
	
	
	
	
	/**
	 * 文件上传多个文件对象+对象
	 * 
	 * @param file
	 * @param FeginEntity
	 * @return
	 */
	@PostMapping("/file/UploadMultifiles")
	public Map<String,Object> UploadMultifiles(String folder,@RequestParam(name="file")MultipartFile[] files,FeginEntity FeginEntity){
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("fileArray-len", files.length);
		result.put("folder", folder);
		result.put("FeginEntity", FeginEntity.getFeginName());
		return result;
	}

}
