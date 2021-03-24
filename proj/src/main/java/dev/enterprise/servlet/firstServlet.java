package dev.enterprise.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class firstServlet extends HttpServlet {

    public void getInfo(HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("<h1>Welcome Test</h1>");
        StringBuilder sb = new StringBuilder();
        InfoDAO info = new InfoDAO();
        ArrayList<String> s = info.getAll();

        for(String sub : s) {
            sb.append(sub);
            sb.append("\n");
        }
        resp.getWriter().println(sb);
    }
}
