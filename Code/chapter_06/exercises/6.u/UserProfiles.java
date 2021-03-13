package com.claudiodesio.authentication;

public class UserProfiles {

    private static UserProfiles instance;

    private User[] users;

    private UserProfiles() {
        users = createUsers();
    }

    public static UserProfiles getInstance() {
        if (instance == null) {
            instance = new UserProfiles();
        }
        return instance;
    }

    private User[] createUsers() {
        User[] users = {
            new User("Daniele", "dansap", "music"),
            new User("Giovanni", "giobat", "science"),
            new User("Ligeia", "ligder", "art")
        };
        return users;
    }

    public void setUsers(User[] users) {
        this.setUsers(users);
    }

    public User[] getUsers() {
        return users;
    }

}