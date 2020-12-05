package com.daar.project3.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.daar.project3.model.Resume;

public interface ResumeRepository extends ElasticsearchRepository<Resume, String> {

	List<Resume> findByBody(String body);

}