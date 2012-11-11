package com.epam.pdp.concurency.service.impl;

import com.epam.pdp.concurency.domain.FileInfo;
import com.epam.pdp.concurency.service.FileService;
import com.epam.pdp.concurency.service.SearchThreadServise;

public class DefaultSearchThreadService implements SearchThreadServise {
	
	private FileService fileService = new DefaultFileService();

	@Override
	public Thread createThread(final FileInfo fileInfo) {
		
		return new Thread(new Runnable() {
			@Override
			public void run() {
				fileService.search(fileInfo);
				System.out.println(fileInfo.getFile().getName() + " " + fileInfo.getMatchesCount());
			}
		});
	}

}
