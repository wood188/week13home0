package com.qf.controller;

import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import com.qf.service.RolerPermService;
import com.qf.service.UserRolerService;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRolerService userRolerService;
    @Autowired
    private RolerPermService rolerPermService;

    @RequestMapping("/register0")
    public String register0() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(User user) {
        user.setChoose(0);
        int res = userService.userAdd(user);
        if (res == 1) {
            //角色关系赋值
            UserRoler userRoler = new UserRoler();
            userRoler.setUid(userService.selectOne(user).getUid());
            userRoler.setRid(3);
            userRolerService.userRolerAdd(userRoler);
           /* //权限赋值
            RolerPerm rolerPerm =new RolerPerm();
            rolerPerm.setRid(3);
            rolerPerm.setPid(1);
            rolerPermService.rolerPermAdd(rolerPerm);*/
            return "login";
        }
        return "register";
    }

    @RequestMapping("/login0")
    public String login0() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
      /* User user1 =userService.selectOne(user);
       if(user1!=null){
           if(user1.getUpass().equals(user.getUpass())){

               return "redirect:/showall";
           }
       }
        return "login";*/
        //加入shiro
        try {
            Subject subject = SecurityUtils.getSubject();//从安全对象内获取对象主体
            //构建令牌对象
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUname(), user.getUpass());
           /* //赋身份信息
            token.setUsername(user.getUname().toString());
            //赋凭证
            token.setUsername(String.valueOf(user.getUpass().toString().toCharArray()));*/
            subject.login(token);
            if (subject.isAuthenticated()) {
                return "redirect:/goods/showall";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录 失败");
        }
        return "login";
    }
}
