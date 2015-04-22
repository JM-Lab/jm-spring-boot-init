package kr.jm.springboot.business;

import kr.jm.business.Bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessSpringBootConf {

	@Bean
	public BusinessStatus businessStatus() {
		return new BusinessStatus();
	}

	@Bean
	@Autowired
	public Bussiness business(BusinessStatus businessStatus) {
		return new Bussiness(businessStatus);
	}

}