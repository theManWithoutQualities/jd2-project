
package com.konst.webbattle.controllers;

import com.konst.webbattle.services.Battle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/send-invitation/{rivalLogin}")
@SessionAttributes("battle")
public class SendInvitationController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String send(@PathVariable String rivalLogin,
            @ModelAttribute Battle battle,
            ModelMap model){

        battle.invite(rivalLogin);
        model.addAttribute("message", "Your invitation has been sent!");
        return "invite_end";
        
    }

}
