package student;

import student.InvalidPersonNameException;

public class Student {
    private String name;

    public Student(String name) {
        setName(name);
    }

    private void setName(String name)  {
        for (int i = 0; i < name.length() ; i++) {
            char symbol = name.charAt(i);
            if (Character.isDigit(symbol)){
                try {
                    throw new InvalidPersonNameException("Name can not contains numbers");
                } catch (InvalidPersonNameException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        this.name = name;
    }
}
