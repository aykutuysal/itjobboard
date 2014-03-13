package aykutuysal.itjobboard.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Companies")
public class Company implements Serializable {

	private static final long serialVersionUID = 2517818741423059466L;

	@Id
    @GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private List<Listing> listings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Listing> getListings() {
		return listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}
	
}
