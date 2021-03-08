package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void addStudent (String name, int age, double grade){
        this.repository.putIfAbsent(name, new Student(name, age, grade));
    }

    public void print(String name) {
        if (repository.containsKey(name)) {
            Student student = repository.get(name);
            String output = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                output += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                output += " Average student.";
            } else {
                output += " Very nice person.";
            }

            System.out.println(output);
        }
    }

}
