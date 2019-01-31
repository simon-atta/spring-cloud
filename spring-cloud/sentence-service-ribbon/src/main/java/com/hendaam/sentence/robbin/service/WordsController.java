package com.hendaam.sentence.robbin.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WordsController {

    @Autowired
    private LoadBalancerClient client;

    @RequestMapping("/sentence")
    public @ResponseBody String getSentence() {


        StringBuilder builder = new StringBuilder();
        builder.append(getWord("ADJECTIVE"));
        builder.append(" ");
        builder.append(getWord("ARTICLE"));
        builder.append(" ");
        builder.append(getWord("NOUN"));
        builder.append(" ");
        builder.append(getWord("SUBJECT"));
        builder.append(" ");
        builder.append(getWord("VERB"));
        builder.append(" ");

        System.out.println(builder.toString());

        return builder.toString();
    }

    public String getWord(String service) {
        ServiceInstance list = client.choose(service);
        if (list != null) {
            URI uri = list.getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }

}
