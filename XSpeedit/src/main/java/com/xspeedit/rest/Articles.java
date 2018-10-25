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
	 * The constructor creates an array of articles of different sizes randomly.
	 * The size of the array is defined by the Size parameter of the Articles class.
	 */
	public Articles() {
		
		String articles = "";
		
		for (int i = 0; i < this.size; i++) {
			int tmp = (((int) (Math.random() * 9)) + 1);
			String str = String.valueOf(tmp);
			articles = articles.concat(str);
		}
		
		this.articles = articles;
	}
	
	/**
	 * Gets the array of articles
	 * @return String
	 */
	public String getArticles() {
		return articles;
	}
	
	/**
	 * Gets the size of the array of article
	 * @return Integer
	 */
	public int getSize() {
		return size;
	}
}
