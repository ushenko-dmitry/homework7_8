package ru.mail.dimaushenko.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.mail.dimaushenko.service.UserService;
import ru.mail.dimaushenko.service.impl.UserServiceImpl;
import ru.mail.dimaushenko.service.model.FullUserDTO;

import static ru.mail.dimaushenko.constants.HtmlPatterns.VIEW_ALL_USER_START;
import static ru.mail.dimaushenko.constants.HtmlPatterns.VIEW_ALL_USER_END;
import static ru.mail.dimaushenko.constants.HtmlPatterns.USER_INSERT_ID;
import static ru.mail.dimaushenko.constants.HtmlPatterns.USER_INSERT_USERNAME;
import static ru.mail.dimaushenko.constants.HtmlPatterns.USER_INSERT_PASSWORD;
import static ru.mail.dimaushenko.constants.HtmlPatterns.USER_INSERT_IS_ACTIVE;
import static ru.mail.dimaushenko.constants.HtmlPatterns.USER_INSERT_AGE;
import static ru.mail.dimaushenko.constants.HtmlPatterns.VIEW_ALL_USER_TABLE_PATTERN;

public class ViewAllUserServlet extends HttpServlet {

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FullUserDTO> users = userService.getAllFullUser();

        try (PrintWriter out = resp.getWriter()) {
            out.println(VIEW_ALL_USER_START);
            for (FullUserDTO user : users) {
                String s;

                String id = String.valueOf(user.getId());
                String isActive = String.valueOf(user.isIsActive());
                String age = String.valueOf(user.getAge());

                s = VIEW_ALL_USER_TABLE_PATTERN.replaceAll(USER_INSERT_ID, id);
                s = s.replaceAll(USER_INSERT_USERNAME, user.getUsername());
                s = s.replaceAll(USER_INSERT_PASSWORD, user.getPassword());
                s = s.replaceAll(USER_INSERT_IS_ACTIVE, isActive);
                s = s.replaceAll(USER_INSERT_AGE, age);

                out.println(s);
            }
            out.println(VIEW_ALL_USER_END);
        }

    }

}
