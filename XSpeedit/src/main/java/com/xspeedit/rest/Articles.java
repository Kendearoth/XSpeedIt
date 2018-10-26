package com.xspeedit.rest;

/**
 * This class represent a random array of articles of different sizes
 * @author corentin
 *
 */
public class Articles  {
	
	private int size = 15;
	private String articles;
	
	/**
	 * The constructor creates a string of number between 1 and 9 representing the size of an article
	 * The size of the string is 15 by default.
	 */
	public Articles() {
		
		String articles = "";
		
		for (int i = 0; i < this.size; i++) {
			int tmp = (((int) (Math.random() * 9)) + 1);
			articles = articles.concat(String.valueOf(tmp));
		}
		
		this.articles = articles;
	}
	
	/**
	 * Constructor by String representation
	 * @param articles
	 */
	public Articles(String articles) {
		//Functions to verify that the String is OK
		
		this.size = articles.length();
		this.articles = articles;
	}
	
	/**
	 * Constructor by copy
	 * @param articles 
	 */
	public Articles(Articles articles) {
		this.size = articles.getSize();
		this.articles = articles.getArticles();
	}
	
	/**
	 * Gets the string representing the articles
	 * @return String
	 */
	public String getArticles() {
		return articles;
	}
	
	/**
	 * Gets the size of the string representing the article
	 * @return Integer
	 */
	public int getSize() {
		return size;
	}
}
