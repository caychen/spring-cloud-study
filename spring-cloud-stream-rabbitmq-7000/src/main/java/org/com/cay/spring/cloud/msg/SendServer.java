package org.com.cay.spring.cloud.msg;

import org.com.cay.spring.cloud.channel.SendChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by caychen on 2018/6/29.
 */
@Service
public class SendServer {

	@Autowired
	private SendChannel sendChannel;

	public void send(String msg){
		Message<String> build = MessageBuilder.withPayload(msg).build();

		sendChannel.output().send(build);
	}
}
