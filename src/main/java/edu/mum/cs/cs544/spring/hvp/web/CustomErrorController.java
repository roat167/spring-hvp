package edu.mum.cs.cs544.spring.hvp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController {// implements ErrorController {
	private static final String PATH = "/errorTest";
	
	@RequestMapping(value = PATH)
    public String error() {
        return "error";
    }
	//@Override
	public String getErrorPath() {		
		return PATH;
	}

}
