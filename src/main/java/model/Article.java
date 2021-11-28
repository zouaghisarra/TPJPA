package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int code;

	private String designation;

	private float marge;

	private float prixHT;

	private float prixTTC;

	private float remise;

	private float tva;

	public Article() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getMarge() {
		return this.marge;
	}

	public void setMarge(float marge) {
		this.marge = marge;
	}

	public float getPrixHT() {
		return this.prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public float getPrixTTC() {
		return this.prixTTC;
	}

	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}

	public float getRemise() {
		return this.remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
	}

	public float getTva() {
		return this.tva;
	}

	public void setTva(float tva) {
		this.tva = tva;
	}

}