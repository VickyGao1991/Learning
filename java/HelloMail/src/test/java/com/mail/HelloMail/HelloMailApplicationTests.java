package com.mail.HelloMail;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.mail.HelloMail.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloMailApplicationTests {
    private String to = "test@qq.com"; // NOTE: change to your account which is used to send the email

    @Resource
    private MailService mailService;
    
    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void testSendSimpleMail() {
        mailService.sendSimpleMail(to, "Hello simple mail !", "Configuration, you got my simple test emial.");
    }

    @Test
    public void testSendHtmlMail() throws MessagingException {
        String content = "<html>" +
                "<body>" +
                    "<h1>Configuration, you got my HTML test emial.</h1>" +
                    "<button>click me</button>" +
                "</body>"+
            "</html>";
        mailService.sendHtmlMail(to, "Hello HTML mail !", content);
    }

    @Test
    public void testSendAttachmentMail() throws MessagingException {
        mailService.sendAttachmentMail(to, "Hello attachment mail !", "Please see the attached file.", "/tmp/vicky-test/test");
    }

    @Test
    public void testSendInlineResourceMail() throws MessagingException {
        String content = "<html>" +
                "<body>" +
                    "<h1>Configuration, you got my inline resource test emial.</h1>" +
                    "<img src='cid:imgid01'></img>" +
                "</body>"+
            "</html>";
        mailService.sendInlineResourceMail(to, "Hello inline resource mail !", content, "/tmp/vicky-test/haha.png",
                "imgid01");
    }

    @Test
    public void testSendTemplateMail() throws MessagingException {
      Context context = new Context();
      context.setVariable("name", "vicky");
      String content = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(to, "Hello template mail !", content);
    }

}
