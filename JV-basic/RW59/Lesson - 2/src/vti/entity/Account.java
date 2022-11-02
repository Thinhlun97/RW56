package vti.entity;

import java.time.LocalDate;
import java.util.Arrays;


public class Account {
    public  int accountId;
    public  String email;
    public  String username;
    public  String fullname;
    public  Department department;
    public  Position position;
    public  LocalDate createDate;
    public  Group[] groups;

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
