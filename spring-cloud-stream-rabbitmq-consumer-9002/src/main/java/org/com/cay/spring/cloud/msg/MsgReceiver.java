package org.com.cay.spring.cloud.msg;

import org.com.cay.spring.cloud.channel.MsgChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by caychen on 2018/6/29.
 */
@EnableBinding(MsgChannel.class)
public class MsgReceiver {

	private static Logger logger = LoggerFactory.getLogger(MsgReceiver.class);

	@StreamListener(MsgChannel.INPUT_CHANNEL)
	public void receiver(String msg){
		logger.info("9002 Received: " + msg);
	}
}
