package abstractfactory.male;


import abstractfactory.AbstractFactory;
import abstractfactory.Human;

public class MaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        if (age <= KidBoy.MAX_AGE)
            return new KidBoy();
        if (age <= TeenBoy.MAX_AGE)
            return new TeenBoy();
        return new Man();
    }
}
