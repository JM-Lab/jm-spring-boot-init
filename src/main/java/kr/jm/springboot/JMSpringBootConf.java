package kr.jm.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableAutoConfiguration
// @PropertySources({
// @PropertySource("classpath:default-application.properties") })
// @PropertySource(name = "idcInfo", value ="classpath:idc-info.properties")})
// @PropertySource("classpath:services.properties")
@EnableScheduling
public class JMSpringBootConf {

	@Bean
	@Autowired
	public JMServiceSpringBootInterface jmService(
			JMServiceSpringBootInterface jmService) {
		return jmService;
	}

}