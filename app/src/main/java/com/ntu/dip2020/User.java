package com.ntu.dip2020;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String email;
    private String school;
    private String admissionYear;

    public User(String school, String admissionYear) {
        this.school = school;
        this.admissionYear = admissionYear;
    }

    public String getEmail() {
        return email;
    }

    public String getSchool() {
        return school;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> m = new HashMap<>();
        m.put("email", email);
        m.put("school", school);
        m.put("admissionYear", admissionYear);
        return m;
    }

    public void setFromMap(Map m){
        setEmail((String) m.get("email"));
        setSchool((String) m.get("school"));
        setAdmissionYear((String) m.get("admissionYear"));
    }
}
