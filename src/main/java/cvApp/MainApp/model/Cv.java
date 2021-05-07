package cvApp.MainApp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cv")
public class Cv 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="cvlang")
	private String cvLanguage;
	
	@Column(name="fname")
	@Size(min=3, max=30)
	private String fullName;
	
	@Size(min=3, max=50)
	@Column(name="email")
	private String eMail;
	
	@Size(min=3, max=50)
	@Column(name="address")
	private String address;
	
	@Past
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="dob")
	private LocalDate dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="nation")
	@Size(min=3, max=30)
	private String nationality;
	
	@Size(min=5, max=150)
	@Column(name="school")
	private String schoolName;
	
	@DecimalMin(value="1.5")
	@DecimalMax(value="4.0")
	@Column(name="gpa")
	private Double gpa;
	
	@Size(min=3, max=300)
	@Column(name="skill")
	private String skills;
	
	@Size(min=3, max=500)
	@Column(name="projects")
	private String projects;
	
	@ManyToOne
	@JoinColumn(name="applicantid")
	private Applicant applicant;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCvLanguage() {
		return cvLanguage;
	}

	public void setCvLanguage(String cvLanguage) {
		this.cvLanguage = cvLanguage;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}
	
	
	
	
}
