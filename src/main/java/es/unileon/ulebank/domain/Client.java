package es.unileon.ulebank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTS")
public class Client {

	@Id
    @Column(name = "client_id")
	private String clientId;
	
	@Column(name = "name")
	private String name;

	@Column(name = "surnames")
	private String surnames;

	@Column(name = "address")
	private String address;

	@Column(name = "civil_state")
	private float civilState;
	
	@Column(name = "phone_number1")
	private String phoneNumber1;

	@Column(name = "phone_number2")
	private String phoneNumber2;

	@Column(name = "profession")
	private String profession;

	@Column(name = "birth_date")
	private Date birthDate;
	
	@Column(name = "enterprise_name")
	private String enterpriseName;

	@ManyToOne
	@JoinColumn(name = "account_number", insertable = false, updatable = false)
	private Account account;

	public Client(String clientId, String name, String surnames,
			String address, float civilState, String phoneNumber1,
			String phoneNumber2, String profession, Date birthDate,
			String enterpriseName, Account account) {
		this.clientId = clientId;
		this.name = name;
		this.surnames = surnames;
		this.address = address;
		this.civilState = civilState;
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.profession = profession;
		this.birthDate = birthDate;
		this.enterpriseName = enterpriseName;
		this.account = account;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getCivilState() {
		return civilState;
	}

	public void setCivilState(float civilState) {
		this.civilState = civilState;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
