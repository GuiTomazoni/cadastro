package com.fundatec.lpi.camadas.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import com.fundatec.lpi.camadas.domain.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDao implements BaseDao<Item> {
	
	private Connection conn;
	
	public ItemDao() throws SQLException {
		super();
		String connString = "jdbc:mysql://localhost/fundatec?user=root&password=";
		this.conn = DriverManager.getConnection(connString);
	}
	
	public void close () {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void save(Item objeto) {
		try {			
		Statement statement = conn.createStatement();
		String query = "insert into itens (nome, preco) values (\""+objeto.getNome() +"\", " + objeto.getPreco() + ");";
		statement.execute(query);		
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public List<Item> listAll() {
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM itens";
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null; //adicionar o return
	}

	public void delete(int id) {
		try {			
			Statement statement = conn.createStatement();
			String query = "delete from itens where id =" + id + ";";
			statement.execute(query);
			} catch (Exception e) {
				e.printStackTrace();
			}	
	}

	public void update(Item objeto) {
		try {			
			Statement statement = conn.createStatement();
			//String query = "update itens set nome = \""+objeto.getNome()+"\", preco = " + objeto.getPreco() +" where id = " + id + ";";
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	}

