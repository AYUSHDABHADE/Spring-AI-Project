package com.ai.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisor;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisorChain;

import reactor.core.publisher.Flux;

public class TokenPrintAdvisor implements CallAdvisor, StreamAdvisor {

    private static final Logger logger =
            LoggerFactory.getLogger(TokenPrintAdvisor.class);

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public int getOrder() {
        return 0;
    }

    // For normal .call()
    @Override
    public ChatClientResponse adviseCall(
            ChatClientRequest chatClientRequest,
            CallAdvisorChain callAdvisorChain) {

        logger.info("My Token Print Advisor is called");

        // Call the next advisor/model
        ChatClientResponse chatClientResponse =
                callAdvisorChain.nextCall(chatClientRequest);

        logger.info("Response is received from model");

        // VERY IMPORTANT
        return chatClientResponse;
    }

    // For streaming
    @Override
    public Flux<ChatClientResponse> adviseStream(
            ChatClientRequest chatClientRequest,
            StreamAdvisorChain streamAdvisorChain) {

        logger.info("My Token Print Advisor is called");

        // Call the next advisor/model
        Flux<ChatClientResponse> chatClientResponse =
                streamAdvisorChain.nextStream(chatClientRequest);

        logger.info("Response is received from model");

        return chatClientResponse;
    }
}