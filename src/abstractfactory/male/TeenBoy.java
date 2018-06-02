package abstractfactory.male;


import abstractfactory.Human;

public class TeenBoy implements Human {
    public static final int MAX_AGE = 19;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
