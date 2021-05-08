package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private String user;
	private String password;
	private String path;
	private Connection connect;
	
	public Connect(String path, String user, String password) {
		this.path = path;
		this.user = user;
		this.password = password;
		
	}
		
	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection(path, user, password);
			
			
		}catch(Exception e) {
				System.out.println("Erro na conex�o: " + e.getMessage());
				
		}
	}
	
	public void desconectar() {
		try {
			connect.close();
		} catch(Exception e) {
			System.out.println("Erro de desconexão!");
		}
	}
	
	public Connection getConnect() {
		return connect;
	}
	
}
