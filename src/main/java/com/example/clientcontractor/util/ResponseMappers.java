package com.example.clientcontractor.util;

import com.example.clientcontractor.model.Contract;
import com.example.clientcontractor.model.Job;
import com.example.clientcontractor.model.Profile;
import com.example.clientcontractor.pojos.ContractResponse;
import com.example.clientcontractor.pojos.JobResponse;
import com.example.clientcontractor.pojos.ProfileResponse;

import java.util.stream.Collectors;

public class ResponseMappers {

    public static ProfileResponse profileMap (Profile profile) {
        return ProfileResponse.builder()
                .id(profile.getId())
                .firstName(profile.getFirstName())
                .lastName(profile.getLastName())
                .email(profile.getEmail())
                .build();
    }

    public static JobResponse jobMap (Job job) {
        return JobResponse.builder()
                .id(job.getId())
                .name(job.getName())
                .contractId(job.getId())
                .build();
    }

    public static ContractResponse contractMap (Contract myContract) {
        return ContractResponse.builder()
//                .name(myContract)
//                .contractStatus(myContract)
//                .clientProfile(profileMap(myContract.getClient))
//                .contractor(profileMap(myContract.getContractor))
//                .jobs(myContract.getJobs)

                .name(myContract.getName())
                .contractor(profileMap(myContract.getContractor()))
                .contractStatus(myContract.getStatus())
                .clientProfile(profileMap(myContract.getClient())
                .jobs(myContract.getJobs()));
    }
}
