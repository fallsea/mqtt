package com.wueasy.mqtt.auth;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.command.ConnectionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


/**
 * @Description: 认证拦截器
 * @Copyright: 2018 wueasy.com Inc. All rights reserved.
 * @author: fallsea
 * @version 1.0
 * @date: 2018年11月23日 下午12:19:27
 */
public class AuthFilter extends BrokerFilter{
	
	private static Logger log = LoggerFactory.getLogger(AuthFilter.class);

	public AuthFilter(Broker next) {
		super(next);
	}

	@Override
	public void addConnection(ConnectionContext context, ConnectionInfo info) throws Exception {
		
		if(StringUtils.isEmpty(info.getUserName()) || StringUtils.isEmpty(info.getPassword())) {
			throw new SecurityException("账号或密码不能为空!");
		}
		
		//为了方便演示，这里写死了要验证的用户和密码，实际根据自己的需求做处理
		if(!"admin".equals(info.getUserName()) || !"123456".equals(info.getPassword()))
		{
			throw new SecurityException("账号或密码不正确!");
		}
		
		if(log.isInfoEnabled()) {
			log.info("创建连接，ClientId：{},RemoteAddress：{}",context.getClientId(),context.getConnection().getRemoteAddress());
		}
		
		super.addConnection(context, info);
	}
	
}
