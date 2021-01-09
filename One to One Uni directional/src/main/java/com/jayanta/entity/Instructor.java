package com.jayanta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Convert this class into an Entity Class using @Entity annotation
@Entity
// Map it with database table using @Table
@Table(name = "instructor")
public class Instructor {

	/*
	 * 1. Make id field as primary key using @Id annotation 
	 * 2. Define auto increment
	 * of id using @GeneratedValue(strategy=GenerationType.IDENTITY) 
	 * 3. Map column in database with each field using @Column 
	 * 4. Create no argument constructor
	 * 5. Create constructor using fields 
	 * 6. Generate Getters and Setters for all fields 
	 * 7. Generate toString() --> method using all fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	/*
	 * 1. Set up mapping to InstructorDetail entity 
	 * 2. One-to-One map using @OneToOne 
	 * 3. (cascade=CascadeType.ALL) --> CascadeType.ALL will handle
	 * all the related operations in db i.e Persist, Delete etc.
	 * 4. @JoinColumn annotation maps using db column. i. InstructorDetail Primary
	 * Key id mapped with ii. Instructor Foreign key instructor_detail_id
	 * 
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	private InstructorDetail instructorDetail;

	public Instructor() {

	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	
}
