package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.*;
import modelo.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabian
 */
public class crudController implements ActionListener, MouseListener {
    Conexion ConexionModel;
    modeloEmpleador empleador;
    frmEmpleados VistaEmpleados;
    frmPrincipal VistaPrincipal;

    public crudController(Conexion ConexionModel, modeloEmpleador empleador, frmEmpleados VistaEmpleados, frmPrincipal VistaPrincipal) {
        this.ConexionModel = ConexionModel;
        this.empleador = empleador;
        this.VistaEmpleados = VistaEmpleados;
        this.VistaPrincipal = VistaPrincipal;
        
        this.VistaPrincipal.setVisible(true);
        this.VistaPrincipal.btnBaseDatos.addActionListener(this);
        this.VistaEmpleados.btnAgregar.addActionListener(this);
        this.VistaEmpleados.btnEditar.addActionListener(this);
        this.VistaEmpleados.btnEliminar.addActionListener(this);
        this.VistaEmpleados.jtTablaDatosPersona.addMouseListener(this);
        
        DefaultTableModel TablaModelo = new DefaultTableModel();
        TablaModelo.setRowCount(0);
        TablaModelo.setColumnCount(0);
        this.VistaEmpleados.jtTablaDatosPersona.setModel(TablaModelo);
        
            TablaModelo.addColumn("ID");
            TablaModelo.addColumn("Apellidos");
            TablaModelo.addColumn("Nombre");
            TablaModelo.addColumn("Telefono");
            
            
             ResultSet rst = this.empleador.ListarDatos();
            try
            {
                
            while(rst.next())
            {
                TablaModelo.addRow(new Object[]{rst.getInt("idEmpleado"), rst.getString("Apellidos"), rst.getString("Nombre"), rst.getString("Telefono")});
            } 
            }
            catch(SQLException ex){
            System.out.println(ex+"no jala");
    }
    

         
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.VistaPrincipal.btnBaseDatos){
            this.VistaEmpleados.setVisible(true);
        }
        
        if(e.getSource()== this.VistaEmpleados.btnEditar){
             //Editar empleados
            this.empleador.Actualizar(Integer.parseInt(this.VistaEmpleados.txtCodigo.getText()),
                    this.VistaEmpleados.txtApellidos.getText(),
                    this.VistaEmpleados.txtNombre.getText(),
                    this.VistaEmpleados.txtTelefono.getText());
            
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila;        
        //Setea los textos que clickes
        if(e.getSource()== this.VistaEmpleados.jtTablaDatosPersona){  
            fila = this.VistaEmpleados.jtTablaDatosPersona.getSelectedRow();
            
            this.VistaEmpleados.txtCodigo.setText(this.VistaEmpleados.jtTablaDatosPersona.getValueAt(fila, 0).toString());
            
            this.VistaEmpleados.txtApellidos.setText(this.VistaEmpleados.jtTablaDatosPersona.getValueAt(fila, 1).toString());
            
            this.VistaEmpleados.txtNombre.setText(this.VistaEmpleados.jtTablaDatosPersona.getValueAt(fila, 2).toString());
            
            this.VistaEmpleados.txtTelefono.setText(this.VistaEmpleados.jtTablaDatosPersona.getValueAt(fila, 3).toString());
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

 