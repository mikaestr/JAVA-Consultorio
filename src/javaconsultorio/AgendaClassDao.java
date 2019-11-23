
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsultorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author IFSul
 */
public class AgendaClassDao {
   private Connection conexao;
    
    public AgendaClassDao() throws SQLException{
	this.conexao = Conexao.getConexaoMySQL();  
}
   
    public void adiciona(AgendaClass agenda) throws SQLException{
	String sql = "insert into agenda (paciente, medico, data) values (?,?,?)";
	PreparedStatement stmt = conexao.prepareStatement(sql);
	
	stmt.setString(1, agenda.getPaciente());
        stmt.setString(2, agenda.getMedico());
        stmt.setString(3, agenda.getData());

	stmt.execute();
	stmt.close();
}
    
    public ArrayList<AgendaClass> getLista() throws SQLException{
	String sql = "select * from agenda";
	PreparedStatement stmt = this.conexao.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery();

	ArrayList<AgendaClass> lista = new ArrayList<AgendaClass>();
	
	while(rs.next()){
		AgendaClass agenda = new AgendaClass();
		agenda.setPaciente(rs.getString("paciente"));
		agenda.setMedico(rs.getString("medico"));
                agenda.setData(rs.getString("data"));

		lista.add(agenda);
	}
	rs.close();
	stmt.close();
	
	return lista;
}
}
