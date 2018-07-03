package org.com.cay.spring.cloud.config;

import org.com.cay.spring.cloud.channel.SendChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by caychen on 2018/6/29.
 */
@EnableBinding(SendChannel.class)
public class SendServerConfig {

}
