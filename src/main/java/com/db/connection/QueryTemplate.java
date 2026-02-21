package com.db.connection;

import com.db.dto.User;
import com.db.logger.Log;
import com.db.logger.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class QueryTemplate {

    private static final Log log = Logger.getLogger(QueryTemplate.class);


    private static void executeUpdate(PreparedStatement ps) {
        try (ps) {
            log.info("Executing prepared statement: {}", ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Failed to execute prepared statement", e);
            throw new RuntimeException(e);
        }
    }


    public static void addUser(String name, String randomId) throws SQLException {
        String query = "INSERT INTO sample.`User` (id, name, randomId) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, 0);                // or omit id if AUTO_INCREMENT
            ps.setString(2, name);
            ps.setString(3, randomId);      // or ps.setInt(...) based on type
            executeUpdate(ps);
        } catch (SQLException e) {
            log.error("Failed to add user: {}", e);
            throw e;
        }
    }

    public static List<Object> getUsers() {
        String query = "Select * from sample.`User` order by id desc";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {


            List<Object> users = new LinkedList<>();
            while (rs.next()) {
                var data = new User(rs.getInt("id"), rs.getString("name"), rs.getString("randomId"));
                users.add(data);
            }
//                log.info("Executed query to get users: {}", users);
            return users;

        } catch (SQLException e) {
            log.error("Failed to get users: {}", e);
            throw new RuntimeException(e);
        }
    }

    public static User getUserByName(String name) {
        String query = "SELECT id, name, randomId FROM sample.`User` WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            ps.setString(1, name);

            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("randomId"));
            }
            return null;
        } catch (SQLException e) {
            log.error("Failed to get user : {}", e);
            throw new RuntimeException(e);
        }
    }

}
