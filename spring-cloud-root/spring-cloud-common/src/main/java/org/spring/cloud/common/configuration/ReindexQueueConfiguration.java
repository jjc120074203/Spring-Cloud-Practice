package org.spring.cloud.common.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by jiazaibo on 17-5-23.
 */
public class ReindexQueueConfiguration {

    public static final String REINDEX_SERVICE_EXCHANGE = "reindex-exchange-service";
    public static final String REINDEX_SERVICE_QUEUE = "reindex-queue-service";


    public static final String REINDEX_QUANTAPP_EXCHANGE = "reindex-exchange-quantapp";
    public static final String REINDEX_QUANTAPP_QUEUE = "reindex-queue-quantapp";


    public static final String REINDEX_COMPONENT_EXCHANGE = "reindex-exchange-component";
    public static final String REINDEX_COMPONENT_QUEUE = "reindex-queue-component";

    @Bean
    public FanoutExchange reindexServiceExchange() {
        return new FanoutExchange(REINDEX_SERVICE_EXCHANGE);
    }

    @Bean
    public Queue reindexServiceQueue() {
        return new Queue(REINDEX_SERVICE_QUEUE);
    }

    @Bean
    public Binding reindexServiceBinding(FanoutExchange reindexServiceExchange, Queue reindexServiceQueue) {
        return BindingBuilder.bind(reindexServiceQueue).to(reindexServiceExchange);
    }


    @Bean
    public FanoutExchange reindexQuantAppxchange() {
        return new FanoutExchange(REINDEX_QUANTAPP_EXCHANGE);
    }

    @Bean
    public Queue reindexQuantAppQueue() {
        return new Queue(REINDEX_QUANTAPP_QUEUE);
    }

    @Bean
    public Binding reindexQuantAppBinding(FanoutExchange reindexQuantAppxchange, Queue reindexQuantAppQueue) {
        return BindingBuilder.bind(reindexQuantAppQueue).to(reindexQuantAppxchange);
    }


    @Bean
    public FanoutExchange reindexComponentExchange() {
        return new FanoutExchange(REINDEX_COMPONENT_EXCHANGE);
    }

    @Bean
    public Queue reindexComponentQueue() {
        return new Queue(REINDEX_COMPONENT_QUEUE);
    }

    @Bean
    public Binding reindexComponentBinding(FanoutExchange reindexComponentExchange, Queue reindexComponentQueue) {
        return BindingBuilder.bind(reindexComponentQueue).to(reindexComponentExchange);
    }
}
