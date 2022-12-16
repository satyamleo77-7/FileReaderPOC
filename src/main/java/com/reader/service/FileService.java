package com.reader.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.io.Files;
import com.reader.dto.FileRequest;
import com.reader.dto.FileResponse;

@Service
public class FileService {
	List<FileResponse> response = new ArrayList<FileResponse>();

	public List<FileResponse> getFile(FileRequest request) {
		if (request.isIncludeDirectory())
			listAllFilesWithSubDirectories(new File(request.getPathDir()), request.getExtensions());
		else
			getOnlyRotDirectoryFileDetails(request);

		return response;
	}

	// Recursive Function that reads all files within Each sub directory until end
	// of directory
	public void listAllFilesWithSubDirectories(File directory, List<String> extension) {

		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				FileResponse fileResponse = new FileResponse();
				fileResponse.setFullPath(file.getAbsolutePath());
				fileResponse.setType("Directory");
				response.add(fileResponse);
				listAllFilesWithSubDirectories(file, extension);
			} else {
				if (!extension.isEmpty() && extension.contains(Files.getFileExtension(file.getAbsolutePath()))) {
					FileResponse fileResponse = new FileResponse();
					fileResponse.setFilename(file.getName());
					fileResponse.setFullPath(file.getAbsolutePath());
					fileResponse.setType("file");
					response.add(fileResponse);
				} else if (extension.isEmpty()) {
					FileResponse fileResponse = new FileResponse();
					fileResponse.setFilename(file.getName());
					fileResponse.setFullPath(file.getAbsolutePath());
					fileResponse.setType("file");
					response.add(fileResponse);
				}
			}
		}

	}

	/* Function that shows only file in a specific directory */
	public List<FileResponse> getOnlyRotDirectoryFileDetails(FileRequest request) {
		if (request.getPathDir().isBlank())
			return (new ArrayList<FileResponse>());
		// directory path
		String path = request.getPathDir();
		// get the file object
		File directory = new File(path);

		// get all the files and directories in the directory
		File[] files = directory.listFiles();

		// loop through all the files and directories
		for (File file : files) {

			// check if it is a file or directory
			if (file.isFile()) {
				if (!request.getExtensions().isEmpty()
						&& request.getExtensions().contains(Files.getFileExtension(file.getAbsolutePath()))) {
					FileResponse fileResponse = new FileResponse();
					fileResponse.setFilename(file.getName());
					fileResponse.setFullPath(file.getAbsolutePath());
					fileResponse.setType("file");
					response.add(fileResponse);
				} else if (request.getExtensions().isEmpty()) {
					FileResponse fileResponse = new FileResponse();
					fileResponse.setFilename(file.getName());
					fileResponse.setFullPath(file.getAbsolutePath());
					fileResponse.setType("file");
					response.add(fileResponse);
				}
			}
		}
		return response;
	}
}
