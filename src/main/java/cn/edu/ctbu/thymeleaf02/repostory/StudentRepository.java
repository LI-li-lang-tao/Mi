package cn.edu.ctbu.thymeleaf02.repostory;


import cn.edu.ctbu.thymeleaf02.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * 按全部姓名查询
     * @param name
     * @return
     */
    public List<Student> findByName(String name);

    /**
     * 按名字和年纪
     * @param name
     * @param age
     * @return
     */
    public List<Student> findByNameAndAge(String name, int age);

    public List<Student> findByNameLike(String name);
    public List<Student> findByNameStartingWith(String name);

}
