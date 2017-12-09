package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	
	private Date DateProd;
	private String Description;
	private String Name;
	private double Price;   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int ProductPk;
	private int Quantity;
	
	@ManyToOne
	@JoinColumn(name = "CategoryId", nullable = true)
	private Category category ;
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}   
	public Date getDateProd() {
		return this.DateProd;
	}

	public void setDateProd(Date DateProd) {
		this.DateProd = DateProd;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}   
	public double getPrice() {
		return this.Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;
	}   
	public int getProductPk() {
		return this.ProductPk;
	}

	public void setProductPk(int ProductPk) {
		this.ProductPk = ProductPk;
	}   
	public int getQuantity() {
		return this.Quantity;
	}

	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
   
}
