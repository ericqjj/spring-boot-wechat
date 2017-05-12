package com.wechat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/**
 * Created by hztps on 2017/5/11.
 */
@Configuration
@ComponentScan(basePackages={"com.wechat.service","com.wechat.controller"})
@Import(value={MybatisPlusConfig.class})
public class SpringConfig {

}

