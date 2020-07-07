package com.ntu.dip2020;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Firebase implements FirebaseInterface {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    String email = "";
        @Override
        public String getUserEmail() {
            if (user != null) {email = user.getEmail();}
            return email;
        }

}
