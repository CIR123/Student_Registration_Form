package in.ashokit.binding;

import lombok.Data;

@Data
public class Student {
	
	private Integer id;
	private String name;
	private String email;
	private String gender;
	private String course;
	private String[] timings;

}
