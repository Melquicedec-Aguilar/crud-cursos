package org.aguilar.webapp.crud.cursos.service;

import java.util.List;
import org.aguilar.webapp.crud.cursos.models.Curso;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}
