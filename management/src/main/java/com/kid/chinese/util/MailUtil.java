package com.kid.chinese.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public static final int TIMELIMIT = 1000 * 60 * 60 * 24; // 邮件过期时间24小时
	public static final String TITLE = "";
	public static final String HOST = "";
	public static final String SMTP = "";
	public static Transport transport;
	public static String FROM = "";
	public static String PWD = "";
	
	private final static String smtp_config_file = "/smtp.properties";
	public String getValueByKey(String key) {
		Properties pps = new Properties();
		try {
			InputStream in = this.getClass().getResourceAsStream(smtp_config_file);
			pps.load(in);
			String value = pps.getProperty(key);
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Properties getProperties() {
		Properties pps = new Properties();
		try {
			InputStream in = this.getClass().getResourceAsStream(smtp_config_file);
			pps.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return pps;
	}

	public static  void sendEmil(String to,String subject, String message) {
        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            //设置邮件会话参数
            MailUtil mailUtil = new MailUtil();
            Properties props = mailUtil.getProperties();
            //邮箱的发送服务器地址
            //props.setProperty("mail.smtp.host", HOST);
            //props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            //props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口,这里设置为465端口
            //props.setProperty("mail.smtp.port", "465");
            //props.setProperty("mail.smtp.socketFactory.port", "465");
            //props.put("mail.smtp.auth", "true");
            final String username = props.getProperty("FROM");
            final String password = props.getProperty("PWD");;
            //获取到邮箱会话,利用匿名内部类的方式,将发送者邮箱用户名和密码授权给jvm
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            //通过会话,得到一个邮件,用于发送
            Message msg = new MimeMessage(session);
            //设置发件人
            msg.setFrom(new InternetAddress(username));
            //设置收件人,to为收件人,cc为抄送,bcc为密送
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(to, false));
            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
            msg.setSubject(subject);
            //设置邮件消息
            msg.setText(message);
            //设置发送的日期
            msg.setSentDate(new Date());
            //调用Transport的send方法去发送邮件
            Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



	public static String getNumber() {
		String number = "";
		String chars = "abcdefghijkl0123456789ABCDEFGHIJKLMNOPQLSTUVWXYZ";
		Random r = new Random();
		for (int i = 0; i < 6; ++i) {
			number = number + chars.charAt(r.nextInt(chars.length()));
		}
		return number;
	}
	public static void main(String []args) {
		MailUtil.sendEmil("xiaowulf@163.com","test","test");
		System.out.println(getNumber());
	}
}
