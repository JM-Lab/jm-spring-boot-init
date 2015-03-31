package kr.jm.springboot.business;

import kr.jm.business.Bussiness;
import kr.jm.springboot.JMServiceSpringBootInterface;
import kr.jm.springboot.business.status.BusinessStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
public class BusinessSpringBootConf {

	// @Bean
	// public CollectorBuilderInterface collectorBuilder() {
	// return new PlandasIdcQosCollectorBuilder();
	// }
	//
	// @Bean
	// @Autowired
	// public QosCollectorBundle qosCollectorBundle(
	// CollectorBuilderInterface collectorBuilder,
	// @Value("${application.collector.properties}") String
	// collectorPropertiesPath) {
	// return BundleBuilder.buildBunndle(new QosCollectorBundle(
	// collectorBuilder), ResourcesManager.getProperties(new File(
	// collectorPropertiesPath)));
	// }
	//
	// @Bean
	// public ReceiverBuilderInterface receiverBuilder() {
	// return new HeartbeatReceiverBuilder();
	// }
	//
	// @Bean
	// @Autowired
	// public QosReceiverBundle qosRecieverBundle(
	// ReceiverBuilderInterface receiverBuilder,
	// @Value("${application.receiver.properties}") String
	// receiverPropertiesPath) {
	// return BundleBuilder.buildBunndle(
	// new QosReceiverBundle(receiverBuilder), ResourcesManager
	// .getProperties(new File(receiverPropertiesPath)));
	// }
	//
	// @Bean
	// public Properties dataStoreProperties(
	// @Value("${application.datastore.properties}") String
	// dataStorePropertiesPath) {
	// return ResourcesManager
	// .getProperties(new File(dataStorePropertiesPath));
	// }
	//
	// @Bean
	// public DataStoreBuilderInterface dataStoreBuilder() {
	// return new PlandasRedisDatastoreBuilder();
	// }
	//
	// @Bean
	// @Autowired
	// public DataStoreBundle dataStoreBundle(
	// DataStoreBuilderInterface dataStoreBuilder,
	// Properties dataStoreProperties) {
	// return BundleBuilder.buildBunndle(
	// new DataStoreBundle(dataStoreBuilder), dataStoreProperties);
	// }
	//
	// @Bean
	// public StatusDecisionMakerInterface simpleStatusDecisionMaker() {
	// return new SimpleStatusDecisionMaker();
	// }
	//
	// @Bean
	// @Lazy
	// public StatusDecisionMakerInterface droolsStatusDecisionMaker(
	// @Value("${application.drools.rulePath}") String rulePath)
	// throws URISyntaxException {
	// return new DroolsStatusDecisionMaker(new File(rulePath));
	// }
	//
	// @Bean
	// @Autowired
	// public QosDataManager qosDataManager(
	// @Value("${application.datamanager.limitedQueueSize}") int
	// limitedQueueSize,
	// QosCollectorBundle qosCollectorBundle,
	// QosReceiverBundle qosReceiverBundle) {
	// return new QosDataManager(limitedQueueSize, qosCollectorBundle,
	// qosReceiverBundle);
	// }
	//
	// @Bean
	// @Autowired
	// public QosDataAccumulator qosDataAccumulator(
	// QosDataManager qosDataManager,
	// @Qualifier("simpleStatusDecisionMaker") StatusDecisionMakerInterface
	// statusDecisionMaker) {
	// return new QosDataAccumulator(qosDataManager, statusDecisionMaker);
	// }
	
	@Bean
	public BusinessStatus businessStatus() {
		return new BusinessStatus();
	}

	@Bean
	@Autowired
	public Bussiness business(BusinessStatus businessStatus) {
		return new Bussiness(businessStatus);
	}
	
	@Bean
	@Autowired
	public JMServiceSpringBootInterface jmService(JMServiceSpringBootInterface jmService) {
		return jmService;
	}
}