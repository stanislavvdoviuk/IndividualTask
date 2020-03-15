package test_suits;

import models.SerializationUtils;
import models.Student;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DeserializerTest {
    @Test
    public void testSerialization() throws ParseException, FileNotFoundException {
        //arrange
        String filename="FileTest.xml";
        SerializationUtils serializor = new SerializationUtils();
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        Student student = new Student("454891818","Nazar","Besen", formater.parse("01-03-1997"),1998);
        List<Student> students=new ArrayList<Student>();
        students.add(student);

        //act
        List<Student> deserialized = serializor.deserializeStudents(filename);

        //assert
        AssertJUnit.assertEquals(students.get(0).toString(), deserialized.get(0).toString());
    }
}
