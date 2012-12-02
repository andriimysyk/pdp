package com.epam.pdp.concurency.service.impl;

import java.io.File;
import java.util.List;

import com.epam.pdp.concurency.service.AbstractSearchService;

public class DefaultSearchService extends AbstractSearchService {

	@Override
	public void startSearch(List<File> fiels, String text) {
		for (File f : fiels) {
			System.out.println(f.getName() + " " + this.search(f, text));
		}
	}

}
