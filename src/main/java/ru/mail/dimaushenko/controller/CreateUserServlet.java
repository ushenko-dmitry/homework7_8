package ru.mail.dimaushenko.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.mail.dimaushenko.service.UserService;
import ru.mail.dimaushenko.service.impl.UserServiceImpl;
import ru.mail.dimaushenko.service.model.AddUserDTO;
import ru.mail.dimaushenko.utils.PropertyUtil;
import ru.mail.dimaushenko.utils.impl.PropertyUtilConstantsImpl;

import static ru.mail.dimaushenko.constants.PropertyConstants.FORM_PARAMETER_AGE;
import static ru.mail.dimaushenko.constants.PropertyConstants.FORM_PARAMETER_IS_ACTIVE;
import static ru.mail.dimaushenko.constants.PropertyConstants.FORM_PARAMETER_PASSWORD;
import static ru.mail.dimaushenko.constants.PropertyConstants.FORM_PARAMETER_USERNAME;
import static ru.mail.dimaushenko.constants.ErrorConstants.ERROR_DATA_IS_INCORRECT;
import static ru.mail.dimaushenko.constants.HtmlPatterns.END_HTML;
import static ru.mail.dimaushenko.constants.HtmlPatterns.HEAD_HTML;

public class CreateUserServlet extends HttpServlet {

    private final PropertyUtil propertyUtil = PropertyUtilConstantsImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();
    private final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private final String MESSAGE_USER_CREATED = "<p>User is created<br/>If you want to create another USER click <a href=\"createNewUser.jsp\">here</a></p>";
    private final String MESSAGE_DATA_IS_INCORRECT = "<p>You write incorrect data<br/>If you want to create another USER click <a href=\"createNewUser.jsp\">here</a></p>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message;

        String username = req.getParameter(propertyUtil.getProperty(FORM_PARAMETER_USERNAME));
        String password = req.getParameter(propertyUtil.getProperty(FORM_PARAMETER_PASSWORD));
        String isActiveStr = req.getParameter(propertyUtil.getProperty(FORM_PARAMETER_IS_ACTIVE));
        String ageStr = req.getParameter(propertyUtil.getProperty(FORM_PARAMETER_AGE));

        boolean isActive;
        try {
            Integer age = Integer.parseInt(ageStr);
            if (isActiveStr == null) {
                isActive = false;
            } else {
                isActive = true;
            }

            AddUserDTO addUserDTO = new AddUserDTO();
            addUserDTO.setUsername(username);
            addUserDTO.setPassword(password);
            addUserDTO.setIsActive(isActive);
            addUserDTO.setAge(age);

            userService.addUser(addUserDTO);
            message = MESSAGE_USER_CREATED;
        } catch (NumberFormatException nfe) {
            logger.error(ERROR_DATA_IS_INCORRECT);
            message = MESSAGE_DATA_IS_INCORRECT;
        }

        try (PrintWriter out = resp.getWriter()) {
            out.println(HEAD_HTML + message + END_HTML);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
