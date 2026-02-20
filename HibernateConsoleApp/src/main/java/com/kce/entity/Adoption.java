package com.kce.entity;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Adoption_Tbl")

public class Adoption {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adoptionlD;
	@Column(name = "pet id", nullable = false)
	private String petID;
	@Column(name = "adopter name", nullable = false)
	private String adopterName;
	@Column(name = "adopter contact", nullable = false)
	private String adopterContact;
	@Column(name = "adoption date", nullable = false)
	private Date adoptionDate;
	@Column(name = "status", nullable = false)
	private String status;
	
	public Adoption() {
    }
	
	public Adoption(int adoption1D,String petID,String adopterName,
	String adopterContact,Date adoptionDate,String status, int adoptionlD)
	{
		    this.adoptionlD = adoptionlD;
	        this.petID = petID;
	        this.adopterName = adopterName;
	        this.adopterContact = adopterContact;
	        this.adoptionDate = adoptionDate;
	        this.status = status;
	}

	public int getAdoptionlD() {
		return adoptionlD;
	}

	public void setAdoptionlD(int adoptionlD) {
		this.adoptionlD = adoptionlD;
	}

	public String getPetID() {
		return petID;
	}

	public void setPetID(String petID) {
		this.petID = petID;
	}

	public String getAdopterName() {
		return adopterName;
	}

	public void setAdopterName(String adopterName) {
		this.adopterName = adopterName;
	}

	public String getAdopterContact() {
		return adopterContact;
	}

	public void setAdopterContact(String adopterContact) {
		this.adopterContact = adopterContact;
	}

	public Date getAdoptionDate() {
		return adoptionDate;
	}

	public void setAdoptionDate(Date adoptionDate) {
		this.adoptionDate = adoptionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pet [adoptionlD=" + adoptionlD + ", petID=" + petID + ", adopterName=" + adopterName
				+ ", adopterContact=" + adopterContact + ", adoptionDate=" + adoptionDate + ", status=" + status + "]";
	}
	
	
	
	
}
