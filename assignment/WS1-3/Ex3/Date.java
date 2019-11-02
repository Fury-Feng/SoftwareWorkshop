/**
 * This program is a class named Date, the class has three private variables
 * month is String type, day and year are int type
 * The class has constructor, getter and setter and toString method.
 * @author: Fuwei Feng
 * @version: 2019/10/18
 */
public class Date {
    private int day;
    private String month;
    private int year;

    /**
     *The constructor is used to creat a Date object.
     * @param day       The day of the date.
     * @param month     The month of the date.
     * @param year      The year of the date.
     */
    public Date(int day, String month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Getter for the day.
     * @return day      The day of the date is returned.
     */
    public int getDay() {
        return day;
    }

    /**
     * Setter for the day. The day of the date is updated.
     * @param day       The new day of the date.
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Getter for the month.
     * @return month    The month of the date is returned.
     */
    public String getMonth() {
        return month;
    }

    /**
     * Setter for the month. The month of the date is updated.
     * @param month     The new month of the date.
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Getter for the year.
     * @return year     The year of the date is returned.
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter for the year. The year of the date is updated.
     * @param year      The new year of the date.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return A human readable description of the date in form of three field variables.
     */
    @Override
    public String toString() {
        return day + " " + month + " " + year;
    }
}
