package com.example.clientcontractor.controllers;

import com.example.clientcontractor.dto.PaymentRequestDto;
import com.example.clientcontractor.pojos.JobResponse;
import com.example.clientcontractor.pojos.PaymentResponse;
import com.example.clientcontractor.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    public final JobService jobService;

    @GetMapping("/unpaid-jobs")
    public ResponseEntity<List<JobResponse>> getUnpaidJobs() {
        return ResponseEntity.ok(jobService.getUnpaidJobs());
    }

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> payForAJob(@RequestBody PaymentRequestDto paymentRequestDto) {
        return ResponseEntity.ok(jobService.payForAJob(paymentRequestDto.getJobId()));
    }


}
