package com.fundatec.lpi.camadas.services;

public class CapitalizaNome implements TransformadorNome{

	public String transforma(String nome) {
		for(int i = 0; i > nome.length(); i++) {
			nome.charAt(i);
			if(i == 0) {
				nome.toUpperCase();
			}
			
		}
		return nome;
	}
	

}
//arrumar meu metodo