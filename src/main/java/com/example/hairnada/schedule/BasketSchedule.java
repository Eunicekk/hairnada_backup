package com.example.hairnada.schedule;

import com.example.hairnada.service.user.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class BasketSchedule {
    @Autowired
    private BasketService basketService;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkRemove(){
        basketService.removeAfter30();
        System.out.println("30일 이전에 담은 장바구니 항목이 성공적으로 삭제되었습니다.");
    }
}
