package hashtablesproject.models;

/**
 *
 * @author Luigi Salcedo
 */
public class Person 
{
    private Identifier ID;
    private String firstName;
    private String lastName;
    private String gender;
    
    public Person()
    {
        
    }
    
    public Person(Identifier ID, String firstName, String lastName, String gender)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
    
    public Person(String ID, String firstName, String lastName, String gender)
    {
        this(new Identifier(ID), firstName, lastName, gender);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Identifier getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }
    
    @Override
    public String toString()
    {
        return ID.toString();
    }
    
    public static Person parsePerson(String str)
    {
        String [] data = str.split(";");
        return new Person(data[0].trim(), data[1], data[2], data[3]);
    }
}
