package com.epam.pdp.concurency.domain;

import java.io.File;

public class FileInfo {
	
	private File file;
	private Integer matchesCount;
	private String searchedText;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public Integer getMatchesCount() {
		return matchesCount;
	}
	public void setMatchesCount(Integer matchesCount) {
		this.matchesCount = matchesCount;
	}
	public String getSearchedText() {
		return searchedText;
	}
	public void setSearchedText(String searchedText) {
		this.searchedText = searchedText;
	}

}
