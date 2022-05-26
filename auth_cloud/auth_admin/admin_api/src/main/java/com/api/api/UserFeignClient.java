package com.api.api;
import com.api.dto.UserAuthDTO;
import com.bases.restult.ResultResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName : { UserFeignClient }
 * @Author : {whisper}
 * @Date : {Created in 16:51 2022/1/30}
 */
@SuppressWarnings("all")
@FeignClient(value = "admin-boot")
@Service
public interface UserFeignClient {
    /**
     * 根据用户名获取用户信息的feign
     * @param username
     * @return
     */
    @GetMapping("/api/v1/users/username/{username}")
    ResultResponse<UserAuthDTO> getUserByUsername(@PathVariable String username);
}
