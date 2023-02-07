package com.vti.shoppe.Controller;

import com.vti.shoppe.Exception.AppException;
import com.vti.shoppe.Modal.Entity.Account;
import com.vti.shoppe.Modal.Request.CreateAccountRequest;
import com.vti.shoppe.Modal.Request.UpdateAccountRequest;
import com.vti.shoppe.Service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/account")
@CrossOrigin("*")
@Validated
public class AccountController {
    @Autowired
    private AccountService service;

    @GetMapping("/get-all")
    public List<Account> getAllA(){
        return service.getAllA();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAById(@PathVariable int id){
            Account account = service.getAById(id);
            return ResponseEntity.status(HttpStatus.OK).body(account);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createA(@RequestBody @Valid CreateAccountRequest request){
            service.createA(request);
            return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping("/update/{id}")
    public Account updateA(@RequestBody UpdateAccountRequest request,@PathVariable int id){
        return service.updateA(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteA(@PathVariable int id){
        service.delete(id);
    }
}
