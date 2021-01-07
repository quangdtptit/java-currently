package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.ScheduledFuture;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CloseScheduleDTO implements Runnable {

    private ScheduledFuture scheduledFuture;

    @Override
    public void run() {
        scheduledFuture.cancel(true);
    }
}
