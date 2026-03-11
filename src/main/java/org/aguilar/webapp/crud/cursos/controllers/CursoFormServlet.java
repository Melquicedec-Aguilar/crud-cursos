package org.aguilar.webapp.crud.cursos.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.aguilar.webapp.crud.cursos.models.Curso;
import org.aguilar.webapp.crud.cursos.service.CursoService;
import org.aguilar.webapp.crud.cursos.service.CursoServiceJdbc;

@WebServlet("/form")
public class CursoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        CursoService service = new CursoServiceJdbc(conn);

        Long id;

        try {
            id = Long.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0L;
        }

        Curso curso = new Curso();

        if (id>0){
            Optional<Curso> o = service.porId(id);
            if (o.isPresent()){
                curso = o.get();
            }
        }

        req.setAttribute("curso", curso);
        getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        CursoService service = new CursoServiceJdbc(conn);

        Long id;
        try {
            id = Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }

        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String instructor = req.getParameter("instructor");

        float duracion;
        try {
            duracion = Float.parseFloat(req.getParameter("duracion"));
        }catch (NumberFormatException e){
            duracion = 0;
        }

        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()){
            errores.put("nombre", "El nombre es requerido!!");
        }
        if (descripcion == null || descripcion.isBlank()){
            errores.put("descripcion", "La descripcion es requerida!!");
        }
        if (instructor == null || instructor.isBlank()){
            errores.put("instructor", "El instructor es requerido!!");
        }
        if (duracion <= 0){
            errores.put("duracion", "La duración debe ser mayor a 0");
        }

        Curso curso = new Curso();
        curso.setId(id);
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setInstructor(instructor);
        curso.setDuracion(duracion);

        if (errores.isEmpty()){
            service.guardar(curso);

            resp.sendRedirect(req.getContextPath() + "/listar");
        }else {
            req.setAttribute("errores", errores);
            req.setAttribute("curso", curso);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
