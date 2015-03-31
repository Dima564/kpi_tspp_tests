package core;

import model.Role;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kovalenkodima on 3/31/15.
 */
public class RoleRepository {

    public static RoleRepository INSTANCE;

    // TODO use dao
    private Map<String, Role> rolesDB = new HashMap<>();

    private RoleRepository() {}

    public static RoleRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (RoleRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RoleRepository();
                }
            }
        }
        return INSTANCE;
    }


    public Role create(Role role) {
        rolesDB.put(role.getName(), role.clone());
        return role;
    };

    public Role get(String name) {
        return rolesDB.get(name);
    }

    public Collection<Role> getAll() {
        return rolesDB.values();
    }

    public Role update(Role role) {
        rolesDB.put(role.getName(), role.clone());
        return role;
    }


}
