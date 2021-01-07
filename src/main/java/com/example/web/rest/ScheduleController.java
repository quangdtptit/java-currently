package com.example.web.rest;

import com.example.dto.ScheduleDTO;
import com.example.service.DynamicScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final DynamicScheduleService dynamicScheduleService;

    @PostMapping
    public ScheduleDTO create(@RequestBody ScheduleDTO dto) {
        System.out.println("CREATE SCHEDULE: " + dto.getName());
        return dynamicScheduleService.create(dto);
    }

}
