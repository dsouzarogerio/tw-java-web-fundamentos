package br.com.treinaweb.agenda.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryJDBC {
	
	public static Connection criarConexao() throws SQLException, IOException {
		InputStream is = ConnectionFactoryJDBC.class.getClassLoader().getResourceAsStream("application.properties");
		if(is == null) {
			throw new FileNotFoundException("O arquivo de configuração do banco de dados não foi encontrado.");
		}
		Properties props = new Properties();
		props.load(is);
		Connection conexao = DriverManager.getConnection(props.getProperty("urlConnection"), 
					props.getProperty("user"), props.getProperty("password"));
		return conexao;
	}
}