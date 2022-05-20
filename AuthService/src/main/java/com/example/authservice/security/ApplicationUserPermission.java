package com.example.authservice.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    STUDENT_DELETE("student:delete"),
    STUDENT_UPDATE("student:update");
//    ,
//    COURSE_READ("course:read"),
//    COURSE_WRITE("course:write"),
//    COURSE_DELETE("course:delete"),
//    COURSE_UPDATE("course:update");



    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
