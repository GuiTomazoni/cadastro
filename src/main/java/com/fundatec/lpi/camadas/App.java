package com.fundatec.lpi.camadas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.Scanner;

import com.fundatec.lpi.camadas.dao.ItemDao;
import com.fundatec.lpi.camadas.domain.Item;
import com.fundatec.lpi.camadas.services.CapitalizaNome;

public class App 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
    {
    	
    	String mysqlDriver = "com.mysql.cj.jdbc.Driver";
		Class.forName(mysqlDriver);
		
    	Scanner scanner = new Scanner(System.in);
    	CapitalizaNome capitalizaNome = new CapitalizaNome();
    	ItemDao itemDao = new ItemDao();
    	
    	int comando = 0;
    	do {
    		System.out.println("Escolha uma opção:");
    		System.out.println("------------------");
    		System.out.println("1 - Cadastrar item");
    		System.out.println("2 - Listar itens");
    		System.out.println("3 - Editar item por ID");
    		System.out.println("4 - Deletar item por ID");
    		System.out.println("5 - Mostrar custo total do estoque");
    		System.out.println("0 - Sair");
    		System.out.println("");
    		System.out.print("Qual opção? ");
    		comando = scanner.nextInt();
    		
    		if (comando == 1) {
    			System.out.println("=> Você quer cadastrar um item");
    			System.out.print("=> NOME: ");
    			String nome = scanner.next() + "\n";
    			String nomeCapitalizado = capitalizaNome.transforma(nome);
    			
    			System.out.println("=> Preço: ");
    			int preco = scanner.nextInt();
    			
    			Item novoItem = new Item(nomeCapitalizado, preco);  
    			itemDao.save(novoItem);
    			
    			
    		} else if (comando == 2) {
    			System.out.println("=> Você quer listar itens");
    			//ir no "alunoDao" e pegar a lista de itens do Mysql
    			
    		
    		} else if (comando == 3) {
    			System.out.println("=> Qual o ID do item que você deseja editar?");
    			int idDigitado = scanner.nextInt();
    			System.out.println("=> Novo nome");
    			String nome = scanner.next();
    			System.out.println("=> Novo preço");
    			int preco = scanner.nextInt();
    			
    			Item novoItem = new Item(nome, preco, idDigitado);
    			
    		}else if (comando == 4) {
    			System.out.println("=> Qual o ID do item que você deseja excluir?");
    			int idDigitado = scanner.nextInt();
    			itemDao.delete(idDigitado);
    			
    		}else if(comando == 5) {
    			System.out.println("=> O custo total é: ");
    			//ir no Estoque e pegar o valor total
    			
    		} else if (comando == 0) {
    			System.out.println("Saindo....");
    			itemDao.close();
    		
    		} else {
    			System.out.println("Comando inválido");
    		}
    		
    	} while (comando != 0);
    	
    	scanner.close();
    }
}
