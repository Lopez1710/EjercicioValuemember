/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author William
 */
public class NotaVM {
    
    public String nombre;
    public String nombremateria;
    public String nota;

    public String getFechadeNcimiento() {
        return FechadeNcimiento;
    }

    public void setFechadeNcimiento(String FechadeNcimiento) {
        this.FechadeNcimiento = FechadeNcimiento;
    }
    public String FechadeNcimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
}
