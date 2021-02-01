package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Student;

public class StudentDao {

    private static List<Student> student;

    static {
        student = new ArrayList<>();
        student.add( new Student(1, "Thang", 23, "Hue"));
        student.add( new Student(2, "Dat", 23, "Hue"));
        student.add( new Student(3, "Anh", 23, "Hue"));
        student.add( new Student(4, "Huy", 23, "Hue"));
    }

    public List<Student> getAll(){
        return new ArrayList<>(student);
    }

    public Student findByID(int id){
        return student.get(id);
    }
}
