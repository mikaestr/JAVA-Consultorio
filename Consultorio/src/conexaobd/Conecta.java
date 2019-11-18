/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author IFSul
 */
public class Conecta {

    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao banco");
            return DriverManager.getConnection("jdbc:mysql://localhost/consultorio", "root", "");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
