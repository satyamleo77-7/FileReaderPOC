package com.reader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reader.dto.FileRequest;
import com.reader.dto.FileResponse;
import com.reader.service.FileService;


/**
 * @author Satyam Kumar Rai
 * 
 * A POC to read files from directory and all its sub-directories
 *
 */
@RestController
public class FileController {
	@Autowired
	private FileService service;

	@GetMapping("/hello")
	public String getHello() {
		return ("Hello");
	}
	@PostMapping("/filepath")
	public List<FileResponse> getAllFiles(@RequestBody FileRequest request) {
		return service.getFile(request);
	}
}
