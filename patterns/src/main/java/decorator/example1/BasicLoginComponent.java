package decorator.example1;

public class BasicLoginComponent implements LoginComponent {
    @Override
    public void login(String user, String password) {
        System.out.println("Basic login: " + user + ", " + password);
    }
}