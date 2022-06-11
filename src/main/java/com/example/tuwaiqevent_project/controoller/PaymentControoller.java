
package com.example.tuwaiqevent_project.controoller;


import com.example.tuwaiqevent_project.model.Admin;
import com.example.tuwaiqevent_project.model.Payment;
import com.example.tuwaiqevent_project.servies.AdminServies;
import com.example.tuwaiqevent_project.servies.PaymentServies;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/payment")
public class PaymentControoller {
    Logger log=LoggerFactory.getLogger(PaymentControoller.class);

    private final PaymentServies paymentServies;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment() {
        log.info("Payment are return by through getAllPayment()");

        return ResponseEntity.status(201).body(paymentServies.getAllPayment());
    }

    @PostMapping("/{userid}/{price}")
    public ResponseEntity addPayment(@RequestBody Payment payment,@PathVariable Integer userid,@PathVariable Double price) {
        log.info("Payment are added by through addPayment()");

        boolean ischeck=paymentServies.addPayment(payment,userid,price);
        if(ischeck!=true){
            return ResponseEntity.status(200).body("can't Payment !");
        }
        return ResponseEntity.status(200).body("Payment added!");
    }





}
