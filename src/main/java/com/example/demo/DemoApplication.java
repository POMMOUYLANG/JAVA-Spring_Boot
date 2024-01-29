package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Addons;
import com.example.demo.model.Product_size;
import com.example.demo.model.User;
import com.example.demo.repository.AddonsRepository;
// import com.example.demo.repository.DrinkRepository;
import com.example.demo.repository.ProductSizeRepository;
// import com.example.demo.service.DrinkSizeService;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private ProductSizeRepository productSizeRepository;

	@Autowired
	private AddonsRepository addonsRepository;

	@Autowired
	private UserRepository userreRepository;


	@Override
	public void run(String... args) throws Exception {
		if(productSizeRepository.count() == 0){
			Product_size product_size_small = new Product_size("small", (float) 0);
			Product_size product_size_medium = new Product_size("medium", (float) 0.25);
			Product_size product_size_large = new Product_size("large", (float) 0.5);
			
			productSizeRepository.save(product_size_small);
			productSizeRepository.save(product_size_medium);
			productSizeRepository.save(product_size_large);
			
		}

		if(addonsRepository.count() == 0) {
			Addons cream = new Addons("cream", 1);
			Addons sugar25 = new Addons("sugar", 25);
			Addons sugar50 = new Addons("sugar", 50);
			Addons sugar75 = new Addons("sugar", 75);
			Addons sugar100 = new Addons("sugar", 100);
			
			addonsRepository.save(cream);
			addonsRepository.save(sugar25);
			addonsRepository.save(sugar50);
			addonsRepository.save(sugar75);
			addonsRepository.save(sugar100);
		}

		if(userreRepository.count() == 0){
			userreRepository.save(new User("admin", "admin", "admin", "admin", null, "admin", "admin", "admin"));
		}
	}

}
