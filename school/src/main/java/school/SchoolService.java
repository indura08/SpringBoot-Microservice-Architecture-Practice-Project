package school;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.client.StudentClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    public void saveStudent(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllStudents() {
        return schoolRepository.findAll();
    }

    public School getStudentById(int id){
        return schoolRepository.findById(id).get();
    }

    public FullSchoolResponse findSchoolsWithStudents(int schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(School.builder().name("NOT_FOUND").email("NOT FOUND").build());
        var students = studentClient.findAllStudentBySchoolId(schoolId);
        return FullSchoolResponse.builder().name(school.getName()).email(school.getEmail()).students(students).build();
    }


}
