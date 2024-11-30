package org.hta.emp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.emp.action.Term;
import org.hta.emp.action.Term2;
import org.hta.emp.action.Term3;

import java.io.IOException;

@WebServlet("*.emp")
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());
        ActionForward forward = null;
        Action action = null;

        System.out.println("RequestURI = " + RequestURI);
        System.out.println("contextPath = " + contextPath);
        System.out.println("command = " + command);

        switch (command) {
            case "/term.emp":
                action = new Term();
                break;
            case "/term2.emp":
                action = new Term2();
                break;
            case "/term3.emp":
                action = new Term3();
                break;

        }

        forward = action.execute(request, response);

        if (forward != null) {
            if (forward.isRedirect()) {
                response.sendRedirect(forward.getPath());
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}
