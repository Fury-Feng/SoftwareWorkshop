import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
* The class has 8 tests to test 4 class files and their methods.
* @author: Fuwei Feng
* @version: 2019/11/17
*/
public class AccountTests {

   private MusicTitle firstMusicTitle;
   private MusicTitle secondMusicTitle;
   private MusicTitle thirdMusicTitle;
   private AccountStandard userFury;
   private AccountAdministrator admin;

   @BeforeEach
   public void init() {
       firstMusicTitle = new MusicTitle("Sun", "Ciwei", 5);
       secondMusicTitle = new MusicTitle("Moon", "Newpants", 10);
       thirdMusicTitle = new MusicTitle("Star", "Heisa", 15);

       ArrayList<MusicTitleInterface> list = new ArrayList<>();
       list.add(firstMusicTitle);
       list.add(secondMusicTitle);
       list.add(thirdMusicTitle);

       Account testUser = new AccountStandard("Tony", "Mr", "furyfeng@sina.com", "12ab");
       userFury = new AccountStandard("Fury", "Mr", "610418875@qq.com", "23ab");
       admin = new AccountAdministrator("Steven", "Miss", "ffw@123.com", "34ab");
   }

   // Testing getters for firstMusicTitle
   @Test
   public void test1() {
       String expectedTitle = "Sun";
       String expectedArtist = "Ciwei";
       int expectedPrice = 5;

       String actualTitle = firstMusicTitle.getTitle();
       String actualArtist = firstMusicTitle.getArtist();
       int actualPrice = firstMusicTitle.getPrice();

       assertEquals(expectedTitle, actualTitle);
       assertEquals(expectedArtist, actualArtist);
       assertEquals(expectedPrice, actualPrice);
   }

   // Testing getters for userFury.
   @Test
   public void test2() {
       String expectedName = "Fury";
       String expectedSalutation = "Mr";
       String expectedEmail = "610418875@qq.com";
       String expectedPassword = "23ab";
       int expectedBalance = 0;
       ArrayList<MusicTitle> expectedList = new ArrayList<>();

       String actualName = userFury.getName();
       String actualSalutation = userFury.getSalutation();
       String actualEmail = userFury.getEmail();
       String actualPassword = userFury.getPassword();
       int actualBalance = userFury.getBalance();
       ArrayList<MusicTitle> actualList = userFury.getTitlesBought();

       assertEquals(expectedName, actualName);
       assertEquals(expectedSalutation, actualSalutation);
       assertEquals(expectedEmail, actualEmail);
       assertEquals(expectedPassword, actualPassword);
       for (int i = 0; i < actualList.size(); i++) {
           assertEquals(expectedList.get(i), actualList.get(i));
       }
   }

   // Testing for MAXIMAL_LOGIN_ATTEMPTS
   @Test
   public void test3() {
       int expectedMaximalLoginAttempts = 3;
       int actualMaximalLoginAttempts = AccountStandard.MAXIMAL_LOGIN_ATTEMPTS;
       assertEquals(expectedMaximalLoginAttempts, actualMaximalLoginAttempts);
   }

   // Testing for successful login and fail to buy.
   @Test
   public void test4() {
       userFury.login("23ab");
       assertTrue(userFury.getLoggedIn());

       userFury.buy(secondMusicTitle);
       ArrayList<MusicTitle> actualList = userFury.getTitlesBought();
       assertTrue(actualList.isEmpty());
   }

   // Testing for unsuccessful login.
   @Test
   public void test5() {
       userFury.login("45ab");
       assertFalse(userFury.getLoggedIn());
   }

   // Testing for purchase.
   @Test
   public void test6() {
       userFury.login("12ab");
       assertFalse(userFury.getLoggedIn());

       assertEquals(1, userFury.getFailedLoginAttempts());

       userFury.login("23ab");
       assertTrue(userFury.getLoggedIn());

       assertEquals(0, userFury.getFailedLoginAttempts());

       userFury.deposit(20);
       userFury.buy(firstMusicTitle);

       String expectedTitle = "Sun";
       String actualTitle = userFury.getTitlesBought().get(0).getTitle();
       assertEquals(expectedTitle, actualTitle);

       String expectedArtist = "Ciwei";
       String actualArtist = userFury.getTitlesBought().get(0).getArtist();
       assertEquals(expectedArtist, actualArtist);

       int expectedPrice = 5;
       int actualPrice = userFury.getTitlesBought().get(0).getPrice();
       assertEquals(expectedPrice, actualPrice);

       int expectedBalance = 15;
       int actualBalance = userFury.getBalance();
       assertEquals(expectedBalance, actualBalance);

       userFury.logout();
       assertFalse(userFury.getLoggedIn());


   }

   // Testing admin reset the password without logging in
   @Test
   public void test7() {
       userFury.login("13ab");
       assertFalse(userFury.getLoggedIn());

       assertEquals(1, userFury.getFailedLoginAttempts());

       userFury.login("sdljf3");
       assertFalse(userFury.getLoggedIn());

       assertEquals(2, userFury.getFailedLoginAttempts());

       userFury.login("13ab");
       assertFalse(userFury.getLoggedIn());

       assertEquals(3, userFury.getFailedLoginAttempts());

       admin.resetAccount(userFury, "1234");
       String expectedPassword = "23ab";
       assertTrue(userFury.checkPassword(expectedPassword));

       int expectedFailedLoginAttempts = 3;
       int actualFailedLoginAttempts = userFury.getFailedLoginAttempts();
       assertEquals(expectedFailedLoginAttempts, actualFailedLoginAttempts);
   }

   // Testing admin login to reset account.
   @Test
   public void test8() {
       userFury.login("13ab");
       assertFalse(userFury.getLoggedIn());

       assertEquals(1, userFury.getFailedLoginAttempts());

       userFury.login("sdljf3");
       assertFalse(userFury.getLoggedIn());

       assertEquals(2, userFury.getFailedLoginAttempts());

       userFury.login("13ab");
       assertFalse(userFury.getLoggedIn());

       assertEquals(3, userFury.getFailedLoginAttempts());

       admin.login("34ab");
       assertTrue(admin.getLoggedIn());

       admin.addAccount(userFury);
       String expectedAccountName = "Fury";
       String actualAccountName = admin.getAccounts().get(0).getName();
       assertTrue(!admin.getAccounts().isEmpty());

       admin.resetAccount(userFury, "seed");
       System.out.println(admin);
       String expectedPassword = "seed";
       assertTrue(userFury.checkPassword(expectedPassword));
   }
}



