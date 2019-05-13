/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import com.mycompany.models.User;
import com.mycompany.repositories.UserRepository;
import com.mycompany.repositories.UserRepositoryInMemoryImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author user
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserRepository usersRepository;
    @Override
    public void init() throws ServletException {
        this.usersRepository = new UserRepositoryInMemoryImpl();
    }
    @Override
    protected void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();
        reg.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = reg.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(reg, resp);     
    }
    @Override
    protected void doPost(HttpServletRequest reg, HttpServletResponse resp) throws ServletException, IOException {
        // вытащили данные регистрации
        String name = reg.getParameter("name");
        String password = reg.getParameter("password");
        LocalDate birthDate = LocalDate.parse(reg.getParameter("birthDate"));
        // создали пользователя и сохранили его в хранилище
        User user = new User(name, password, birthDate);
        usersRepository.save(user);
        doGet(reg, resp);
     
}
}
