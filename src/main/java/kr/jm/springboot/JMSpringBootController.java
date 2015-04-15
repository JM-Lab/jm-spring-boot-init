package kr.jm.springboot;

import java.util.List;

import kr.jm.utils.exception.ErrorMessageHistory;
import kr.jm.utils.exception.JMExceptionManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class JMSpringBootController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public RedirectView mainRedirect() {
		return new RedirectView("/info");
	}

	@RequestMapping(value = "/monitoring/jvm", method = RequestMethod.GET)
	public RedirectView monitoringJvmRedirect() {
		return new RedirectView("/monitoring/JVM.html");
	}

	@RequestMapping(value = "/monitoring/error/list", method = RequestMethod.GET)
	public @ResponseBody List<ErrorMessageHistory> monitoringErrorList() {
		return JMExceptionManager.getErrorMessageHistoryList();
	}

	@RequestMapping(value = "/monitoring/error/view", method = RequestMethod.GET)
	public RedirectView monitoringErrorView() {
		return new RedirectView("/monitoring/ErrorMessageView.html");
	}

}