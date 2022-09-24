package com.example.demo.authorization;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.authorization.ApplicationUserPermission.ADD_PRODUCT;
import static com.example.demo.authorization.ApplicationUserPermission.SEE_PRODUCT;

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
