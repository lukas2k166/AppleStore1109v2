package com.example.demo.auth;

import com.example.demo.security.config.ApplicationUserPermission;
import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.security.config.ApplicationUserPermission.ADD_PRODUCT;
import static com.example.demo.security.config.ApplicationUserPermission.SEE_PRODUCT;

public enum AppUserRole {

    CLIENT(Sets.newHashSet(SEE_PRODUCT)),
    ADMIN(Sets.newHashSet(SEE_PRODUCT,ADD_PRODUCT));

    private final Set<ApplicationUserPermission> permissions;

        AppUserRole(Set<ApplicationUserPermission> permissions) {
            this.permissions = permissions;
        }

        public Set<ApplicationUserPermission> getPermissions() {
            return permissions;
        }


}
