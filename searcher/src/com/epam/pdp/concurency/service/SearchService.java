package com.epam.pdp.concurency.service;

import java.io.File;
import java.util.List;

public interface SearchService {

	void startSearch(List<File> fiels, String text);
}
