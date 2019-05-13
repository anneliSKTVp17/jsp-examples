/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import com.mycompany.repositories.UserRepository;
import com.mycompany.repositories.UserRepositoryInMemoryImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
/**
 *
 * @author user
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
// ссылка на хранилище пользователей
private UserRepository usersRepository;
    //private UserRepositoryInMemoryImpl userRepositiry;

@Override
public void init() throws ServletException {
    this.usersRepository = new UserRepositoryInMemoryImpl();
}
@Override
protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException{
reg.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(reg, resp);      
}
@Override
protected void doPost(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
    // вытаскиваем из запроса имя пользователя и его пароль
    String name = reg.getParameter("name");
    String password = reg.getParameter("password");
    
    // если пользователь есть в системе
    if (usersRepository.isExist(name, password)) {
        // создаём для него сессию
        HttpSession session = reg.getSession();
        // кладём в атрибут сессии атрибут user с именем пользователя
        session.setAttribute("user", name);
        // пренаправляем на страницу home
        reg.getServletContext().getRequestDispatcher("/home").forward(reg, resp);
    } else {
        resp.sendRedirect(reg.getContextPath() + "/login");
    }
}
}

