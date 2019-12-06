package com.example.dilorenzoapp.Clases;

import java.util.Date;
import java.util.List;

public class ZonaTrabajador {

    Zona zona;
    Date fecha_inicio;
    Date fecha_fin;

    public ZonaTrabajador() {
    }

    public ZonaTrabajador(Zona zona, Date fecha_inicio, Date fecha_fin) {
        this.zona = zona;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public class Zona{
        String descripcion;
        List<Coordenada> coordenadas;

        public Zona() {
        }

        public Zona(String descripcion, List<Coordenada> coordenadas) {
            this.descripcion = descripcion;
            this.coordenadas = coordenadas;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public List<Coordenada> getCoordenadas() {
            return coordenadas;
        }

        public void setCoordenadas(List<Coordenada> coordenadas) {
            this.coordenadas = coordenadas;
        }

        public class Coordenada{
            Double latitud;
            Double longitud;
            int orden_polygono;

            public Coordenada() {
            }

            public Coordenada(Double latitud, Double longitud, int orden_polygono) {
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
