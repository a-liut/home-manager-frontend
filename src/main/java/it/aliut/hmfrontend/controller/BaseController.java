package it.aliut.hmfrontend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
abstract class BaseController {

    @Value("${app.title}")
    protected String appTitle;

}
