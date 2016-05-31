package kr.jm.springboot.example;

import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import kr.jm.springboot.AbstractJMSpringBootStatus;

@Component
public class ExampleStatus extends AbstractJMSpringBootStatus {

	@Override
	public void checkStatus(Builder builder) {
		// TODO Auto-generated method stub
		builder.status("Good");
	}

}
