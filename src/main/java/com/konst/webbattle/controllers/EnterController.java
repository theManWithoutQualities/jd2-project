
package com.konst.webbattle.controllers;

import com.konst.webbattle.services.Battle;
import com.konst.webbattle.domain.DataService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("battle")
public class EnterController {
    
    @Autowired
    DataService dataService;

    @RequestMapping(method = RequestMethod.POST)
    public String enter(@RequestParam String login, 
            @RequestParam String password,
            ModelMap model){
        
        boolean isEntered = false;
        Battle battle = null;
 
        battle = new Battle(dataService);
        isEntered = battle.setUser(login, password);
        if(!isEntered) {
            model.addAttribute("message", "There is no such login and password");
            return "enter";
        }else {
            model.addAttribute("battle", battle);
            return "battle";
        }
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String enter(HttpServletRequest request,
            ModelMap model){
        Battle battle = (Battle)request.getSession().getAttribute("battle");
        if(battle==null)
            return "enter"; 
        else
            return "battle";
    }


}
