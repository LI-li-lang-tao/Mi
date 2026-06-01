package cn.edu.ctbu.thymeleaf02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_student")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sNo;
    private Integer sex;
    private Integer age;
    private Integer score;

}
