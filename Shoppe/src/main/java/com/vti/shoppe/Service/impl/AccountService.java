package com.vti.shoppe.Service.impl;

import com.vti.shoppe.Exception.AppException;
import com.vti.shoppe.Exception.ErrorResponseBase;
import com.vti.shoppe.Modal.Entity.Account;
import com.vti.shoppe.Modal.Request.CreateAccountRequest;
import com.vti.shoppe.Modal.Request.UpdateAccountRequest;
import com.vti.shoppe.Repository.AccountRepository;
import com.vti.shoppe.Service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository repository;


    @Override
    public List<Account> getAllA() {
        return repository.findAll();
    }

    @Override
    public Account getAById(int id) {
        Optional<Account> optional = repository.findById(id);
        if (optional.isEmpty()) {
             throw new AppException(ErrorResponseBase.NOT_FOUND);
        }
        try{
            return optional.get();
        } catch (Exception ex){
            //Dù có ngoại lệ nào xảy ra thì đều throw ra đối tượng AppException
            throw new AppException(ex);

        }

    }

    @Override
    public void createA(CreateAccountRequest request) {
        Account account = new Account();
        BeanUtils.copyProperties(request, account);
        //Kiểm tra username đã tồn tại chưa
        Optional<Account> accountCheck = repository.findByUsername(request.getUsername());
        if(accountCheck.isPresent()){
            // username đã tồn tại => bắn lỗi
            throw new AppException(ErrorResponseBase.USERNAME_EXITED);
        }

        try{
            repository.save(account);
        }catch (Exception ex){
            throw new AppException(ex);
        }

    }

    @Override
    public Account updateA(int id, UpdateAccountRequest request) {
        Account accountDb = getAById(id);
        if (accountDb != null) {
            BeanUtils.copyProperties(request, accountDb);

            accountDb.setId(id);
            repository.save(accountDb);
        }
        return null;
    }



    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
