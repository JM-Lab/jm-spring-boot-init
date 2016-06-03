package kr.jm.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import kr.jm.utils.datastructure.JMCollections;
import kr.jm.utils.exception.ErrorMessageHistory;
import kr.jm.utils.exception.JMExceptionManager;

@RestController
@RequestMapping("/ops")
public class JMSpringBootController {

	@Autowired
	private AbstractJMSpringBootStatus jmServiceSpringBootStatus;

	@RequestMapping(method = RequestMethod.GET)
	public RedirectView mainRedirect() {
		return new RedirectView("/Dashboard.html");
	}

	@RequestMapping(value = "serviceInfo", method = RequestMethod.GET)
	public @ResponseBody AbstractJMSpringBootStatus serviceInfo() {
		return jmServiceSpringBootStatus;
	}

	@RequestMapping(value = "jvm", method = RequestMethod.GET)
	public RedirectView monitoringJvmRedirect() {
		return new RedirectView("/ops/JVM.html");
	}

	@RequestMapping(value = "error/list", method = RequestMethod.GET)
	public @ResponseBody List<ErrorMessageHistory> getErrorList() {
		return JMCollections
				.getReversed(JMExceptionManager.getErrorMessageHistoryList());
	}

	@RequestMapping(value = "error/list", method = RequestMethod.DELETE)
	public @ResponseBody void removeErrorList() {
		JMExceptionManager.removeErrorMessgeHistoryList();
	}

	@RequestMapping(value = "error/count/reset", method = RequestMethod.POST)
	public @ResponseBody void resetErrorCount() {
		JMExceptionManager.resetErrorCount();
	}

	@RequestMapping(value = "error/count", method = RequestMethod.GET)
	public @ResponseBody long getErrorCount() {
		return JMExceptionManager.getErrorCount();
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public RedirectView monitoringErrorView() {
		return new RedirectView("/ops/ErrorMessageView.html");
	}

}
