package kr.jm.springboot.business.timerjob;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PreDestroy;

import kr.jm.business.Bussiness;
import kr.jm.springboot.timerjob.Every1MinuteJobInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BusinessTimerJob implements Every1MinuteJobInterface {

	private ExecutorService timerThreadPool = Executors.newCachedThreadPool();

	@Autowired
	private Bussiness business;

	@Scheduled(initialDelay = 0, fixedRate = 60000)
	public void run() {

	}

	@PreDestroy
	public void cleanUp() {
		timerThreadPool.shutdown();
		while (!timerThreadPool.isTerminated()) {
		}
	}

}
