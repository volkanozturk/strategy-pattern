package com.volkanozturk.strategypattern.strategypattern.config;

import com.volkanozturk.strategypattern.strategypattern.enums.NotificationType;
import com.volkanozturk.strategypattern.strategypattern.service.INotificationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @author volkanozturk
 */
@Configuration
public class CommonConfig {

	private final List<INotificationStrategy> notificationStrategies;

	public CommonConfig(List<INotificationStrategy> notificationStrategies) {
		this.notificationStrategies = notificationStrategies;
	}

	@Bean
	public Map<NotificationType, INotificationStrategy> sendNotificationByType() {
		Map<NotificationType, INotificationStrategy> messagesByType = new EnumMap<>(NotificationType.class);
		notificationStrategies.forEach(notificationStrategy -> messagesByType.put(notificationStrategy.notificationType(), notificationStrategy));
		return messagesByType;
	}
}
