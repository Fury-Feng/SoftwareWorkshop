/**
 * @Author: Fuwei Feng
 * @Date: 2019/10/3
 **/
public class Ex3 {
    public static int timeToAngle(int hours, int minutes){
        /**
         * The angle should be the hourhand minus minutehand plus 360 then except 360 to get the reminder
         * @param hours is the time of the hour
         * @param hours is the time of the minute
         * @return the angle
         */
        double hourhand =  (hours % 12) * 30 + (minutes / 60.0) * 30;    // hourhand is the angle of hour hand
        double minutehand = minutes * 6;                                // minutehand is the angle of minute hand
        double angle = (hourhand - minutehand + 360) % 360;             // angle is the angle of counterclockwise from hour to minute hand
        return (int)(angle);
    }

    public static int timeToAngle(int hours, int minutes, double seconds){
        /**
         * Overload the timeToAngle to add a variable seconds, the type of seconds is double
         */
        double hourhand =  (hours % 12) * 30 + (minutes / 60.0) * 30 + (seconds / 3600.0) * 30;    // hourhand is the angle of hour hand
        double minutehand = minutes * 6 + (seconds / 60) * 6;                                // minutehand is the angle of minute hand
        double angle = (hourhand - minutehand + 360) % 360;             // angle is the angle of counterclockwise from hour to minute hand
        return (int)(angle);
    }

    public static void printAngle(int hours, int minutes){
        // Print the angle.
        System.out.println("When the time is " + hours + ":" + minutes + ", the angle is  " + timeToAngle(hours, minutes));
    }

    public static void printAngle(int hours, int minutes, double seconds){
        /**
         * Overload the printAngle to add a variable seconds, the type of seconds is double
         */
        System.out.println("When the time is " + hours + ":" + minutes + ":" + seconds+
                ", the angle is  " + timeToAngle(hours, minutes, seconds));
    }

    public static void main(String[] args) {
        Ex3 e3 = new Ex3();
        e3.printAngle(9, 00);      // get the angle of 9:00
        e3.printAngle(3, 00);      // get the angle of 3:00
        e3.printAngle(18, 00);     // get the angle of 18:00
        e3.printAngle(1, 00);      // get the angle of 1:00
        e3.printAngle(2, 30);      // get the angle of 2:30
        e3.printAngle(4, 41);      // get the angle of 4:41
        e3.printAngle(0, 00, 20);       // get the angle of 0:00:20
        e3.printAngle(13, 05, 27.272727272727);     // get the angle of 13:05:27.272727272727
    }
}
