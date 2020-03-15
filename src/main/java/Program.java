import models.SerializationUtils;
import models.Student;
import java.io.*;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String args[]) throws ParseException, IOException, InvalidParameterException {
        String studentsFile="Student.txt";
        String serelizationFile="File.xml";

        SerializationUtils serializor = new SerializationUtils();
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        List<Student> students = new ArrayList<Student>();
        Student student1= new Student("4656846","Dima","BMW",formater.parse("04-05-2018"),1958);
        Student student2= new Student("1481614","Ivan","Ivaniv",formater.parse("07-12-1856"),1985);
        Student student3= new Student("8765353","Vova","VW",formater.parse("05-04-1751"),1945);
        Student student4= new Student("9846521","Petro","Opel",formater.parse("04-05-1557"),1995);
        Student student5= new Student("9531561","Nazar","Skoda",formater.parse("04-05-1557"),2001);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        try {
            saveInFile(studentsFile,students);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        showStudents(students);

        System.out.println("***********");

        studentOrder(students);
        showStudentsByAge(students,18);

        serializor.serializeStudents(serelizationFile, students);
        List<Student> studentDeserialize = serializor.deserializeStudents(serelizationFile);
        System.out.println(studentDeserialize);
    }

    public static void saveInFile(String filename, List<Student> students) throws FileNotFoundException {
       try {
           PrintWriter write = new PrintWriter(new FileOutputStream(filename));
           for (Student student:students)
           {
               write.println(student);
           }
           write.close();
       }
       catch (FileNotFoundException e) {
           throw new FileNotFoundException("File with name: " + filename + "not exist. Please set correct file name");
       }
       catch (Exception e) {
           System.out.print("Some error corrupted when write data to the file.");
       }
    }

    public static void showStudents(List<Student> students)
    {
        for (Student student:students
        ) {
            student.getOutput();
        }
    }
    public static void showStudentsByAge(List<Student> students, int age)
    {
        for (Student student:students
             ) {
            if(student.getAge()>=age)
            {
                student.getOutput();
            }
        }
    }
    private static void studentOrder(List<Student> students)
    {
        Collections.sort(students, new Comparator <Student>() {
            @Override
            public int compare(Student student, Student t1) {
                String x1 = student.getFirstName();
                String x2 = t1.getFirstName();
                int sComp = x1.compareTo(x2);
                if (sComp != 0) {
                    return sComp;
                }
                x1 = student.getLastName();
                x2 = t1.getLastName();
                return x1.compareTo(x2);
            }
        });
    }
}
