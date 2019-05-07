/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author user
 */
@WebFilter("/home")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    // на вход фильтр получает запрос, ответ, а также цепочку фильтров, которым следует отдать запрос далее.

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
// выполняем преобразование Servlet-запросов-ответов в HTTP-запросы-ответы
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//смотрим, есть ли сессия для данного запроса (проверяется наличие Cookie с названием JSESSIONID
        HttpSession session = request.getSession(false);
// если сессия не была, или у сессии отсутствует атрибут user, перенаправляем пользователей на страницу с логином
        if (session == null || session.getAttribute("user") == null) {
            servletRequest.getServletContext().getRequestDispatcher("/login").forward(request, response);
        }
// отдаём запрос данных в цепочку фильтров
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
