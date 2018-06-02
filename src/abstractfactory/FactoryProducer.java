package abstractfactory;


import abstractfactory.female.FemaleFactory;
import abstractfactory.male.MaleFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(HumanFactoryType type){
        if (HumanFactoryType.MALE == type)
            return new MaleFactory();
        if (HumanFactoryType.FEMALE == type)
            return new FemaleFactory();
        throw new IllegalArgumentException();
    }
    public static enum HumanFactoryType{
        MALE,
        FEMALE
    }
}
