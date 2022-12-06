/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PacienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Lucas
 */
public class PacienteDAO {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarPaciente(PacienteDTO objpacientedto) {
        String sql = "INSERT INTO paciente (datanascimento, nomepaciente, telefonepaciente) values (?, ?, ?)";

        conexao = new ConexaoDAO().conectaBD();

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objpacientedto.getDataNascimento());
            pstm.setString(2, objpacientedto.getNomePaciente());
            pstm.setString(3, objpacientedto.getTelefonePaciente());
            
           pstm.execute();
           pstm.close();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Cadastrar " + sql);
        }
    }
    
    public ResultSet<PacienteDTO> pesquisarPaciente(){
        String sql = "SELECT * FROM paciente";
        
        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {                
                PacienteDTO objpacientedto = new PacienteDTO();
                objpacientedto.setId_Paciente(rs.getInt("id"));
                objpacientedto.setNomePaciente(rs.getString("nomepaciente"));
                objpacientedto.setDataNascimento(rs.getString("datanascimento"));
                objpacientedto.setTelefonePaciente(rs.getString("telefonepaciente"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PacienteDAO Pesquisar" + sql);
        }
    }
}
