package models;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Student extends Person
{
    public Student(){};
    int yearOfEntry;
    public Student(String taxNumber, String firstName, String lastName, Date birthDate, int yearOfEntry) throws InvalidParameterException
    {
        super(taxNumber, firstName, lastName, birthDate);
        this.yearOfEntry = yearOfEntry;
    }
    public int getYearOfEntry()
    {
        return yearOfEntry;
    }
    public void setYearOfEntry(int yearOfEntry)
    {
        this.yearOfEntry = yearOfEntry;
    }

    @Override
    public void getOutput() {
        super.getOutput();
        System.out.println("Year of Entry "+yearOfEntry);
    }

    @Override
    public void getInput() throws ParseException {
        super.getInput();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Year of Entry:");
        yearOfEntry = scanner.nextInt();
    }
    @Override
    public String toString()
    {
        return super.toString() + " "+ yearOfEntry;
    }
}
