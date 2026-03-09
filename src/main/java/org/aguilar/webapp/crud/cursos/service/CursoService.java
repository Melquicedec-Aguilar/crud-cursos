package org.aguilar.webapp.crud.cursos.service;

import java.util.List;
import java.util.Optional;
import org.aguilar.webapp.crud.cursos.models.Curso;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
    Optional<Curso> porId(Long id);
    void guardar(Curso curso);
    void eliminar(Long id);

}
