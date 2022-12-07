/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.MedicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class MedicoDAO {

    Connection conexao;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<MedicoDTO> lista = new ArrayList<>();

    public void cadastrarMedico(MedicoDTO objmedicodto) {
        String sql = "INSERT INTO medico (nomeMedico, especialidade, crm) values (?, ?, ?)";

        conexao = new ConexaoDAO().conectaBD();

        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objmedicodto.getNomeMedico());
            pstm.setString(2, objmedicodto.getEspecialidade());
            pstm.setString(3, objmedicodto.getCrm());
            
           pstm.execute();
           pstm.close();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "MedicoDAO " + sql);
        }
    }
    
    public ArrayList<MedicoDTO> pesquisarMedico() {
        String sql = "SELECT * FROM medico";
        conexao = new ConexaoDAO().conectaBD();

        try {
            pstm = conexao.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MedicoDTO objmedicodto = new MedicoDTO();
                objmedicodto.setId_Medico(rs.getInt("id_Medico"));
                objmedicodto.setNomeMedico(rs.getString("nomeMedico"));
                objmedicodto.setEspecialidade(rs.getString("especialidade"));
                objmedicodto.setCrm(rs.getString("crm"));

                lista.add(objmedicodto);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "MedicoDAO Pesquisar" + sql);
        }
        return lista;
    }
    
    public void alterarMedico(MedicoDTO objmedicodto){
        String sql = "UPDATE medico SET nomeMedico = ?, especialidade = ?, crm = ? WHERE id_Medico = ?";
        
        conexao = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, objmedicodto.getNomeMedico());
            pstm.setString(2, objmedicodto.getEspecialidade());
            pstm.setString(3, objmedicodto.getCrm());
            pstm.setInt(4, objmedicodto.getId_Medico());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "MedicoDAO Alterar " + sql);
        }
    }
    
    public void excluirMedico(MedicoDTO objmedicodto){
        String sql = "DELETE FROM medico WHERE id_Medico = ?";
        
        conexao = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, objmedicodto.getId_Medico());
            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "MedicoDAO Excluir " + sql);
        }
    }
}
