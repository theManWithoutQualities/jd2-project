
package com.konst.webbattle.controllers;

import com.konst.webbattle.services.Battle;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/sign-out")
@SessionAttributes("battle")
public class SignOutController{

    @RequestMapping(method = RequestMethod.GET)
    public String signOut(HttpServletRequest request,
            ModelMap model){
        Battle battle = (Battle)request.getSession().getAttribute("battle");        
        battle.unsetUser();
        battle=null;
        return "enter";
        
    }

}
