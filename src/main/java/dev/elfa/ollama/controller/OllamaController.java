package dev.elfa.ollama.controller;

import dev.elfa.ollama.service.OllamaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OllamaController {
	private final OllamaService ollamaService;

	@PostMapping("/ask")
	public ResponseEntity<String> askOllama(@RequestBody String userPrompt) {
		String response = ollamaService.askOllama(userPrompt);

		return ResponseEntity.ok(response);
	}
}
