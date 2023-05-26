package modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabian
 */

public class modeloEmpleador {
    
    Connection MyConexion;
    ResultSet rst;
    
    public ResultSet ListarDatos(){
        
        DefaultTableModel TablaModelo = new DefaultTableModel();
        TablaModelo.setRowCount(0);
        TablaModelo.setColumnCount(0);
        
        TablaModelo.addColumn("ID");
        TablaModelo.addColumn("Apellidos");
        TablaModelo.addColumn("Nombre");
        TablaModelo.addColumn("Telefono");
        
        
        try{
            Conexion nuevaConexion = new Conexion();
            MyConexion = nuevaConexion.Conectar();
            Statement st = MyConexion.createStatement();
            rst = st.executeQuery("Select * from  Empleados");
            return rst;
        }
        
        catch(SQLException e){
            System.out.println(e+ " No jalo :3");
            return rst;
        }
        
    }
    
    public void Actualizar(int Codigo, String Apellidos, String Nombre, String Telefono){
        
        try{
            Conexion nuevaConexcion = new Conexion();
            MyConexion = nuevaConexcion.Conectar();
            Statement st = MyConexion.createStatement();
            st.executeQuery("Update empleados set APELLIDOS ="+"'"+Apellidos+"',NOMBRE="+"'"+Nombre+"',TELEFONO="+"'"+Telefono+"' where idempleado="+"'"+Codigo+"'");
            
        }
        catch(SQLException e){
      
            JOptionPane.showMessageDialog(null, "No jalo a editar tu empleado "+ e);
            
        }
    }
    
    public void Guardar(int Codigo, String Apellidos, String Nombre, String Telefono){
        try{
            Conexion nuevaConexcion = new Conexion();
            MyConexion = nuevaConexcion.Conectar();
            Statement st = MyConexion.createStatement();
            st.executeQuery("Insert into empleados values ("+"'"+Codigo+"',"+"'"+Apellidos+"',"+"'"+Nombre+"'"+"'"+Telefono+"')");
            JOptionPane.showMessageDialog(null, "Empleado Guardado");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No jalo a subir tu persona "+ e);
          
            
        }
        
    }
    
    public void Eliminar(int Codigo){
        
    }
    
}