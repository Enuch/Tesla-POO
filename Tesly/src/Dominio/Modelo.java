package Dominio;

import java.util.ArrayList;

public class Modelo {
	private int modeloId;
	private String nomeModelo;
	
	public Modelo() {
		
	}
	
	public Modelo(int modeloId, String nomeModelo) {
		this.modeloId = modeloId;
		this.nomeModelo = nomeModelo;
	}

	public int getModeloId() {
		return modeloId;
	}

	public void setModeloId(int modeloId) {
		this.modeloId = modeloId;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
}
