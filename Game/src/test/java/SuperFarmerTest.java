import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SuperFarmerTest {


    @Test
    public void testUserRabbitRabbit() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.RABBIT;
        Animal blue = Animal.RABBIT;
        ArrayList<Animal> animaList = new ArrayList<>();
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue)).size();
        //Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testUserRabbitFox() {
        //Given
        UserAnimalList userAnimalList = new UserAnimalList();
        Animal orange = Animal.RABBIT;
        Animal blue = Animal.FOX;
        ArrayList<Animal> animaList = new ArrayList<>();
        animaList.add(Animal.RABBIT);
        animaList.add(Animal.RABBIT);
        //When
        int result = (userAnimalList.greedingUser(animaList, orange, blue)).size();
        //Then
        Assert.assertEquals(0, result);
    }
}
