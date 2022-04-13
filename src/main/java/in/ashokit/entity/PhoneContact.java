package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@XmlRootElement
@Table(name="CONTACT_DETAILS")
public class PhoneContact {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="CREATE_DATE",updatable=false)
	@CreationTimestamp
	private LocalDate createDate;

	@Column(name="UPDATE_DATE",insertable=false)
	@UpdateTimestamp
	private LocalDate updatedDate;

	@Column(name="ACTIVE_SW")
	private String activeSw;
}
