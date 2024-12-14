package com.api_veiculos.model;

import java.io.Serializable;
import java.util.Objects;

public class Marca implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String nome;
    private String codigo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome);
	}
    
    

	
}

