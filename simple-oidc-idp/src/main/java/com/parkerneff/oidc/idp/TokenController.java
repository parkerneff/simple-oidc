package com.parkerneff.oidc.idp;

import com.parkerneff.oidc.idp.ext.CustomUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class TokenController {
    private Log log = LogFactory.getLog(TokenController.class);

    /*
    https://server.example.com/authorize?
    response_type=id_token%20token
    &client_id=s6BhdRkqt3
    &redirect_uri=https%3A%2F%2Fclient.example.org%2Fcb
    &scope=openid%20profile
    &state=af0ifjsldkj
    &nonce=n-0S6_WzA2Mj




    oidc:
  server: http://localhost:8080/openid-connect-server-webapp
  client_id: parker-test-client
  redirect_uri: http://localhost:8081/postLogin
     */

//    @Value("${oidc.server}") String oidcServer;
//    @Value("${oidc.client_id}") String clientId;
//    @Value("${oidc.redirect_uri_base}") String redirectUriBase;


    // http://localhost:8080/openid-connect-server-webapp/authorize/response_type=id_token%2Ctoken&client_id=parker-test-client&redirect_uri=http%3A%2F%2Flocalhost%3A8081%2FpostLogin&scope=openid&state=mystate&nonce=mynonce
    @GetMapping("/token")
    public RedirectView startImplictFlow() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      //  log.info("token method pricipal class is " + principal.getClass().toString());
        CustomUser customUser = (CustomUser)auth.getPrincipal();
        log.info("First Name=" + customUser.getFirstName());
        log.info("last name=" + customUser.getLastName());



        return new RedirectView("www.google.com");
    }

}
