package bold.thread;

import java.util.ArrayList;
import java.util.List;
/*  Spring Annotations Cheat Sheet

1. @Component Annotation
Identifies a class as a Spring component.
Spring automatically detects and registers this class as a bean during component scanning.

2. @Autowired Annotation
Used to inject dependencies automatically into a Spring bean.
Eliminates the need for manual bean wiring.

3. @Qualifier Annotation
Used to disambiguate bean injection when multiple beans of the same type exist.
Specifies which bean should be injected by name.

4. @Primary Annotation
Indicates the primary bean to be used when multiple beans of the same type are present.
Automatically selects this bean for injection if no specific qualifier is provided.

5. @SpringBootApplication
Combination of @Configuration, @ComponentScan, and @EnableAutoConfiguration.
Main entry point for a Spring Boot application.

6. @Bean and @Configuration Annotations
@Bean: Marks a method to produce a bean to be managed by the Spring container.
@Configuration: Indicates that the class contains bean definitions and should be processed by the Spring container to generate bean definitions and service requests for those beans.

7. @Controller, @Service, and @Repository
@Controller: Marks a class as a Spring MVC controller.
@Service: Indicates that a class provides a business service.
@Repository: Marks a class as a data repository, typically used to access the database.

8. @Lazy Annotation
Delays the initialization of a bean until it is first requested.
Useful for optimizing resource usage, especially for beans that are not frequently used.

9. @Scope Annotation
Specifies the scope of a bean.
Defines how long a bean lives and how many instances of a particular bean type can be created.

10. @Value Annotation
Injects values into Spring beans from properties files, environment variables, etc.
Supports resolving placeholders in bean definitions.

11. @PropertySource and @PropertySources Annotations
@PropertySource: Indicates the properties file to be loaded into the Spring Environment.
@PropertySources: Allows multiple property source annotations to be declared.

12. @ConfigurationProperties Annotation
Binds and validates external configuration properties to a bean.
Simplifies the handling of configuration properties in Spring Boot applications.

13. @ResponseBody Annotation
Used in Spring MVC controllers to indicate that the return value of a method should be serialized directly to the HTTP response body.

14. @RestController Annotation
A specialized version of @Controller that is a convenience annotation for creating RESTful controllers.
Combines @Controller and @ResponseBody.

15. @RequestMapping Annotation
Maps HTTP requests to handler methods in Spring MVC controllers.
Defines the URL pattern and HTTP methods that the controller method can handle.

16. @GetMapping Annotation
A specialized version of @RequestMapping for handling HTTP GET requests.

17. @PostMapping and @RequestBody Annotations
@PostMapping: Handles HTTP POST requests.
@RequestBody: Indicates that a method parameter should be bound to the body of the HTTP request.

18. @PutMapping Annotation
Handles HTTP PUT requests.
Maps the HTTP PUT request to the annotated handler method.

19. @DeleteMapping Annotation
Handles HTTP DELETE requests.
Maps the HTTP DELETE request to the annotated handler method.

20. @PathVariable Annotation
Used to extract values from the URI template.
Binds the method parameter to the value of the URI template variable.

21. @RequestParam Annotation
Binds the parameters of a web request to a method parameter in a Spring MVC controller.
Used to extract query parameters from the URL.

22. @EnableAutoConfiguration
Enables Spring Boot's auto-configuration feature.
Automatically configures the Spring application based on classpath settings, other beans, and various property settings.

23. @ComponentScan
Instructs Spring to scan and detect other Spring components (such as @Component, @Controller, @Service, etc.) in the specified package and its sub-packages.*/


class SharedResource{

    private volatile int counter;

    public synchronized void increment(){
        counter++;
    }

    public synchronized int getCounter(){
        return counter;
    }
}

class MyThread extends Thread{
    private SharedResource sharedResource;

    public MyThread(String name, SharedResource sharedResource) {
        super(name);
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" started");

        //using sleep
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        //using syncronized block
        synchronized (sharedResource){
            sharedResource.increment();
            System.out.println(Thread.currentThread().getName() +"incremented counter:" +sharedResource.getCounter());

        }


        //using wait and notify

        if(Thread.currentThread().getName().equals("Thread-1")){
            synchronized (sharedResource){
                try{
                    System.out.println(Thread.currentThread().getName() +" waiting...");
                    sharedResource.wait();
                    System.out.println(Thread.currentThread().getName() +"notified, counter: "+sharedResource.getCounter());

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        } else if(Thread.currentThread().getName().equals("Thread-2")){
            try{
                Thread.sleep(2000);
                sharedResource.notify();
                System.out.println(Thread.currentThread().getName() +"notified thread 1");

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        //using yield
        Thread.yield();
        System.out.println(Thread.currentThread().getName() +"after yield");

        //using join
        if(Thread.currentThread().getName().equals("Thread-3")){
            try{
                Thread thread4 = new MyThread("Thread-4", sharedResource);
                thread4.start();
                thread4.join();
                System.out.println(Thread.currentThread().getName() +"joined Thread-4");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }



    }



}
public class Main {
    public static void main(String[] args) {


        SharedResource sharedResource = new SharedResource();

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Thread thread = new MyThread("Thread-" + i, sharedResource);
            threads.add(thread);
            thread.start();
        }
        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Main thread finished.");
    }
}
