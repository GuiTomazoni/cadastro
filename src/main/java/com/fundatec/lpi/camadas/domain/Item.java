package com.fundatec.lpi.camadas.domain;

public class Item {

	private String nome;
	private int preco;
	private int id;
	
	
	
	public Item(String nome, int preco, int id) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.id = id;
	}
	
	public Item(String nome, int preco) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.id = 0;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	
	
}
