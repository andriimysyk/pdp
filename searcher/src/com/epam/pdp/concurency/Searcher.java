package com.epam.pdp.concurency;

import java.io.File;

import javax.management.AttributeNotFoundException;

import com.epam.pdp.concurency.domain.FileInfo;
import com.epam.pdp.concurency.service.FileService;
import com.epam.pdp.concurency.service.impl.DefaultFileService;
import com.epam.pdp.concurency.service.impl.DefaultSearchThreadService;

public class Searcher {

	/**
	 * @param args
	 * @throws AttributeNotFoundException 
	 */
	public static void main(String[] args) throws AttributeNotFoundException {
		String folderPath = null;
		String searchedText = null;
		Boolean isMulty = false;
		
		if (args.length == 3) {
			folderPath = args[0];
			searchedText = args[1];
			isMulty = new Boolean(args[2]);
		} else {
			throw new AttributeNotFoundException("Can not find attributes");
		}
		
		FileService fileService = new DefaultFileService();
		DefaultSearchThreadService searchThreadService = new DefaultSearchThreadService();
		
		if (isMulty) {
			for (File f : fileService.getAllFiles(folderPath)) {
				FileInfo fileInfo = new FileInfo();
				
				fileInfo.setFile(f);
				fileInfo.setSearchedText(searchedText);
				
				searchThreadService.createThread(fileInfo).start();
			}
		} else {
			for (File f : fileService.getAllFiles(folderPath)) {
				FileInfo fileInfo = new FileInfo();
				
				fileInfo.setFile(f);
				fileInfo.setSearchedText(searchedText);
				fileService.search(fileInfo);
				
				System.out.println(fileInfo.getFile().getName() + " " + fileInfo.getMatchesCount());
			}
		}
	}

}
