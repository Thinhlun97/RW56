package com.vti.modal.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GroupAccountKey implements Serializable {
    @Column(name = "groupID", nullable = false)
    private int groupID;

    @Column(name = "accountID", nullable = false)
    private int accountID;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
