package models;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Person
{
    String taxNumber, firstName, lastName;
    Date birthDate;
    int a;
    void setA(int b) {b= }
    public Person() {}
    public Person(String taxNumber, String firstName, String lastName, Date birthDate) throws InvalidParameterException
    {
        if (taxNumber == "" || taxNumber == null) {
            throw new InvalidParameterException("Invalid tax number value");
        }
        this.taxNumber=taxNumber;
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;

    }

    public String getTaxNumber()
    {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber)
    {
        this.taxNumber = taxNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public int getAge()
    {
        Date currentDate = new Date();
        return (int)((currentDate.getTime() - birthDate.getTime())
                / (1000*60 *60 *24 )/365.25);
    }

    public void getOutput()
    {
        System.out.println("First Name "+firstName+", Last Name "+lastName+", Tax Number "+taxNumber);
    }

    public void getInput() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Enter First Name:");
        System.out.println();
        firstName = scanner.nextLine();
        System.out.println("Enter Last Name:");
        lastName = scanner.nextLine();
        System.out.println("Enter Birthday Date:");
        birthDate = formater.parse(scanner.nextLine());
        }
    @Override
    public String toString() {
        return firstName+ " "+lastName+" "+taxNumber;
    }
}
