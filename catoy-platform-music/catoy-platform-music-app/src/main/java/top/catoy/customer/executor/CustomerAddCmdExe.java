
package top.catoy.customer.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import top.catoy.dto.CustomerAddCmd;
import org.springframework.stereotype.Component;
import top.catoy.dto.data.ErrorCode;


@Component
public class CustomerAddCmdExe{

    public Response execute(CustomerAddCmd cmd) {
        //The flow of usecase is defined here.
        //The core ablility should be implemented in Domain. or sink to Domian gradually
        if(cmd.getCustomerDTO().getCompanyName().equals("ConflictCompanyName")){
            throw new BizException(ErrorCode.UNKNOWN_ERROR.getCode(), "公司名冲突");
        }
        return Response.buildSuccess();
    }

}
