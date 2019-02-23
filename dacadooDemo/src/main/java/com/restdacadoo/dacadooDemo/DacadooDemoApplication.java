package com.restdacadoo.dacadooDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DacadooDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DacadooDemoApplication.class, args);
	}

	@RequestMapping("/dacadoo/gethealth")
	public String getHealth() {
		return "{\"scr\":718,\"lcl\":137,\"ucl\":73,\"rqy\":3.07766126409,\"components\":"
				+ "{\"lfs\":690,\"bdy\":827,\"fee\":509},\"subscores\":{\"mvm\":317,\"nut\":550,\"smk\""
				+ ":1000,\"obe\":942,\"slp\":514,\"dep\":555,\"wel\":570,\"str\":553}}";
	}

}
