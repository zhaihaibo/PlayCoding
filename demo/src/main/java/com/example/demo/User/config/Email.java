package com.example.demo.User.config;

import org.springframework.stereotype.Repository;

@Repository
public class Email {
    private String content; //邮件内容
    private String toEmail; //收件人
    private String fromEmial; //发件人

    public Email() {
    }

    public Email(String content, String toEmail, String fromEmial) {
        this.content = content;
        this.toEmail = toEmail;
        this.fromEmial = fromEmial;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getFromEmial() {
        return fromEmial;
    }

    public void setFromEmial(String fromEmial) {
        this.fromEmial = fromEmial;
    }
}
