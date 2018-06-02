package abstractfactory.female;


import abstractfactory.Human;

public class KidGirl implements Human {
    public static final int MAX_AGE = 12;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
