package com.example.service.impl;

import com.example.dto.CloseScheduleDTO;
import com.example.dto.ScheduleDTO;
import com.example.service.DynamicScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class DynamicScheduleServiceImpl implements DynamicScheduleService {

    private final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    @Override
    public ScheduleDTO create(ScheduleDTO dto) {
        ScheduledFuture<?> beepHandler = scheduledThreadPoolExecutor.scheduleAtFixedRate(dto, dto.getStartTime().longValue(), dto.getIdLoop().longValue(), TimeUnit.SECONDS);
        CloseScheduleDTO closeScheduleDTO = new CloseScheduleDTO(beepHandler);
        scheduledThreadPoolExecutor.schedule(closeScheduleDTO, dto.getEndTime().longValue(), TimeUnit.SECONDS);
        return dto;
    }
}
