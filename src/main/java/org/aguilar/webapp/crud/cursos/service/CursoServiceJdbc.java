package org.aguilar.webapp.crud.cursos.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.aguilar.webapp.crud.cursos.models.Curso;
import org.aguilar.webapp.crud.cursos.repository.CursoRepositoryJdbcImpl;

public class CursoServiceJdbc implements CursoService{

    private CursoRepositoryJdbcImpl repositoryJdbc;

    public CursoServiceJdbc(Connection connection) {
        this.repositoryJdbc = new CursoRepositoryJdbcImpl(connection);
    }

    @Override
    public List<Curso> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repositoryJdbc.porNombre(nombre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Curso> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(Curso curso) {
        try {
            repositoryJdbc.guardar(curso);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
