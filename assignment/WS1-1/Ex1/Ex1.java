/**
 * @Author: Fuwei Feng
 * @Date: 2019/10/3  下午3:18
 * @File: FirstWeekAssignment.java
 **/
public class Ex1 {
    public static double areaCircle(double radius){
        /**
         * @param radius is the radius of the circle
         * @return the area of the circle
         */
        return (Math.PI * radius * radius);
    }

    public static void printArea(double radius){
        /**
         * @param radius is the radius of the circle
         * Prints the area of the circle.
         */
        System.out.println("The radius of the circle is " + radius + ", the area of the circle is " + areaCircle(radius) + ".");
    }

    public static void main(String[] args) {
        printArea(0);
        printArea(5);
        printArea(10);
    }
}
