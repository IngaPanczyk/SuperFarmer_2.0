import java.util.ArrayList;
import java.util.Collections;

public class UserAnimalList {
    public boolean checkAnimalsInCollection(ArrayList userListAfterGreeding) {
        if (userListAfterGreeding.contains(Animal.RABBIT)) {

        }
        if (userListAfterGreeding.contains(Animal.SHEEP)) {

        }
        if (userListAfterGreeding.contains(Animal.PIG)) {

        }
        if (userListAfterGreeding.contains(Animal.COW)) {

        }
        if (userListAfterGreeding.contains(Animal.HORSE)) {
            return true;
        } else {
        }
        return false;
    }

    public ArrayList greedingUser(ArrayList userAnimalList, Animal orange, Animal blue) {

        System.out.println("User move: " + orange + " " + blue);

        int qantityOfPig = Collections.frequency(userAnimalList, Animal.PIG);
        if (orange == Animal.PIG) {
            for (int n = 0; n < (qantityOfPig + 1) / 2; n++) {
                userAnimalList.add(Animal.PIG);
                System.out.println("User +" + orange);
                userAnimalList.size();
            }
        } else if (blue == Animal.PIG) {
            for (int n = 0; n < (qantityOfPig + 1) / 2; n++) {
                userAnimalList.add(Animal.PIG);
                System.out.println("User +" + blue);
                userAnimalList.size();
            }
        }
        int qantityOfRabbit = Collections.frequency(userAnimalList, Animal.RABBIT);
        ;
        if (orange == Animal.RABBIT) {
            for (int n = 0; n < (qantityOfRabbit + 1) / 2; n++) {
                userAnimalList.add(Animal.RABBIT);
                System.out.println("User + " + orange);
                userAnimalList.size();
            }
        } else if (blue == Animal.RABBIT) {
            for (int n = 0; n < (qantityOfRabbit + 1) / 2; n++) {
                userAnimalList.add(Animal.RABBIT);
                System.out.println("User + " + blue);
                userAnimalList.size();
            }
        }
        int qantityOfSheep = Collections.frequency(userAnimalList, Animal.SHEEP);
        if (orange == Animal.SHEEP) {
            for (int n = 0; n < (qantityOfSheep + 1) / 2; n++) {
                userAnimalList.add(Animal.SHEEP);
                System.out.println("User + " + orange);
                userAnimalList.size();
            }
        } else if (blue == Animal.SHEEP) {
            for (int n = 0; n < (qantityOfSheep + 1) / 2; n++) {
                userAnimalList.add(Animal.SHEEP);
                System.out.println("User + " + blue);
                userAnimalList.size();
            }
        }
        int qantityOfCow = Collections.frequency(userAnimalList, Animal.COW);
        if (orange == Animal.COW) {
            for (int n = 0; n < (qantityOfCow + 1) / 2; n++) {
                userAnimalList.add(Animal.COW);
                System.out.println("User + " + orange);
                userAnimalList.size();
            }
        } else if (blue == Animal.COW) {
            for (int n = 0; n < (qantityOfCow + 1) / 2; n++) {
                userAnimalList.add(Animal.COW);
                System.out.println("User + " + blue);
                userAnimalList.size();
            }
        }
        int qantityOfHorse = Collections.frequency(userAnimalList, Animal.HORSE);
        if (orange == Animal.HORSE) {
            for (int n = 0; n < (qantityOfHorse + 1) / 2; n++) {
                userAnimalList.add(Animal.HORSE);
                System.out.println("User + " + orange);
                userAnimalList.size();
            }
        } else if (blue == Animal.HORSE) {
            for (int n = 0; n < (qantityOfHorse + 1) / 2; n++) {
                userAnimalList.add(Animal.HORSE);
                System.out.println("User + " + blue);
                userAnimalList.size();
            }
        }
        if (blue == Animal.WOLF) {

            userAnimalList.removeAll(userAnimalList);

            if (Collections.frequency(userAnimalList, Animal.RABBIT) > 0) {
                userAnimalList.add(Animal.RABBIT);
            }
        }
        if (orange == Animal.WOLF) {
            userAnimalList.removeAll(userAnimalList);
            for (int n = 0; n < userAnimalList.size(); n++) {
                userAnimalList.remove(n);
            }
            if (Collections.frequency(userAnimalList, Animal.RABBIT) > 0) {
                userAnimalList.add(Animal.RABBIT);
            }
        }
        if (blue == Animal.FOX) {
            for (int n = 0; n < qantityOfRabbit; n++) {
                userAnimalList.remove(Animal.RABBIT);
            }
        } else if (orange == Animal.FOX) {
            for (int n = 0; n < qantityOfRabbit; n++) {
                userAnimalList.remove(Animal.RABBIT);
            }
        }
        if (orange == blue) {
            userAnimalList.add(orange);
            System.out.println("User +" + orange);
        }
        return userAnimalList;
    }
    public ArrayList getlist() {
        ArrayList userList = new ArrayList();
        return userList;
    }

}
