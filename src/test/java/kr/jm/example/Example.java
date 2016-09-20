package kr.jm.example;

import java.util.List;

import kr.jm.utils.destory.DestroyInterface;
import kr.jm.utils.destory.Destroyer;
import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.helper.JMLog;
import kr.jm.utils.helper.JMOptional;
import lombok.extern.slf4j.Slf4j;
import springboot.AbstractJMSpringBootStatus;
import springboot.JMSpringBootApplication;
import springboot.JMSpringBootInterface;

@Slf4j
public class Example implements JMSpringBootInterface {

	private AbstractJMSpringBootStatus backendStatus;
	private List<DestroyInterface> destroyList;

	public Example(AbstractJMSpringBootStatus backendStatus,
			List<DestroyInterface> destroyList) {
		this.backendStatus = backendStatus;
		this.destroyList = destroyList;
	}

	public static void main(String[] args) {
		JMSpringBootApplication.main(args);
	}

	@Override
	public void start() {
		JMLog.info(log, "start");
		try {
			System.out.println(backendStatus.getInfo() + " Start !!!");
			throw new RuntimeException("[Sample Error] Hello World !!!");
		} catch (Exception e) {
			JMExceptionManager.logException(log, e, "start");
		}

	}

	@Override
	public void stop() {
		JMLog.info(log, "Start Graceful Shutdown");
		JMOptional.getOptional(destroyList).ifPresent(Destroyer::cleanUp);
		JMLog.info(log, "Shutdown Completely");
	}

}
