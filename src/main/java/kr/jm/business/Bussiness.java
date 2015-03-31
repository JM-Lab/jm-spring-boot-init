package kr.jm.business;

import kr.jm.springboot.JMServiceSpringBootInterface;
import kr.jm.springboot.business.status.BusinessStatus;

import org.springframework.stereotype.Service;

public class Bussiness implements JMServiceSpringBootInterface{

	private BusinessStatus businessStatus;
	
	public Bussiness(BusinessStatus businessStatus) {
		this.businessStatus = businessStatus;
	}

	@Override
	public void start() {
		System.out.println("Bussiness Start !!!");	
	}
	
}