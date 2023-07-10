package in.sp.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController
{
	@GetMapping("/addProducts")
	public String openAddProductsPage()
	{
		return "add-products";
	}
}
