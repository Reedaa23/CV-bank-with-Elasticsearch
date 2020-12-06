package com.daar.project3.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.daar.project3.service.FileUploadService;

@RestController
public class FileUploadController {
	
@Autowired
FileUploadService fileUploadService;
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public void uploadFile(@RequestParam("files") List<MultipartFile> files) throws IllegalStateException, IOException {
		fileUploadService.uploadFile(files);
	}
}
