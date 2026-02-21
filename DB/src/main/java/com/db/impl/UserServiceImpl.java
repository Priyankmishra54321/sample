package com.db.impl;

import com.db.connection.QueryTemplate;
import com.db.core.CommonUtils;
import com.db.logger.Log;
import com.db.logger.Logger;
import com.db.service.UserService;
import org.slf4j.LoggerFactory;

import java.util.*;

public class UserServiceImpl implements UserService {
    private static final Log log = Logger.getLogger(UserServiceImpl.class);

    @Override
    public List<Object> getUsers() {

        List<Object> list1 = QueryTemplate.getUsers();
        log.info("List size: {}", list1.size());
        if (!list1.isEmpty()) {
            return list1;
        } else {
            return new LinkedList<>();
        }
    }

    @Override
    public void addUser() {
        try {
            for (int i = 0; i <= 10001; i++) {
                String name = "User" + i;
                if (QueryTemplate.getUserByName(name) != null) {
                    log.info("User{} already exists, skipping addition.", name);
                    continue;
                }
                QueryTemplate.addUser("User" + i, UUID.randomUUID().toString());
            }
        } catch (Exception e) {
            log.error("Error adding users: ", e);

        }
    }
}
