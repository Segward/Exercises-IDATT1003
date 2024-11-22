import java.util.Calendar;
import java.util.GregorianCalendar;

public class Worker  {
    
    private Person person;
    private int yearOfHire;
    private double monthlySalary;
    private double taxPercentage;

    private static GregorianCalendar calendar = new GregorianCalendar();
    private static int currentYear = calendar.get(Calendar.YEAR);

    public Worker(int yearOfHire, double monthlySalary, double taxPercentage, Person person) {
        this.person = person;
        this.yearOfHire = yearOfHire;
        this.monthlySalary = monthlySalary;
        this.taxPercentage = taxPercentage;
    }
    
    public double getTaxPerMonth() {
        return monthlySalary * taxPercentage / 100;
    }

    public double getYearlySalary() {
        return monthlySalary * 12;
    }

    public double getYearlyTax() {
        return getTaxPerMonth() * 10 + getTaxPerMonth() / 2;
    }

    public String getFullName() {
        return person.getFullName();
    }

    public int getAge() {
        return currentYear - person.getBirthYear();
    }

    public int getYearsEmployed() {
        return currentYear - yearOfHire;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public Boolean hasBeenHiredForMoreThanYears(int years) {
        return getYearsEmployed() > years;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public void setYearOfHire(int yearOfHire) {
        this.yearOfHire = yearOfHire;
    }

    public void setFirstName(String firstName) {
        person.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        person.setLastName(lastName);
    }

    public void setBirthYear(int birthYear) {
        person.setBirthYear(birthYear);
    }

    public String toString() {
        return String.format("\nName: %s\nAge: %d\nYears employed: %d\nMonthly salary: %.2f\nTax per month: %.2f\nYearly salary: %.2f\nYearly tax: %.2f",
        getFullName(), getAge(), getYearsEmployed(), getMonthlySalary(), getTaxPerMonth(), getYearlySalary(), getYearlyTax());
    }

}