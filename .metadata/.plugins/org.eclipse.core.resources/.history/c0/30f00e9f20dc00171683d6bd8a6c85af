package tn.esprit.volunteering.volunteering.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int CategoryId;
	private String Name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> Products ;
	
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}   
	public int getCategoryId() {
		return this.CategoryId;
	}

	public void setCategoryId(int CategoryId) {
		this.CategoryId = CategoryId;
	}   
	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
   
}
