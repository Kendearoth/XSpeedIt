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
;		for (int i = 0; i < articleString.length(); i++) {
			int x = Character.getNumericValue((articleString.charAt(i)));
			sumTmp += x;
			if (sumTmp > 10) {
				if (sumTmp == 10) {
					articlePacked = articlePacked.concat(articleString.substring(anchor, i+1)).concat("/");
					anchor = i+1;
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
	 * A function which pack articles focus on making pairs
	 * @param articles Object
	 * @return String representing the article packed
	 */
	public String packOptimized(Articles articles) {
		String articleString = articles.getArticles();
		String articlesPacked = "";
		int i = 0;
		
		ArrayList<Integer> articlesArray = StringValueToArray(articleString);
		Collections.sort(articlesArray);
		//System.out.println(articlesArray);
		
		while (i != articlesArray.size()) {
			int j = articlesArray.size() - 1;
			while (j != i) {
				int value = articlesArray.get(i);
				int valueSeek = 10 - value;
				if (articlesArray.get(j) == valueSeek) {
					//On a trouvé
					
					//On écrit la combinaison
					articlesPacked = articlesPacked.concat(String.valueOf(articlesArray.get(i)))
													.concat(String.valueOf(articlesArray.get(j))).concat("/");
					//On supprime les articles de la liste
					articlesArray.remove(j);
					articlesArray.remove(i);
					i = 0;
					j = articlesArray.size() - 1;
				} else {
					//On a pas trouvé, on continue de chercher
					j -= 1;
				}
			}
			// On a pas trouvé du tout, on recherche une autre combinaison
			i += 1;
		}
		//System.out.println(articlesArray);
		while (articlesArray.size() != 0) {
			int k = 0;
			int value = articlesArray.get(k);
			int l = articlesArray.size() - 1;
			while (k != l) {
				if (value + articlesArray.get(l) < 10) {
					//On a trouvé
					articlesPacked = articlesPacked.concat(String.valueOf(articlesArray.get(k)))
							.concat(String.valueOf(articlesArray.get(l))).concat("/");
					articlesArray.remove(l);
					articlesArray.remove(k);
					//System.out.println(articlesArray);
					break;
				} else {
					//On a pas trouvé
					l -= 1;
				}
			}
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
	 * @return ArrayList<Integer>
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
