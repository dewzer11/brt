package northwind.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.omnifaces.util.Messages;


import northwind.data.ProductRepository;
import northwind.model.Product;

@Model
public class ProductController {

	@Inject
	private ProductRepository productRepository;
	
	private List<Product> products;
	
	@PostConstruct
	void init() {
		products = productRepository.findAll();
	}

	public List<Product> getProducts() {
		return products;
	}
	private List<Product> productsByCategory;	// getter
	private int currentSelectedCategoryId;	// getter/setter
//	private category currentSelectedcategory;	// getter
	
	public void findProductsByCategory() {
		if( !FacesContext.getCurrentInstance().isPostback() ) {
			// verify that a valid categoryId was set
			if( currentSelectedCategoryId > 0) {
				productsByCategory = productRepository.findAllByCategoryId(currentSelectedCategoryId);
				if( productsByCategory.size() == 0 ) {
					Messages.addGlobalInfo("There are no products for categoryID {0}", 
							currentSelectedCategoryId);
				}
			} else {
				Messages.addGlobalError("Bad request. A valid categoryID is required.");
			}
		}
	}

	public int getCurrentSelectedCategoryId() {
		return currentSelectedCategoryId;
	}

	public void setCurrentSelectedCategoryId(int currentSelectedCategoryId) {
		this.currentSelectedCategoryId = currentSelectedCategoryId;
	}

	public List<Product> getproductsByCategory() {
		return productsByCategory;
	}
	
	
}