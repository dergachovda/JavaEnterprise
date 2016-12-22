package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.
                getConnection(
                        "jdbc:h2:file:E:\\java\\JavaEnterprise\\less12\\src\\main\\resources\\user_db",
                        "sa",
                        "sa"
                );

        JdbcTest jdbcTest = new JdbcTest();
//        jdbcTest.createTable(connection);
//        jdbcTest.insertRecords(connection);
//        jdbcTest.dropTable(connection);

        jdbcTest.savePointExample(connection);
    }

    private void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE user" +
                "(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(25) NOT NULL)");
    }

    private void dropTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP TABLE user");
    }

    private void insertRecords(Connection connection) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO user(name) VALUES(?)");
        for (int i = 0; i < 10; i++) {
            preparedStatement.setString(1, "name" + i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }

    private void savePointExample(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        String insertSQL = "INSERT INTO user(name) VALUES('xxx')";
        String selectSQL = "SELECT * FROM user";

        Savepoint savepoint = connection.setSavepoint("sp1");

        Statement statement = connection.createStatement();
        statement.executeUpdate(insertSQL);

        selectFromTable(selectSQL, statement);

        connection.rollback(savepoint);

        System.out.println("---> connection.rollback(savepoint);");
        selectFromTable(selectSQL, statement);

        connection.setAutoCommit(true);
    }

    private ResultSet selectFromTable(String selectSQL, Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(selectSQL);
        while (resultSet.next()) {
            System.out.println("---> " + resultSet.getString("name"));
        }
        return resultSet;
    }

}
