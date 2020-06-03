package com.ntu.dip2020;

public class User {

    private String matric;
    private String school;
    private String admissionYear;

    public User(String matric, String school, String admissionYear) {
        this.matric = matric;
        this.school = school;
        this.admissionYear = admissionYear;
    }

    public String getMatric() {
        return matric;
    }

    public String getSchool() {
        return school;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }
}
