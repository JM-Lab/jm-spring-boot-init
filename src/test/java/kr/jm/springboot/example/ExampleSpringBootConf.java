package kr.jm.springboot.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.jm.example.Example;
import kr.jm.utils.destory.DestroyInterface;

@Configuration
public class ExampleSpringBootConf {

	// apply required = false
	@Autowired(required = false)
	private List<DestroyInterface> destroyList;

	@Bean
	public ExampleStatus exampleStatus() {
		return new ExampleStatus();
	}

	@Bean
	@Autowired
	public Example example(ExampleStatus exampleStatus) {
		return new Example(exampleStatus, destroyList);
	}

}
