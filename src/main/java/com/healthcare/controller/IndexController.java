package com.healthcare.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController implements ErrorController {

	public static final String PATH = "/error";

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}

	@RequestMapping("/error")
	public String error() {
		return "No mapping Found";
	}
}
