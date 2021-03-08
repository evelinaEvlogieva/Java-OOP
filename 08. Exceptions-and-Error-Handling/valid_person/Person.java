package valid_person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setFirstName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private void setFirstName(String firstName) {
        if (isNullOrEmpty(firstName)){
            throw new IllegalArgumentException("The fisrt name can not be empty");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (isNullOrEmpty(lastName)){
            throw new IllegalArgumentException("The last name can not be empty");
        }
        this.lastName = lastName;
    }

    private void setAge(int age){
        if (age < 0 || age > 120){
            throw new IllegalArgumentException ("Age must be in range [0...120]");

        }

        this.age = age;
    }

    private boolean isNullOrEmpty(String name) {
        if (!name.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}