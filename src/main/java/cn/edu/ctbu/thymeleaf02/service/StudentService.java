package cn.edu.ctbu.thymeleaf02.service;

import cn.edu.ctbu.thymeleaf02.entity.Student;
import cn.edu.ctbu.thymeleaf02.repostory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }
    //新增学生
    public Student addStudent(Student student) {
        if(student == null) {
            throw new RuntimeException("student is null");
        }
        return studentRepository.save(student);
    }

    /**
     *分页读取
     */
    public Page<Student> findAll(Example<Student> studentExample, Pageable pageable) {
        return studentRepository.findAll(studentExample, pageable);
    }

    /**
     * 更新学生
     * @param student
     * @return
     */
    public Student updateStudent(Student student) {
        if(student == null) {
            throw new RuntimeException("student is null");
        }
        if(student.getId()==null) {
            throw new RuntimeException("student id is null");
        }
        return studentRepository.save(student);
    }

    /**
     * 按id删除学生
     * @param id
     */
    public void deleteStudent(Long id) {
        if(id == null){
            throw new RuntimeException("student id is null");
        }
        studentRepository.deleteById(id);
    }
    public void deleteStudent(Student student) {
        if(student == null && student.getId()==null) {
            throw new RuntimeException("student id is null,必须有id");
        }
        studentRepository.delete(student);
    }



}
