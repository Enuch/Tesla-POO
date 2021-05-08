package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Venda;

public class VendaDAO {
	private Connect myConnect;
	private final String RELATORIOGERAL1 = "select * from \"venda\"";
	private final String RELATORIOGERAL = "select * from \"venda\" where \"func_id\"=? ";
	private final String RELATORIODATA = "select \"codigo\", \"func_id\", \"car_id\", \"client_cpf\", \"pagamento\", \"date\" from \"venda\", \"funcionario\" where \"date\"=? and \"id\"=func_id and \"id\"=? ";
	private final String RELATORIOCLIENTECPF = "select \"codigo\", \"func_id\", \"car_id\", \"client_cpf\", \"pagamento\", \"date\" from \"venda\", \"funcionario\" where \"id\"=func_id and \"client_cpf\"=? and \"id\"=? ";
	private final String BUSCACODIGO = "select * from \"venda\" where \"codigo\"=?";
	private final String INCLUIR = "insert into \"venda\" (\"codigo\", \"func_id\", \"car_id\", \"client_cpf\", \"pagamento\", \"date\") values (?,?,?,?,?,?)";
	private final String EXCLUIR = "delete from \"venda\" where \"codigo\"=?";
	private final String ALTERAR = "update \"venda\" set \"codigo\"=?, \"func_id\"=?, \"car_id\"=?, \"client_cpf\"=?, \"pagamento\"=?, \"date\"=? where \"codigo\"=?";
	
	public VendaDAO() {
		this.myConnect = new Connect("jdbc:postgresql://localhost:5432/Tesla", "postgres", "Sung5713@");
	}
	
	public ArrayList<Venda> relatorioGeral() {
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOGERAL1);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Venda v = new Venda(rs.getInt("codigo"), rs.getInt("func_id"), rs.getInt("car_id"), rs.getString("client_cpf"), rs.getString("pagamento"), rs.getString("date"));
				vendas.add(v);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return vendas;
	}

	public ArrayList<Venda> relatorioCodigo(int id) {
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOGERAL);
			instrucao.setInt(1, id);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Venda v = new Venda(rs.getInt("codigo"), rs.getInt("func_id"), rs.getInt("car_id"), rs.getString("client_cpf"), rs.getString("pagamento"), rs.getString("date"));
				vendas.add(v);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return vendas;
	}
	
	public ArrayList<Venda> relatorioData(String data, int id) {
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIODATA);
			instrucao.setString(1, data);
			instrucao.setInt(2, id);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Venda v = new Venda(rs.getInt("codigo"), rs.getInt("func_id"), rs.getInt("car_id"), rs.getString("client_cpf"), rs.getString("pagamento"), rs.getString("date"));
				vendas.add(v);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return vendas;
	}
	
	public ArrayList<Venda> relatorioClienteCpf(String clienteCpf, int id) {
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(RELATORIOCLIENTECPF);
			instrucao.setString(1, clienteCpf);
			instrucao.setInt(2, id);
			ResultSet rs = instrucao.executeQuery();
			while(rs.next()) {
				Venda v = new Venda(rs.getInt("codigo"), rs.getInt("func_id"), rs.getInt("car_id"), rs.getString("client_cpf"), rs.getString("pagamento"), rs.getString("date"));
				vendas.add(v);
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro no relario geral" + e.getMessage());
		}
		
		return vendas;
	}
	
	public Venda buscaCodigo(int codigo) {
		Venda v = null;
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(BUSCACODIGO);
			instrucao.setInt(1, codigo);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next()) {
				v = new Venda(rs.getInt("codigo"), rs.getInt("func_id"), rs.getInt("car_id"), rs.getString("client_cpf"), rs.getString("date"), rs.getString("pagamento"));
			}
			myConnect.desconectar();
		} catch(SQLException e) {
			System.out.println("Erro na busca "+e.getMessage());
		}
		return v;
	}
	
	
	public void incluir(Venda v) {
		try {
			this.myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(INCLUIR);
			instrucao.setInt(1, v.getCodigo());
			instrucao.setInt(2, v.getFuncionarioId());
			instrucao.setInt(3, v.getCarroCodigo());
			instrucao.setString(4, v.getClienteCpf());
			instrucao.setString(5, v.getPagamento());
			instrucao.setString(6, v.getData());
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
	
	public void alterar(Venda v, int codigoAntigo) {
		try {
			myConnect.conectar();
			PreparedStatement instrucao = myConnect.getConnect().prepareStatement(ALTERAR);
			instrucao.setInt(1, codigoAntigo);
			instrucao.setInt(2, v.getFuncionarioId());
			instrucao.setInt(3, v.getCarroCodigo());
			instrucao.setString(4, v.getClienteCpf());
			instrucao.setString(5, v.getPagamento());
			instrucao.setString(6, v.getData());
			instrucao.setInt(7, codigoAntigo);
			instrucao.execute();
			myConnect.desconectar();
		}catch(SQLException e) {
			System.out.println("Erro na alteração " + e.getMessage());
		}
	}
}
