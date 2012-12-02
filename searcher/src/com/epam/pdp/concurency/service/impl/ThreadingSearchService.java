package com.epam.pdp.concurency.service.impl;

import java.io.File;
import java.util.List;

import com.epam.pdp.concurency.service.AbstractSearchService;

public class ThreadingSearchService extends AbstractSearchService {

	@Override
	public void startSearch(List<File> fiels, String text) {
		for (File file : fiels) {
			createThread(file, text).start();
		}

	}

	public Thread createThread(final File file, final String text) {

		return new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(file.getName() + " " + search(file, text));
			}
		});
	}

}
