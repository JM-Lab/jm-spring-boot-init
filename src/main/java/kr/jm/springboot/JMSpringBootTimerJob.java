package kr.jm.springboot;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kr.jm.springboot.timerjob.Every1MinuteJobInterface;
import kr.jm.utils.destory.DestroyInterface;
import kr.jm.utils.helper.JMLog;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JMSpringBootTimerJob implements DestroyInterface {
	private ExecutorService timerThreadPool = Executors.newCachedThreadPool();

	@Autowired
	private List<Every1MinuteJobInterface> every1MinuteJobList;

	@Scheduled(initialDelay = 0, fixedRate = 60000)
	public void workEvery1Minute() {
		JMLog.logMethodStartInfo(log, "workEvery1Minute",
				every1MinuteJobList.size(), every1MinuteJobList);
		for (Every1MinuteJobInterface timerJob : every1MinuteJobList)
			timerThreadPool.execute(timerJob);
	}

	@Scheduled(cron = "0 0 */1 * * *")
	public void workEvery1Hour() {

	}

	@Override
	public void cleanUp() throws RuntimeException {
		timerThreadPool.shutdown();
		while (!timerThreadPool.isTerminated()) {
		}
	}

}
