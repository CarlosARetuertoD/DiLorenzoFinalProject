package com.example.dilorenzoapp.Clases;

import java.util.Date;

public class Trabajador {
    String dni;
    String apellidos;
    String nombre;
    Date fecha_inicio;
    String contacto;
    String contrasenia;
    String foto_perfil;

    public Trabajador() {
    }

    public Trabajador(String dni, String apellidos, String nombre, Date fecha_inicio, String contacto, String contrasenia, String foto_perfil) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.contacto = contacto;
        this.contrasenia = contrasenia;
        this.foto_perfil = foto_perfil;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }
}
