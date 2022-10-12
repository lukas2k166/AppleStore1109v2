package com.example.demo.authorization;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.authorization.ApplicationUserPermission.*;

public enum AppUserRole {

    CLIENT(Sets.newHashSet(SEE_PRODUCT,FIND_PRODUCT,ADD_ORDER,DELETE_ORDER)),
    ADMIN(Sets.newHashSet(
            SEE_PRODUCT, FIND_PRODUCT,
            ADD_PRODUCT, UPDATE_PRODUCT,
            DELETE_PRODUCT, ADD_CATEGORY,
            ADD_ORDER, DELETE_ORDER
            ));

    private final Set<ApplicationUserPermission> permissions;

        AppUserRole(Set<ApplicationUserPermission> permissions) {
            this.permissions = permissions;
        }

        public Set<ApplicationUserPermission> getPermissions() {
            return permissions;
        }


}
