package com.baizhi.yym.controller;

import com.baizhi.yym.entity.Admin;
import com.baizhi.yym.service.AdminService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * Created by yamin on 2018/7/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    DefaultKaptcha defaultKaptcha;
    @RequestMapping("/login")
    public String login(String name, String password, String vrifyCode, HttpSession session){
        String captchaId = (String) session.getAttribute("vrifyCode");
        if (!captchaId.equals(vrifyCode)) {
            return "login";
        } else {
            Admin admin = adminService.queryOneAdmin(name);
            if(admin==null || !admin.getPassword().equals(password)){
                return "login";
            }else{
                session.setAttribute("user",admin);
                return "redirect:/main/main.jsp";
            }
        }
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpSession session, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            session.setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

  /*  @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public ModelAndView imgvrifyControllerDefaultKaptcha(String vrifyCode,HttpSession session, HttpServletResponse httpServletResponse){
        ModelAndView andView = new ModelAndView();

    }
*/
}
