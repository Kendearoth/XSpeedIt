package com.xspeedit.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller of XSpeedit application. It contains REST function
 * @author corentin
 *
 */
@Controller
public class XSpeeditController {

	/**
	 * Function that is triggered with : "http://localhost:8080/pack?articles=[1-9]*"
	 * @param String representing the articles to be packed
	 * @return String of articles packed
	 */
	@RequestMapping("/pack")
	public @ResponseBody String get(@RequestParam(value="articles") String articles) {
		Articles art = new Articles(articles);
		Robot r = new Robot();
		return r.packOptimized(art);
	}
}
