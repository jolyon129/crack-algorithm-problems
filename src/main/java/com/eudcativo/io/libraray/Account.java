package com.eudcativo.io.libraray;

import com.eudcativo.io.libraray.Constants.AccountStatus;

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public boolean resetPassword();
}