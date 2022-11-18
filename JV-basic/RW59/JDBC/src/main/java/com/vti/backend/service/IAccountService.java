package com.vti.backend.service;

import com.vti.entity.Account;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface IAccountService {

    List<Account> getAllAccount() throws SQLException, ClassNotFoundException, FileNotFoundException;

    Account findById(int id) throws SQLException;

    Account findByName(String name) throws SQLException;

    void createAccount(Account account);
}
