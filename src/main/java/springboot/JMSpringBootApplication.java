package springboot;

import static kr.jm.utils.helper.JMConsumer.getSOPL;
import static kr.jm.utils.helper.JMOptional.getOptional;

import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import kr.jm.utils.enums.OS;
import kr.jm.utils.helper.JMResources;
import kr.jm.utils.helper.JMStream;
import kr.jm.utils.helper.JMString;

@SpringBootApplication
// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableScheduling
public class JMSpringBootApplication {

	static {
		Properties applicationProperties =
				JMResources.getProperties("application.properties");
		String loggingPath = "logging.path";
		JMResources.setSystemPropertyIfIsNull(loggingPath,
				getOptional(applicationProperties, loggingPath).orElse("log"));
		JMResources.setSystemPropertyIfIsNull("logging.level",
				getOptional(applicationProperties, "logging.level.root")
						.orElse("INFO"));
		JMResources.setSystemPropertyIfIsNull("info.monitoring",
				"http://" + OS.getIp()
						+ Optional
								.ofNullable(applicationProperties
										.getProperty("server.port"))
								.map(o -> ":" + o).orElse(JMString.EMPTY)
						+ "/ops/jvm");
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
