package com.epam.pdp.concurency.service;

import java.io.File;
import java.util.List;

import com.epam.pdp.concurency.domain.FileInfo;

public interface FileService {
	
	FileInfo search(FileInfo fileInfo); 
	
	List<File> getAllFiles(String path);
}
