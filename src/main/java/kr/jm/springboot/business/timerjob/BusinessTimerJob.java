package kr.jm.springboot.business.timerjob;

import kr.jm.business.Bussiness;
import kr.jm.springboot.timerjob.Every1MinuteJobInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BusinessTimerJob implements Every1MinuteJobInterface {

	@Autowired
	private Bussiness business;

	@Scheduled(initialDelay = 0, fixedRate = 60000)
	public void run() {

	}

}
