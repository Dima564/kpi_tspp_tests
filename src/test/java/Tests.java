import core.CryptoService;
import core.UserRepository;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

// TODO create test suits
@RunWith(MockitoJUnitRunner.class)
public class Tests {

    private UserRepository repository;
    private boolean didSetup = false;

    @Mock
    CryptoService cryptoService;


    private void initialSetup() throws SQLException {
        repository = UserRepository.getInstance();
        Mockito.when(cryptoService.hashpw(any(String.class), any(String.class))).thenReturn("dummyHash");


    }

    @Before
    public void setup() throws SQLException {
        if (!didSetup) {
            initialSetup();
            didSetup = true;
        }

        repository.deleteAll();

    }

    @Test
    public void testUserSaved() throws SQLException {
        User user = new User("Dima Kovalenko", "kovalenkodimag@gmail.com", cryptoService.hashpw("passwd", cryptoService.gensalt()), "Are you OK?", "Yes");

        long count = repository.count();
        repository.create(user);
        assertEquals(count + 1, repository.count());

        assertEquals(user, repository.get(user.getId()));
        assertEquals(user, repository.getByEmail(user.getEmail()));
        assertEquals(user, repository.getByName(user.getName()));

    }

    @Test(expected = SQLException.class)
    public void testCannotAddTwoSameEmails() throws SQLException {
        User user = new User("Dima Kovalenko", "kovalenkodimag@gmail.com", cryptoService.hashpw("passwd", cryptoService.gensalt()), "Are you OK?", "Yes");
        User user2 = new User("Andriy Bas", "kovalenkodimag@gmail.com", cryptoService.hashpw("passwd", cryptoService.gensalt()), "Are you OK?", "Yes");

        repository.save(user);
        repository.save(user2);

    }


}