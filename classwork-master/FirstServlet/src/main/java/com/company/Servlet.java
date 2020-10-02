package com.company;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


@WebServlet(urlPatterns = "/servlet", smallIcon = "C:\\Users\\J-2019\\Downloads\test.ico")
public class Servlet extends HttpServlet {

    private String SERVLET_NAME;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("hello its my first servlet" + SERVLET_NAME);


        String name = req.getParameter("name");

        req.getSession().setAttribute("Name", name);







    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.SERVLET_NAME = config.getInitParameter("adminServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
