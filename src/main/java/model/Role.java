package model;

import java.util.Date;

/**
 * Created by kovalenkodima on 3/31/15.
 */
public class Role {

    // TODO dao
    private String name;
    private boolean isDeleted;
    private long createdAt;

    public Role(String name) {
        this.name = name;
        createdAt = new Date().getTime();
        isDeleted = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public Role clone(){
        Role role = new Role(name);
        role.isDeleted = isDeleted;
        role.createdAt = createdAt;
        return role;
    }
}
