package com.vti.shoppe.Service;

import com.vti.shoppe.Modal.Entity.Account;
import com.vti.shoppe.Modal.Request.CreateAccountRequest;
import com.vti.shoppe.Modal.Request.UpdateAccountRequest;

import java.util.List;

public interface IAccountService {
    List<Account> getAllA();

    Account getAById(int id);

    void createA(CreateAccountRequest request);

    Account updateA(int id, UpdateAccountRequest request);

    void delete(int id);
}
