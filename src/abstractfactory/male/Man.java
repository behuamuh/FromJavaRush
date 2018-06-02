package abstractfactory.male;


import abstractfactory.Human;

public class Man implements Human {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
