package org.com.cay.spring.cloud.config;

import org.com.cay.spring.cloud.channel.ReceiveChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by caychen on 2018/6/29.
 */
@EnableBinding(ReceiveChannel.class)
public class ReceiverServerConfig {

	private static Logger logger = LoggerFactory.getLogger(ReceiverServerConfig.class);

	@StreamListener(ReceiveChannel.INPUT_CHANNEL)
	public void receive(String payLoad) {
		logger.info("Received: " + payLoad);
	}
}
