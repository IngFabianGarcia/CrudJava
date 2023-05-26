import vista.*;
import modelo.*;
import controller.*;

/**
 *
 * @author Fabian
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) {
        frmPrincipal VistaPrincipal = new frmPrincipal();
        frmEmpleados VistaEmpleados = new frmEmpleados(VistaPrincipal, true);
        Conexion ConexionBd = new Conexion();
        modeloEmpleador Empleado = new modeloEmpleador();
        
        crudController CrudControlador = new crudController(ConexionBd, Empleado, VistaEmpleados, VistaPrincipal);
    }
    
}
