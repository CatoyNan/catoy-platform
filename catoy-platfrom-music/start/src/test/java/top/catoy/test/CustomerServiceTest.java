package top.catoy.test;

import com.alibaba.cola.dto.Response;
import top.catoy.api.CustomerServiceI;
import top.catoy.dto.CustomerAddCmd;
import top.catoy.dto.data.CustomerDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.catoy.dto.data.ErrorCode;

/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerServiceI customerService;


    @Before
    public void setUp() {

    }

    @Test
    public void testCustomerAddSuccess(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCompanyName("NormalName");
        customerAddCmd.setCustomerDTO(customerDTO);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void testCustomerAddCompanyNameConflict(){
        //1.prepare
        CustomerAddCmd customerAddCmd = new CustomerAddCmd();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCompanyName("ConflictCompanyName");
        customerAddCmd.setCustomerDTO(customerDTO);

        //2.execute
        Response response = customerService.addCustomer(customerAddCmd);

        //3.assert error
        Assert.assertEquals(ErrorCode.UNKNOWN_ERROR.getCode(), response.getErrCode());
    }
}
