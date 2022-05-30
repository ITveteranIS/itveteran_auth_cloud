package com.bases.restult.sentinelHandlerconfig;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.bases.restult.ResultResponse;
import org.springframework.stereotype.Component;

/**
 * @author : ITveteran•JIE
 * @version 1.0x
 * @Package: {"packageName":"com.boots.config.sentinelHandlerconfig"}
 * @ClassName: {"classname":"SentinelHandler"}
 * @Description: TODO {"description":""} 0_0
 * @Date : Create in {"date":"2022/5/311:42"}
 */
@Component
public class SentinelHandler {
    public static ResultResponse handle(BlockException ex) throws Exception {
        String msg = null;
        if (ex instanceof FlowException) {
            msg = "您访问过快-限流中";
        } else if (ex instanceof DegradeException) {
            msg = "您访问过快-降级中";
        } else if (ex instanceof ParamFlowException) {
            msg = "热点参数限流";
        } else if (ex instanceof SystemBlockException) {
            msg = "系统规则（负载/...不满足要求）";
        } else if (ex instanceof AuthorityException) {
            msg = "授权规则不通过";
        }
        System.out.println(msg+"=====");
     return ResultResponse.sentinelError(msg);
    }
}
