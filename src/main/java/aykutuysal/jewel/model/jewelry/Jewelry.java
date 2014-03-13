package aykutuysal.jewel.model.jewelry;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Jewelries")
public class Jewelry implements Serializable {

	private static final long serialVersionUID = 8434558645119510876L;

	@Id
    @GeneratedValue
	private Long id;

	@NotNull
	private JewelryType type;
	
	private Long weight;
	
	private String imagePath;
	
	private Long price;
	
	private String notes;
	
	private JewelryStatus status;

	public Jewelry() {
		this.status = JewelryStatus.ACTIVE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public JewelryType getType() {
		return type;
	}

	public void setType(JewelryType type) {
		this.type = type;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public JewelryStatus getStatus() {
		return status;
	}

	public void setStatus(JewelryStatus status) {
		this.status = status;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Jewelry [id=" + id + ", type=" + type + ", weight=" + weight
				+ ", imagePath=" + imagePath + ", price=" + price + ", notes="
				+ notes + ", status=" + status + "]";
	}

}
