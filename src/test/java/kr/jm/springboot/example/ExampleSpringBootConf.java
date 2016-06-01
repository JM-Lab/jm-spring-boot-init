package kr.jm.springboot.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.jm.example.Example;
import kr.jm.springboot.AbstractJMSpringBootStatus;
import kr.jm.utils.destory.DestroyInterface;

@Configuration
public class ExampleSpringBootConf {

	// apply required = false
	@Autowired(required = false)
	private List<DestroyInterface> destroyList;

	@Bean
	@Autowired
	public Example example(AbstractJMSpringBootStatus backendStatus) {
		return new Example(backendStatus, destroyList);
	}

}
