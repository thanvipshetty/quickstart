package com.example.demo;



import java.time.LocalDate;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;



import com.example.demo.entity.Restaurant;
import com.example.demo.ifaces.RestaurantRepository;
import com.example.demo.service.RestaurantService;



@SpringBootApplication
public class RestaurantServiceApplication {



   public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(RestaurantServiceApplication.class, args);
        RestaurantService service = ctx.getBean(RestaurantService.class)  ;
        int key=3;
        switch (key) {
        case 1:
        	service.findAll().forEach(System.out::println);
        	break;
        case 2:
        	System.out.println(service.findById(20303));
        	break;
        case 3:
        	System.out.println(service.remove(20303));
        	break;
        case 4:
        	Restaurant objToUpdate = ctx.getBean("updateBean",Restaurant.class);
        	System.out.println(service.update(objToUpdate));
        	break;
        case 5:
        	service.findByName("WoodLands").forEach(System.out::println);
        	break;
        case 6:
        	service.fetchUsingLocation("Mangaluru").forEach(System.out::println);
        	break;
        case 7:
        	service.fetchUsingRating(4.7).forEach(System.out::println);
        	break;
        case 8:
        	System.out.println(service.updateRating(23303,4.0));
        	break;
        default:
        	break;
       
       }
        // ctx.getBean(RestaurantService.class).findAll().forEach(System.out::println);
      // System.out.println(service.findById(40303));
    		  ctx.close();
    
    }
   @Bean
   public Restaurant updateBean() {
	  return new Restaurant(40303,"geetha ",4.4,"chennai",LocalDate.of(2022, 10, 24));
   }
    
    @Bean
    public CommandLineRunner runner() {
        
        return new CommandLineRunner() {
            
        @Autowired
        RestaurantRepository repo;
        
            @Override
            public void run(String...args) throws Exception{
                repo.save(new Restaurant(10303,"Sangeetha Upahar",4.4,"chennai",LocalDate.of(2020, 10, 24)));
                repo.save(new Restaurant(30303,"WoodLands",4.8,"Mangaluru",LocalDate.of(2022, 4, 22)));
                repo.save(new Restaurant(40303,"Lands",4.7,"udupi",LocalDate.of(2023, 4, 22)));
                repo.save(new Restaurant(50303,"apollo",4.9,"bangalore",LocalDate.of(2024, 4, 22)));
                
            }
        };
    }
}
