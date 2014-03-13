package aykutuysal.jewel.model.dto;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import aykutuysal.jewel.model.jewelry.Jewelry;
import aykutuysal.jewel.model.jewelry.JewelryType;

public class JewelryForm {

	private JewelryType type;
	
	private Long weight;
	
	private Long price;
	
	private String notes;
	
	@NotNull
	private CommonsMultipartFile imageData;

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

	public CommonsMultipartFile getImageData() {
		return imageData;
	}

	public void setImageData(CommonsMultipartFile imageData) {
		this.imageData = imageData;
	}
	
	public Jewelry convertToJewelry() {
		Jewelry jewel = new Jewelry();
		jewel.setNotes(this.notes);
		jewel.setPrice(this.price);
		jewel.setType(this.type);
		jewel.setWeight(this.weight);
		return jewel;
	}
}
