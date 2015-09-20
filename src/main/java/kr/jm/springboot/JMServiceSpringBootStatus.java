package kr.jm.springboot;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import kr.jm.utils.enums.OS;
import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public abstract class JMServiceSpringBootStatus {

	@Value("${info.app.name}")
	private String info;
	@Getter
	protected long startTimeMillis;
	private Map<String, Object> infoMap;

	@PostConstruct
	public void init() {
		this.startTimeMillis = System.currentTimeMillis();
		this.infoMap = new HashMap<>();
		this.infoMap.put("info", info);
		this.infoMap.put("hostname", OS.getHostname());
		this.infoMap.put("ip", OS.getIp());
		this.infoMap.put("startTimeMillis", startTimeMillis);
	}

	public Map<String, Object> getJMServiceInfo() {
		return infoMap;
	}

	protected void putInfo(String key, Object value) {
		infoMap.put(key, value);
	}

	abstract public void checkStatus(Builder builder);

}