package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="STUDENT_DETL")
public class StudentEntity {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String gender;
	private String course;
	private String timings;
	

}
