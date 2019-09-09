package com.itsol.smartoffice.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

}
