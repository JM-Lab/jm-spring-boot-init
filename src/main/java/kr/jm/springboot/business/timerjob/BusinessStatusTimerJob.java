package kr.jm.springboot.business.timerjob;

import kr.jm.springboot.business.status.BusinessStatus;
import kr.jm.springboot.timerjob.Every1MinuteJobInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("businessStatus")
public class BusinessStatusTimerJob implements Every1MinuteJobInterface {

	@Autowired
	private BusinessStatus businessStatus;

	@Override
	public void run() {
		businessStatus.checkStatus();
	}

}
