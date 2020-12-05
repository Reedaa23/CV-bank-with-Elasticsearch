package com.daar.project3.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "resumes",shards=2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
	
	// Id of each resume
	@Id
	public String id;
	// All the string content of each resume
	public String body;
	
}
