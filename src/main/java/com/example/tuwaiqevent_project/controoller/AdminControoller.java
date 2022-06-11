package com.example.tuwaiqevent_project.controoller;


import com.example.tuwaiqevent_project.model.Admin;
import com.example.tuwaiqevent_project.model.Api;
import com.example.tuwaiqevent_project.model.Event;
import com.example.tuwaiqevent_project.servies.AdminServies;
import com.example.tuwaiqevent_project.servies.EventServies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/admin")
public class AdminControoller {
    Logger log=LoggerFactory.getLogger(AdminControoller.class);
    private final AdminServies adminServies;

    @GetMapping("/getalladmain")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        log.info("Admin are return by through getAllAdmin()");

        return ResponseEntity.status(201).body(adminServies.getAllAdmin());
    }

    @GetMapping("/viewdetailsuser/{eventid}")
    public ResponseEntity viewDetailsUser(@PathVariable Integer eventid) {
        log.info("Admin are view Detail sUser");

        return ResponseEntity.status(201).body(adminServies.viewDetails(eventid));
    }

    @GetMapping("/admins")
    public ResponseEntity<?> LoginAdmin() {
        log.info("Admin are login by through LoginAdmin()");

        return ResponseEntity.status(200).body(new Api("Welcome Admin",200));
    }

    @PostMapping("/register")
    public ResponseEntity addAdmin(@RequestBody Admin admin, Errors errors) {
        log.info("Admin are register by through addAdmin()");

        if(errors.hasErrors()) {
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new Api(massage,400));
        }
        adminServies.addAdmin(admin);
        return ResponseEntity.status(200).body("Admin added!");

    }
   @PutMapping("/updateadmin")
    public ResponseEntity UpdateAdmin(@RequestBody Admin admin) {
       log.info("Admin are Update by through UpdateAdmin()");

       boolean ischeck=adminServies.Update(admin);
        if(ischeck!=true){
      return ResponseEntity.status(400).body("Admin can't Update!");

        }
        return ResponseEntity.status(200).body("Admin Update!");
    }


    @DeleteMapping("/deleteAdmin/{adminid}")
    public ResponseEntity deleteAdmin(@PathVariable Integer adminid){

        log.info("Admin are delete by through deleteAdmin()");

        boolean ischeck=adminServies.delete(adminid);
        if (ischeck!=true){
            return ResponseEntity.status(400).body("Admin can't delete!");

        }
        return ResponseEntity.status(200).body("Admin  delete!");


    }


}
