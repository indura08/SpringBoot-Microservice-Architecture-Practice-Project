package student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("create")
    public ResponseEntity<String> createStudent(@RequestBody Student newStudent){
        studentService.saveStudent(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> studentsList = studentService.findAllStudents();
        if(studentsList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findAllStudents());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        Student student = studentService.getStudentById(id);
        if(student == null){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> getStudentsBySchoolId(@PathVariable("school-id") int schoolId){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAllStudentBySchool(schoolId));
    }
}
