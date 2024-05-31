package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;


public class DaoUsuario {
	
    private Connection conexion;

    public DaoUsuario(Connection conexion) {
        this.conexion = conexion;
    };
     
    public List<Usuario> obtenerTodos(){
    	
    	String consultaSQL = "SELECT user_id, nombre_usuario, saldo FROM usuario";
    	List<Usuario> lista = new ArrayList<Usuario>();
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(consultaSQL);

            while (resultSet.next()) {

                Usuario usuario = new Usuario();
                
                int user_id = resultSet.getInt("user_id");
                String nombre_usuario = resultSet.getString("nombre_usuario");
                double saldo = resultSet.getInt("saldo");
                
                System.out.println("ID: " + user_id + " - Usuario: " + nombre_usuario + " - Saldo: " + saldo );
                
                usuario.setUser_id(user_id);
                usuario.setNombre_usuario(nombre_usuario);
                usuario.setSaldo(saldo);
                
                lista.add(usuario);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    	return lista;
    }
    
    //MÉTODO PARA CONSULTAR SALDO DE USUARIO ESPECÍFICO DE BD
    public Usuario consultaSaldo() {
    String consultaSQL = "SELECT nombre_usuario, saldo FROM usuario WHERE user_id = 1";
    try {
        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(consultaSQL);
       
        while (resultSet.next()) {
             String nombre_usuario = resultSet.getString("nombre_usuario");
             double saldo = resultSet.getDouble("saldo");
             System.out.println(" - Usuario: " + nombre_usuario + " - Saldo: " + saldo );            
        }        
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.err.println("Error al ejecutar la consulta: " + e.getMessage());
    } return null;
    }

        
    // MÉTODO PARA REALIZAR DEPÓSITO AL SALDO DE UN USUARIO
    public boolean realizarDeposito(double cantidadDepositar) {
        String updateSQL = "UPDATE usuario SET saldo = saldo + ? WHERE user_id = 1";
        try (PreparedStatement ps = conexion.prepareStatement(updateSQL)) {
            ps.setDouble(1, cantidadDepositar);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al realizar el depósito: " + e.getMessage());
            return false;
        }
    }
    
    // MÉTODO PARA REALIZAR GIRO DE DINERO DESDE EL SALDO DE UN USUARIO
    public boolean retiroFondos(double cantidadRetiro) {
        String updateSQL = "UPDATE usuario SET saldo = saldo - ? WHERE user_id = 1";
        try (PreparedStatement ps = conexion.prepareStatement(updateSQL)) {
            ps.setDouble(1, cantidadRetiro);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al realizar el giro: " + e.getMessage());
            return false;
        }
    }
        
      
}
 

