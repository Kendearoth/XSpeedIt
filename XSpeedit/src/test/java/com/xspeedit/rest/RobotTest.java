package com.xspeedit.rest;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotTest {
	
	/**
	 *  Test that all articles are in the result of the sequential algorithm
	 */
	@Test
	public void packAllArticlesTest() {
		Articles art = new Articles();
		Robot r = new Robot();
		String res = r.pack(art);
		Boolean test = false;
		ArrayList<Integer> artArray = r.StringValueToArray(art.getArticles());
		System.out.println(artArray);
		for (int i = 0; i < res.length(); i++) {
			System.out.println(res.substring(i,i+1));
			if (res.substring(i,i+1).matches("[1-9]")) {
				if (artArray.contains(Character.getNumericValue(res.charAt(i)))) {
					artArray.remove(artArray.indexOf(Character.getNumericValue(res.charAt(i))));
					System.out.println(artArray);
				}
			}
		}
		if (artArray.size() == 0) {
			test = true;
		}
		assertTrue(true == test);
	}
	
	@Test
	public void packOptimizedAllArticlesTest() {
		Articles art = new Articles();
		Robot r = new Robot();
		String res = r.packOptimized(art);
		Boolean test = false;
		ArrayList<Integer> artArray = r.StringValueToArray(art.getArticles());
		System.out.println(artArray);
		for (int i = 0; i < res.length(); i++) {
			System.out.println(res.substring(i,i+1));
			if (res.substring(i,i+1).matches("[1-9]")) {
				if (artArray.contains(Character.getNumericValue(res.charAt(i)))) {
					artArray.remove(artArray.indexOf(Character.getNumericValue(res.charAt(i))));
					System.out.println(artArray);
				}
			}
		}
		if (artArray.size() == 0) {
			test = true;
		}
		assertTrue(true == test);
	}
}
