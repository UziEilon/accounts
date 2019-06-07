package com.ca.conjur.demo.accounts;


import com.ca.conjur.demo.accounts.objects.account;
import com.ca.conjur.demo.accounts.objects.accounts;
import com.ca.conjur.demo.accounts.utils.dbConnection;
import org.springframework.web.bind.annotation.*;

@RestController
public class loadController {

     public loadController()
    {
        System.out.printf("Load loadController ");

    }


    @RequestMapping(value = "/getData", method = RequestMethod.POST)
    public accounts getData(@RequestParam String ip,@RequestParam String dbuser,@RequestParam String dbpass) {
        System.out.println(" ********"+ip+"<"+dbuser+","+dbuser+">");
         dbConnection db = new dbConnection(ip,dbuser,dbpass);
        accounts accountList = db.getAccounts();

        return accountList;

    }

}
