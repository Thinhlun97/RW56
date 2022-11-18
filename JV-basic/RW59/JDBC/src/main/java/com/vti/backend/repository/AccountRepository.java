package com.vti.backend.repository;

import com.vti.entity.Account;
import com.vti.entity.Role;
import com.vti.utils.JDBCutils;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    public List<Account> getAllAccount() throws ClassNotFoundException, SQLException, FileNotFoundException {

        String sql = "SELECT * FROM jdbc.account";

        Statement statement = JDBCutils.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String username = resultSet.getString("username");
            String role = resultSet.getString("role");
            String lastname = resultSet.getString("last_name");
            String firstname = resultSet.getString("first_name");

            Account account = new Account();
            account.setId(id);
            account.setUsername(username);
            account.setRole(Role.valueOf(role));
            account.setFirstName(firstname);
            account.setLastName(lastname);
            accounts.add(account);

        }

        return accounts;
    }

    public Account findById(int id) throws SQLException {
        String sql = "Select * from JDBC.Account where id = ?";
        PreparedStatement prepareStatement = JDBCutils.getConnect().prepareStatement(sql);
        prepareStatement.setInt(1, id);
        ResultSet resultSet = prepareStatement.executeQuery();
        Account account = new Account();

        if (resultSet.next()) {
            account.setId(id);

            String username = resultSet.getString("username");
            account.setUsername(username);
            account.setFirstName(resultSet.getString("first_name"));
            account.setLastName(resultSet.getString("last_name"));
            String roleString = resultSet.getString("role");
            account.setRole(Role.valueOf(roleString));
        } else {
            return null;
        }

        return account;
    }

    public Account findByName(String name) throws SQLException {
        String sql = "Select * from JDBC.Account where username = ?";
        PreparedStatement prepareStatement = JDBCutils.getConnect().prepareStatement(sql);
        prepareStatement.setString(1, name);
        ResultSet resultSet = prepareStatement.executeQuery();
        Account account = new Account();

        if (resultSet.next()) {
            String username = resultSet.getString("username");
            account.setUsername(username);
            account.setFirstName(resultSet.getString("first_name"));
            account.setLastName(resultSet.getString("last_name"));
            String roleString = resultSet.getString("role");
            account.setRole(Role.valueOf(roleString));
        } else {
            return null;
        }

        return account;
    }
}
