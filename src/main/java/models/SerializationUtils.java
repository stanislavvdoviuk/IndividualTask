package models;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class SerializationUtils {
    public void serializeStudents(String fileName, List<Student> students) throws FileNotFoundException {
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(fileName));
        encoder.setPersistenceDelegate(Date.class,
                new PersistenceDelegate(){
                    @Override
                    protected Expression instantiate(Object birthDate, Encoder out) {
                        Date date = (Date) birthDate;
                        return new Expression(date,
                                Date.class,
                                "new",
                                new Object[]{
                                        date.getYear(),
                                        date.getMonth(),
                                        date.getDay()
                                });
                    }
                });
        encoder.writeObject(students);
        encoder.close();
    }
    public  List<Student> deserializeStudents(String fileName)throws FileNotFoundException{
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
        List<Student> students = (List<Student>)decoder.readObject();
        decoder.close();
        return students;
    }
}
