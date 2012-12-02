package com.epam.pdp.concurency.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractSearchService implements SearchService {
	
	public Integer search(File file, String text) {
		Integer count = 0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String tmp = null;
			
			do {
				tmp = reader.readLine();
				if (tmp != null) {
					count += searchMatches(tmp, text);
				}
			} while(tmp != null);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return count;
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
