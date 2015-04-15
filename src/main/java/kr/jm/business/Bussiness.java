package kr.jm.business;

import kr.jm.springboot.JMServiceSpringBootInterface;
import kr.jm.springboot.business.status.BusinessStatus;
import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.helper.JMLog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bussiness implements JMServiceSpringBootInterface {

	private BusinessStatus businessStatus;

	public Bussiness(BusinessStatus businessStatus) {
		this.businessStatus = businessStatus;
	}

	@Override
	public void start() {
		JMLog.logMethodStartInfo(log, "start");
		try {
			System.out.println("JM Service Spring Boot Start !!!");
			throw new RuntimeException("Sample Error!!!");
		} catch (Exception e) {
			JMExceptionManager.logException(log, e, "start");
		}

	}

	@Override
	public void stop() {
		JMLog.logMethodStartInfo(log, "stop");
		// TODO Auto-generated method stub

	}

}