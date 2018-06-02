package abstractfactory.female;


import abstractfactory.Human;

public class Woman implements Human {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
