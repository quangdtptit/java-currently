package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleDTO implements Runnable {

    private Integer id;
    private String name;
    private String code;
    private Long startTime;
    private Long endTime;
    private Integer idLoop;
    private String output;
    private Boolean isActive;

    @Override
    public void run() {
        System.out.println(LocalDateTime.now() + " | " + Thread.currentThread().getName() + " | " + output);
    }
}
