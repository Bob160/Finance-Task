package com.example.clientcontractor.serviceImpl;

import com.example.clientcontractor.Enum.Profession;
import com.example.clientcontractor.dto.ProfileDto;
import com.example.clientcontractor.model.Profile;
import com.example.clientcontractor.pojos.ProfessionResponse;
import com.example.clientcontractor.pojos.ProfileResponse;
import com.example.clientcontractor.repositories.JobRepository;
import com.example.clientcontractor.services.AdminService;
import com.example.clientcontractor.util.ResponseMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final JobRepository jobRepository;
    @Override
    public ProfessionResponse bestProfession(Date dateStart, Date dateEnd) {

        Profession myProfession = jobRepository.findTopJobsByDates(dateStart, dateEnd).get(0);
        return ProfessionResponse.builder()
                .id(myProfession.getId())
                .name(myProfession.getName())
                .build();

    }

    @Override
    public ProfileResponse bestClient(Date dateStart, Date dateEnd) {
        return jobRepository.findTopClientByDates(dateStart, dateEnd)
                .stream()
                .limit(limit)
                .map(ResponseMappers::profileMap)
                .collect(Collectors.toList());
    }
}
