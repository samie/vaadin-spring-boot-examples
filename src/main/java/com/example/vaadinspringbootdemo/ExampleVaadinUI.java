package com.example.vaadinspringbootdemo;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.web.client.RestTemplate;

@SpringUI
public class ExampleVaadinUI extends UI {

    VerticalLayout rootLayout = new VerticalLayout();
    Label text =  new Label("This is Vaadin application at localhost:8080/");
    Button button = new Button("Call rest at localhost:8080/rest", event -> callRestService());
    Link link = new Link("Static HTML at localhost:8080/example.html", new ExternalResource("http://localhost:8080/example.html"));


    @Override
    protected void init(VaadinRequest request) {
        rootLayout.addComponents(text, button, link);
        setContent(rootLayout);
    }

    private void callRestService() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/rest", String.class);
        Notification.show(result);
    }

}
