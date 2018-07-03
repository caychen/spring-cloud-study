package org.com.cay.spring.cloud.controller;

import org.com.cay.spring.cloud.msg.SendServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caychen on 2018/6/29.
 */
@RestController
public class MsgController {

	@Autowired
	private SendServer sendServer;

	@RequestMapping("/send")
	public String send(String msg) {
		sendServer.send(msg);
		return msg;
	}
}
