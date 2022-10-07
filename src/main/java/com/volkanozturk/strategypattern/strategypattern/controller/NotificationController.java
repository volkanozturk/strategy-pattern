package com.volkanozturk.strategypattern.strategypattern.controller;

import com.volkanozturk.strategypattern.strategypattern.exception.NotFoundNotificationStrategy;
import com.volkanozturk.strategypattern.strategypattern.utility.NotificationContext;
import com.volkanozturk.strategypattern.strategypattern.enums.NotificationType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author volkanozturk
 */
@RestController
@RequestMapping("/api/v1.0/notify")
public class NotificationController {

	private final NotificationContext notificationContext;

	public NotificationController(NotificationContext notificationContext) {
		this.notificationContext = notificationContext;
	}

	@GetMapping(value = "/send")
	public String sendNotification(@RequestParam("message") String message,
								   @RequestParam("notificationType") NotificationType notificationType) throws NotFoundNotificationStrategy {
		notificationContext.sendMessage(message, notificationType);
		return message;
	}
}
