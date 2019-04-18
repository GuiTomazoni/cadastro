package com.fundatec.lpi.camadas.services;

public class CapitalizaNome implements TransformadorNome{

	public String transforma(String nome) {
		nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
		return nome;
	}
	

}
