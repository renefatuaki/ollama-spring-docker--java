package dev.elfa.ollama.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {
	private final ChatClient chatClient;

	OllamaService(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.defaultOptions(
				ChatOptionsBuilder.builder()
						.withTemperature(0.9f)
						.build()
		).build();
	}

	public String askOllama(String userPrompt) {
		return chatClient.prompt()
				.system("""
						You are an assistant that answers questions using only the provided context.
						""")
				.user(userPrompt)
				.call()
				.content();
	}
}
