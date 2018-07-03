package org.com.cay.spring.cloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by caychen on 2018/6/29.
 */
public interface ReceiveChannel {

	String INPUT_CHANNEL = "input";

	@Input(ReceiveChannel.INPUT_CHANNEL)
	SubscribableChannel input();
}
