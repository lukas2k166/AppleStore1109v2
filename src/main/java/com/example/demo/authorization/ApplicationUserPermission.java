package com.example.demo.authorization;

public enum ApplicationUserPermission {

    SEE_PRODUCT("see:product"),
    FIND_PRODUCT("find:product"),
    ADD_PRODUCT("add:product"),
    UPDATE_PRODUCT("update:product"),
    DELETE_PRODUCT("delete:product"),
    ADD_CATEGORY("add:category"),

    ADD_ORDER("add:order"),
    DELETE_ORDER("delete:order"),
    EDIT_ORDER("edit:order");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
