import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        int id=2;
        Optional<User> userOptional = findUserById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println("User with id "+user.getId()+ " found: " + user.getName());
        } else {
            System.out.println("User with id "+id+" not found.");
        }
    }

    public static Optional<User> findUserById(int id) {
        // Simulating database lookup
        if (id == 1) {
            return Optional.of(new User(1, "Alice"));
        } else {
            return Optional.empty();
        }
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
