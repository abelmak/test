package com.ntu.dip2020;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;

import static java.security.AccessController.getContext;

public class CloudFirestore implements CloudStoreInterface{
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseInterface firebase = new Firebase();
    private Boolean result;

    public void addNewUser(User newUser){
        String address = firebase.getUserEmail();
        newUser.setEmail(address);

        Map<String, Object> m = newUser.toMap();

        DocumentReference newUserRef = db.collection("User").document(address);
        newUserRef.set(m);
        Log.d("email", address);

    }

    public User getUser(String address){
        DocumentReference newUserRef = db.collection("Users").document(address);
        newUserRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                documentSnapshot.getData();

                User user = documentSnapshot.toObject(User.class);
            }
        });

        return null;
    }

    public Boolean checkCreateProfile(){
        DocumentReference docIdRef = db.collection("User").document(firebase.getUserEmail());
        docIdRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    result = document.exists();
                } else { result = false; }
            }
        });
        return result;
    }

}