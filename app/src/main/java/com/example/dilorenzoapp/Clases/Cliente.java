package com.example.dilorenzoapp.Clases;

public class Cliente {
    private String puntaje ;
    private String latitud ;
    private String longitud ;
    private String estadoCliente;
    private String dni;
    private String nombre;
    private String apellidos;
    private String contacto;
    private String email;
    private String direccion;
    private String razonSocial;
    private String estadoVentaCliente;

    public Cliente() {

    }

    public Cliente(String estadoVentaCliente, String puntaje, String latitud, String longitud, String estadoCliente, String dni, String nombre, String apellidos, String contacto, String email, String direccion, String razonSocial) {
        this.estadoVentaCliente = estadoVentaCliente;
        this.puntaje = puntaje;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estadoCliente = estadoCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contacto = contacto;
        this.email = email;
        this.direccion = direccion;
        this.razonSocial = razonSocial;
    }

    public Cliente(String estadoCliente, String nombre, String apellidos, String direccion, String razonSocial, String estadoVentaCliente) {
        this.estadoCliente = estadoCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.razonSocial = razonSocial;
        this.estadoVentaCliente = estadoVentaCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getEstadoVentaCliente() {
        return estadoVentaCliente;
    }

    public void setEstadoVentaCliente(String estadoVentaCliente) {
        this.estadoVentaCliente = estadoVentaCliente;
    }


    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
