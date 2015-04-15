package kr.jm.springboot.business.status;

import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Service;

@Service
public class BusinessStatus {

	public void checkStatus(Builder builder) {
		// TODO Auto-generated method stub
		builder.status("Good");
	}

	// start business logic

}