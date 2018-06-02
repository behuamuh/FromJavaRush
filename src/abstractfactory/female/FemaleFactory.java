package abstractfactory.female;


import abstractfactory.AbstractFactory;
import abstractfactory.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        if (age <= KidGirl.MAX_AGE)
            return new KidGirl();
        if (age <= TeenGirl.MAX_AGE)
            return new TeenGirl();
        return new Woman();
    }
}
