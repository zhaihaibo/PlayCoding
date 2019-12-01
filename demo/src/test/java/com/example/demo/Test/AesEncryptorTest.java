package com.example.demo.Test;

import org.junit.Test;

import java.text.MessageFormat;

public class AesEncryptorTest {
    private AES aes = new AesEncryptor() ;

    @Test
    public void test1(){
        String woaini = aes.encrypt("woaini");
        System.out.println(woaini+"0000000000000000000000000000");

        String wobuaini = aes.decrypt("wobuaini");
        System.out.println(wobuaini+"1111111111111111111111111111");
    }


    @Test
    public void test2(){
        String s = "Thank you for submitting your credit application. The application number is {0}.  We will forward your application to our lender for their reveiw.  They will contact you in the next few days if they have any questions regarding the application.<br/>Meanwhile, you can log onto  Vtic''s Trade Finance Platform to check out the status of your credit application. For any questions, please contact JETCO via email {1} or hotline {2}.\n";
        String format = MessageFormat.format(s, "1111111111", "222222222222", "333333333333333");
        System.out.println(format);
    }
}
