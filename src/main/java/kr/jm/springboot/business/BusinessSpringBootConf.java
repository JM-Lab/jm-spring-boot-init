package kr.jm.springboot.business;

import java.util.List;

import kr.jm.business.Business;
import kr.jm.utils.destory.DestroyInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessSpringBootConf {

	// apply required = false
	@Autowired(required = false)
	private List<DestroyInterface> destroyList;

	@Bean
	public BusinessStatus businessStatus() {
		return new BusinessStatus();
	}

	@Bean
	@Autowired
	public Business business(BusinessStatus businessStatus) {
		return new Business(businessStatus, destroyList);
	}

}