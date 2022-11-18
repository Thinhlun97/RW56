package com.vti.frontend;

import com.vti.backend.controller.AccountController;
import com.vti.entity.Account;
import com.vti.utils.ScannerUtils;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class Funtion {
    AccountController controller = new AccountController();

    public void getAllAccount() throws SQLException, ClassNotFoundException, FileNotFoundException {
        List<Account> accounts = controller.getAllAccount();
        if ((accounts.size() > 0)) {
            System.out.println(accounts);
        } else {
            System.out.println("Danh sách rỗng !!");
        }
    }

    public void getById() throws SQLException {
        System.out.println("Mời bạn nhập vào ID cần tìm kiếm!");
        int id = ScannerUtils.inputIntPositive();
        Account account = controller.findById(id);
        if (account == null) {
            System.out.println("Account không tồn tại");
        } else {
            System.out.println(account);
        }
    }

    public void getByname() throws SQLException {
        System.out.println("Mời bạn nhập vào name cần tìm kiếm");
        String name = ScannerUtils.inputString();
        Account account = controller.findByName(name);
        if (account == null) {
            System.out.println("Account không tồn tại");
        } else {
            System.out.println(account);
        }
    }
}
