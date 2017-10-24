
package com.konst.webbattle.controllers;

import com.konst.webbattle.logic.User;
import com.konst.webbattle.services.Battle;
import com.konst.webbattle.services.DataService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/register")
@SessionAttributes("battle")
public class RegisterController {
    
    @Autowired
    DataService dataService;
    
    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid User user,
                BindingResult bindingResult,
                ModelMap model){
        
        if(bindingResult.hasErrors())
            return "register";
        
        boolean isEntered = false;
        Battle battle = null;

        battle = new Battle(dataService);
        
        isEntered = battle.setNewUser(user);
        if(!isEntered) {
            model.addAttribute("message", "Login must be unique");
            return "register";
        }else {
            model.addAttribute("battle", battle);
            return "battle";
        }
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String register(ModelMap model){

            User user = new User();
            model.addAttribute("user", user);
            return "register";
        
    }

}
