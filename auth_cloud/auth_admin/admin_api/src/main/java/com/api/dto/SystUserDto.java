package com.api.dto;

import com.api.group.GroupBy;
import com.bases.annotate.NotnullAll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.api.dto"}
 * @ClassName: {"classname":"SystUserDto"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/253:12"}
 */
@Data
@Builder
@SuppressWarnings("all")
@NoArgsConstructor
@AllArgsConstructor

public class SystUserDto {

    @NotnullAll(message = "{SystUserDto.name.mess}",groups = GroupBy.class)
    private String username;

}
