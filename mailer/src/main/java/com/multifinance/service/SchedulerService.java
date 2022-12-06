package com.multifinance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class SchedulerService {

    @Autowired
    private ApplStatService applStatService;

    @Scheduled(cron="${repayment.scheduler.appl.cron}")
    public void executeApplJob() {
        applStatService.expiringIdleApplStat();
        applStatService.expiringMaxApplStat();
        applStatService.notifApplStat();
    }
}
