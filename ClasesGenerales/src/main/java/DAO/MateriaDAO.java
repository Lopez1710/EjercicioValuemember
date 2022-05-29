/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Estudiante;
import Entidades.Materia;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dead1
 */
public class MateriaDAO {
    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Materia> ListadoMaterias() {
        ArrayList<Materia> listado = null;

        try {
            listado = new ArrayList<Materia>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MATERIAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Materia mt = new Materia();
                mt.setIdmateria(resultado.getInt("idmateria"));
                mt.setNombreMateria(resultado.getString("NombreMateria"));
                listado.add(mt);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
}
