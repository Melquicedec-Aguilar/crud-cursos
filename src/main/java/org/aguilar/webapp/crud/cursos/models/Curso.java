package org.aguilar.webapp.crud.cursos.models;

import java.util.Objects;

public class Curso {
    private Long id;
    private String nombre;
    private String descripcion;
    private String instructor;
    private float duracion;

    public Curso() {
    }

    public Curso(Long id, String nombre, String descripcion, String instructor, float duracion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instructor = instructor;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Curso curso = (Curso) object;
        return Float.compare(duracion, curso.duracion) == 0 && Objects.equals(id, curso.id) && Objects.equals(nombre, curso.nombre) && Objects.equals(descripcion, curso.descripcion) && Objects.equals(instructor, curso.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, instructor, duracion);
    }
}
