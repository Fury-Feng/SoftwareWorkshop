/**
 *The program is a class named GenerateClass, the class has three private field variables,
 * classname is String type, variableNames is String array type, variableTypes is String array type.
 * The class has constructor, getters and setters.
 * The class has 6 methods, they are makeFields method, makeConstructor method, makeGetters method,
 * makeSetters method, writeFile method and main method.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/2
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateClass {

    private String classname;
    private String[] variableNames;
    private String[] variableTypes;

    /**
     * This constructor is used to create a GenerateClass object.
     * @param classname             The classname of the GenerateClass.
     * @param variableNames         The variableNames of the GenerateClass.
     * @param variableTypes         The variableTypes of the GenerateClass.
     */
    public GenerateClass(String classname, String[] variableNames, String[] variableTypes) {
        this.classname = classname;
        this.variableNames = variableNames;
        this.variableTypes = variableTypes;
    }

    /**
     * Getter for the classname.
     * @return  classname       The classname of the GenerateClass is returned.
     */
    public String getClassname() {
        return classname;
    }

    /**
     * Setter for the classname. The classname of the GenerateClass is updated.
     * @param classname          The new classname of the GenerateClass.
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     * Getter for the variableNames.
     * @return  variableNames       The variableNames of the GenerateClass is returned.
     */
    public String[] getVariableNames() {
        return variableNames;
    }

    /**
     * Setter for the variableNames. The variableNames of the GenerateClass is updated.
     * @param variableNames          The new variableNames of the GenerateClass.
     */
    public void setVariableNames(String[] variableNames) {
        this.variableNames = variableNames;
    }

    /**
     * Getter for the variableTypes.
     * @return  variableTypes       The variablesTypes of the GenerateClass is returned.
     */
    public String[] getVariableTypes() {
        return variableTypes;
    }

    /**
     * Setter for the variableTypes. The variableTypes of the GenerateClass is updated.
     * @param variableTypes          The new variableTypes of the GenerateClass.
     */
    public void setVariableTypes(String[] variableTypes) {
        this.variableTypes = variableTypes;
    }

    /**
     * The makeFields method is used to return a String with a declaration of the corresponding field variables.
     * @return field        The fields of the GenerateClass.
     */
    public String makeFields() {

        String field = new String();

        for (int i = 0; i < variableNames.length; i++ ) {
            field = field + "  private " + variableTypes[i] + " " + variableNames[i] +";\n";
        }

        field = field + "\n";
        return field;

    }

    /**
     * The makeConstructor method is used to return a String with a corresponding constructor.
     * @return constructor     The constructor of the GenerateClass.
     */
    public String makeConstructor() {

        String constructor = "  public " + classname + "(";

        for (int i = 0; i < variableNames.length; i++) {
            constructor = constructor + variableTypes[i] + " " + variableNames[i] + ", ";
        }

        if (constructor.equals("  public " + classname + "(")) {
            constructor = constructor + "){}\n";
            return constructor;
        }
        else {
            constructor = constructor.substring(0, constructor.length()-2) + "){\n";
        }

        for (int j = 0; j < variableNames.length; j++) {
            constructor = constructor + "    this." + variableNames[j] + " = " + variableNames[j] + ";\n";
        }

        constructor = constructor + "  }\n";
        return constructor;

    }

    /**
     * The makeGetters method is used to return a String with all getters in the order given by variableNames/variableTypes.
     * @return getters      The getters of the GenerateClass.
     */
    public String makeGetters() {

        String getters = new String();

        for (int i = 0; i < variableNames.length; i++) {
            getters = getters + "  public " + variableTypes[i] + " get" + variableNames[i].substring(0,1).toUpperCase() + variableNames[i].substring(1) + "(){\n"
                    + "    return " + variableNames[i] + ";\n" + "  }\n";
        }

        return getters;

    }

    /**
     * The makeSetters method is used to return a String with all setters in the order given by variableNames/variableTypes.
     * @return setters      The setters of the GenerateClass.
     */
    public String makeSetters() {
        String setters = new String();

        for (int i = 0; i < variableNames.length; i ++) {
            setters = setters + "  public void set" + variableNames[i].substring(0,1).toUpperCase() + variableNames[i].substring(1) + "(" + variableTypes[i] + " " + variableNames[i] + "){\n"
                    + "    this." + variableNames[i] + " = " + variableNames[i] +";\n" + "  }\n";
        }

        return setters;

    }

    /**
     * The writeFile method is used to write a rudimentary class, and create the java file with the name of the GenerateClass.
     */
    public void writeFile() {

        try {
            BufferedWriter wf = new BufferedWriter(new FileWriter(classname + ".java"));
            wf.write("public class " + classname + " {\n");
            wf.write(makeFields());
            wf.write(makeConstructor());
            wf.write(makeGetters());
            wf.write(makeSetters());
            wf.write("}\n");
            wf.flush();
            wf.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The main method create the object of the GenerateClass called person and write the GenerateClass in the java file,
     * the classname is Person, variableNames are name and dob,
     * variableTypes are String and Date.
     * @param args
     */
    public static void main(String[] args) {

        GenerateClass person = new GenerateClass("Person", new String[] {"name", "dob"}, new String[] {"String", "Date"});

        person.writeFile();

    }

}
