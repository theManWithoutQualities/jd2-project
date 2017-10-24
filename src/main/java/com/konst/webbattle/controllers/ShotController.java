
package com.konst.webbattle.controllers;

import com.konst.webbattle.logic.Shot;
import com.konst.webbattle.services.Battle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/shot/{data}")
@SessionAttributes("battle")
public class ShotController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String shot(@PathVariable String data,
            @ModelAttribute Battle battle,
            ModelMap model){
        
        String[] dataArr = data.split("_");
        String login = dataArr[0];
        int x = Integer.parseInt(dataArr[1]);
        int y = Integer.parseInt(dataArr[2]);
        battle.makeShot(login, new Shot(x, y));
        
        return "battle";
        
    }

}
