package com.example.jpajava.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Person
 */
@Entity(name = "person")
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 생성
//@RequiredArgsConstructor // final 이나 @nonNull인 필드 값만 파라미터로 받는 생성자를 생성
@ToString
public class Person {

    /**
     * GenerationType.AUTO :: 특정 DB에 맞게 자동 선택 ( default )
     * GenerationType.IDENTITY :: DB의 identity 컬럼을 이용
     * GenerationType.SEQUENCE :: DB의 시퀀스 컬럼을 이용
     * GenerationType.TABLE :: 유일성이 보장된 데이터베이스 테이블을 이용
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private int age;
    
    @Column(nullable = false)
    private String name;
    
    /**
     * FetchType.LAZY :: animal 객체 조회 요청 시 조회 시작
     * FetchType.EAGER :: 미리 조회
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    private List<Animal> animal;
    
    // @Column(nullable = false)
    // @Enumerated(EnumType.STRING)
    // private StringEnum stringEnum;

	public long getId() {
        return id;
	}
    
	public void setId(long id) {
        this.id = id;
	}
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

}