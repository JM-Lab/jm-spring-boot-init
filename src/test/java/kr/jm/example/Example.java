package kr.jm.example;

import java.util.List;

import kr.jm.springboot.AbstractJMSpringBootStatus;
import kr.jm.springboot.JMSpringBootApplication;
import kr.jm.springboot.JMSpringBootInterface;
import kr.jm.utils.destory.DestroyInterface;
import kr.jm.utils.destory.Destroyer;
import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.helper.JMLog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example extends JMSpringBootApplication
		implements JMSpringBootInterface {

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
		JMLog.infoBeforeStart(log, "start");
		try {
			System.out.println(backendStatus.getInfo() + " Start !!!");
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
