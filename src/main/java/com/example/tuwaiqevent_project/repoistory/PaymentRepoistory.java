package com.example.tuwaiqevent_project.repoistory;

import com.example.tuwaiqevent_project.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepoistory extends JpaRepository<Payment,Integer> {
}
