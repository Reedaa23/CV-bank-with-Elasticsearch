package com.daar.project3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// Delete all resumes
    @CrossOrigin(origins = "*")
	@PostMapping("/deleteAll")
	public void deleteAll() {
		repository.deleteAll();
	}
	
	// Get all resumes
    @CrossOrigin(origins = "*")
	@GetMapping("/findAll")
	public Iterable<Resume> findAll() {
		return repository.findAll();
	}
	
	// Get resumes containing the given skills/words
    @CrossOrigin(origins = "*")
	@GetMapping("/findByBody")
	public ArrayList<String> findByBody(@RequestParam String body) {
    	ArrayList<String> bodies = new ArrayList<String>();
    	List<Resume> resumes = repository.findByBody(body);
    	for (Resume resume: resumes) {
    		bodies.add(resume.body);
    	}
		return bodies;
	}

	public static void main(String[] args) {
		SpringApplication.run(DaarProject3Application.class, args);
	}

}
