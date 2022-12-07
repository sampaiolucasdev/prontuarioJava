/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class UsuarioDAO {

    Connection conexao;
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) throws SQLException {
        
        conexao = new ConexaoDAO().conectaBD();
        try {
            String sql = "select * from usuario where usuario= ? and senha = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1,objusuariodto.getNome_usuario());
            pstm.setString(2,objusuariodto.getSenha_usuario());
                        
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
    
    public ResultSet verificarPermissao(UsuarioDTO objusuariodto) throws SQLException {
        conexao = new ConexaoDAO().conectaBD();
        
        try {
            String sql = "SELECT permissao FROM usuario WHERE usuario = ? AND senha = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1,objusuariodto.getNome_usuario());
            pstm.setString(2,objusuariodto.getSenha_usuario());
            
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "PermissãoDAO: " + erro);
            return null;
        }
    }
}
