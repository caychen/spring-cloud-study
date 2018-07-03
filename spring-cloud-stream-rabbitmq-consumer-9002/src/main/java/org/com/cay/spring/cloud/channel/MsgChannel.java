package org.com.cay.spring.cloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by caychen on 2018/6/29.
 */
public interface MsgChannel {

	String INPUT_CHANNEL = "input";

	@Input(MsgChannel.INPUT_CHANNEL)
	SubscribableChannel input();
}
