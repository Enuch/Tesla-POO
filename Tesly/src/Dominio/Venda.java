package Dominio;

public class Venda {
	private int codigo;
	private int funcionarioId;
	private int carroCodigo;
	private String clienteCpf;
	private String pagamento;
	private String data;
	
	public Venda(int codigo, int funcionarioId, int carroCodigo, String clienteCpf, String pagamento, String data) {
		this.codigo = codigo;
		this.funcionarioId = funcionarioId;
		this.carroCodigo = carroCodigo;
		this.clienteCpf = clienteCpf;
		this.pagamento = pagamento;
		this.data = data;
	}
	
	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	
	public int getFuncionarioId() {
		return this.funcionarioId;
	}
	
	public void setCarroCodigo(int carroCodigo) {
		this.carroCodigo = carroCodigo;
	}
	
	public int getCarroCodigo() {
		return this.carroCodigo;
	}
	
	public void setClientCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}
	
	public String getClienteCpf() {
		return this.clienteCpf;
	}
	
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
	public String getPagamento() {
		return this.pagamento;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
}
