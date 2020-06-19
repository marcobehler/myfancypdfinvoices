package com.marcobehler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().print("<html>\n" +
                        "<body>\n" +
                        "<h1>Hello World</h1>\n" +
                        "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
                "</body>\n" +
                        "</html>");
    }
}
