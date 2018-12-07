/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




/**
 *
 * @author Kevin_PC
 */
@Controller
@RequestMapping("index1.htm")
public class index1Controller {
    @RequestMapping(method = RequestMethod.GET)
    public String otro (Model model){
        return "index1";
    }
    
    /*
    @RequestMapping(value="index1.htm", method=RequestMethod.GET)
    public ModelAndView index1(){
        
        return new ModelAndView("index1","command");
    }
    */
    
    
}
