package org.spring.cloud.common.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.spring.cloud.common.aop.annotation.MessageOperation;
import org.spring.cloud.common.aop.annotation.MessageProducer;
import org.spring.cloud.common.aop.annotation.MessageType;
import org.spring.cloud.common.aop.entity.MessageEntity;
import org.spring.cloud.common.constant.ExceptionConstants;
import org.spring.cloud.common.constant.QueueConstant;
import org.spring.cloud.common.exception.CIBaseException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
public class MessageProducerInterceptor {
	
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
		if (null == rabbitTemplate) {
			throw new CIBaseException(ExceptionConstants.ERR_0XFFFFFF);
		}
		this.rabbitTemplate = rabbitTemplate;
	}

	@Pointcut("@annotation(com.isoftstone.cityinsight.aop.annotation.MessageProducer)")
	public void methodPointcut() {
	}

	@AfterReturning(value = "methodPointcut()", returning = "obj")
	public void Interceptor(JoinPoint joinPoint, Object obj) throws JsonProcessingException {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		MessageProducer annotation = method.getAnnotation(MessageProducer.class);
		if (annotation == null) {
			return;
		}
		if (null == obj) {
			return;
		}
		MessageType type = annotation.type();
		MessageOperation operation = annotation.operation();
		MessageEntity msg = new MessageEntity();
		ObjectMapper om = new ObjectMapper();
		msg.setType(type);
		msg.setOperation(operation);
		msg.setPayload(om.writeValueAsString(obj));
		String exchangeName = caculExchangeName(type);
		if (null == exchangeName) {
			throw new CIBaseException(ExceptionConstants.ERR_0XFFFFFE);
		}
		rabbitTemplate.convertAndSend(exchangeName, "", msg);
	}
	
	private String caculExchangeName(MessageType type) {
		switch (type) {
		case SERVICE:
		case COMPONENT:
		case API:
			return QueueConstant.ExchangeName.MICRO_SERVICE;
		case SYS_MESSAGE:
			return QueueConstant.ExchangeName.SYS_MESSAGE;
		default:
			return null;
		}
	}
}
