package com.ai.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.ai.advisor.TokenPrintAdvisor;
import com.ai.entity.Tut;
import org.springframework.beans.factory.annotation.Value;
import com.google.common.reflect.ClassPath;

import reactor.core.publisher.Flux;

@Service
public class ChatServiceImpl implements ChatService {

	private ChatClient chatClient;

	

	public ChatServiceImpl(ChatClient.Builder buider ) {
	//	MessageChatMemoryAdvisor advisor= MessageChatMemoryAdvisor.builder(chatMemory).build();
	//	System.out.println(advisor);
		this.chatClient = buider
		            .defaultAdvisors(
		                    new TokenPrintAdvisor()
		                   
		            )
		            .build();	}

	@Override
	public String chat(String query) {
		
		
		// Read prompt from file
        
		Prompt pro = new Prompt(query);

		var res = chatClient
				.prompt(pro)
			    .call()
				.content();
		return res;
	}


	@Override
	public Flux<String> stramChat(String query ) {
         
	    return this.chatClient
	            .prompt()
	            .user(user -> user.text(query))
	            .stream()
	            .content();
	}

}
