package kr.jm.springboot;

import kr.jm.springboot.business.status.BusinessStatus;
import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.time.JMTimeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class JMServiceSpringBootHealth extends AbstractHealthIndicator {
	private String upTimestamp = JMTimeUtil.getCurrentTimestampInUtc();

	@Autowired
	private BusinessStatus businessStatus;

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.withDetail("Up Timestamp", upTimestamp);
		builder.withDetail("Current Timestamp",
				JMTimeUtil.getCurrentTimestampInUtc());
		builder.withDetail("Error Count", JMExceptionManager.getErrorCount());
		businessStatus.checkStatus(builder);
	}

}
