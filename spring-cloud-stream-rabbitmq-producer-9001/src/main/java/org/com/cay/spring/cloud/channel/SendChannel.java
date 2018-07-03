package org.com.cay.spring.cloud.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by caychen on 2018/6/29.
 */
public interface SendChannel {

	String OUPUT_CHANNEL = "input";

	@Output(SendChannel.OUPUT_CHANNEL)
	MessageChannel output();
}
