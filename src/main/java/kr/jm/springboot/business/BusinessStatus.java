package kr.jm.springboot.business;

import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import kr.jm.springboot.JMServiceSpringBootStatus;

@Component
public class BusinessStatus extends JMServiceSpringBootStatus {

	public void checkStatus(Builder builder) {
		// TODO Auto-generated method stub
		builder.status("Good");
	}

}
