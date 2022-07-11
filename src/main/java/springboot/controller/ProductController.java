package net.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import net.springboot.model.Product;

import net.springboot.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ProductService;
	
	// display list of employees
	
		@GetMapping("/")
		public String viewHomePage(Model model) {
			return findPaginated(1, "productName", "asc", model);		
		}
		
	
	@GetMapping("/showProductForm")
	public String showNewProductForm(Model model) {
		// create model attribute to bind form data
		Product product = new Product();
		model.addAttribute("Product", product);
		return "new_product";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("Product") Product product) {
		// save employee to database
		ProductService.saveProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/Product/{id}")
	public String Product(@PathVariable (value = "id") String id) {
		
		// call delete employee method 
		this.ProductService.deleteProductById(id);
		return "redirect:/";
	}
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Product> page = ProductService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Product> listProduct = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		
		model.addAttribute("listProduct", listProduct);
		return "index";
	}
	
	@GetMapping("/deleteProduct/{id}")
    public String deleteproduct(@PathVariable (value = "id") String id) {

       
        this.ProductService.deleteProductById(id);
        return "redirect:/";
    }
}
