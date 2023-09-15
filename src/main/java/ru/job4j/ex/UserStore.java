package ru.job4j.ex;

import java.util.Objects;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User neededUser = null;
        for (User user : users) {
            if (Objects.equals(user.getUsername(), login)) {
                neededUser = user;
                break;
            }
        }
        if (neededUser == null) {
            throw new UserNotFoundException("user with login " + login + " is not found");
        }
        return neededUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() <= 3) {
            throw new UserInvalidException("" + user + " is invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Timur Khasmamedov", true),
                new User("Oleg Popov", true),
                new User("Petr Arsentev", false)
        };
        String login = "Oleg Popov";
        try {
            User user = findUser(users, login);
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}