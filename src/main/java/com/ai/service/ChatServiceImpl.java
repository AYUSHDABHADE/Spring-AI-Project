package com.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import com.ai.entity.Tut;

@Service
public class ChatServiceImpl implements ChatService {
	
	private ChatClient chatClient;

	public ChatServiceImpl(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	
	
	

	@Override
	public String chat(String query) {
		 Prompt context = new Prompt(query);
     var content = chatClient.prompt(context).call().content(); 
		
		

		return content;
	}

}
