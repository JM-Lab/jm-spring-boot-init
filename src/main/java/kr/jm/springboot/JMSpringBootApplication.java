package kr.jm.springboot;

import java.util.Arrays;

import kr.jm.utils.helper.JMResources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

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

		ApplicationContext ctx = SpringApplication.run(
				JMSpringBootApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames)
			System.out.println(beanName);

		// service start
		JMServiceSpringBootInterface jmService = ctx.getBean("jmService",
				JMServiceSpringBootInterface.class);
		jmService.start();

	}

	@Bean(destroyMethod = "stop")
	@Autowired
	public JMServiceSpringBootInterface jmService(
			JMServiceSpringBootInterface jmService) {
		return jmService;
	}

}
