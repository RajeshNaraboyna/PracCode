package com.restdacadoo.dacadooDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller("/")
public class DacadooDemoService {

	// @RequestMapping("/")
	public String getHealthData() {
		return "Success";
	}

}
