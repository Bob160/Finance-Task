package com.example.clientcontractor.model;

import com.example.clientcontractor.Enum.PaymentStatus;
import com.example.clientcontractor.Enum.Profession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {

    @Id
    private Long id;
    @NotBlank(message = "Please enter a job name")
    private String name;

    @NotBlank(message = "Please enter a budget for your job")
    private BigDecimal budget;

    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn
    @Enumerated(EnumType.STRING)
    private Profession profession;
    private Date started;
    private Date completed;

}
