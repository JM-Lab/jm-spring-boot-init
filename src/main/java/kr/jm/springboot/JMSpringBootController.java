package kr.jm.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class JMSpringBootController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	String getDefault(@Value("${info.app.name}") String appName) {
		return "Hello " + appName;
	}

	@RequestMapping(value = "/monitoring/jvm", method = RequestMethod.GET)
	public RedirectView monitoringJvmRedirect() {
		return new RedirectView("/monitoring/JVM.html");
	}

	@RequestMapping(value = "/monitoring", method = RequestMethod.GET)
	public RedirectView monitoringSystemProcStatusViewRedirect() {
		return new RedirectView("/monitoring/StatusView.html");
	}

}