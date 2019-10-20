/**
 * This program is a class named Film, the class has three private
 * title is String type, releaseDate is Date type, length is int type.
 * The class has constructor, getter and setter and toString method and main method
 * @author: Fuwei Feng
 * @version: 2019/10/17
 */
public class Film {

    private String title;
    private Date releaseDate;
    private int length;

    /**
     * The constructor is used to create the Film object.
     * @param title
     * @param releaseDate
     * @param length
     */
    public Film(String title, Date releaseDate, int length) {

        this.title = title;
        this.releaseDate = releaseDate;
        this.length = length;
    }

    /**
     * Getter for the title.
     * @return title    The title of the film is returned.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the releaseDate.
     * @return releaseDate  The releaseDate of the film is returned
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Getter for the length.
     * @return length       The length of the film is returned.
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter for the releaseDate. The releaseDate of the film is updated.
     * @param releaseDate   The new releaseDate of the film.
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return A human readable description of the film in form of the three variables.
     */
    @Override
    public String toString() {
        return "Film { " +
                "title: " + title +
                ", releaseDate: " + releaseDate +
                ", length: " + length +
                " }";
    }

    /**
     * Main method is to create date object called date, and film object called adAstra.
     */
    public static void main(String[] args) {
        Date date = new Date(18, "September", 2019);
        Film adAstra = new Film("Ad Astra",date, 123);
    }
}
