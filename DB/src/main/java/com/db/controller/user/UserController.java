package com.db.controller.user;

import com.db.core.CommonUtils;
import com.db.impl.UserServiceImpl;
import com.db.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.db.logger.Log;
import com.db.logger.Logger;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@WebServlet(name = "UserApi", urlPatterns = "/api/v1/user")
public class UserController extends HttpServlet {

    private final UserService userService;

    private static final Log log = Logger.getLogger(UserController.class);

    public UserController() {
        this.userService = new UserServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object> list;
        try (ExecutorService executorService = CommonUtils.getExecutorService()) {
            Future<List<Object>> future = executorService.submit(() -> {
                log.info("Received GET request for /api/v1/users");
                List<Object> users = userService.getUsers();
                resp.setContentType("application/json");
                return users;
            });
            list = future.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        CommonUtils.getMapper().writeValue(resp.getOutputStream(), list);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.addUser();
        resp.getWriter().write("User added successfully");
    }
}
