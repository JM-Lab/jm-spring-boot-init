package kr.jm.springboot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.jm.business.Business;

@RestController
public class BusinessSpringBootController {

	@Autowired
	private Business business;

}
