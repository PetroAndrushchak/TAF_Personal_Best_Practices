package decorator.example1;

public class CancelButtonDecorator extends LoginDecorator {
    public CancelButtonDecorator(LoginComponent loginComponent) {
        super(loginComponent);
    }
    public void cancel() {
        System.out.println("Click the cancel button");
    }
}