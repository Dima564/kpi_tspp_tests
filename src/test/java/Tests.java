import core.UserRepository;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

// TODO create test suits
@RunWith(MockitoJUnitRunner.class)
public class Tests {

    @Mock
    private UserRepository repository;

    @Before
    public void setup() throws SQLException {
        Mockito.when(repository.get("email")).thenReturn(new User());
    }

    @Test
    public void testSomething() throws SQLException {
        assertNotNull(repository.get("email"));

    }



}