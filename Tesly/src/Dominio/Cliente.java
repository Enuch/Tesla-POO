package Dominio;

public class Cliente extends Pessoa{
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String telefone, String email, String cpf, String rua, int numero, String bairro, String cidade) {
		super(nome, telefone, email, cpf, rua, numero, bairro, cidade);

	}
	
}
