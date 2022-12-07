package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class ConexaoDAO {
    
    public Connection conectaBD() {
        Connection conexao = null;
        try {
            String url = "jdbc:mysql://prontuario.ctxwl27tz2k6.sa-east-1.rds.amazonaws.com:3306/prontuario?user=admin&password=Secret2022";
            
            conexao = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão: "+ e);
        }
        return conexao;
    }
    
}
