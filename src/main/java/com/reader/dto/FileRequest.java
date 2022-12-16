package com.reader.dto;

import java.util.List;

public class FileRequest {
List<String> extensions;
String pathDir;
boolean includeDirectory;
public FileRequest(List<String> extensions, String pathDir, boolean includeDirectory) {
	super();
	this.extensions = extensions;
	this.pathDir = pathDir;
	this.includeDirectory = includeDirectory;
}
public List<String> getExtensions() {
	return extensions;
}
public void setExtensions(List<String> extensions) {
	this.extensions = extensions;
}
public String getPathDir() {
	return pathDir;
}
public void setPathDir(String pathDir) {
	this.pathDir = pathDir;
}
public boolean isIncludeDirectory() {
	return includeDirectory;
}
public void setIncludeDirectory(boolean includeDirectory) {
	this.includeDirectory = includeDirectory;
}
}
