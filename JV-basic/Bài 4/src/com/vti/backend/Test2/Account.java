package com.vti.backend.Test2;

import java.time.LocalDate;

public class Account {
        public int id;
        public String email;
        public String userName;
        public String firstName;
        public String lastName;
        public String position;
        public LocalDate createDate;


        public Account(){
            id = 0;
            email = "không có email";
            userName = "không có userName";
            firstName = "không có firstName";
            lastName = "không có lastName";
        }

        public Account(int id, String email, String userName, String firstName, String lastName){
            this.id = id;
            this.email = email;
            this.userName = userName;
            this.firstName = firstName;
            this.lastName = lastName;
        }


        public Account(int cid, String cemail, String cuserName, String cfirstName,
                       String clastName, String position ){
            this.id = cid;
            this.email = cemail;
            this.userName = cuserName;
            this.firstName = cfirstName;
            this.lastName = clastName;
            this.position = position;
            this.createDate = LocalDate.now();
        }

        void showInfoAc(){
            System.out.println("thông tin của account này là: ");
            System.out.println("id :" + id);
            System.out.println("email :" + email);
            System.out.println("userName :" + userName);
            System.out.println("firstName :" + firstName);
            System.out.println("lastName :" + lastName);
            System.out.println("fullName :" + firstName + lastName);
            System.out.println("position :" + position);
            System.out.println("createDate :" + createDate);
        }



}
