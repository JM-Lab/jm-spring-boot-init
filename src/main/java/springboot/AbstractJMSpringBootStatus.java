package springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

import kr.jm.utils.enums.OS;
import lombok.Getter;

@Component
@Getter
public abstract class AbstractJMSpringBootStatus {

	@Value("${info.name}")
	private String info;
	private String hostname = OS.getHostname();
	private String ip = OS.getIp();
	protected long startTimeMillis = System.currentTimeMillis();

	abstract public void checkStatus(Builder builder);

}
