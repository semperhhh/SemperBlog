package com.zph.listener;

import cn.hutool.system.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MainEventListener implements ApplicationListener {

    @Value("8091")
    private Integer port;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //程序已经启动
        if (applicationEvent instanceof ApplicationStartedEvent) {

            String address = SystemUtil.getHostInfo().getAddress();
            //url打印
            log.info("访问地址: http://{}:{}", address, port);
        }
    }
}
