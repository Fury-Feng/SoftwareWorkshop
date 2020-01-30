/**
 * The program is a class named MusicTitle implements interface MusicTitleInterface.
 * The class has three field variables: title with String type, artist with String type, price with int type.
 * The class has a constructor, getters and toString method.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/16
 */
public class MusicTitle implements MusicTitleInterface {

    private String title;
    private String artist;
    private int price;

    /**
     * The constructor is used to create a musicTitle object.
     * @param title         The title of the music.
     * @param artist        The artist of the music.
     * @param price         The price of the music.
     */
    public MusicTitle(String title, String artist, int price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    /**
     * Override the getter for the title.
     * @return title    The title of the music.
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Override the getter for the artist.
     * @return artist   The artist of the music.
     */
    @Override
    public String getArtist() {
        return artist;
    }

    /**
     * Override the getter for the price.
     * @return price    The price of the music.
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * Override the toString method.
     * @return a human readable description of the musictitle in form of the three field variables specifying in.
     */
    @Override
    public String toString() {
        return "MusicTitle[Title: " + title + ", Artist: " + artist + ", Price: " + price;
    }
}
