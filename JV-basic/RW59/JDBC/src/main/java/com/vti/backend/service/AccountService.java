package com.vti.backend.service;

import com.vti.backend.repository.AccountRepository;
import com.vti.entity.Account;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class AccountService implements IAccountService {
    AccountRepository repository = new AccountRepository();

    @Override
    public List<Account> getAllAccount() throws SQLException, ClassNotFoundException, FileNotFoundException {
        return repository.getAllAccount();
    }

    @Override
    public Account findById(int id) throws SQLException {
        return repository.findById(id);
    }

    @Override
    public void createAccount(Account account) {

    }

    @Override
    public Account findByName(String name) throws SQLException {
        return repository.findByName(name);
    }
}
