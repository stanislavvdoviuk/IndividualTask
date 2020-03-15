package test_suits;
import models.Person;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class PersonTest {

    @Test(description = "Verifying if getAge return correct result.")
    public void testingGetAge() throws ParseException {
        //arrange
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Person person = new Person("454891818", "Nazar", "Besen", formater.parse("01-03-1997"));
        int testAge=23;

        //act
        int age = person.getAge();

        //assert
        AssertJUnit.assertEquals(testAge, age);
    }

    @Test(description = "Testing method ToString")
    public void testingToString() throws ParseException {
        //arrange
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Person person = new Person("454891818", "Nazar", "Besen", formater.parse("01-03-1997"));
        String testingData="Nazar Besen 454891818";

        //act
        String personDescription = person.toString();

        //assert
        AssertJUnit.assertEquals(testingData, personDescription);
    }
}
