
package com.kimdeath.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @author 配置Ribbon内部复杂均衡策略
 * 负载均衡随机规则
 * 
 *
 */
@Configuration
@RulesExcludeRibbon
public class RibbonRublesConfig{
	@Autowired
	private IClientConfig config;
	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new RandomRule();
	}
}