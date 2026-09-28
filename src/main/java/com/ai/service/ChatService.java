package com.ai.service;

import java.io.IOException;
import java.util.List;

import org.jspecify.annotations.Nullable;

import com.ai.entity.Tut;

import reactor.core.publisher.Flux;

public interface ChatService {
public String chat(String query);

  public Flux<String> stramChat(String query);


}
