import core.CryptoService;
import core.UserRepository;
import model.User;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

//        System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");

        User user = new User("Dima", "kovalenkodimag@gmail.com", CryptoService.hashpw("passwd", CryptoService.gensalt()),"Are you ok?", "Yes");
        UserRepository repository = UserRepository.getInstance();
        repository.create(user);
        repository.get("shit");
        repository.get("kovalenkodimag@gmail.com");

    }
}
