package org.spring.cloud.common.aop.configuration;

import org.slf4j.LoggerFactory;
import org.spring.cloud.common.aop.MessageProducerInterceptor;
import org.spring.cloud.common.constant.QueueConstant;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import ch.qos.logback.classic.Logger;

@Configuration
@EnableAspectJAutoProxy
@Import({ MessageProducerInterceptor.class })
@PropertySource("classpath:/amqp/amqp.properties")
public class AMQPConfiguration {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(AMQPConfiguration.class.getCanonicalName());
	
	@Autowired
	private Environment env;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		if (log.isDebugEnabled()) {
			log.debug("AMQP Server: " + env.getProperty("spring.rabbitmq.host") + ":" + env.getProperty("spring.rabbitmq.port"));
		}
		connectionFactory.setHost(env.getProperty("spring.rabbitmq.host"));
		connectionFactory.setPort(Integer.parseInt(env.getProperty("spring.rabbitmq.port")));
		return connectionFactory;
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		return template;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}

	@Bean
	public FanoutExchange microServiceExchange() {
		return new FanoutExchange(QueueConstant.ExchangeName.MICRO_SERVICE);
	}

	@Bean
	public FanoutExchange sysMessageExchange() {
		return new FanoutExchange(QueueConstant.ExchangeName.SYS_MESSAGE);
	}
}
