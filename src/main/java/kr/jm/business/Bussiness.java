package kr.jm.business;

import kr.jm.springboot.JMServiceSpringBootInterface;
import kr.jm.springboot.business.status.BusinessStatus;
import kr.jm.utils.exception.JMExceptionManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bussiness implements JMServiceSpringBootInterface {

	private BusinessStatus businessStatus;

	public Bussiness(BusinessStatus businessStatus) {
		this.businessStatus = businessStatus;
	}

	@Override
	public void start() {
		try {
			System.out.println("Bussiness Start !!!");
			throw new RuntimeException("Sample Error!!!");
		} catch (Exception e) {
			JMExceptionManager.logExption(log, e, "start");
		}

	}

}