//package com.boots.listener;
//
//import com.ams.admin.service.ISysPermissionService;
//import lombok.AllArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName : { InitResourcePermissionCache }
// * @Author : {whisper}
// * @Date : {Created in 17:15 2022/1/30}
// * 添加启动监听器
// * 初始化角色权限
// */
//@Component
//@AllArgsConstructor
//public class InitResourcePermissionCache implements CommandLineRunner {
//
//    private ISysPermissionService iSysPermissionService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        iSysPermissionService.refreshPermRolesRules();
//    }
//}
