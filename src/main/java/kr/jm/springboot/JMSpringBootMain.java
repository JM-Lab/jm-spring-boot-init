package kr.jm.springboot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class JMSpringBootMain {

	private static final String LOGGING_PATH = "logging.path";
	private static final String LOGGING_LEVEL = "logging.level";
	
	static {
		if (!System.getProperties().containsKey(LOGGING_PATH))
			System.setProperty(LOGGING_PATH, "log");
		if (!System.getProperties().containsKey(LOGGING_LEVEL))
			System.setProperty(LOGGING_LEVEL, "INFO");
	}

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(JMSpringBootConf.class,
				args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames)
			System.out.println(beanName);

		// service start
		JMServiceSpringBootInterface jmServiceSpringBoot = ctx.getBean(
				"jmService", JMServiceSpringBootInterface.class);
		jmServiceSpringBoot.start();
	}

}
