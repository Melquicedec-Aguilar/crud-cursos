package org.aguilar.webapp.crud.cursos.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;
import org.aguilar.webapp.crud.cursos.models.Curso;
import org.aguilar.webapp.crud.cursos.service.CursoService;
import org.aguilar.webapp.crud.cursos.service.CursoServiceJdbc;

@WebServlet("/eliminar")
public class CursoEliminarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");

        CursoService service = new CursoServiceJdbc(conn);

        Long id;

        try {
            id = Long.valueOf(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }

        if (id > 0){
            Optional<Curso> o = service.porId(id);
            if (o.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/listar");
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el producto que desea eliminar");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El id es null, se debe enviar como parámetro en la URL!");
        }
    }
}
