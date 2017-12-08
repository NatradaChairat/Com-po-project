package camt.cbsd.lab05.dao;


import camt.cbsd.lab05.entity.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Profile("firstDataSource")
@ConfigurationProperties(prefix = "server")
@Repository
public class StudentDaoImpl implements StudentDao {
    List<Student> students;
    String imageBaseUrl;
    String baseUrl;
    String imageUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Student findById(long id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Student findByUserUsername(String username) {
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        student.setImage(this.imageBaseUrl + student.getImage());
        if (students.add(student)) {
            return student;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getStudents(String searchText) {
        return null;
    }

    @Override
    public Integer size() {
        return students.size();
    }

    @PostConstruct
    protected void init() {
        this.imageBaseUrl = this.baseUrl + this.imageUrl;
        students = new ArrayList<>();

        Student student1 = Student.builder().studentId("SE-001").name("Mitsuha").surname("Miyamizu")
                .gpa(2.15).image(imageBaseUrl + "mitsuha.gif").feature(true)
                .penAmount(0).description("The most beloved one").build();
        Student student2 = Student.builder().studentId("SE-002").name("Prayuth").surname("The minister")
                .gpa(3.59).image(imageBaseUrl + "tu.jpg").feature(false)
                .penAmount(15).description("The great man ever!!!!").build();
        Student student3 = Student.builder().studentId("SE-003").name("Jurgen").surname("Kloop")
                .gpa(2.15).image(imageBaseUrl + "Kloop.gif").feature(true)
                .penAmount(2).description("The man for the Kop").build();

        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

}
