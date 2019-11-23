
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
public class ConsultaClassDao {
   private Connection conexao;
    
    public ConsultaClassDao() throws SQLException{
	this.conexao = Conexao.getConexaoMySQL();  
}
   
    
    
    public void adiciona(ConsultaClass consulta) throws SQLException{
	String sql = "insert into consulta (medico, paciente, observacao) values (?,?,?)";
       try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
           stmt.setString(2, consulta.getMedico());
           stmt.setString(1, consulta.getPaciente());
           stmt.setString(3, consulta.getObservacao());
           
           stmt.execute();
       }
}
    
    public ArrayList<ConsultaClass> getLista(String paciente) throws SQLException{
	String sql = "select * from consulta where paciente like ?";
	PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setString(1,paciente);
	ResultSet rs = stmt.executeQuery();

	ArrayList<ConsultaClass> lista = new ArrayList<ConsultaClass>();
	
	while(rs.next()){
		ConsultaClass consulta = new ConsultaClass();
		consulta.setPaciente(rs.getString("paciente"));
		consulta.setMedico(rs.getString("medico"));
                consulta.setObservacao(rs.getString("observacao"));
                
		lista.add(consulta);
	}
        
	rs.close();
	stmt.close();
	
	return lista;
}
}
