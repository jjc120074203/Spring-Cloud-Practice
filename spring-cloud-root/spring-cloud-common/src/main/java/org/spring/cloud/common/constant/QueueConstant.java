package org.spring.cloud.common.constant;

public interface QueueConstant {
	
	public interface ExchangeName {
		String DEFAULT = "SPRING-DEFAULT";
		String MICRO_SERVICE = "MICRO_SERVICE";
		String SYS_MESSAGE = "SYS_MESSAGE";
		//数据同步
		String SYNC_BASE_PAYLOAD = "SYNC_BASE_PAYLOAD";
	}
	
	public interface QueueName {
		String ES_SEARCH_QUEUE = "ES_SEARCH";
		//calbe 
		String CABLE_SYS_MESSAGE_QUEUE = "CABLE_SYS_MESSAGE_QUEUE";
		//城市小蜜
		String CB_SECRETARY_QUEUE="CB_SECRETARY_QUEUE";
		// 数据同步
		String SYNC_OPBASE_QUEUE = "SYNC_OPBASE";
	}
	
}
