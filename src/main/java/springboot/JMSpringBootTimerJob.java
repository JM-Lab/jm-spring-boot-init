package springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import kr.jm.utils.exception.JMExceptionManager;
import kr.jm.utils.helper.JMLog;
import kr.jm.utils.helper.JMOptional;
import lombok.extern.slf4j.Slf4j;
import springboot.timerjob.Every1MinuteJobInterface;

@Service
@Slf4j
public class JMSpringBootTimerJob {

	@Autowired(required = false)
	private List<Every1MinuteJobInterface> every1MinuteJobList;

	@Scheduled(initialDelay = 0, fixedRate = 60000)
	public void workEvery1Minute() {
		JMLog.info(log, "workEvery1Minute", every1MinuteJobList);
		JMOptional.getOptional(every1MinuteJobList)
				.ifPresent(this::runEvery1Minute);
	}

	private void runEvery1Minute(List<Every1MinuteJobInterface> list) {
		list.forEach(this::runBatchJobWithHandlingException);
	}

	private void runBatchJobWithHandlingException(
			Every1MinuteJobInterface batchJob) {
		try {
			batchJob.runEvery1Minute();
		} catch (Exception e) {
			JMExceptionManager.logException(log, e, "runEvery1Minute",
					batchJob);
		}
	}

	@Scheduled(cron = "0 0 */1 * * *")
	public void workEvery1Hour() {

	}

}
