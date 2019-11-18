/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import conexaobd.Conecta;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author IFSul
 */
public class Consultorio {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection conexao = (Connection) new Conecta();
        conexao.close();
        System.out.println("Desconectado do banco! c:");
    }
    
}
