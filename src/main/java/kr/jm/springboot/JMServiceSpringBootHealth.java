package kr.jm.springboot;

import kr.jm.utils.exception.JMExceptionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class JMServiceSpringBootHealth extends AbstractHealthIndicator {

	@Autowired
	private JMServiceSpringBootStatus jmServiceSpringBootStatus;

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		builder.withDetail("Error Count", JMExceptionManager.getErrorCount());
		jmServiceSpringBootStatus.checkStatus(builder);
	}

}
