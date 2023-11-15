package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car(1,"BMW");
      Car car2 = new Car(2,"Mersedes");
      Car car3 = new Car(3, "Bugatti");
      Car car4 = new Car(4, "Kamaz");

      User u1 = new User("Name1", "lastName1", "email1");
      User u2 = new User("Name2", "lastName2", "email2");
      User u3 = new User("Name3", "lastName3", "email3");
      User u4 = new User("Name4", "lastName4", "email4");

      u1.setCar(car1);
      u2.setCar(car2);
      u3.setCar(car3);
      u4.setCar(car4);

      userService.add(u1);
      userService.add(u2);
      userService.add(u3);
      userService.add(u4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car is " + user.getCar());
         System.out.println();
      }

      System.out.println("-----------------------------------------");
      System.out.println(userService.userByCar(4, "Kamaz"));
      System.out.println("-----------------------------------------");

      context.close();
   }
}
