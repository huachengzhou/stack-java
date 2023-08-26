package com.me.test;

import com.me.RabbitMqApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author noatn
 * @description
 * @date 2023-08-22
 */
@AutoConfigureMockMvc
@SpringBootTest(classes = {RabbitMqApplication.class})
public class BaseControllerJunitTest {
    public static final String HSDSDJSJSDJ = "hsdsdjsjsdj";
    @Resource
    private MockMvc mockMvc;


    @Test
    public void getDataDicListPaging() throws Exception {
//        HttpHeaders httpHeaders = getHttpHeaders();
//        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/baseDataDic/getDataDicListPaging");
//        servletRequestBuilder.headers(httpHeaders);
//        String search = "工程";
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("search", search);
//        params.add("pageNo", "1");
//        params.add("pageSize", "10");
//        servletRequestBuilder.params(params) ;
//        MvcResult mvcResult = mockMvc.perform(
//                servletRequestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println("http get方法结果:" + mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void getDataDicByUuid() throws Exception {
//        HttpHeaders httpHeaders = getHttpHeaders();
//        MockHttpServletRequestBuilder servletRequestBuilder = MockMvcRequestBuilders.get("/baseDataDic/getDataDicByUuid");
//        servletRequestBuilder.headers(httpHeaders);
//        String uuid = "3CF07Bet";
//        servletRequestBuilder.param("uuid", uuid);
//        MvcResult mvcResult = mockMvc.perform(
//                servletRequestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println("http get方法结果:" + mvcResult.getResponse().getContentAsString());
    }

    private HttpHeaders getHttpHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("swtoken", HSDSDJSJSDJ);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);
        return httpHeaders;
    }

}
