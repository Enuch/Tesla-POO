package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Modelo;

public class ModeloDAO {
	private Connect myConnect;
	private final String RELATORIOGERAL = "select * from \"modelo\"";
	private final String RELATORIOCODIGO = "select * from \"modelo\" where \"codigo\"=? ";
	private final String INCLUIR = "insert into \"modelo\" (\"modelo\", \"codigo\") values (?,?)";
	private final String EXCLUIR = "delete from \"modelo\" where \"codigo\"=?";
	private final String ALTERAR = "update \"modelo\" set \"modelo\"=?, \"codigo\"=? where \"codigo\"=?";
	
	public ModeloDAO() {
		this.myConnect = new Connect("jdbc:postgresql://localhost:5432/Tesla", "postgres", "Sung5713@");
	}

	public ArrayList<Modelo> relatorioGeral() {
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		try {
			myConnect.conectar();
			Statement instrucao = myConnect.getConnect().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIOGERAL);
			while(rs.next()) {
				Modelo m = new Modelo(rs.getInt("codigo"), rs.getString("modelo"));
				modelos.add(m);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return modelos;
	}
	
	public Modelo relatorioId(int id) {
		Modelo m = null;
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOCODIGO);
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				m = new Modelo(rs.getInt("codigo"), rs.getString("modelo"));
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na busca "+e.getMessage());
		}
		return m;
	}
	
	public void incluir(Modelo m) {
		try {
			this.myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(INCLUIR);
			instrucao.setString(1, m.getNomeModelo());
			instrucao.setInt(2, m.getModeloId());
			instrucao.execute();
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na inclus�o " + e.getMessage());
		}
	}
	
	public void excluir(int id) {
		try {
			this.myConnect.conectar();		
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(EXCLUIR);
			instrucao.setInt(1, id);
			instrucao.execute();
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na exclusão: " +e.getMessage());
		}
	}
	
	public void alterar(Modelo m, int idAntigo) {
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(ALTERAR);
			instrucao.setString(1, m.getNomeModelo());
			instrucao.setInt(2, idAntigo);
			instrucao.setInt(3, m.getModeloId());
			instrucao.execute();
			myConnect.desconectar();
		}catch(SQLException e) {
			System.out.println("Erro na alteração " + e.getMessage());
		}
	}
}
