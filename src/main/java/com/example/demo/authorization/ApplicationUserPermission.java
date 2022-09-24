package com.example.demo.authorization;

public enum ApplicationUserPermission {

    SEE_PRODUCT("see:product"),
    ADD_PRODUCT("add:product");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}