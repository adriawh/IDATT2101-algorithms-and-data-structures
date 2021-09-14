package Assignments.lists;

public class Josephus {

    public static void main(String[] args) {

        int numberOfPeople = 10;
        int interval = 4;

        System.out.println("*** The Josephus problem ***");
        System.out.println("Number of people: " + numberOfPeople +
                "\nInterval: " + interval +
                "\nSurvivor: number " + josephus(numberOfPeople,interval) );

    }

    /**
     * Method for solving the Josephus problem
     *
     * "People are standing in a circle waiting to be executed. Counting begins at a specified point
     * in the circle and proceeds around the circle in a specified direction. After a specified number
     * of people are skipped, the next person is executed. The procedure is repeated with the remaining
     * people, starting with the next person, going in the same direction and skipping the same number
     * of people, until only one person remains, and is freed." -wikipedia
     *
     * @param m number of people in line
     * @param n interval size
     * @return the placement that would survive.
     */
    private static int josephus(int m, int n){
        CircularList l = new CircularList();

        for(int i = 1; i<=m; i++){//generating a circular list with the specified count m
            l.addNode(i);
        }

        Node current = l.getHead();
        do{
            for(int i = 0; i<n-1; i++){//iterating to the next person to be executed based on the interval n
                current = current.getNext();
            }
            l.deleteNode(current.getValue());//executing the person
            current = current.getNext(); //iterating

        } while(l.getHead().getValue() != l.getTail().getValue());

        return l.getHead().getValue();
    }
}