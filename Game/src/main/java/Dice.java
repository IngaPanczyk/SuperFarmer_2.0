import java.util.Random;

public class Dice {
    Animal orange;
    Animal blue;

    public static Animal orangeDice() {
        Random randomBlue = new Random();
        int n = randomBlue.nextInt(13);
        if (n == 1) {
            return Animal.HORSE;
        } else if (n == 2) {
            return Animal.WOLF;
        } else if (n >= 3 && n <= 7) {
            return Animal.RABBIT;
        } else if (n >= 8 && n <= 10) {
            return Animal.SHEEP;
        } else {
            return Animal.PIG;
        }
    }

    public static Animal blueDice() {
        Random randomOrange = new Random();
        int z = randomOrange.nextInt(13);
        if (z == 1) {
            return Animal.COW;
        } else if (z == 2) {
            return Animal.FOX;
        } else if (z >= 3 && z <= 7) {
            return Animal.RABBIT;
        } else if (z >= 8 && z <= 10) {
            return Animal.SHEEP;
        } else {
            return Animal.PIG;
        }
    }

    public Animal blueDice1() {
        Random randomOrange = new Random();
        int z = randomOrange.nextInt(13);
        if (z == 1) {
            return Animal.COW;
        } else if (z > 1 && z < 4) {
            return Animal.FOX;
        } else if (z >= 5 && z <= 7) {
            return Animal.RABBIT;
        } else if (z >= 8 && z <= 10) {
            return Animal.SHEEP;
        } else {
            return Animal.PIG;
        }
    }

    public Animal orangeDice1() {
        Random randomBlue = new Random();
        int n = randomBlue.nextInt(13);
        if (n == 1) {
            return Animal.HORSE;
        } else if (n >= 2 && n <= 3) {
            return Animal.WOLF;
        } else if (n >= 4 && n <= 7) {
            return Animal.RABBIT;
        } else if (n >= 8 && n <= 10) {
            return Animal.SHEEP;
        } else {
            return Animal.PIG;
        }
    }

    public Animal orangeDicelevel(int level) {
        Dice dice = new Dice();
        if (level == 1) {
            orange = dice.orangeDice1();
        }
        if (level == 0) {
            orange = dice.orangeDice();
        }
        return orange;
    }

    public Animal blueDicelevel(int level) {
        Dice dice = new Dice();
        if (level == 1) {
            blue = dice.blueDice1();
        }
        if (level == 0) {
            blue = dice.blueDice();
        }
        return blue;
    }
}
