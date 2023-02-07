package com.vti.shoppe.Modal.Request;

import com.vti.shoppe.Modal.Entity.Role;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class CreateAccountRequest {
    @NotBlank(message = "Tên không được để trống")
    private String username;

    private Role role;

    @NotBlank(message = "Pass không được để trống")
    private String password;

    private Date dateOfBirth;

    private String address;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String facebook;

    private String information;
}
