package abstractfactory.female;

import abstractfactory.Human;

public class TeenGirl implements Human {
    public static final int MAX_AGE = 19;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
