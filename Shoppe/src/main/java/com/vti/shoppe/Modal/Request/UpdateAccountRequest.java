package com.vti.shoppe.Modal.Request;

import com.vti.shoppe.Modal.Entity.Role;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateAccountRequest {
    private Role role;

    private String password;

    private Date dateOfBirth;

    private String address;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String facebook;

    private String information;
}
