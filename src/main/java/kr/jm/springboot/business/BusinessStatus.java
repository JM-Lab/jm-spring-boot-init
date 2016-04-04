package kr.jm.springboot.business;

import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import kr.jm.springboot.AbstractJMSpringBootStatus;

@Component
public class BusinessStatus extends AbstractJMSpringBootStatus {

	@Override
	public void checkStatus(Builder builder) {
		// TODO Auto-generated method stub
		builder.status("Good");
	}

}
