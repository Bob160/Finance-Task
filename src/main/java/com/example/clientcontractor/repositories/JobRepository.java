package com.example.clientcontractor.repositories;

import com.example.clientcontractor.Enum.PaymentStatus;
import com.example.clientcontractor.Enum.Profession;
import com.example.clientcontractor.model.Job;
import com.example.clientcontractor.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {
   @Query(nativeQuery = true, value = "SELECT * from jobs where client_email=email OR contractor_email=email AND paymentStatus=paymentStatus" )
   List<Job> findAllByIdOrPaymentStatus(Long id, PaymentStatus paymentStatus);

   @Query("SELECT j.profession " +
           "FROM Job j " +
           "WHERE j.paymentStatus = 'PAID' AND j.started >= :started AND j.completed <= :completed " +
           "GROUP BY j.profession.id" +
           "ORDER BY SUM(j.budget) DESC")
   List<Profession> findTopJobsByDates(@Param("startDate") Date started,
                                   @Param("endDate") Date completed);

   @Query("SELECT j.contract.client " +
           "FROM Job j " +
           "WHERE j.paymentStatus = 'PAID' AND j.started >= :started AND j.completed <= :completed " +
           "GROUP BY j.profession.id " +
           "ORDER BY SUM(j.budget) DESC")
   List<Profile> findTopClientByDates(@Param("startDate") Date started,
                                      @Param("endDate") Date completed);

   List<Job> findAllByPaymentStatus(PaymentStatus paymentStatus);

   Optional<Job> findById (Long id);


}
