package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Carro;

public class CarroDAO {
	private Connect myConnect;
	private final String RELATORIOGERAL1 = "select * from \"carro\"";
	private final String RELATORIOGERAL = "select * from \"carro\" where \"mod_id\"=?";
	private final String RELATORIOVALOR = "select * from \"carro\", \"modelo\" where \"valor\">? and \"mod_id\"=codigo and \"codigo\"=?";
	private final String RELATORIOANO = "select * from \"carro\", \"modelo\" where \"ano\">? and \"mod_id\"=codigo and \"codigo\"=? ";
	private final String BUSCAID = "select * from \"carro\" where \"id\"=?";
	private final String INCLUIR = "insert into \"carro\" (\"cor\", \"marcha\", \"combustivel\", \"num_portas\", \"ano\", \"chassi\", \"valor\", \"id\", \"mod_id\") values (?,?,?,?,?,?,?,?,?)";
	private final String EXCLUIR = "delete from \"carro\" where \"id\"=?";
	private final String ALTERAR = "update \"carro\" set \"cor\"=?, \"marcha\"=?, \"combustivel\"=?, \"num_portas\"=?, \"ano\"=?, \"chassi\"=?, \"valor\"=?, \"id\"=?, \"mod_id\"=? where \"id\"=?";
	
	public CarroDAO() {
		this.myConnect = new Connect("jdbc:postgresql://localhost:5432/Tesla", "postgres", "Sung5713@");
	}

	public ArrayList<Carro> relatorioGeral() {
		ArrayList<Carro> carros = new ArrayList<Carro>();
		try {
			myConnect.conectar();
			Statement instrucao = myConnect.getConnect().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIOGERAL1);
			while(rs.next()) {
				Carro c = new Carro(rs.getString("cor"), rs.getString("marcha"), rs.getString("combustivel"), rs.getInt("num_portas"), rs.getString("ano"), rs.getString("chassi"), rs.getFloat("valor"), rs.getInt("id"), rs.getInt("mod_id"));
				carros.add(c);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return carros;
	}
	
	public ArrayList<Carro> relatorioGeral(int mod_id) {
		ArrayList<Carro> carros = new ArrayList<Carro>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOGERAL);
			instrucao.setInt(1, mod_id);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Carro c = new Carro(rs.getString("cor"), rs.getString("marcha"), rs.getString("combustivel"), rs.getInt("num_portas"), rs.getString("ano"), rs.getString("chassi"), rs.getFloat("valor"), rs.getInt("id"), rs.getInt("mod_id"));
				carros.add(c);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return carros;
	}
	
	public ArrayList<Carro> relatorioValor(float valor, int id) {
		ArrayList<Carro> carros = new ArrayList<Carro>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOVALOR);
			instrucao.setFloat(1, valor);
			instrucao.setInt(2, id);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Carro c = new Carro(rs.getString("cor"), rs.getString("marcha"), rs.getString("combustivel"), rs.getInt("num_portas"), rs.getString("ano"), rs.getString("chassi"), rs.getFloat("valor"), rs.getInt("id"), rs.getInt("mod_id"));
				carros.add(c);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return carros;
	}
	
	public ArrayList<Carro> relatorioAno(String ano, int id) {
		ArrayList<Carro> carros = new ArrayList<Carro>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOANO);
			instrucao.setString(1, ano);
			instrucao.setInt(2, id);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Carro c = new Carro(rs.getString("cor"), rs.getString("marcha"), rs.getString("combustivel"), rs.getInt("num_portas"), rs.getString("ano"), rs.getString("chassi"), rs.getFloat("valor"), rs.getInt("id"), rs.getInt("mod_id"));
				carros.add(c);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return carros;
	}
	
	public Carro buscaId(int id) {
		Carro c = null;
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(BUSCAID);
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				c = new Carro(rs.getString("cor"), rs.getString("marcha"), rs.getString("combustivel"), rs.getInt("num_portas"), rs.getString("ano"), rs.getString("chassi"), rs.getFloat("valor"), rs.getInt("id"), rs.getInt("mod_id"));
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na busca "+e.getMessage());
		}
		return c;
	}
	
	public void incluir(Carro c) {
		try {
			this.myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(INCLUIR);
			instrucao.setString(1, c.getCor());
			instrucao.setString(2, c.getMarcha());
			instrucao.setString(3, c.getCombustivel());
			instrucao.setInt(4, c.getNumeroPortas());
			instrucao.setString(5, c.getAno());
			instrucao.setString(6, c.getChassi());
			instrucao.setFloat(7, c.getValor());
			instrucao.setInt(8, c.getId());
			instrucao.setInt(9, c.getModeloId());
			instrucao.execute();
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na inclusão " + e.getMessage());
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
	
	public void alterar(Carro c, int idAntigo) {
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(ALTERAR);
			instrucao.setString(1, c.getCor());
			instrucao.setString(2, c.getMarcha());
			instrucao.setString(3, c.getCombustivel());
			instrucao.setInt(4, c.getNumeroPortas());
			instrucao.setString(5, c.getAno());
			instrucao.setString(6, c.getChassi());
			instrucao.setFloat(7, c.getValor());
			instrucao.setInt(8, idAntigo);
			instrucao.setInt(9, c.getModeloId());
			instrucao.setInt(10, idAntigo);
			instrucao.execute();
			myConnect.desconectar();
		}catch(SQLException e) {
			System.out.println("Erro na alterão " + e.getMessage());
		}
	}
}
