package springboot;

import kr.jm.utils.enums.OS;
import kr.jm.utils.helper.JMStream;
import kr.jm.utils.helper.JMString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

import static kr.jm.utils.helper.JMConsumer.getSOPL;
import static kr.jm.utils.helper.JMOptional.getOptional;
import static kr.jm.utils.helper.JMResources.getProperties;
import static kr.jm.utils.helper.JMResources.setSystemPropertyIfIsNull;

@SpringBootApplication
// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableScheduling
public class JMSpringBootApplication {

    static {
        Properties applicationProperties = getApplicationProperties();
        String loggingPath = "logging.path";
        setSystemPropertyIfIsNull(loggingPath,
                getOptional(applicationProperties, loggingPath).orElse("log"));
        setSystemPropertyIfIsNull("logging.level",
                getOptional(applicationProperties, "logging.level.root")
                        .orElse("INFO"));
        setSystemPropertyIfIsNull("info.monitoring", "http://" + OS.getIp()
                + getOptional(applicationProperties, "server.port")
                .map(o -> ":" + o).orElse(JMString.EMPTY) + "/ops/jvm");
    }

    private static Properties getApplicationProperties() {
        String APPLICATION_PROPERTIES = "application.properties";
        try {
            return getProperties("BOOT-INF/classes/" + APPLICATION_PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
            return getProperties(APPLICATION_PROPERTIES);
        }
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
