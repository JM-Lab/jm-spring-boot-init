package kr.jm.springboot;

import static kr.jm.utils.helper.JMConsumer.getSOPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import kr.jm.utils.helper.JMResources;
import kr.jm.utils.helper.JMStream;

@SpringBootApplication
// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableScheduling
public class JMSpringBootApplication {

	private static final String LOGGING_PATH = "logging.path";

	static {
		if (!System.getProperties().containsKey(LOGGING_PATH))
			System.setProperty(LOGGING_PATH, "log");
		JMResources.setSystemPropertyIfIsNull("logging.level", "INFO");
	}

	public static void main(String[] args) {

		ApplicationContext applicationContext =
				SpringApplication.run(JMSpringBootApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		JMStream.buildStream(applicationContext.getBeanDefinitionNames())
				.sorted().forEach(getSOPL());

		// service start
		applicationContext
				.getBean("jmSpringBootService", JMSpringBootInterface.class)
				.start();

	}

	@Bean(destroyMethod = "stop")
	@Autowired
	public JMSpringBootInterface
			jmSpringBootService(JMSpringBootInterface jmSpringBootService) {
		return jmSpringBootService;
	}

}
