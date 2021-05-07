package cvApp.MainApp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="applicant")
public class Applicant
{
	public static int numberOfApplicants=1;
	public int getApplicantNumber()
	{
		return numberOfApplicants;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Size(min=3,max=50)
	@Column(name="usrname")
	private String userName;
	
	@Size(min=3,max=50)
	@Column(name="email")
	private String email;

	@Size(min=3,max=15)
	@Column(name="pass")
	private String password;

	@OneToMany(mappedBy="applicant")
	@OrderBy(clause = "id")
	private Set<Cv> cvs = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Cv> getCvs() {
		return cvs;
	}

	public void setCvs(Set<Cv> cvs) {
		this.cvs = cvs;
	}
	
	
}
