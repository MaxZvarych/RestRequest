package ua.lviv.iot.spring.first.rest.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
 
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Student_Subjects", joinColumns = {
            @JoinColumn(name = "subject_id", nullable = false) }, 
    inverseJoinColumns = {
                    @JoinColumn(name = "student_id", nullable = false) })
    @JsonIgnoreProperties("subjects")
    private Set<Student> students;

	public Subject() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}


