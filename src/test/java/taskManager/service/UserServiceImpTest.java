package taskManager.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.Test;
import taskManager.domain.User;
import taskManager.repository.UserRepository;
import taskManager.util.UserFixture;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {

    @InjectMocks
    private UserServiceImp service;

    @Mock
    private UserRepository repository;

    @Test
    public void saveUser() throws Exception {
        // GIVEN
        User user = UserFixture.createUser();
        when(repository.saveUser(any(User.class))).thenReturn(true);

        // WHEN
        service.saveUser(user);

        // THEN
        verify(repository).saveUser(user);
    }

    @Test
    void testGetUserInRepo() throws Exception {
        // GIVEN
        User user = UserFixture.createUser();
        when(repository.getUser(0)).thenReturn(Optional.of(user));

        // WHEN
        User userFromRepo = service.getUser(0);

        // THEN
        assertThat(userFromRepo).isEqualTo(user);
        verify(repository).getUser(0);
    }

    @Test
    void testGetProductNoProductInRepo() throws Exception {
        // GIVEN
        User user = UserFixture.createUser();

        // WHEN
        User userFromRepo = service.getUser(0);

        // THEN
        assertThat(userFromRepo).isNotEqualTo(user);
        assertThat(userFromRepo.getId()).isZero();
        verify(repository).getUser(0);
    }

}
