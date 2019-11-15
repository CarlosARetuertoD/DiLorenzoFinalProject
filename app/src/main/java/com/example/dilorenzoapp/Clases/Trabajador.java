package com.example.dilorenzoapp.Clases;

import java.util.Date;

public class Trabajador {
    String apellidos;
    String nombre;
    String dni;
    Date fecha_inicio;
    String contacto;
    String usuario;
    String contrasenia;

    public Trabajador() {
    }

    public Trabajador(String apellidos, String nombre, String dni, Date fecha_inicio, String contacto, String usuario,String contrasenia) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.dni = dni;
        this.fecha_inicio = fecha_inicio;
        this.contacto = contacto;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
