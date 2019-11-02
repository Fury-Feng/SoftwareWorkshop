/**
 * The class contains 12 tests to test the makeField method, makeConstructor method,
 * makeGetter method, makeSetter method in the GenerateClass class.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/2
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenerateClassTests {

    private GenerateClass personOneClass, personTwoClass, personThreeClass, personFourClass;

    @BeforeEach
    public void init() {
        String classname1 = "Person1";
        String[] variableNames1 = { "name", "dob" };
        String[] variableTypes1 = { "String", "Date" };
        personOneClass = new GenerateClass(classname1, variableNames1, variableTypes1);

        String classname2 = "Person2";
        String[] variableNames2 = { "name" };
        String[] variableTypes2 = { "String" };

        personThreeClass = new GenerateClass(classname2, variableNames2, variableTypes2);

        String classname3 = "Person3";
        String[] variableNames3 = {};
        String[] variableTypes3 = {};

        personFourClass = new GenerateClass(classname3, variableNames3, variableTypes3);

    }

    // ----------------Testing personOneClass----------------------------------------------
    @Test
    public void test1() {
        String expectedFields = "  private String name;\n" + "  private Date dob;\n\n";
        String actualFields = personOneClass.makeFields();
        assertEquals(expectedFields, actualFields);
    }

    @Test
    public void test2() {
        String expectedConstructor = "  public Person1(String name, Date dob){\n" + "    this.name = name;\n"
                + "    this.dob = dob;\n" + "  }\n";
        String actualConstructor = personOneClass.makeConstructor();
        assertEquals(expectedConstructor, actualConstructor);
    }

    @Test
    public void test3() {
        String expectedGetters = "  public String getName(){\n" + "    return name;\n" + "  }\n"
                + "  public Date getDob(){\n" + "    return dob;\n" + "  }\n";
        String actualGetters = personOneClass.makeGetters();
        assertEquals(expectedGetters, actualGetters);
    }

    @Test
    public void test4() {
        String expectedSetters = "  public void setName(String name){\n" + "    this.name = name;\n" + "  }\n"
                + "  public void setDob(Date dob){\n" + "    this.dob = dob;\n" + "  }\n";
        String actualSetters = personOneClass.makeSetters();
        assertEquals(expectedSetters, actualSetters);
    }

    // ----------------Testing personTwoClass----------------------------------------------

    @Test
    public void test5() {
        String expectedFields = "  private String name;\n\n";
        String actualFields = personThreeClass.makeFields();
        assertEquals(expectedFields, actualFields);
    }

    @Test
    public void test6() {
        String expectedConstructor = "  public Person2(String name){\n" + "    this.name = name;\n" + "  }\n";
        String actualConstructor = personThreeClass.makeConstructor();
        assertEquals(expectedConstructor, actualConstructor);
    }

    @Test
    public void test7() {
        String expectedGetters = "  public String getName(){\n" + "    return name;\n" + "  }\n";
        String actualGetters = personThreeClass.makeGetters();
        assertEquals(expectedGetters, actualGetters);
    }

    @Test
    public void test8() {
        String expectedSetters = "  public void setName(String name){\n" + "    this.name = name;\n" + "  }\n";
        String actualSetters = personThreeClass.makeSetters();
        assertEquals(expectedSetters, actualSetters);
    }

    // ----------------Testing personThreeClass----------------------------------------------

    @Test
    public void test9() {
        String expectedFields = "\n";
        String actualFields = personFourClass.makeFields();
        assertEquals(expectedFields, actualFields);
    }

    @Test
    public void test10() {
        String expectedConstructor = "  public Person3(){}\n";
        String actualConstructor = personFourClass.makeConstructor();
        assertEquals(expectedConstructor, actualConstructor);
    }

    @Test
    public void test11() {
        String expectedGetters = "";
        String actualGetters = personFourClass.makeGetters();
        assertEquals(expectedGetters, actualGetters);
    }

    @Test
    public void test12() {
        String expectedSetters = "";
        String actualSetters = personFourClass.makeSetters();
        assertEquals(expectedSetters, actualSetters);
    }

}
