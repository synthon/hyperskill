import java.io.Serializable;

class User {
    private static final long serialVersionUID = 2L;
    String name;
    transient String password;
}
