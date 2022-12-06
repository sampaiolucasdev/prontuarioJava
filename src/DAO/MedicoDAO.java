/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.MedicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class MedicoDAO {

    Connection conexao;
    PreparedStatement pstm;

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
}
