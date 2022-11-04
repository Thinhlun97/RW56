package com.vti.entiy.entity;

import java.time.LocalDate;

public class Group {
    public int groupId;
    public String groupName;
    public Account creator;
    public LocalDate createDate;
    public Account[] accounts;


}
