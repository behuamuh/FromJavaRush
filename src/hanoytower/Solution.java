package hanoytower;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char a, char b, char c, int count) {
        if (count == 1){
            System.out.println("from " + a + " to " + b);
            return;
        }
        moveRing(a, c, b, count - 1);
        moveRing(a,b,c,1);
        moveRing(c,b,a, count - 1);
    }
}
    /*  Перекладывание стека из 5 дисков — это:
        1. Перекладывание стека из 4х дисков на независимую ось
        2. Перекладывание 5-го диска на нужную нам ось
        3. Перекладывание стека из 4х дисков на нужную нам ось

        В свою очередь перекладывание стека из 4 дисков — это:
        1. Перекладывание стека из 3х дисков на независимую ось
        2. Перекладывание 4-го диска на нужную нам ось
        3. Перекладывание стека из 3х дисков на нужную нам ось*/