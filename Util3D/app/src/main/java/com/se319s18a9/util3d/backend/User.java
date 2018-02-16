package com.se319s18a9.util3d.backend;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

/**
 * Created by Mason on 2/14/2018.
 */

public class User {
    private static final User instance = new User();
    private FirebaseAuth mAuth;

    private User() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static User getInstance(){
        return instance;
    }

    public boolean isAlreadyLoggedIn(){
        return mAuth.getCurrentUser() != null;
    }

    //TODO: If user is already logged in, decide how to handle this request
    public boolean validateAndLogin(String username, String password) {
        if(isAlreadyLoggedIn())
        {
            return true;
        }
        else {
            Task<AuthResult> loginTask = mAuth.signInWithEmailAndPassword(username, password);
            while (!loginTask.isComplete()) ;
            return loginTask.isSuccessful();
        }
    }

    public void sendPasswordResetEmail(String email){
        mAuth.sendPasswordResetEmail(email);
    }

    //TODO: add display name registration
    public boolean createAccount(String email, String password){
        Task<AuthResult> createTask = mAuth.createUserWithEmailAndPassword(email, password);
        while(!createTask.isComplete());
        return createTask.isSuccessful();
    }

    public boolean changeEmail(String email){
        if (isAlreadyLoggedIn())
        {
            Task changeTask = mAuth.getCurrentUser().updateEmail(email);
            while(!changeTask.isComplete());
            return changeTask.isSuccessful();
        }
        else {
            return false;
        }
    }

    public boolean changeDisplayName(String displayName) {
        if (isAlreadyLoggedIn()) {
            UserProfileChangeRequest.Builder change = new UserProfileChangeRequest.Builder();
            Task changeTask = mAuth.getCurrentUser().updateProfile(change.setDisplayName(displayName).build());
            while (!changeTask.isComplete());
            return changeTask.isSuccessful();
        } else {
            return false;
        }
    }

    public boolean changePassword(String password){
        if (isAlreadyLoggedIn())
        {
            Task changeTask = mAuth.getCurrentUser().updatePassword(password);
            while(!changeTask.isComplete());
            return changeTask.isSuccessful();
        }
        else {
            return false;
        }
    }

    public void signOut() {
        mAuth.signOut();
    }

    public String getDisplayName(){
        return isAlreadyLoggedIn() ? mAuth.getCurrentUser().getDisplayName() : "";
    }

    public String getEmail(){
        return isAlreadyLoggedIn() ? mAuth.getCurrentUser().getEmail() : "";
    }
}