package Dominio;

import java.util.Date;

public class Funcionario extends Pessoa {
	private int id;
	private String data;
	
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(int id, String data, String nome, String telefone, String email, String cpf, String rua, int numero, String bairro, String cidade) {
		super(nome, telefone, email, cpf, rua, numero, bairro, cidade);
		this.id = id;
		this.data = data;
		
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
}
