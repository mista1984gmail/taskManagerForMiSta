package taskManager.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import taskManager.db.BD;
import taskManager.domain.User;
import taskManager.util.UserFixture;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class UserRepositoryImpTest {
    private UserRepositoryImp userRepository = new UserRepositoryImp();

    @BeforeAll
    public void setUp() {
        log.info("Test for 'UserRepositoryImpl' are started.");
    }

    @AfterAll
    public void tearDown() {
        log.info("Test for 'UserRepositoryImpl' are finished.");
    }

    @Test
    public void testSaveUser() throws Exception {
        // GIVEN
        User user = UserFixture.createUser();

        // WHEN
        boolean isUserSaved = userRepository.saveUser(user);

        // THEN
        assertThat(isUserSaved).isTrue();
        User userFromDB = BD.getInstance().executeGetOperation(0)
                .orElseThrow(RuntimeException::new);
        User userForAssert = UserFixture.createUser();
        assertThat(userForAssert).usingRecursiveComparison().ignoringFields("id")
                .isEqualTo(userForAssert);
    }

    @Test
    public void  testGetUser() throws Exception {
        // GIVEN
        User user = UserFixture.createUser();
        BD.getInstance().executeSaveOperation(user);

        // WHEN
        Optional<User> userFromRepo = userRepository.getUser(0);

        // THEN
        assertThat(userFromRepo).contains(user);

    }

    @Test
    public void testGetUsers() throws Exception {
        // GIVEN
        int expectedSize = 3;
        for (int i = 0; i < expectedSize; i++) {
            User user = UserFixture.createUser();
            BD.getInstance().executeSaveOperation(user);
        }

        // WHEN
        List<User> users;
        users = userRepository.getUsers();

        // THEN
        assertThat(users).hasSize(expectedSize).doesNotContainNull();

    }

    @Test
    public void testDeleteUser(){

    }

    @Test
    public void testTasks(){

    }

}
