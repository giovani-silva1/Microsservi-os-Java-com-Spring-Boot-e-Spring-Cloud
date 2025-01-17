package com.giovanidev.hrworker.resources;

import java.util.List;

import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giovanidev.hrworker.entity.Worker;
import com.giovanidev.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value ="/workers")
public class WorkerResources {
	
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);
	
	@Autowired
	private Environment env;
	
	
	@Autowired
	private WorkerRepository workerRepository;

	
	@GetMapping
	public ResponseEntity<List<Worker>> findall(){
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		logger.info("PORT = " + env.getProperty("local.server.port"));
		Worker obj = workerRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
