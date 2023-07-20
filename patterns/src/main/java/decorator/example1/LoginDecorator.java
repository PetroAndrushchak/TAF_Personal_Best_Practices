package decorator.example1;

public abstract class LoginDecorator implements LoginComponent {

    private final LoginComponent loginComponent;

    public LoginDecorator(LoginComponent loginComponent) {
        this.loginComponent = loginComponent;
    }

    @Override
    public void login(String user, String password) {
        loginComponent.login(user, password);
    }
}