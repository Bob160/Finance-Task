package com.example.clientcontractor.services;

import com.example.clientcontractor.dto.ProfileDto;
import com.example.clientcontractor.model.Profile;
import com.example.clientcontractor.pojos.ProfessionResponse;
import com.example.clientcontractor.pojos.ProfileResponse;

import java.util.Date;


public interface AdminService {
//Profile signUp(ProfileDto profileDto);
//
//ProfileDto login(String email, String password);

    ProfileResponse bestClient(Date dateStart, Date dateEnd);

    ProfessionResponse bestProfession(Date dateStart, Date dateEnd);



}
