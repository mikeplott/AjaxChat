package com.company;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by michaelplott on 10/17/16.
 */
public class MainTest {

    public Connection startConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Main.createTables(conn);
        return conn;
    }

    @Test
    public void testInsertMessagesAndUsers() throws SQLException {
        Connection conn = startConnection();
        Main.insertUser(conn, "Mike");
        User user = Main.selectUser(conn, "Mike");
        assertTrue(user != null);
        assertTrue(user.name.equals("Mike"));
        Main.insertMessage(conn, "hello", user.id);
        Main.insertMessage(conn, "Sup", user.id);
        ArrayList<Message> msgs = Main.selectMessages(conn);
        conn.close();
        assertTrue(msgs.size() == 2);
    }

}