package school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public void saveStudent(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllStudents() {
        return schoolRepository.findAll();
    }

    public School getStudentById(int id){
        return schoolRepository.findById(id).get();
    }

}
