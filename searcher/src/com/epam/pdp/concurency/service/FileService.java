package com.epam.pdp.concurency.service;

import java.io.File;
import java.util.List;

public interface FileService {
	
	List<File> getAllFiles(String path);
}
