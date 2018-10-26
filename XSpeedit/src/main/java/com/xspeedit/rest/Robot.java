package com.xspeedit.rest;
import java.util.ArrayList;
import java.util.*;

/**
 * A Robot is a class that manipulate sequences of articles of multiple size.
 *
 * @author corentin
 *
 */
public class Robot {

	public Robot() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * The function read the article flow sequentially and split them
	 * @param articles Object
	 * @return String representing the articles packed
	 */
	public String pack(Articles articles) {
		String articleString = articles.getArticles();
		String articlePacked = "";
		int anchor = 0;
		int sumTmp = 0;
		//For every articles we sum them sequentially until the sum is greater than 10
;		for (int i = 0; i < articleString.length(); i++) {
			int x = Character.getNumericValue((articleString.charAt(i)));
			sumTmp += x;
			if (sumTmp > 10) {
				//If it's equal 10, we put the articles into box (i.e we add a slash after the precedent articles)
				if (sumTmp == 10) {
					articlePacked = articlePacked.concat(articleString.substring(anchor, i+1)).concat("/");
					anchor = i+1;
				//if not, we put the precedent articles except the last counted, and resume packing at i-1
				} else {
					articlePacked = articlePacked.concat(articleString.substring(anchor, i)).concat("/");
					anchor = i;
					i = i-1;
				}
				sumTmp = 0;
			}	
		}
		if (sumTmp > 0) {
			articlePacked = articlePacked.concat(articleString.substring(anchor, articleString.length()).concat("/"));
		}
			
		return articlePacked.substring(0, articlePacked.length() - 1);
	}
	
	/**
	 * A function which pack articles focusing on making pairs
	 * @param articles Object
	 * @return String representing of the article packed
	 */
	public String packOptimized(Articles articles) {
		String articleString = articles.getArticles();
		String articlesPacked = "";
		int i = 0;
		
		//The sequence of articles is cast to an array in order to be sorted
		ArrayList<Integer> articlesArray = StringValueToArray(articleString);
		Collections.sort(articlesArray);
		
		// While the iterator hasn't reach the end of the sequence
		while (i != articlesArray.size()) {
			int j = articlesArray.size() - 1;
			// while j and i are different, we try to find the complementary value (10 - value) of the articles at the index i
			while (j != i) {
				int value = articlesArray.get(i);
				int valueSeek = 10 - value;
				//if we find it, we add the pair to the result and remove the two articles from the array
				if (articlesArray.get(j) == valueSeek) {
					
					articlesPacked = articlesPacked.concat(String.valueOf(articlesArray.get(i)))
													.concat(String.valueOf(articlesArray.get(j))).concat("/");
					articlesArray.remove(j);
					articlesArray.remove(i);
					i = 0;
					j = articlesArray.size() - 1;
				//if not we iterate on j to check another pair
				} else {
					j -= 1;
				}
			}
			// if the pair doesn't exist, we iterate on i
			i += 1;
		}
		//It last the articles that doesn't have perfect pairs
		//So we try to make pairs by minimizing the lost
		while (articlesArray.size() != 0) {
			int k = 0;
			int value = articlesArray.get(k);
			int l = articlesArray.size() - 1;
			while (k != l) {
				if (value + articlesArray.get(l) < 10) {
					articlesPacked = articlesPacked.concat(String.valueOf(articlesArray.get(k)))
							.concat(String.valueOf(articlesArray.get(l))).concat("/");
					articlesArray.remove(l);
					articlesArray.remove(k);
					break;
				} else {
					l -= 1;
				}
			}
			//if no pair exist we put only one article into a box
			if ((articlesArray.size() != 0) && (k == l)) {
				articlesPacked = articlesPacked.concat(String.valueOf(articlesArray.get(k))).concat("/");
				articlesArray.remove(k);
			}
		}
		return articlesPacked.substring(0, articlesPacked.length() - 1);
	}
	
	/**
	 * Function that transform the sequence of articles representation into an ArrayList of Integers
	 * @param str : the sequence of articles (an integer represent its size)
	 * @return ArrayList of Integer
	 */
	public ArrayList<Integer> StringValueToArray(String str) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			int x = Character.getNumericValue(str.charAt(i));
			result.add(x);
		}
		return result;
	}
}
