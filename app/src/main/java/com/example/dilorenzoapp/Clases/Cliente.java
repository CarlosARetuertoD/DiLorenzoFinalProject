package com.example.dilorenzoapp.Clases;

import java.util.List;

public class Cliente {
    int id;
    String apellidos;
    String nombre;
    String dni;
    Double puntaje;
    String direccion;
    Double latitud;
    Double longitud;
    Boolean verificado;
    List<datos_facturacion> datos_facturacion;
    Zona zona;

    public Cliente() {
    }

    public Cliente(int id, String apellidos, String nombre, String dni, Double puntaje, String direccion,Double latitud, Double longitud, Boolean verificado, List<Cliente.datos_facturacion> datos_facturacion, Zona zona) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.dni = dni;
        this.puntaje = puntaje;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.verificado = verificado;
        this.datos_facturacion = datos_facturacion;
        this.zona = zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Boolean getVerificado() {
        return verificado;
    }

    public void setVerificado(Boolean verificado) {
        this.verificado = verificado;
    }

    public List<Cliente.datos_facturacion> getDatos_facturacion() {
        return datos_facturacion;
    }

    public void setDatos_facturacion(List<Cliente.datos_facturacion> datos_facturacion) {
        this.datos_facturacion = datos_facturacion;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public class datos_facturacion{
        String ruc;
        String razon_social;

        public datos_facturacion() {
        }

        public datos_facturacion(String ruc, String razon_social) {
            this.ruc = ruc;
            this.razon_social = razon_social;
        }

        public String getRuc() {
            return ruc;
        }

        public void setRuc(String ruc) {
            this.ruc = ruc;
        }

        public String getRazon_social() {
            return razon_social;
        }

        public void setRazon_social(String razon_social) {
            this.razon_social = razon_social;
        }
    }
    class Zona{
        int id;
        String descripcion;
        List<coordenada> coordenadas;

        public Zona() {
        }

        public Zona(int id, String descripcion, List<coordenada> coordenadas) {
            this.id = id;
            this.descripcion = descripcion;
            this.coordenadas = coordenadas;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public List<coordenada> getCoordenadas() {
            return coordenadas;
        }

        public void setCoordenadas(List<coordenada> coordenadas) {
            this.coordenadas = coordenadas;
        }

        class coordenada {
            Double latitud;
            Double longitud;
            int orden_polygono;

            public coordenada() {
            }

            public coordenada(Double latitud, Double longitud, int orden_polygono) {
                this.latitud = latitud;
                this.longitud = longitud;
                this.orden_polygono = orden_polygono;
            }

            public Double getLatitud() {
                return latitud;
            }

            public void setLatitud(Double latitud) {
                this.latitud = latitud;
            }

            public Double getLongitud() {
                return longitud;
            }

            public void setLongitud(Double longitud) {
                this.longitud = longitud;
            }

            public int getOrden_polygono() {
                return orden_polygono;
            }

            public void setOrden_polygono(int orden_polygono) {
                this.orden_polygono = orden_polygono;
            }
        }
    }
}
