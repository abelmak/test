package com.ntu.dip2020;

public interface CloudStoreInterface {

    public void addNewUser(User newUser);
    public User getUser(String email);
    public Boolean checkCreateProfile();

}
