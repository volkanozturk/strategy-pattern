package com.volkanozturk.strategypattern.strategypattern.service;

import com.volkanozturk.strategypattern.strategypattern.enums.NotificationType;

/**
 * @author volkanozturk
 */
public interface INotificationStrategy {

	void sendMessage(String message);

	NotificationType notificationType();

}
