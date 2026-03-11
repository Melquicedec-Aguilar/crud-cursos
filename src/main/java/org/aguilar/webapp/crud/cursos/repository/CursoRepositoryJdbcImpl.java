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

    @Override
    public Curso porId(Long id) throws SQLException {
        Curso curso = new Curso();

        //Se abre un try con recursos para que se cierre de forma automatica la conexión
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cursos as c WHERE c.id = ?")){

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    curso = getCurso(rs);
                }
            }
        }
        return curso;
    }

    @Override
    public void guardar(Curso curso) throws SQLException {
        String sql;

        if (curso.getId() != null && curso.getId() > 0){
            sql = "UPDATE cursos SET nombre = ?, descripcion = ?, instructor = ?, duracion = ? WHERE id = ?";
        }else {
            sql = "INSERT INTO cursos (nombre, descripcion, instructor, duracion,) values (?, ?, ?, ?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getDescripcion());
            stmt.setString(3, curso.getInstructor());
            stmt.setFloat(4, curso.getDuracion());
            if (curso.getId() != null && curso.getId() > 0){
                stmt.setLong(5, curso.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

        String sql = "DELETE FROM cursos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
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
