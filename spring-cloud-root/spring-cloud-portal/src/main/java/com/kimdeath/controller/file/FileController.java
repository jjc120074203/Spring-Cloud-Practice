package com.kimdeath.controller.file;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kimdeath.api.fegin.orgin.IFileSystemClient;
import com.kimdeath.configuration.file.FeignSpringFormEncoder;
import com.kimdeath.domain.FeginEntity;

import feign.Feign;
import feign.jackson.JacksonDecoder;

@RestController
public class FileController {

	private IFileSystemClient iFileSystemUploadClient;

	// 初始化 文件格式文件
	public FileController() {
		Feign.Builder encoder = Feign.builder().decoder(new JacksonDecoder()).encoder(new FeignSpringFormEncoder());
		this.iFileSystemUploadClient = encoder.target(IFileSystemClient.class, "http://localhost:1236");
	}

//	@PostMapping("/UploadSinglefile")
//	public Map<String,Object> UploadSinglefile(@RequestParam("file")MultipartFile file, String names){
//		MultipartFile[] files={file};
//		FeginEntity fe=new  FeginEntity();
//		fe.setFeginName(names);
//		 return iFileSystemUploadClient.UploadMultifiles("", files, fe);
//	}
//
//	@PostMapping("/UploadMultifiles")
//	public Map<String, Object> UploadMultifiles(String names,String folder, @RequestParam("files")MultipartFile[] files){
//	FeginEntity fe=new  FeginEntity();
//	fe.setFeginName(names);
//	return iFileSystemUploadClient.UploadMultifiles(folder, files, fe);
//	}
}
