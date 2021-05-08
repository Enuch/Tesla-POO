package Persistencia;

import Dominio.Cliente;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO {
	private Connect myConnect;
	private final String RELATORIOGERAL = "select * from \"cliente\"";
	private final String RELATORIONOME = "select * from \"cliente\" where \"nome\"=? ";
	private final String RELATORIOEMAIL = "select * from \"cliente\" where \"email\"=? ";
	private final String BUSCACPF = "select * from \"cliente\" where \"cpf\"=? ";
	private final String INCLUIR = "insert into \"cliente\" (\"nome\", \"telefone\", \"email\", \"cpf\", \"rua\", \"numero\", \"bairro\", \"cidade\") values (?,?,?,?,?,?,?,?)";
	private final String EXCLUIR = "delete from \"cliente\" where \"cpf\"=?";
	private final String ALTERAR = "update \"cliente\" set \"nome\"=?, \"telefone\"=?, \"email\"=?, \"cpf\"=?, \"rua\"=?, \"numero\"=?, \"bairro\"=?, \"cidade\"=? where \"cpf\"=?";
	
	public ClienteDAO() {
		this.myConnect = new Connect("jdbc:postgresql://localhost:5432/Tesla", "postgres", "Sung5713@");
	}

	public ArrayList<Cliente> relatorioGeral() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			myConnect.conectar();
			Statement instrucao = myConnect.getConnect().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIOGERAL);
			while(rs.next()) {
				Cliente c = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cidade"));
				clientes.add(c);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return clientes;
	}
	
	public ArrayList<Cliente> relatorioEmail(String email) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOEMAIL);
			instrucao.setString(1, email);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cidade"));
				clientes.add(c);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return clientes;
	}
	
	public ArrayList<Cliente> relatorioNome(String nome) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIONOME);
			instrucao.setString(1, nome);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cidade"));
				clientes.add(c);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return clientes;
	}
	
	public Cliente buscaCpf(String cpf) {
		Cliente c = null;
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(BUSCACPF);
			instrucao.setString(1, cpf);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				c = new Cliente(rs.getString("nome"), rs.getString("telefone"), rs.getString("email"), rs.getString("cpf"), rs.getString("rua"), rs.getInt("numero"), rs.getString("bairro"), rs.getString("cidade"));
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na busca "+e.getMessage());
		}
		return c;
	}
	
	public void incluir(Cliente c) {
		try {
			this.myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(INCLUIR);
			instrucao.setString(1, c.getNome());
			instrucao.setString(2, c.getTelefone());
			instrucao.setString(3, c.getEmail());
			instrucao.setString(4, c.getCpf());
			instrucao.setString(5, c.getRua());
			instrucao.setInt(6, c.getNumero());
			instrucao.setString(7, c.getBairro());
			instrucao.setString(8, c.getCidade());
			instrucao.execute();
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na inclus�o " + e.getMessage());
		}
	}
	
	public void excluir(String cpf) {
		try {
			this.myConnect.conectar();		
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(EXCLUIR);
			instrucao.setString(1, cpf);
			instrucao.execute();
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na exclusão: " +e.getMessage());
		}
	}
	
	public void alterar(Cliente c, String cpfAntigo) {
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(ALTERAR);
			instrucao.setString(1, c.getNome());
			instrucao.setString(2, c.getTelefone());
			instrucao.setString(3, c.getEmail());
			instrucao.setString(4, cpfAntigo);
			instrucao.setString(5, c.getRua());
			instrucao.setInt(6, c.getNumero());
			instrucao.setString(7, c.getBairro());
			instrucao.setString(8, c.getCidade());
			instrucao.setString(9, cpfAntigo);
			instrucao.execute();
			myConnect.desconectar();
		}catch(SQLException e) {
			System.out.println("Erro na alterão " + e.getMessage());
		}
	}
	
}
