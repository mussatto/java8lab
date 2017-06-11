package lab.j8;

public class DefaultMethodSample implements DefaultMethodI {
    @Override
    public void sayHi(String name) {
        System.out.println("Hello "+name);
    }
}
