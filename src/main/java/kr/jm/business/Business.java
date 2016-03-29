package kr.jm.business;

import java.util.List;

import kr.jm.springboot.JMServiceSpringBootInterface;
import kr.jm.springboot.business.BusinessStatus;
import kr.jm.utils.destory.DestroyInterface;
import kr.jm.utils.destory.Destroyer;
import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.helper.JMLog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Business implements JMServiceSpringBootInterface {

	private BusinessStatus businessStatus;
	private List<DestroyInterface> destroyList;

	public Business(BusinessStatus businessStatus,
			List<DestroyInterface> destroyList) {
		this.businessStatus = businessStatus;
		this.destroyList = destroyList;
	}

	@Override
	public void start() {
		JMLog.infoBeforeStart(log, "start");
		try {
			System.out.println("JM Spring Boot Service Start !!!");
			throw new RuntimeException("[Sample Error] Hello World !!!");
		} catch (Exception e) {
			JMExceptionManager.logException(log, e, "start");
		}

	}

	@Override
	public void stop() {
		JMLog.infoBeforeStart(log, "Start Graceful Shutdown");
		Destroyer.cleanUp(destroyList);
		JMLog.infoBeforeStart(log, "Shutdown Completely");
	}

}
