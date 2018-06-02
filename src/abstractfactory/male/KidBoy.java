package abstractfactory.male;


import abstractfactory.Human;

public class KidBoy implements Human {
    public static final int MAX_AGE = 12;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
