package br.com.ans.empresa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExemploCacheService {
	
	private static final Logger log = LoggerFactory.getLogger(ExemploCacheService.class);

	public String exemploCache() {
		
		log.info("### Executando o serviço...");
		
		return "Teste de exemplo de cache";
		
	}
	
}
