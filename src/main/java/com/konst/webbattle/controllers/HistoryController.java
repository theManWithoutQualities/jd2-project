
package com.konst.webbattle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/history")
@SessionAttributes("battle")
public class HistoryController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHistory(ModelMap model){

            return "history";
        
    }

}
