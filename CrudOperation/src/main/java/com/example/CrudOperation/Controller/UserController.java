//package com.example.CrudOperation.Controller;
//import org.springframework.ui.Model;
//import com.example.CrudOperation.Model.User;
//import com.example.CrudOperation.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RestController
//@Controller
//@RequestMapping("/")
//public class UserController {
//
//    public UserController(UserService userservice) {
//        this.userservice = userservice;
//    }
//
//    @Autowired
//    private UserService userservice;
//
//    @GetMapping("/home")
//    public String Users(Model model){
//       List <User> emp =userservice.getAllUsers();
//        model.addAttribute("emp", emp.get(4));
//        return "index";
//    }
//
//
//    @GetMapping("/displayList")
//    public String displayList(Model model) {
//        List<String> fruits = new ArrayList<>();
//        fruits.add("Apple");
//        fruits.add("Banana");
//        fruits.add("Orange");
//        model.addAttribute("fruitList", fruits); // "fruitList" is the attribute name
//        return "displayList"; // Name of your Thymeleaf template
//    }
//
//
//    @PostMapping("/user")
//    public void AddUser(@RequestBody User user){
//        userservice.addUser(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
//        userservice.deleteUser(id);
//        return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User user){
//        user.setId(id);
//        userservice.updateUser(user);
//        return ResponseEntity.ok("User with ID " + id + " updated successfully.");
//    }
//}
