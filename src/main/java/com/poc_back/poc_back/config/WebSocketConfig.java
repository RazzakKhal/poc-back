package com.poc_back.poc_back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configure le broker de messages avec des préfixes pour les destinations
        config.enableSimpleBroker("/topic", "/queue"); // Configurer les destinations pour envoyer les messages
        config.setApplicationDestinationPrefixes("/app"); // Préfixe des messages envoyés de l'application
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Enregistrement de l'endpoint WebSocket à laquelle le client doit se connecter
        registry.addEndpoint("/chat-websocket").setAllowedOriginPatterns("*").withSockJS();
    }
}

