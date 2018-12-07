/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Kevin_PC
 */

@Controller
@PersistenceContext(unitName = "RemakeSMPU")
public class agregarProductoController {
    @RequestMapping(value="agregarProducto.htm", method = RequestMethod.GET)
    public String otroM (Model model){
        return "index";
    }
} 

