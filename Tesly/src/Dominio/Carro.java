package Dominio;

public class Carro {
	private String cor;
	private String marcha;
	private String combustivel;
	private int numeroPortas;
	private String ano;
	private String chassi;
	private float valor;
	private int modeloId;
	private int id;
	
	public Carro() {
		
	}
	
	public Carro(String cor, String marcha, String combustivel, int numeroPortas, String ano, String chassi, float valor, int id, int modeloId) {
		this.modeloId = modeloId;
		this.cor = cor;
		this.marcha = marcha;
		this.combustivel = combustivel;
		this.numeroPortas = numeroPortas;
		this.ano = ano;
		this.chassi = chassi;
		this.valor = valor;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public int getModeloId() {
		return modeloId;
	}

	public void setModeloId(int modeloId) {
		this.modeloId = modeloId;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarcha() {
		return marcha;
	}

	public void setMarcha(String marcha) {
		this.marcha = marcha;
	}

	public int getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
