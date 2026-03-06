package org.aguilar.webapp.crud.cursos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.aguilar.webapp.crud.cursos.models.Curso;

public class CursoRepositoryJdbcImpl implements Repository<Curso> {

    private Connection conn;

    public CursoRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Curso> listar() throws SQLException {
        List<Curso> cursoList = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                 "SELECT * FROM cursos"
             )){

            while (rs.next()){
                Curso c = getCurso(rs);

                cursoList.add(c);
            }
        }
        return cursoList;
    }

    @Override
    public List<Curso> porNombre(String nombre) throws SQLException {
        List<Curso> cursoList = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement(
            "SELECT * FROM cursos as c WHERE c.nombre like ?"
        )){
            statement.setString(1, "%" + nombre + "%");

            try (ResultSet rs = statement.executeQuery()){
                while (rs.next()){
                    Curso c = getCurso(rs);

                    cursoList.add(c);
                }
            }
        }
        return cursoList;
    }

    private static Curso getCurso(ResultSet rs) throws SQLException {
        Curso c = new Curso();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setInstructor(rs.getString("instructor"));
        c.setDuracion(rs.getFloat("duracion"));

        return c;
    }
}
