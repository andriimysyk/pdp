package com.epam.pdp.concurency.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.epam.pdp.concurency.service.FileService;

public class DefaultFileService implements FileService {
	
	@Override
	public List<File> getAllFiles(String path) {
		
		return allFiles(new File(path), new ArrayList<File>());
	}
	
	private List<File> allFiles(File rootDirectory, List<File> files) {
		File[] subFiles = rootDirectory.listFiles();
		
		for (File file : subFiles) {
			if (file.isDirectory()) {
				allFiles(file, files);
			}
			if (file.isFile()) {
				files.add(file);
			}
		}
		
		return files;
	}
	
}
