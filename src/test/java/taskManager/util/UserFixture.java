package taskManager.util;

import taskManager.domain.User;

public class UserFixture {
    private static final String NAME = "User #1";

    public static User createUser(){
        User user = new User();
        user.setNameUser(NAME);
        return user;
    }

}
