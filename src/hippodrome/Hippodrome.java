package hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;
    public List<Horse> getHorses() {
        return horses;
    }
    public void move(){
        for (Horse h: horses
             ) {
            h.move();
        }
    }
    public void print(){
        for (Horse h: horses
             ) {
            h.print();
        }
        for (int i = 0; i < 10; i++)
            System.out.println();
    }
    public void run(){
        try {
            for (int i = 1; i <= 100; i++) {
                move();
                print();
                Thread.sleep(200);
            }
        }catch (InterruptedException ex){}
    }
    public Horse getWinner(){
        int indexWinner = 0;
        double max = 0.0;
        for (int i = 0; i < horses.size(); i++){
            if (horses.get(i).getDistance() > max){
                max = horses.get(i).getDistance();
                indexWinner = i;
            }
        }
        return horses.get(indexWinner);
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args){
        Hippodrome.game = new Hippodrome(new ArrayList<Horse>());
        for (int i = 0; i < 3; i++){
            Hippodrome.game.horses.add(new Horse("Horse" + (i+1), 3.0, 0.0));
        }
        List listHorse = game.getHorses();
        game.run();
        game.printWinner();

    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
}
