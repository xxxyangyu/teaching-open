package org.jeecg.modules.teaching.controller;

import net.dongliu.requests.RawResponse;
import net.dongliu.requests.Requests;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/teaching/onlineCode")
public class TeachingOnlineCodeController {
    private static String token = "Token d11088bc-a29d-4d49-a633-b1b1ae807064";

    @PostMapping("cpp")
    public String cpp(@RequestBody String code){
        return this.execCode("cpp", code);
    }

    @PostMapping("c")
    public String c(@RequestBody String code){
        return this.execCode("c", code);
    }

    @PostMapping("python")
    public String python(@RequestBody String code){
        return this.execCode("python", code);
    }

    @PostMapping("java")
    public String java(@RequestBody String code){
        return this.execCode("java", code);
    }

    @PostMapping("php")
    public String php(@RequestBody String code){
        return this.execCode("php", code);
    }

    @PostMapping("go")
    public String go(@RequestBody String code){
        return this.execCode("go", code);
    }

    @PostMapping("javascript")
    public String javascript(@RequestBody String code){
        return this.execCode("javascript", code);
    }

    @PostMapping("csharp")
    public String csharp(@RequestBody String code){
        return this.execCode("csharp", code);
    }

    @PostMapping("bash")
    public String bash(@RequestBody String code){
        return this.execCode("bash", code);
    }

    private String execCode(String lang, String code){
        String url = "http://68.79.43.146:88/languages/"+lang+"/latest";
        RawResponse rawResponse = Requests
                .post(url)
                .verify(false)
                .headers(new HashMap<String, String>(){{
                    put("Authorization", token);
                    put("Content-type", "application/json");
                }})
                .body(code)
                .timeout(60000)
                .send();
        return rawResponse.readToText();
    }

}
