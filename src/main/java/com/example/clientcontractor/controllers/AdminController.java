package com.example.clientcontractor.controllers;

import com.example.clientcontractor.Enum.Profession;
import com.example.clientcontractor.pojos.ProfessionResponse;
import com.example.clientcontractor.pojos.ProfileResponse;
import com.example.clientcontractor.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;



    @GetMapping("/best-client")
    public ResponseEntity<List<ProfileResponse>>getBestClient(
            @RequestParam Date dateStart,
            @RequestParam Date dateEnd)
    {
        return  ResponseEntity.ok(Collections.singletonList(adminService.bestClient(dateStart, dateEnd)));
    }

    @GetMapping("/best-profession")
    public ResponseEntity<ProfessionResponse>getBestProfession(
            @RequestParam Date dateStart,
            @RequestParam Date dateEnd ){
        return  ResponseEntity.ok(adminService.bestProfession(dateStart,dateEnd));
    }

}
