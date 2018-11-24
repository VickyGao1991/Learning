package com.mail.HelloMail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String from;
    
    @Autowired
    private JavaMailSender mailSender;

    /**
     * Send the simple email which content is normal text
     * 
     * @param to
     *            the email address that send the email to
     * @param mailSubject
     *            email subject
     * @param mailContent
     *            emial content
     */
    public void sendSimpleMail(String to, String mailSubject, String mailContent) {
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom(from);
        mailMsg.setTo(to);
        mailMsg.setSubject(mailSubject);
        mailMsg.setText(mailContent);
        mailSender.send(mailMsg);
    }

    /**
     * Send the email which content is HTML
     * 
     * @param to
     *            the email address that send the email to
     * @param mailSubject
     *            email subject
     * @param mailContent
     *            emial content
     */
    public void sendHtmlMail(String to, String mailSubject, String mailContent) throws MessagingException {
        MimeMessage mailMsg = mailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(mailMsg, true);
        msgHelper.setFrom(from);
        msgHelper.setTo(to);
        msgHelper.setSubject(mailSubject);
        msgHelper.setText(mailContent, true);
        mailSender.send(mailMsg);
    }

    /**
     * Send the email which attached some files
     * 
     * @param to
     *            the email address that send the email to
     * @param mailSubject
     *            email subject
     * @param mailContent
     *            emial content
     * @param filePath
     *            the path of the attached file
     */
    public void sendAttachmentMail(String to, String mailSubject, String mailContent, String filePath) throws MessagingException {
        MimeMessage mailMsg = mailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(mailMsg, true);
        msgHelper.setFrom(from);
        msgHelper.setTo(to);
        msgHelper.setSubject(mailSubject);
        msgHelper.setText(mailContent, true);

        FileSystemResource fileResource = new FileSystemResource(filePath);
        String fileName = fileResource.getFile().getName();
        msgHelper.addAttachment(fileName, fileResource);
        msgHelper.addAttachment(fileName + "2", fileResource);
        msgHelper.addAttachment(fileName + "3", fileResource);

        mailSender.send(mailMsg);
    }

    /**
     * Send the email which contains some images
     * 
     * @param to
     *            the email address that send the email to
     * @param mailSubject
     *            email subject
     * @param mailContent
     *            emial content
     * @param rscPath
     *            the path of the image file
     * @param rscId
     *            the id of the image file, which will be used in the <image>
     */
    public void sendInlineResourceMail(String to, String mailSubject, String mailContent, String rscPath, String rscId)
            throws MessagingException {
        MimeMessage mailMsg = mailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(mailMsg, true);
        msgHelper.setFrom(from);
        msgHelper.setTo(to);
        msgHelper.setSubject(mailSubject);
        msgHelper.setText(mailContent, true);

        FileSystemResource fileResource = new FileSystemResource(rscPath);
        msgHelper.addInline(rscId, fileResource);

        mailSender.send(mailMsg);
    }
}
