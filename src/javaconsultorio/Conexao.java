package javaconsultorio;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IFSul
 */
public class Conexao {

             public static String status = "Não conectado";

public static java.sql.Connection getConexaoMySQL() throws SQLException {
 
        Connection connection = null;          //atributo do tipo Connection

try {
 
String driverName = "com.mysql.jdbc.Driver";                        
 
Class.forName(driverName);
 
// Configurando a nossa conexão com um banco de dados//
 
        String serverName = "localhost";    //caminho do servidor do BD
 
        String mydatabase ="java-consultorio";        //nome do seu banco de dados
 
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
 
        String username = "root";        //nome de um usuário de seu BD      
 
        String password = "";      //sua senha de acesso
 
        connection = (Connection) DriverManager.getConnection(url, username, password);
 
        //Testa sua conexão//  
 
        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }

        return connection;
  
        } catch (ClassNotFoundException e) {  //Driver não encontrado 
 
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;

        } catch (SQLException e) {
 
//Não conseguindo se conectar ao banco
 
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
 
            return null; 
        }
    }

    //Método que retorna o status da sua conexão//
 
    public static String statusConection() {
 
        return status;
 
    }
}
