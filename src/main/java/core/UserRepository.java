package core;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kovalenkodima on 3/31/15.
 */
public class UserRepository {

    private final static String DATABASE_URL = "jdbc:h2:mem:account";

    private static UserRepository INSTANCE;

    private Dao<User, String> dao;


    private UserRepository() throws SQLException {
        ConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);
        dao = DaoManager.createDao(connectionSource, User.class);
        TableUtils.createTable(connectionSource, User.class);
    }


    public static UserRepository getInstance() throws SQLException {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }
        return INSTANCE;
    }

    public void create(User user) throws SQLException {
        dao.create(user);
    }

    public User getByEmail(String email) throws SQLException {
        QueryBuilder<User, String> qb = dao.queryBuilder();
        qb.setWhere(qb.where().eq("email", email));
        return qb.queryForFirst();
    }

    public User getByName(String name) throws SQLException {
        QueryBuilder<User, String> qb = dao.queryBuilder();
        qb.setWhere(qb.where().eq("name", name));
        return qb.queryForFirst();
    }

    public User get(String id) throws SQLException {
        return dao.queryForId(id);
    }

    public List<User> getUsersPage(Long page, Long perPage) throws SQLException {
        return dao.queryBuilder().offset(page * perPage).limit(perPage).query();
    }

    public List<User> getAllWithOffset(Long offset, Long count) throws SQLException {
        return dao.queryBuilder().offset(offset).limit(count).query();
    }

    public void update(User user) throws SQLException {
        dao.update(user);
    }

    public void save(User user) throws SQLException {
        dao.createOrUpdate(user);
    }

    public List<User> getAll() throws SQLException {
        return dao.queryForAll();
    }

    public long count() throws SQLException {
        return dao.countOf();
    }


    public void deleteAll() throws SQLException {
        TableUtils.clearTable(new JdbcConnectionSource(DATABASE_URL), User.class);
    }
}
