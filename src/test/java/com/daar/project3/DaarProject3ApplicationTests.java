package com.daar.project3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.daar.project3.repository.ResumeRepository;
import com.daar.project3.service.FileUploadService;

@SpringBootTest
class DaarProject3ApplicationTests {

	@Autowired FileUploadService service;	
	
	@MockBean private ResumeRepository repository;	
	
	@Test
	public void deleteAll() {
		repository.deleteAll();
		assertEquals(0, IterableUtils.size(repository.findAll()));
	}
	/*
	@Test
	public void uploadFiles() throws IOException {
		File file = new File("resumes\\resume_example.pdf");
		InputStream stream =  new FileInputStream(file);
		MultipartFile newFile = new MockMultipartFile("file", file.getName(), MediaType.TEXT_HTML_VALUE, stream);
		List newFiles = new ArrayList<>();
		newFiles.add(newFile);
		service.repository.deleteAll();
		service.uploadFiles(newFiles);
		assertEquals(1, IterableUtils.size(service.repository.findAll()));
	}
	
	@Test
	public void findByBody() {
		
	}*/

}
