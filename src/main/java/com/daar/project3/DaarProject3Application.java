package com.daar.project3;

import java.io.File;
import java.util.List;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daar.project3.model.Resume;
import com.daar.project3.repository.ResumeRepository;

@SpringBootApplication
@RestController
public class DaarProject3Application {
	
	// Needed repository extending the Elasticsearch repository
	@Autowired
	private ResumeRepository repository;
    private File file = new File("resumes");
    private String[] pathnames = file.list();
	
	// Add resumes in PDF and Word format and located in the resumes directory 
	@PostMapping("/saveAll")
	public void saveAll() {
		deleteAll();
		for (String pathname : pathnames) {
			try {
				File newFile = new File("resumes/"+pathname);
	            String content = new Tika().parseToString(newFile);
	            Resume resume = new Resume();
	            resume.body = content;
	            repository.save(resume);
			} catch (final Exception e) {
	            e.printStackTrace();
	        }
		}
	}
	
	// Delete the given resume
	@PostMapping("/deleteResume")
	public void saveResume(@RequestBody Resume resume) {
		repository.delete(resume);
	}
	
	// Delete all resumes
	@PostMapping("/deleteAll")
	public void deleteAll() {
		repository.deleteAll();
	}
	
	// Get all resumes
	@GetMapping("/findAll")
	public Iterable<Resume> findAllResumes() {
		return repository.findAll();
	}
	
	// Get resumes containing the given skills/words
	@GetMapping("/findByBody")
	public List<Resume> findByBody(@RequestParam String body) {
		return repository.findByBody(body);
	}

	public static void main(String[] args) {
		SpringApplication.run(DaarProject3Application.class, args);
	}

}
