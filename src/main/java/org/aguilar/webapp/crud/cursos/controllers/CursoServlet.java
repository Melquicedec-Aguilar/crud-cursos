package org.aguilar.webapp.crud.cursos.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import org.aguilar.webapp.crud.cursos.models.Curso;
import org.aguilar.webapp.crud.cursos.service.CursoService;
import org.aguilar.webapp.crud.cursos.service.CursoServiceJdbc;

@WebServlet({"/index.html", "/listar"})
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        CursoService service = new CursoServiceJdbc(conn);

        List<Curso> cursoList = service.listar();
        req.setAttribute("cursos", cursoList);

        getServletContext().getRequestDispatcher("/listar.jsp").forward(req,resp);
    }
}
