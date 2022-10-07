package com.volkanozturk.strategypattern.strategypattern.imp;

import com.volkanozturk.strategypattern.strategypattern.enums.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.volkanozturk.strategypattern.strategypattern.service.INotificationStrategy;

/**
 * @author volkanozturk
 */
@Slf4j
@Service
public class EmailNotificationStrategy implements INotificationStrategy {
	@Override
	public void sendMessage(String message) {
		log.info("message send to email : " + message);
	}

	@Override
	public NotificationType notificationType() {
		return NotificationType.EMAIL;
	}
}
