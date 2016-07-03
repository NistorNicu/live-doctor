//package com.doctor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.converter.MessageConverter;
//import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
//import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.web.socket.config.annotation.*;
//
//import java.util.List;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketMessageBrokerConfig extends AbstractWebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//        stompEndpointRegistry.addEndpoint("/consultations").setAllowedOrigins("*").withSockJS();
//    }
//
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
//        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
//        messageBrokerRegistry.enableSimpleBroker("/topic", "/queue");
//    }
//}
