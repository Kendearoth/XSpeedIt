package com.xspeedit.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XSpeeditApplication {

	public static void main(String[] args) {
		SpringApplication.run(XSpeeditApplication.class, args);
		Articles art = new Articles();
		System.out.println(art.getArticles());
		Robot r = new Robot();
		String response = r.pack((art));
		System.out.println(response);
		String responseOpti = r.packOptimized(art);
		System.out.println(responseOpti);
	}
}
