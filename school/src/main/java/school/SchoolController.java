package school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("create")
    public ResponseEntity<String> createStudent(@RequestBody School newSchool){
        schoolService.saveStudent(newSchool);
        return ResponseEntity.status(HttpStatus.CREATED).body("School created");
    }

    @GetMapping("/all")
    public ResponseEntity<List<School>> getAllStudents(){

        List<School> studentsList = schoolService.findAllStudents();
        if(studentsList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(schoolService.findAllStudents());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getStudentById(@PathVariable("id") int id){
        School student = schoolService.getStudentById(id);
        if(student == null){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }
    }

    @GetMapping("/with-student/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable("school-id") int schoolId){
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.findSchoolsWithStudents(schoolId));
    }
}
