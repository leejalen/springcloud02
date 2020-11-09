package com.example.customerfeignhystrix9003.feign;

import com.example.customerfeignhystrix9003.controller.dto.SpClassDTO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created on 2020/11/9
 * @author leejalen
 */
@Component
@Slf4j
public class HystrixFallbackFactory implements FallbackFactory<FeignClientService> {

    @Override
    public FeignClientService create(Throwable throwable) {

        return new FeignClientService(){

            @Override
            public void getProviderClass() {
                log.info("服务器跪了，迟到点来吧");
            }

            @Override
            public String getProviderClassById(String id) {
                SpClassDTO spClassDTO = new SpClassDTO();
                spClassDTO.setClassId(id);
                spClassDTO.setClassName("服务器跪了");
                spClassDTO.setSchoolId("晚点来吧");
                return spClassDTO.toString();
            }
        };
    }
}
