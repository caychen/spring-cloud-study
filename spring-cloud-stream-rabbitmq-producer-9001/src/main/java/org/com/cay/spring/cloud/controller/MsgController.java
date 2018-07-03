package org.com.cay.spring.cloud.controller;

import org.com.cay.spring.cloud.channel.SendChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caychen on 2018/6/29.
 */
@RestController
public class MsgController {

	@Autowired
	private SendChannel sendChannel;

	@RequestMapping("/send")
	public String send(String msg) {
		Message<String> build = MessageBuilder.withPayload(msg).build();

		sendChannel.output().send(build);
		return msg;
	}
}
