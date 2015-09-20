package kr.jm.springboot;

import java.util.List;
import java.util.Map;

import kr.jm.utils.exception.ErrorMessageHistory;
import kr.jm.utils.exception.JMExceptionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class JMSpringBootController {
	
	@Autowired
	private JMServiceSpringBootStatus jmServiceSpringBootStatus;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public RedirectView mainRedirect() {
		return new RedirectView("/Dashboard.html");
	}
	
	@RequestMapping(value = "/ops/serviceInfo", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> systemInfo() {
		return jmServiceSpringBootStatus.getJMServiceInfo();
	}

	@RequestMapping(value = "/ops/jvm", method = RequestMethod.GET)
	public RedirectView monitoringJvmRedirect() {
		return new RedirectView("/ops/JVM.html");
	}

	@RequestMapping(value = "/ops/error/list", method = RequestMethod.GET)
	public @ResponseBody List<ErrorMessageHistory> getErrorList() {
		return JMExceptionManager.getErrorMessageHistoryList();
	}

	@RequestMapping(value = "/ops/error/list", method = RequestMethod.DELETE)
	public @ResponseBody void removeErrorList() {
		JMExceptionManager.removeErrorMessgeHistoryList();
	}

	@RequestMapping(value = "/ops/error/count/reset", method = RequestMethod.POST)
	public @ResponseBody void resetErrorCount() {
		JMExceptionManager.resetErrorCount();
	}

	@RequestMapping(value = "/ops/error/count", method = RequestMethod.GET)
	public @ResponseBody long getErrorCount() {
		return JMExceptionManager.getErrorCount();
	}

	@RequestMapping(value = "/ops/error", method = RequestMethod.GET)
	public RedirectView monitoringErrorView() {
		return new RedirectView("/ops/ErrorMessageView.html");
	}

}