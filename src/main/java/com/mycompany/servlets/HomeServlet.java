/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 *
 * Сервлет, которы   работает со страницей home
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
  // в случае GET-запросов следует просто отдать страницу home  
    @Override
    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
        reg.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(reg, resp);     
    }
    // обработка запроса, который должен поменять цвет заголовка
    @Override
    protected void doPost(HttpServletRequest geg, HttpServletResponse resp) throws ServletException, IOException {
        // получаем параметр запроса
        String color = reg.Parameter("color");
                //создаём Cookie с данным значением
                Cookie colorCookie = new Cookie("color," color);
                // кладём в ответ
                resp.addCookie(colorCookie);
                // перенаправляем пользователя обратно на страницу home
                resp.sendRedirect(reg.getContextPath() + "/home");
    }
}
