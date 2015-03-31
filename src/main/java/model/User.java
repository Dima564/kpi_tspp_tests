package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kovalenkodima on 3/31/15.
 */
@Data
@DatabaseTable(tableName = "users")
public class User implements Cloneable {
    @DatabaseField(id = true)
    private String id;

    @DatabaseField
    private String name;

    @DatabaseField
    private long createdAt;

    @DatabaseField
    private boolean isDeleted;

    @DatabaseField
    private String email;

    @DatabaseField
    private String hashedPassword;

    @DatabaseField
    private String passwordQuestion;

    @DatabaseField
    private String passwordAnswer;

    public User(String name, String email, String passwordHash, String passwordQuestion, String passwordAnswer) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.createdAt = new Date().getTime();
        this.hashedPassword = passwordHash;
        this.isDeleted = false;
        this.email = email;
        this.passwordQuestion = passwordQuestion;
        this.passwordAnswer = passwordAnswer;
    }

    public User() {
    }
}
