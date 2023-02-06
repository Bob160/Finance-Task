package com.example.clientcontractor.model;

import com.example.clientcontractor.Enum.ContractStatus;
import com.example.clientcontractor.Enum.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    private Long id;

    @NotBlank(message = "Please enter a contract name")
    private String name;

    @OneToMany
    private List<Job> jobs;

    @Enumerated(EnumType.STRING)
    private ContractStatus status;

    @ManyToOne
    @JoinColumn
    private UserType client;

    @ManyToOne
    @JoinColumn
    private UserType contractor;
}
