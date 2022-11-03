/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.learntakehome_33;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author raiha
 */
@Controller
public class Controllertakehome {
    
    @RequestMapping(value = "/tampilan")
    public String tampil(
            @RequestParam(value = "nama") String isinama,
            @RequestParam(value = "lok") String isilok,
            @RequestParam(value = "gbr") MultipartFile isigbr,
            Model bawa
            
    ) throws IOException{
        byte[] img = isigbr.getBytes();
        String base64gbr = Base64.encodeBase64String(img);
        String gbrlink = "data:image/*;base64,".concat(base64gbr);
        
        bawa.addAttribute("paketnama", isinama);
        bawa.addAttribute("paketlok", isilok);
        bawa.addAttribute("paketgbr", gbrlink);
        
    
        return "view";
    }
    
}
