package kr.jm.springboot.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.jm.example.Example;

@RestController
public class ExampleSpringBootController {

	@Autowired
	private Example example;

}
