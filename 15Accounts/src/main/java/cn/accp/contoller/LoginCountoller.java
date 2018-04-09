package cn.accp.contoller;


import cn.accp.entity.Account;
import cn.accp.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Auther: Xiao Yu
 * @Date: Created in 14:36 2018/3/11
 */
@Controller
@RequestMapping("/user")
public class LoginCountoller {
    @Resource(name = "iAccountService")
    private IAccountService  accountService;



    @ResponseBody
    @RequestMapping("/login")
    public Object login(Account account, HttpSession session){
        Account account1 = accountService.selectAccountOne(account);
        Integer stuts=0;
        if (account1==null){
            System.out.println(0);
            stuts=0;//null
        }else if (account1.getStatus()==0){
            System.out.println(1);
            stuts=1;//冻结
        }else if(account1.getStatus()==1){
            session.setAttribute("id",account1.getNumber());
            System.out.println(2);
            stuts=2;//正常
        }
        return stuts;
    }

    @ResponseBody
    @RequestMapping("/account")
    public Object account(Account account,HttpSession session){
        //登陆的id
        String id = (String) session.getAttribute("id");
        System.out.println("id->"+id);

        Account account1 = accountService.selectAccountOne(account);
        Integer stuts=0;
        if (account1==null){
            System.out.println(0);
            stuts=0;//目标账户不存在
        }else if (account1.getStatus()==0){
            System.out.println(1);
            stuts=1;//账户冻结
        }else if(account1.getStatus()==1){
            System.out.println(2);
            System.out.println(3);
            Account account2=new Account();
            System.out.println(4);
            account2.setNumber(id);
            System.out.println(5);
            account2.setBalnace(account.getBalnace());
            System.out.println(6);
            Account a1 = accountService.selectAccountOne(account2);
            System.out.println("id1->金额"+a1.getStatus());
            System.out.println("id2->金额"+account.getBalnace());
            System.out.println(7);
            if(a1.getBalnace()<account.getBalnace()){
                System.out.println(8);
                stuts=2;//余额不足
            }else {
                System.out.println(9);
                //id-2
                accountService.updateAccountup(account);
                System.out.println(10);
                //id-1
                accountService.updateAccountdown(account2);
                System.out.println(11);
                stuts=3;
            }
        }
        return stuts;
    }


}
