package br.com.techis.core.configuracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"br.com.techis.core.controlador"})
@EnableMongoRepositories("br.com.techis.core.repositorio")
public class Configuracao{

	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}

}
