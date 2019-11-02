/**
 * The program is a classed named Salaries, the class has one private variable ArrayList called allSalaries.
 * This class has a constructor to create an initially empty ArrayList,
 * the class has a method named add to add the salaries of one employee to the field variable allSalaries,
 * the class has a method named average to compute the average salary for an employee,
 * the class has a method named averageSalaries to store the average salaries of all employees.
 * the class has a method named not3TimesHigher to check whether for each employee with at least one non-zero monthly salary
 * their average salary is not higher than three times the overall average salary of the other employees.
 *
 * @author: Fuwei Feng
 * @version: 2019/10/31
 */

import java.util.ArrayList;

public class Salaries {

    private ArrayList<double[]> allSalaries ;

    /**
     * This constructor is used to create a Salaries object( an initially empty ArrayList).
     */
    public Salaries() {
        allSalaries = new ArrayList<>();
    }

    /**
     * The add method is used to add the salaries of one employee to the field variable allSalaries.
     * @param employeeSalaries      The 12 salaries of an employee for the 12 months of the year.
     */
    public void add(double[] employeeSalaries) {
        allSalaries.add(employeeSalaries);
    }

    /**
     * The average method is used to compute the average salary for an employee.
     * @param employeeSalaries      The 12 salaries of an employee for the 12 months of the year.
     * @return totalSalaries/months  The average salary of an employee.
     */
    public static double average(double[] employeeSalaries) {

        double totalSalaries = 0;
        int months = 0;

        for (int i = 0; i < employeeSalaries.length; i ++) {
            if (employeeSalaries[i] > 0) {
                totalSalaries = totalSalaries + employeeSalaries[i];
                months++;
            }
        }

        /**
         * If all values in the employeeSalaries array are zero, throw an IllegalArgumentException.
         */
        if (totalSalaries == 0) {
            throw new IllegalArgumentException("This employee did not earn any money this year.");
        }

        return totalSalaries / months;

    }

    /**
     * The averageSalaries method is used to store the average salaries of all employees.
     * @return averageSalary     The averageSalary is an array contain the average salaries of every employee.
     */
    public ArrayList<Double> averageSalaries() {

        ArrayList<Double> averageSalary = new ArrayList<>();

        for (int i = 0; i < allSalaries.size(); i ++) {
            try{
                double avgEmployeeSalary = average(allSalaries.get(i));
                averageSalary.add(avgEmployeeSalary);
            } catch(IllegalArgumentException e) {
                System.out.println("Warning, you are going to add the employee who didn't earn money.");
            }
        }

        return averageSalary;

    }

    /**
     * The not3TimesHigher method is used to check whether for each employee with at least one non-zero monthly salary
     * their average salary is not higher than three times the overall average salary of the other employees.
     * @return boolean value    If employee's average salary is not higher than three times the overall average salary of the other employees, return true, else, return true.
     */
    public boolean not3TimesHigher() {

        ArrayList<Double> average3TimeSalary = averageSalaries();

        for (int i = 0; i < average3TimeSalary.size(); i ++) {
            double employeeAvgSalary = average3TimeSalary.get(i);
            average3TimeSalary.remove(i);

            double[] otherSalary = new double[average3TimeSalary.size()];
            double otherTotalSalary = 0;

            for (int j = 0; j < otherSalary.length; j ++) {
                otherSalary[j] = average3TimeSalary.get(j);
                otherTotalSalary = otherTotalSalary + otherSalary[j];
            }

            if (employeeAvgSalary > (otherTotalSalary / otherSalary.length) * 3) {
                return false;
            }
        }

        return true;

    }

}
