package com.parkerneff.oidc.idp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private Log log = LogFactory.getLog(LoginController.class);
// http://localhost:8080/login?response_type=code&scope=openid&client_id=s6BhdRkqt3&state=af0ifjsldkj&redirect_uri=https%3A%2F%2Fclient.example.org%2Fcb
    /*
    HTTP/1.1 302 Found
Location: https://openid.c2id.com/login?
          response_type=code
          &scope=openid
          &client_id=s6BhdRkqt3
          &state=af0ifjsldkj
          &redirect_uri=https%3A%2F%2Fclient.example.org%2Fcb
     */
    @GetMapping("/login")
    public String prepareLoginForm(@RequestParam("response_type") String responseType,
                            @RequestParam("scope") String scope,
                            @RequestParam("client_id") String clientId,
                            @RequestParam("state") String state,
                            @RequestParam("redirect_uri") String redirectUri,
                            ModelMap model) {
        model.addAttribute("response_type", responseType);
        model.addAttribute("scope", scope);
        model.addAttribute("client_id", clientId);
        model.addAttribute("state", state);
        model.addAttribute("redirect_uri", redirectUri);
      //  model.addAttribute("user_id", null);
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@RequestParam("response_type") String responseType,
                            @RequestParam("code") String code,
                            @RequestParam("client_id") String clientId,
                            @RequestParam("state") String state,
                            @RequestParam("redirect_uri") String redirectUri,
                            @RequestParam("user_id") String userId,
                            @RequestParam("password") String password,
                            ModelMap model) {
//        model.addAttribute("response_type", responseType);
//        model.addAttribute("code", code);
//        model.addAttribute("client_id", clientId);
//        model.addAttribute("state", state);
//        model.addAttribute("redirect_uri", redirectUri);
        //  model.addAttribute("user_id", null);
        log.info("response_type=" + responseType);
        log.info("client_id=" + clientId);
        log.info("user_id=" + userId);
        log.info("password=" + password);
        return "login";
    }
}
