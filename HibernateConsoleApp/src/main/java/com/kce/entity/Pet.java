package com.kce.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "pet_tbl")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String petID;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "species", nullable = false)
    private String species;
    @Column(name = "breed", nullable = false)
    private String breed;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "medical status", nullable = false)
    private String medicalStatus;
    @Column(name = "available", nullable = false)
    private String available;

    public Pet() {
    }

    public Pet(String petID, String name, String species, String breed, int age,
               String medicalStatus, String available) {

        this.petID = petID;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.medicalStatus = medicalStatus;
        this.available = available;
        
        
    }

	public String getPetID() {
		return petID;
	}

	public void setPetID(String petID) {
		this.petID = petID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMedicalStatus() {
		return medicalStatus;
	}

	public void setMedicalStatus(String medicalStatus) {
		this.medicalStatus = medicalStatus;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Pet [petID=" + petID + ", name=" + name + ", species=" + species + ", breed=" + breed + ", age=" + age
				+ ", medicalStatus=" + medicalStatus + ", available=" + available + "]";
	}
	
	

}
