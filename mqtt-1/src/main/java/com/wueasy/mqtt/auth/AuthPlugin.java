package com.wueasy.mqtt.auth;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;

/**
 * @Description: 认证插件
 * @Copyright: 2018 wueasy.com Inc. All rights reserved.
 * @author: fallsea
 * @version 1.0
 * @date: 2018年11月23日 下午12:19:20
 */
public class AuthPlugin implements BrokerPlugin{

	@Override
	public Broker installPlugin(Broker broker) throws Exception {
		return new AuthFilter(broker);
	}

}
