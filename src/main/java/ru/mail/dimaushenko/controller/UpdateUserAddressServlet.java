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

import ru.mail.dimaushenko.utils.PropertyUtil;
import ru.mail.dimaushenko.utils.impl.PropertyUtilConstantsImpl;
import ru.mail.dimaushenko.service.UserInformationService;
import ru.mail.dimaushenko.service.UserService;
import ru.mail.dimaushenko.service.impl.UserInformationServiceImpl;
import ru.mail.dimaushenko.service.impl.UserServiceImpl;
import ru.mail.dimaushenko.service.model.FullUserInformationDTO;

import static ru.mail.dimaushenko.constants.ErrorConstants.ERROR_DATA_IS_INCORRECT;
import static ru.mail.dimaushenko.constants.ErrorConstants.MESSAGE_DATA_IS_INCORRECT;
import static ru.mail.dimaushenko.constants.ErrorConstants.MESSAGE_USER_IS_NOT_FOUND;
import static ru.mail.dimaushenko.constants.HtmlPatterns.END_HTML;
import static ru.mail.dimaushenko.constants.HtmlPatterns.HEAD_HTML;
import static ru.mail.dimaushenko.constants.PropertyConstants.FORM_PARAMETER_ADDRESS;
import static ru.mail.dimaushenko.constants.PropertyConstants.FORM_PARAMETER_ID;

public class UpdateUserAddressServlet extends HttpServlet {

    private final PropertyUtil propertyUtil = PropertyUtilConstantsImpl.getInstance();
    private final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final UserInformationService userInformationService = UserInformationServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    private final String MESSAGE_USER_ADDRESS_IS_UPDATED = "<p>User Address id updated</p>";

    private final String MESSAGE_FAIL = "<p>FAIL</p>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message;

        String idStr = req.getParameter(propertyUtil.getProperty(FORM_PARAMETER_ID));
        String address = req.getParameter(propertyUtil.getProperty(FORM_PARAMETER_ADDRESS));

        try {
            Integer id = Integer.parseInt(idStr);

            FullUserInformationDTO fullUserInformation = new FullUserInformationDTO();
            fullUserInformation.setAddres(address);
            fullUserInformation.setUserId(id);

            boolean isUserFound = userService.isUserFoundById(id);
            if (isUserFound) {
                boolean isUserInformationUpdate = userInformationService.updateUserInformationAddress(fullUserInformation);
                if (isUserInformationUpdate) {
                    message = MESSAGE_USER_ADDRESS_IS_UPDATED;
                } else {
                    message = MESSAGE_FAIL;
                }
            } else {
                message = MESSAGE_USER_IS_NOT_FOUND;
                logger.error(MESSAGE_USER_IS_NOT_FOUND);
            }

        } catch (NumberFormatException nfe) {
            logger.error(ERROR_DATA_IS_INCORRECT);
            message = MESSAGE_DATA_IS_INCORRECT;
        }

        try (PrintWriter out = resp.getWriter()) {
            out.println(HEAD_HTML + message + END_HTML);
        }

    }

}
