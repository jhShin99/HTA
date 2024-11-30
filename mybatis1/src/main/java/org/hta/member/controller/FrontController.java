package org.hta.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hta.member.action.*;

import java.io.IOException;

@WebServlet("*.net")
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
            case "/main.net":
                action = new MainAction();
                break;
            case "/loginForm.net":
                action = new LoginFormAction();
                break;
            case "/joinForm.net":
                action = new JoinFormAction();
                break;
            case "/loginPro.net":
                action = new LoginProAction();
                break;
            case "/joinPro.net":
                action = new JoinProAction();
                break;
            case "/logout.net":
                action = new LogoutAction();
                break;
            case "/list.net":
                action = new ListAction();
                break;
            case "/delete.net":
                action = new DeleteAction();
                break;
            case "/updateForm.net":
                action = new UpdateFormAction();
                break;
            case "/updatePro.net":
                action = new UpdateProAction();
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
