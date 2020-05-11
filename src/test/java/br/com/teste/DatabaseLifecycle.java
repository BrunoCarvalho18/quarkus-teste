package br.com.teste;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.MySQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DatabaseLifecycle implements QuarkusTestResourceLifecycleManager {
	
	private static MySQLContainer<?> MySQL = new MySQLContainer<>("mysql/mysql-server:8.0.19");

	@Override
	public Map<String, String> start() {
		MySQL.start();
		Map<String, String> propriedades = new HashMap<>();
		propriedades.put("quarkus.datasource.url", MySQL.getJdbcUrl());
		propriedades.put("quarkus.datasource.username", MySQL.getUsername());
		propriedades.put("quarkus.datasource.password", MySQL.getPassword());
		return propriedades;
	}

	@Override
	public void stop() {
		if(MySQL !=null) {
			MySQL.stop();
		}

	}

}
