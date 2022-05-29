/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.william.BD;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author William
 */
public class ConexionAMYSQL {
    
    private static Connection ConnectionBD= null;
    public Connection getConecction (){
        try {
            String url = "jdbc:mysql://localhost:3306/estudiante";
            String user = "root";
            String password = "root";
            
            ConnectionBD = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error "+e.toString());
        }
        
    return ConnectionBD;
    }
    
}
