package com.wdq.shorturl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import javax.servlet.http.HttpServletResponse;


/**
 * @author wudq
 * @date 2020/3/23 0023
 * @Description: TODO
 */
@RestController
public class ShortController {

    @RequestMapping("/{shorturl}")
    public void get(@PathVariable("shorturl") String shorturl,  HttpServletResponse response) throws IOException {
        String url = "http://192.168.8.112:9093";
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.sendRedirect(url);
    }
}
