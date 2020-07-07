package com.ntu.dip2020;

public interface CloudStoreInterface {

    void addNewUser(User newUser);
    User getUser(String address);
    Boolean checkCreateProfile();

}
