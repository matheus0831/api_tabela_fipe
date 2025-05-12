package br.com.consultaTabelaCarros.principal;

import br.com.consultaTabelaCarros.modelos.Carro;
import br.com.consultaTabelaCarros.modelosRecords.CarroModelo;
import br.com.consultaTabelaCarros.servicos.ConsomeAPI;
import br.com.consultaTabelaCarros.servicos.ConverteJSON;
import br.com.consultaTabelaCarros.servicos.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu execucao = new Menu();
		execucao.executaMenu();
	}
}
