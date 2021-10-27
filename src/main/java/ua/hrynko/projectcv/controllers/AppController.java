package ua.hrynko.projectcv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.hrynko.projectcv.db.dao.MySqlCarsDAO;
import ua.hrynko.projectcv.db.models.Cars;
import ua.hrynko.projectcv.db.models.Roles;
import ua.hrynko.projectcv.db.models.Users;
import ua.hrynko.projectcv.servise.interfaces.RoleService;
import ua.hrynko.projectcv.servise.interfaces.UserService;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.sort;


@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private MySqlCarsDAO mySqlCarsDAO;




    @RequestMapping(value = {"/", "welcome"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage() {
        return new ModelAndView("welcome");
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }


    @GetMapping("/loginingPage")
    public ModelAndView loginingPage() {
        return new ModelAndView("logining_page");
    }

    @GetMapping("/adminPageUsers")
    public ModelAndView adminPageUsers() {
        ModelAndView model = new ModelAndView();
        List<Users> userList = userService.getAll();
        model.addObject("userList", userList);
        model.setViewName("admin_page_users");
        return model;
    }


    @GetMapping("/adminPageAddNewAdmin")
    public ModelAndView adminPageAddNewAdmin() {
        return new ModelAndView("admin_page_add_new_admin");
    }

    //admin_page_update_car

    @PostMapping("/removeCar")
    public String removeCar(@RequestParam("removeButt") String carId,
                            ModelMap model) {
        int id = Integer.parseInt(carId);
        Users user = new Users();
        user = userService.getById(id);
        userService.delete(user);
        ModelAndView models = new ModelAndView();
        List<Cars> carsItems = mySqlCarsDAO.findCars();
        models.addObject("carsItems", carsItems);
        models.setViewName("admin_page");
        return "admin_page";
    }

    @GetMapping("/forRegistered")
//    public ModelAndView forRegistered() {
//        ModelAndView model = new ModelAndView();
//        List<Cars> carsItems = mySqlCarsDAO.findCars();
//        model.addObject("carsItems", carsItems);
//        model.setViewName("admin_page");


//        List<Cars> carsItems = mySqlCarsDAO.findCars();
//        model.addObject("carsItems", carsItems);
//        model.setViewName("client_page_list_car");
//
//        return model;


    public ModelAndView forRegistered() {
        ModelAndView model = new ModelAndView();
        if (hasRole("ROLE_ADMIN")) {
            List<Cars> carsItems = mySqlCarsDAO.findCars();
            model.addObject("carsItems", carsItems);
            model.setViewName("admin_page");
        } else if (hasRole("ROLE_USER")) {
            List<Cars> carsItems = mySqlCarsDAO.findCars();
            model.addObject("carsItems", carsItems);
            model.setViewName("client_page_list_car");
        }
        else {
            model.setViewName("login");
        }
        return model;
    }

    @GetMapping("/sortedUpPrice")
    public ModelAndView sortedUpPrice() {
        ModelAndView model = new ModelAndView();
        List<Cars> carsItems = mySqlCarsDAO.findCars();
        sort(carsItems, (o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        model.addObject("carsItems", carsItems);
        model.setViewName("client_page_list_car");

        return model;
    }

    @GetMapping("/sortedDownPrice")
    public ModelAndView sortedDownPrice() {
        ModelAndView model = new ModelAndView();
        List<Cars> carsItems = mySqlCarsDAO.findCars();
        carsItems.sort((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
        model.addObject("carsItems", carsItems);
        model.setViewName("client_page_list_car");

        return model;
    }

    @GetMapping("/sortedUpName")
    public ModelAndView sortedUpName() {
        ModelAndView model = new ModelAndView();
        List<Cars> carsItems = mySqlCarsDAO.findCarSortedUpByName();
        model.addObject("carsItems", carsItems);
        model.setViewName("client_page_list_car");

        return model;
    }

    @GetMapping("/sortedDownName")
    public ModelAndView sortedDownName() {
        ModelAndView model = new ModelAndView();
        List<Cars> carsItems = mySqlCarsDAO.findCarSortedDownByName();
        model.addObject("carsItems", carsItems);
        model.setViewName("client_page_list_car");

        return model;
    }

    @PostMapping("/selectByClass")
    public String selectByClass(@RequestParam("selectClass") String selectClass,
                                ModelMap model) {
        List<Cars> carsItems = mySqlCarsDAO.selectCarsByCategory(selectClass);
        model.addAttribute("carsItems", carsItems);
        return "client_page_list_car";
    }

    @PostMapping("/makeOrder")
    public String makeOrder(@RequestParam("makeOrderById") String makeOrderById,
                            ModelMap model) {
        model.addAttribute("car", mySqlCarsDAO.findCarToCarsDb(Integer.parseInt(makeOrderById)));
        return "list_car_order";

    }

    @PostMapping("/toPay")
    public String makeOrder(@RequestParam("days") String days,
                            @RequestParam("payPrice") String payPrices,
                            ModelMap model) {

        model.addAttribute("daysReturn", days);
        model.addAttribute("payPriceReturn", payPrices);

        return "client_page_to_pay";
    }


    @PostMapping("/addAdmin")
    public String createAdmin(@RequestParam("addLoginAdmin") String login,
                              @RequestParam("addPasswordAdmin") String password,
                              @RequestParam("addFirstNameAdmin") String firstName,
                              @RequestParam("addLastNameAdmin") String lastName,
                              ModelMap model) {
        Users user = new Users();
        Roles role = new Roles();
        role.setId(1);
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);

        userService.save(user);

        return "admin_page";
    }

//    @PostMapping("/create_update")
//    public String createOrUpdateUser(@RequestParam("userId") String userId,
//                                     @RequestParam("login") String login,
//                                     @RequestParam("password") String password,
//                                     @RequestParam("firstName") String firstName,
//                                     @RequestParam("lastName") String lastName,
//                                     ModelMap model) {
//        Users user;
//        String message = null;
//        int id = Integer.parseInt(userId);
//
//        if (id == 0) {
//            user = new Users();
//        } else {
//            user = userService.getById(id);
//        }
//
//        user.setLogin(login);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setRoleId(1);
//        if (!password.isEmpty()) {
//            user.setPassword(encoder.encode(password));
//        }
//
//
//        if (id == 0) {
//            try {
//                userService.save(user);
//                message = "User has been created";
//            } catch (Exception e) {
//                message = "The system could not create a new user!";
//            }
//        }
//        model.addAttribute("message", message);
//        return "welcome";
//    }


    private boolean hasRole(String role) {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals(role);
            if (hasRole) {
                break;
            }
        }
        return hasRole;
    }
}
