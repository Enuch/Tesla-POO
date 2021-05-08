package Persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Funcionario;

public class FuncionarioDAO {
	private Connect myConnect;
	private final String RELATORIOGERAL = "select * from \"funcionario\"";
	private final String RELATORIOCPF = "select * from \"funcionario\" where \"id\"=? ";
	private final String INCLUIR = "insert into \"funcionario\" (\"id\", \"data\", \"nome\", \"telefone\", \"email\", \"cpf\", \"rua\", \"numero\", \"bairro\", \"cidade\") values (?,?,?,?,?,?,?,?,?,?)";
	private final String EXCLUIR = "delete from \"funcionario\" where \"id\"=?";
	private final String ALTERAR = "update \"funcionario\" set \"id\"=?, \"data\"=?, \"nome\"=?, \"telefone\"=?, \"email\"=?, \"cpf\"=?, \"rua\"=?, \"numero\"=?, \"bairro\"=?, \"cidade\"=? where \"id\"=?";
	
	public FuncionarioDAO() {
		this.myConnect = new Connect("jdbc:postgresql://localhost:5432/Tesla", "postgres", "Sung5713@");
	}

	public ArrayList<Funcionario> relatorioGeral() {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try {
			myConnect.conectar();
			Statement instrucao = myConnect.getConnect().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIOGERAL);
			while(rs.next()) {
				Funcionario f = new Funcionario(rs.getInt("id"), rs.getString("data"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cidade"));
				funcionarios.add(f);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return funcionarios;
	}
	
	public Funcionario relatorioID(int id) {
		Funcionario f = null;
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOCPF);
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				f = new Funcionario(rs.getInt("id"), rs.getString("data"), rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cidade"));
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na busca "+e.getMessage());
		}
		return f;
	}
	
	public void incluir(Funcionario f) {
		try {
			this.myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(INCLUIR);
			instrucao.setInt(1, f.getId());
			instrucao.setString(2,  f.getData());
			instrucao.setString(3, f.getNome());
			instrucao.setString(4, f.getTelefone());
			instrucao.setString(5, f.getEmail());
			instrucao.setString(6, f.getCpf());
			instrucao.setString(7, f.getRua());
			instrucao.setInt(8, f.getNumero());
			instrucao.setString(9, f.getBairro());
			instrucao.setString(10, f.getCidade());
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
	
	public void alterar(Funcionario f, int idAntigo) {
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(ALTERAR);
			instrucao.setInt(1, idAntigo);
			instrucao.setString(2,  f.getData());
			instrucao.setString(3, f.getNome());
			instrucao.setString(4, f.getTelefone());
			instrucao.setString(5, f.getEmail());
			instrucao.setString(6, f.getCpf());
			instrucao.setString(7, f.getRua());
			instrucao.setInt(8, f.getNumero());
			instrucao.setString(9, f.getBairro());
			instrucao.setString(10, f.getCidade());
			instrucao.setInt(11, idAntigo);
			instrucao.execute();
			myConnect.desconectar();
		}catch(SQLException e) {
			System.out.println("Erro na alteração " + e.getMessage());
		}
	}
}
