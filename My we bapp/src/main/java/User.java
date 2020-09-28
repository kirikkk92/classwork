import java.util.ArrayList;

public class User {
    private String name;
    private static ArrayList<User> users = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void addUser(String name) {
        User user = new User(name);
        users.add(user);
    }

    public static String getNameUsers(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user.getName();
            }
            addUser(name);
        }
        return name;
    }
}
