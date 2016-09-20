package springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import kr.jm.utils.exception.JMExceptionManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class JMSpringBootExceptionLogHandler {
	@ExceptionHandler(Exception.class)
	public ModelAndView logErrorHandler(HttpServletRequest req, Exception e)
			throws Exception {
		JMExceptionManager.logException(log, e, "logErrorHandler", req);
		throw e;
	}
}
