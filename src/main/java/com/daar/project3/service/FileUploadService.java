package com.daar.project3.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.daar.project3.model.Resume;
import com.daar.project3.repository.ResumeRepository;

@Service
@EnableAutoConfiguration
public class FileUploadService {
	
	// Needed repository extending the Elasticsearch repository
	@Autowired
	public ResumeRepository repository;
	
	// Upload and add resumes in PDF and Word format
	public void uploadFiles(List<MultipartFile> files) throws IllegalStateException, IOException {
		try {
			for (MultipartFile file: files) {
				Path tempFile = Files.createTempFile("temp-", ".tmp");
				file.transferTo(tempFile);
	            String content = new Tika().parseToString(tempFile);
	            Resume resume = new Resume();
	            resume.body = content;
	            repository.save(resume);
			}
		} catch (final Exception e) {
            e.printStackTrace();
        }
	}
	
}
