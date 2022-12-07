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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class PacienteDAO {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<PacienteDTO> lista = new ArrayList<>();

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

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Cadastrar " + sql);
        }
    }

    public ArrayList<PacienteDTO> pesquisarPaciente() {
        String sql = "SELECT * FROM paciente";
        conexao = new ConexaoDAO().conectaBD();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PacienteDTO objpacientedto = new PacienteDTO();
                objpacientedto.setId_Paciente(rs.getInt("id"));
                objpacientedto.setNomePaciente(rs.getString("nomepaciente"));
                objpacientedto.setDataNascimento(rs.getString("datanascimento"));
                objpacientedto.setTelefonePaciente(rs.getString("telefonepaciente"));
                objpacientedto.setProntuarioPaciente(rs.getString("prontuarioPaciente"));

                lista.add(objpacientedto);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PacienteDAO Pesquisar" + sql);
        }
        return lista;
    }
    
    public void alterarPaciente(PacienteDTO objpacientedto){
        String sql = "UPDATE paciente SET nomePaciente = ?, dataNascimento = ?, telefonePaciente = ?, prontuarioPaciente = ? WHERE id = ?";
        
        conexao = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objpacientedto.getNomePaciente());
            pstm.setString(2, objpacientedto.getDataNascimento());
            pstm.setString(3, objpacientedto.getTelefonePaciente());
            pstm.setString(4, objpacientedto.getProntuarioPaciente());
            pstm.setInt(5, objpacientedto.getId_Paciente());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "PacienteDAO Alterar " + sql);
        }
    }
//    public void alterarProntuarioPaciente(PacienteDTO objpacientedto){
//        String sql = "UPDATE paciente SET prontuarioPaciente = ? WHERE id = ?";
//        
//        conexao = new ConexaoDAO().conectaBD();
//        
//        try {
//            pstm = conexao.prepareStatement(sql);
//            pstm.setString(1, objpacientedto.getProntuarioPaciente());
//            pstm.setInt(2, objpacientedto.getId_Paciente());
//            
//            pstm.execute();
//            pstm.close();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "FuncionarioDAO Alterar " + sql);
//        }
//    }
    
    public void excluirPaciente(PacienteDTO objpacientedto){
        String sql = "DELETE FROM paciente WHERE id = ?";
        
        conexao = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objpacientedto.getId_Paciente());
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Excluir " + sql);
        }
    }
}
