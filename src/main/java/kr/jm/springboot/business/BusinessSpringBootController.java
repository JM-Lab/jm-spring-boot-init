package kr.jm.springboot.business;

import kr.jm.business.Bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BusinessSpringBootController {

	@Autowired
	private Bussiness business;

	// @RequestMapping(value = "/monitoring/status", method = RequestMethod.GET)
	// public @ResponseBody
	// Map<String, Object> monitoringSystemProcStatus() {
	// return systemProcStatus.getSystemProcStatus();
	// }
	//
	// @RequestMapping(value = "/monitoring/status/idps", method =
	// RequestMethod.GET)
	// public @ResponseBody
	// Double monitoringStatusIdps() {
	// return systemProcStatus.getInputDataPerSecond();
	// }
	//
	// @RequestMapping(value = "/monitoring/status/odps", method =
	// RequestMethod.GET)
	// public @ResponseBody
	// Double monitoringStatusOdps() {
	// return systemProcStatus.getOutputDataPerSecond();
	// }

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public RedirectView mainRedirect() {
	// return new RedirectView("/monitoring.html");
	// }

	// curl에서 '&' 사용 curl -i -H "Content-Type: application/json" -d '{name:asd}'
	// -X PUT localhost:9090/heartbeat/test/ok?authCode=1234
	// @RequestMapping(value = "/collet/monitoring/{cloudServiceId}", method =
	// RequestMethod.GET, consumes = "application/json")
	// public @ResponseBody
	// List<String> collectMonitoringData(@PathVariable String cloudServiceId,
	// @RequestParam(required = true) int intervalInMinutes,
	// @RequestParam(required = true) int monitoringCount,
	// @RequestParam(required = true) String region,
	// @RequestParam(required = true) String metricName) {
	// assert (business.vaild(cloudServiceId));
	// long beforeTimestamp = System.currentTimeMillis();
	// return business.getWatchingData(cloudServiceId,
	// intervalInMinutes, monitoringCount, region, metricName,
	// beforeTimestamp);
	// }

	// @Autowired
	// private WatchPlanet watchPlanet;
	//
	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public @ResponseBody
	// String getDefault() {
	// return "Hello World!!";
	// }
	//
	// @RequestMapping(value = "/qos/{targetId}/now", method =
	// RequestMethod.GET)
	// public @ResponseBody
	// QosDO getQosNow(@PathVariable String targetId) {
	// return watchPlanet.testQosNow(targetId);
	// }
	//
	// @RequestMapping(value = "/qos/{targetId}", method = RequestMethod.GET)
	// public @ResponseBody
	// QosDO getOneMinuteQos(@PathVariable String targetId) {
	// return watchPlanet.getOneMinuteQos(targetId);
	// }
	//
	// @RequestMapping(value = "/data/{targetId}", method = RequestMethod.GET)
	// public @ResponseBody
	// List<QosDO> getQosList(@PathVariable String targetId) {
	// return watchPlanet.getTenSecondsQosList(targetId);
	// }
	//
	// // curl에서 '&' 사용 curl -i -H "Content-Type: application/json" -d
	// '{name:asd}'
	// // -X PUT localhost:9090/heartbeat/test/ok?authCode=1234
	// @RequestMapping(value = "/heartbeat/{targetId}/ok", method =
	// RequestMethod.PUT, consumes = "application/json")
	// public @ResponseBody
	// QosDO putHeartbeatOk(@PathVariable String targetId,
	// @RequestParam(required = true) String authCode,
	// @RequestBody(required = false) String info) {
	//
	// QosDO qosDO = watchPlanet.receiveQos(targetId, authCode,
	// HeartbeatStatus.OK.name(), info);
	//
	// return qosDO;
	// }
	//
	// // curl에서 '&' 사용 curl -i -H "Content-Type: application/json" -d
	// '{name:asd}'
	// // -X PUT localhost:9090/heartbeat/test/no?authCode=1234
	// @RequestMapping(value = "/heartbeat/{targetId}/no", method =
	// RequestMethod.PUT, consumes = "application/json")
	// public @ResponseBody
	// QosDO putHeartbeatNo(@PathVariable String targetId,
	// @RequestParam(required = true) String authCode,
	// @RequestBody(required = false) String info) {
	//
	// QosDO qosDO = watchPlanet.receiveQos(targetId, authCode,
	// HeartbeatStatus.NO.name(), info);
	//
	// return qosDO;
	// }

}