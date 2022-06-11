package com.example.tuwaiqevent_project.servies;

import com.example.tuwaiqevent_project.exceptions.InvalidException;
import com.example.tuwaiqevent_project.model.Event;
import com.example.tuwaiqevent_project.model.Payment;
import com.example.tuwaiqevent_project.model.User;
import com.example.tuwaiqevent_project.repoistory.PaymentRepoistory;
import com.example.tuwaiqevent_project.repoistory.UserRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServies {

    private final PaymentRepoistory paymentRepoistory;
   private final UserServies userServies;

    public List<Payment> getAllPayment(){

        return paymentRepoistory.findAll();
    }
    public Payment getOnePayment(Integer id){

        return paymentRepoistory.findById(id).orElseThrow(()->{
            throw new InvalidException("Payment id is incorrect!");
        });
    }
    public boolean addPayment(Payment payment,Integer userid,Double price){
        Double b;
        Optional<User>currentuser=userServies.getOneUser(userid);
        if (currentuser.isEmpty()) {
            return false;
        }

        if(payment.getBalance()<=price){
            return false;
        }
        b=payment.getBalance()-price;
        payment.setUser(currentuser.get());
        paymentRepoistory.save(payment);
        return true;

    }
}
