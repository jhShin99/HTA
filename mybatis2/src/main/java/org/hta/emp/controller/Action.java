package org.hta.emp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
