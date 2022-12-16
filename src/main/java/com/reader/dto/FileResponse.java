package com.reader.dto;

public class FileResponse {
	
	private String filename;
	private String fullPath;
	private String type;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FileResponse(String filename, String fullPath, String type) {
		super();
		this.filename = filename;
		this.fullPath = fullPath;
		this.type = type;
	}
	public FileResponse() {
		super();
	}
	public FileResponse(String fullPath, String type) {
		super();
		this.fullPath = fullPath;
		this.type = type;
	}
	

}
