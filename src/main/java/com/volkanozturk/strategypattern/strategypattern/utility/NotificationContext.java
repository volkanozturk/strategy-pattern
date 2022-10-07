package com.volkanozturk.strategypattern.strategypattern.utility;

import com.volkanozturk.strategypattern.strategypattern.exception.NotFoundNotificationStrategy;
import com.volkanozturk.strategypattern.strategypattern.enums.NotificationType;
import com.volkanozturk.strategypattern.strategypattern.service.INotificationStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * @author volkanozturk
 */
@Component
public class NotificationContext {
	private final Map<NotificationType, INotificationStrategy> sendNotificationByType;

	public NotificationContext(Map<NotificationType, INotificationStrategy> sendNotificationByType) {
		this.sendNotificationByType = sendNotificationByType;
	}

	public void sendMessage(String message, NotificationType notificationType) throws NotFoundNotificationStrategy {
		INotificationStrategy notificationStrategy = sendNotificationByType.getOrDefault(notificationType, null);
		if (Objects.isNull(notificationStrategy)) {
			throw new NotFoundNotificationStrategy("Notification Type not found. type: " + notificationType);
		}
		notificationStrategy.sendMessage(message);
	}
}
