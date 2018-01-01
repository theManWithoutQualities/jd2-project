
package com.konst.webbattle.controllers;

import com.konst.webbattle.domain.model.Field;
import com.konst.webbattle.domain.model.Orientation;
import com.konst.webbattle.domain.model.Ship;
import com.konst.webbattle.services.Battle;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("battle")
public class PlaceShipController {
    
    @RequestMapping(value="/place-ships/{rivalLogin}", method = RequestMethod.GET )
    public String placeShips(@PathVariable String rivalLogin,
            ModelMap model){
        
        model.addAttribute("rivalLogin", rivalLogin);
        return "placeships";
        
    }
    
    @RequestMapping(value="/place-ships", method = RequestMethod.POST )
    public String placeShips(HttpServletRequest request,
            ModelMap model){
        
        Battle battle = (Battle)request.getSession().getAttribute("battle");
        
        Field field = new Field();
        
        boolean success = false;
        
        for(int i=0; i<Battle.SHIP_COUNT; i++){
            String[] data = request.getParameter(String.valueOf(i)).split("_");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            Orientation orientation = data[2].equals("h")?Orientation.HORIZONTAL:Orientation.VERTICAL;
            int length = 0;
            if(i==0)
                length=4;
            else if((i>0)&&(i<3))
                length=3;
            else if((i>2)&&(i<6))
                length=2;
            else if((i>5))
                length=1;
            success=field.placeShip(new Ship(length, x, y, orientation));
            if(!success){
                model.addAttribute("message", "Wrong placement!");
                return "placeships";
            }
        }
        String rivalLogin = request.getParameter("rival_login");
        battle.initializeGameWithField(battle.findCurrentGame(rivalLogin), field);
        model.addAttribute("message", "Your ships have been placed!");
        return "placeships_end";
        
    }

}
