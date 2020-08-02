import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SuperFarmerTest {


    @Test
    public void testUserRabbitRabbitUser() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.RABBIT;
        Animal blue = Animal.RABBIT;
        ArrayList<Animal> animaList = new ArrayList<>();
        boolean smalldog = false;
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, false,false)).size();
        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testUserRabbitFoxUser() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.RABBIT;
        Animal blue = Animal.FOX;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        boolean smalldog = false;

        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, false, false)).size();
        //Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void testUserRabbitWolfBlueUser() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.RABBIT;
        Animal blue = Animal.WOLF;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.PIG);
        boolean smalldog = false;
        boolean bigDog = false;
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, smalldog,bigDog)).size();
        //Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void testUserRabbitWolfOrangeUser() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal blue = Animal.RABBIT;
        Animal orange = Animal.WOLF;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.PIG);
        boolean smalldog = false;
        boolean bigDog = false;
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, smalldog,bigDog)).size();
        //Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void checkAnimalsInCollectionUser() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();

        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.PIG);
        animaList.add(Animal.SHEEP);
        animaList.add(Animal.COW);
        animaList.add(Animal.HORSE);
        //When
        boolean result = (userAnimalList.checkAnimalsInCollection(animaList));
        //Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void checkAnimalsInCollectionComputer() {
        //Given
        ComputerAnimalList computerAnimalList = new ComputerAnimalList();

        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.PIG);
        animaList.add(Animal.SHEEP);
        animaList.add(Animal.COW);
        animaList.add(Animal.HORSE);
        //When
        boolean result = (computerAnimalList.checkAnimalsInCollection(animaList));
        //Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void greedingRabbitRabbitComputer() {
        //Given
        ComputerAnimalList computerAnimalList = new ComputerAnimalList();
        Animal orange = Animal.RABBIT;
        Animal blue = Animal.RABBIT;
        ArrayList<Animal> animaList = new ArrayList<>();
        //When
        int result = (computerAnimalList.greedingComputer(animaList, orange, blue)).size();
        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testRabbitWolfBlueComputer() {
        //Given
        ComputerAnimalList computerAnimalList = new ComputerAnimalList();
        Animal orange = Animal.RABBIT;
        Animal blue = Animal.WOLF;
        ArrayList<Animal> animaList = new ArrayList<>();
        //animaList.add(Animal.RABBIT);
        //animaList.add(Animal.RABBIT);
        animaList.add(Animal.PIG);
        boolean smalldog = false;

        //When
        int result = (computerAnimalList.greedingComputer(animaList, orange, blue)).size();
        //Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void smallDogTrue() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.PIG;
        Animal blue = Animal.FOX;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        boolean bigDog = false;
        boolean smalldog = true;
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, smalldog, bigDog).size());
        //Then
        Assert.assertEquals(6, result);
    }
    @Test
    public void smallDogFalse() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.PIG;
        Animal blue = Animal.FOX;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        boolean smalldog = false;
        boolean bigDog = false;
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, smalldog, bigDog).size());
        //Then
        Assert.assertEquals(0, result);
    }
    @Test
    public void bigDogFalse() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.PIG;
        Animal blue = Animal.WOLF;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        boolean smalldog = false;
        boolean bigDog = false;
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, smalldog, bigDog).size());
        //Then
        Assert.assertEquals(0, result);
    }
    @Test
    public void bigDogTrue() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.PIG;
        Animal blue = Animal.WOLF;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.HORSE);
        boolean smalldog = false;
        boolean bigDog = true;
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue, smalldog, bigDog).size());
        //Then
        Assert.assertEquals(7, result);
    }
}
