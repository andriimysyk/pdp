package com.epam.pdp.concurency.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.pdp.concurency.domain.FileInfo;
import com.epam.pdp.concurency.service.FileService;

public class DefaultFileService implements FileService {
	
	@Override
	public FileInfo search(FileInfo fileInfo) {
		Integer count = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileInfo.getFile()));
			String tmp = null;
			
			do {
				tmp = reader.readLine();
				if (tmp != null) {
					count += searchMatches(tmp, fileInfo.getSearchedText());
				}
			} while(tmp != null);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		fileInfo.setMatchesCount(count);
		
		return fileInfo;
	}
	
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
	
	private Integer searchMatches(String string, String text) {
		Integer count = 0;
		int stringLength = string.length();
		int startIndex = 0;
		int indexOf = 0;
		
		while (startIndex < stringLength && indexOf != -1) {
			indexOf = string.indexOf(text, startIndex);
			if (indexOf != -1) {
				startIndex = ++indexOf;
				++count;
			}
		}
		
		return count;
	}

}
