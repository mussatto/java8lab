package lab.j8;

public interface DefaultMethodI {

//    private String name="something"; NOT ALLOWED
    default void myDefaultMethod(String name){
        System.out.println("Default is to say hi!");
        sayHi(name);
    }

    void sayHi(String name);
}
