/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Estudiante;
import Entidades.Nota;
import ViewModel.NotaVM;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class Notas {
    
      ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Nota> ListadoEstudiantes() {
        ArrayList<Nota> listado = null;

        try {
            listado = new ArrayList<Nota>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Nota es = new Nota();
                es.setNota(resultado.getString("nota"));
                es.setNombreMateria(resultado.getString("NombreMateria"));
                es.setNombre(resultado.getString("Nombre"));
          
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
     public ArrayList<NotaVM> ListadoEstudiantesConNotas() {
        ArrayList<NotaVM> listado = null;

        try {
            listado = new ArrayList<NotaVM>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                NotaVM es = new NotaVM();
                es.setNota(resultado.getString("nota"));
                es.setNombremateria(resultado.getString("NombreMateria"));
                es.setNombre(resultado.getString("Nombre"));
                es.setFechadeNcimiento(resultado.getString("FechaNc"));
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    public void AgregarNotas(Nota nota){
    
    
    
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_NOTA(?,?,?)}");
            cb.setString("PNota", nota.getNota());
            cb.setInt("PIdMateria", nota.getIdMateria());
            cb.setInt("PIdEstudiante", nota.getIdEstudiante());
            cb.execute();
            
            JOptionPane.showMessageDialog(null, "Nota Agregada","Mensje sistems",1);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex,"Mensje sistems",1);
            
        }
    
    }
    
}
