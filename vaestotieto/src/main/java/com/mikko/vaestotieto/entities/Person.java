package com.mikko.vaestotieto.entities;

import java.util.Objects;
// ALSO TOSTRING, COPY, HASHCODE AND EQUALS - COULD BE ADDED TO ALL CLASSES IF NEEDED
public class Person {
	private Long id;
	private String firstnames;
	private String lastNames;
	private String ssn; // Social Security Number
	private String nationality;

	private Address address;
	private Parents parent1;
	private Parents parent2;
	private PersonMore personMore;
	private Permits permits;

	public Person(Long id, String firstnames, String lastNames, String ssn, String nationality, Address address,
			Parents parent1, Parents parent2, PersonMore personMore, Permits permits) {
		this.id = id; // 1
		this.firstnames = firstnames; // 2
		this.lastNames = lastNames; // 3
		this.ssn = ssn; // 4
		this.nationality = nationality; // 5

		this.address = address; // 6
		this.parent1 = parent1;
		this.parent2 = parent2;// 7
		this.personMore = personMore; // 8
		this.permits = permits; // 9

	}

	public Person() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstnames() {
		return firstnames;
	}

	public void setFirstnames(String firstnames) {
		this.firstnames = firstnames;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getNationality() {
		return nationality;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setParent1(Parents parent1) {
		this.parent1 = parent1;
	}

	public void setParent2(Parents parent2) {
		this.parent2 = parent2;
	}

	public Parents getParent1() {
		return parent1;
	}

	public Parents getParent2() {
		return parent2;
	}

	public PersonMore getPersonMore() {
		return personMore;
	}

	public void setPersonMore(PersonMore personMore) {
		this.personMore = personMore;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Permits getPermits() {
		return permits;
	}

	public void setPermits(Permits permits) {
		this.permits = permits;
	}

	public Person copy() {
		Person copiedPerson = new Person();

		copiedPerson.setId(this.id);
		copiedPerson.setFirstnames(this.firstnames);
		copiedPerson.setLastNames(this.lastNames);
		copiedPerson.setSsn(this.ssn);
		copiedPerson.setNationality(this.nationality);

		// Kopioi osoitetiedot
		Address copiedAddress = new Address();
		Address originalAddress = this.getAddress();
		if (originalAddress != null) {
			copiedAddress.setLocalAddress(originalAddress.getLocalAddress());
			copiedAddress.setPostal(originalAddress.getPostal());
			// rest of the attributes
		}
		copiedPerson.setAddress(copiedAddress);

		Parents copiedParent1 = new Parents();
		Parents originalParent1 = this.getParent1();
		if (originalParent1 != null) {
			copiedParent1.setParentsFirstName(originalParent1.getParentsFirstName());
			copiedParent1.setParentsLastName(originalParent1.getParentsLastName());
			copiedParent1.setParentsBirth(originalParent1.getParentsBirth());
			// rest of the attributes
		}
		copiedPerson.setParent1(copiedParent1);

		Parents copiedParent2 = new Parents();
		Parents originalParent2 = this.getParent2();
		if (originalParent2 != null) {
			copiedParent2.setParentsFirstName(originalParent2.getParentsFirstName());
			copiedParent2.setParentsLastName(originalParent2.getParentsLastName());
			copiedParent2.setParentsBirth(originalParent2.getParentsBirth());

		}
		copiedPerson.setParent2(copiedParent2);

		PersonMore copiedPersonMore = new PersonMore();
		PersonMore originalPersonMore = this.getPersonMore();
		if (originalPersonMore != null) {
			// attributes
		}
		copiedPerson.setPersonMore(copiedPersonMore);

		// Kopioi luvat (Permits)
		Permits copiedPermits = new Permits();
		Permits originalPermits = this.getPermits();
		if (originalPermits != null) {
			// attributes
		}
		copiedPerson.setPermits(copiedPermits);

		return copiedPerson;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstnames=" + firstnames + ", lastNames=" + lastNames + ", ssn=" + ssn
				+ ", nationality=" + nationality + ", address=" + address + ", parent1=" + parent1 + ", parent2="
				+ parent2 + ", personMore=" + personMore + ", permits=" + permits + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, firstnames, id, lastNames, nationality, parent1, parent2, permits, personMore,
				ssn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstnames, other.firstnames)
				&& Objects.equals(id, other.id) && Objects.equals(lastNames, other.lastNames)
				&& Objects.equals(nationality, other.nationality) && Objects.equals(parent1, other.parent1)
				&& Objects.equals(parent2, other.parent2) && Objects.equals(permits, other.permits)
				&& Objects.equals(personMore, other.personMore) && Objects.equals(ssn, other.ssn);
	}

}
