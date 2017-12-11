package camt.cbsd.lab05.config;

import camt.cbsd.lab05.dao.cart.CartDao;
import camt.cbsd.lab05.dao.customer.CustomerDao;
import camt.cbsd.lab05.dao.product.ProductDao;
import camt.cbsd.lab05.dao.shopkeeper.ShopkeeperDao;
import camt.cbsd.lab05.entity.security.Customer;
import camt.cbsd.lab05.entity.security.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@ConfigurationProperties(prefix = "server")
@Component
public class DataLoader implements ApplicationRunner {
    /*StudentDao studentDao;
    User user1, user2, user3;

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    CourseDao courseDao;

    String baseUrl;
    String imageUrl;
    String imageBaseUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }*/

    ProductDao productDao;
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    CustomerDao customerDao;

    @Autowired
    ShopkeeperDao shopkeeperDao;

    @Autowired
    CartDao cartDao;

    String baseUrl;
    String imageUrl;
    String imageBaseUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        imageBaseUrl = baseUrl + imageUrl;
        Product product1 = Product.builder().productId("CC-01").
                name("Durian Mask Cake").image("durianCake.png").price(480).
                description("1 pound: vanilla layer with durian cream.").build();
        Product product2 = Product.builder().productId("CC-02").
                name("Pony Mask Cake").image("ponyCake.png").price(480).
                description("1 pound: vanilla layer with strawberry cream.").build();
        Product product3 = Product.builder().productId("CC-03").
                name("Samurai Mask Cake").image("samuraiCake.png").price(480).
                description("1 pound: hokkaido milk flavor.").build();
        Product product4 = Product.builder().productId("CC-04").
                name("Sumo Mask Cake").image("sumoCake.png").price(480).
                description("1 pound: hokkaido milk flavor.").build();

        Customer customer1 = Customer.builder().customerId("CT-01").name("Little Bunny").
                email("tt_bn@gmail.com").phonenumber("+66 90 5500 555").build();
        Customer customer2 = Customer.builder().customerId("CT-02").name("Dove Cameron").
                email("ifOnly@gmail.com").phonenumber("+66 90 9900 999").build();

        /*Shopkeeper shopkeeper1 = Shopkeeper.builder().shopkeeperId("SK-01").
                name("Shawn Mendes").email("believe@gmail.com").build();
        Shopkeeper shopkeeper2 = Shopkeeper.builder().shopkeeperId("SK-02").
                name("The Vamps").email("sbToU@gmail.com").build();
*/
        productDao.addProduct(product1);
        productDao.addProduct(product2);
        productDao.addProduct(product3);
        productDao.addProduct(product4);
        customerDao.addCustomer(customer1);
        customerDao.addCustomer(customer2);
/*        shopkeeperDao.addShopkeeper(shopkeeper1);
        shopkeeperDao.addShopkeeper(shopkeeper2);*/



        /*Student student1 = Student.builder().studentId("SE-001").name("Mitsuha").surname("Miyamizu")
                .gpa(2.15).image(imageBaseUrl + "mitsuha.gif").feature(true)
                .penAmount(0).description("The most beloved one").build();
        Student student2 = Student.builder().studentId("SE-002").name("Prayuth").surname("The minister")
                .gpa(3.59).image(imageBaseUrl + "tu.jpg").feature(false)
                .penAmount(15).description("The great man ever!!!!").build();
        Student student3 = Student.builder().studentId("SE-003").name("Jurgen").surname("Kloop")
                .gpa(2.15).image(imageBaseUrl + "Kloop.gif").feature(true)
                .penAmount(2).description("The man for the Kop").build();

        Course course1 = Course.builder().courseId("953331").courseName("CBSD").build();
        Course course2 = Course.builder().courseId("953323").courseName("Software Construction").build();
        Course course3 = Course.builder().courseId("953499").courseName("Software Project").build();

        courseDao.add(course1);
        courseDao.add(course2);
        courseDao.add(course3);
        studentDao.addStudent(student1);
        studentDao.addStudent(student2);
        studentDao.addStudent(student3);

        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course2);
        student2.addCourse(course3);
        student3.addCourse(course1);
        student3.addCourse(course3);
        securitySetup();

        student1.setUser(user1);
        user1.setStudent(student1);
        student2.setUser(user2);
        user2.setStudent(student2);
        student3.setUser(user3);
        user3.setStudent(student3);*/
    }


    private void securitySetup() {
        /*Authority auth1 = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        authorityRepository.save(auth1);
        authorityRepository.save(auth2);*/

        /*user1 = User.builder()
                .username("admin")
                .password("admin")
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password("user")
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("disabled")
                .password("disabled")
                .firstname("user")
                .lastname("user")
                .email("disabled@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user1.setAuthorities(new ArrayList<>());
        user1.getAuthorities().add(auth1);
        user1.getAuthorities().add(auth2);
        user2.setAuthorities(new ArrayList<>());
        user2.getAuthorities().add(auth1);
        user3.setAuthorities(new ArrayList<>());
        user3.getAuthorities().add(auth1);

        userRepository .save(user1);
        userRepository .save(user2);
        userRepository .save(user3);*/
    }
}


