package com.epam.pdp.concurency;

import javax.management.AttributeNotFoundException;

import com.epam.pdp.concurency.service.FileService;
import com.epam.pdp.concurency.service.SearchService;
import com.epam.pdp.concurency.service.impl.DefaultFileService;
import com.epam.pdp.concurency.service.impl.DefaultSearchService;
import com.epam.pdp.concurency.service.impl.ThreadingSearchService;

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
		SearchService threadingSearchService = new ThreadingSearchService();
		SearchService searchService = new DefaultSearchService();
		
		if (isMulty) {
			threadingSearchService.startSearch(fileService.getAllFiles(folderPath), searchedText);
		} else {
			searchService.startSearch(fileService.getAllFiles(folderPath), searchedText);
		}
	}

}
