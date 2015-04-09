package kr.jm.springboot.business;

import kr.jm.springboot.business.status.BusinessStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class BusinessSpringBootHealth extends AbstractHealthIndicator {

	@Autowired
	private BusinessStatus businessStatus;

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		// if (business.isRunning()) {
		// builder.withDetail("Timestamp", JMTimeUtil.getTime(
		// System.currentTimeMillis(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
		// builder.withDetail("Error Count", business.getErrorCount());
		// builder.withDetail("Output Failure Count",
		// business.getOutputFailureCount());
		// builder.status("OK");
		// } else {
		// builder.down();
		// }

	}

}
