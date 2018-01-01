
package com.konst.webbattle.controllers;

import com.konst.webbattle.services.Battle;
import com.konst.webbattle.domain.DataService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/refresh")
@SessionAttributes("battle")
public class RefreshController {
    
    @Autowired
    DataService dataService;

    @RequestMapping(method = RequestMethod.GET)
    public String refresh(HttpServletRequest request,
            ModelMap model){
                
        Battle battle = (Battle)request.getSession().getAttribute("battle");
        battle.refresh();    
        return "battle";
    }


}
