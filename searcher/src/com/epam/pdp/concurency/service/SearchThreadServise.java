package com.epam.pdp.concurency.service;

import com.epam.pdp.concurency.domain.FileInfo;


public interface SearchThreadServise {
	
	Thread createThread (FileInfo fileInfo);

}
