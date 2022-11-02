package vti.backend;

import java.time.LocalDate;

public class Group {
    public Account[] accounts;
    public int groupId;
    String groupName;
    Account creator;
    LocalDate createDate;
}
