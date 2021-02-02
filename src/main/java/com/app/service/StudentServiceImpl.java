package com.app.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IStudentDao;
import com.app.pojos.Enrollments;
import com.app.pojos.Student;



import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;
	
	@Override
	public Student addStudentDetails(Student transientpojo)
	{
		
		System.out.println("in add student details "+transientpojo);
		// TODO Auto-generated method stub
		/*if(pojo!=null)
		{
			
			 * String student_name = pojo.getStudent_name(); String contact_no =
			 * pojo.getContact_no(); String email = pojo.getEmail(); String password =
			 * pojo.getPassword(); String confirm_pass = pojo.getConfirm_pass(); String
			 * address = pojo.getAddress(); GenderType gentype = pojo.getGentype();
			 * QualificationType qualitype = pojo.getQualitype(); // pojo.get
			 * 
			 * Student s=new Student( student_name, email, contact_no, password,
			 * confirm_pass, address, gentype, qualitype);
			 * 
			 * Student save = sdao.save(s);
			 * 
			 * double payment = pojo.getPayment(); LocalDate reg_date = pojo.getReg_date();
			 * Blob student_img = pojo.getStudent_img();
			 * 
			 * Enrollments e=new Enrollments(payment, reg_date, student_img);
			 * 
			 * edao.save(e);
			 * 
			 * 
			 }*/
		   
		    return  dao.save(transientpojo);
	}

	
	//for getting all student details
	@Override
	public List<Student> getALLStudentDetails() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}


	 //for getting student by id
	
	  @Override 
	  public Optional<Student> getStudentById(int student_id) 
	  { 
		  // TODOAuto-generated method stub 
	  return dao.findById(student_id);
	  }


	//deleting student by id
	@Override
	public boolean deleteStudentById(int student_id) {
		// TODO Auto-generated method stub
		 Optional<Student> student = dao.findById(student_id);
	
		 if(student.isPresent())
		 {
			 dao.deleteById(student_id);
		    return true;
		 }
		 else
		 {
			 return false;
		 }
	}


	@Override
	public Student validateStudent(String email, String pass) {
		
		System.out.println(" in validate student impl "+email+" "+pass);
		return dao.findByEmailAndPassword(email, pass);
	}
	 
	

	//updating student by id
		@Override
		public Student updateStudent(int student_id, Student detachedpojo) {
			
		 Optional <Student> value=dao.findById(student_id);
			if(value.isPresent())
			{
	            Student pojo=value.get();
				
				pojo.setStudent_name(detachedpojo.getStudent_name());
	            pojo.setPassword(detachedpojo.getPassword());
				pojo.setConfirm_pass(detachedpojo.getConfirm_pass());
				pojo.setEmail(detachedpojo.getEmail());
				pojo.setGentype(detachedpojo.getGentype());
				pojo.setQualitype(detachedpojo.getQualitype());
				pojo.setContact_no(detachedpojo.getContact_no());
		        pojo.setAddress(detachedpojo.getAddress());
		        pojo.setStudentEnrolls(detachedpojo.getStudentEnrolls());
		
				return pojo;
			}
			return null;
		}
		
		public void sendemail(String message ,String subject,String to,String from ) throws UnsupportedEncodingException
		{
			String host="smtp.gmail.com";
			  Properties props = System.getProperties();
			  props.setProperty("mail.transport.protocol", "smtp");     
			    props.setProperty("mail.host", "smtp.gmail.com");  
			    props.put("mail.smtp.auth", "true");  
			    props.put("mail.smtp.port", "465");  
			    props.put("mail.debug", "true");  
			    props.put("mail.smtp.socketFactory.port", "465");  
			    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
			    props.put("mail.smtp.socketFactory.fallback", "false");  
			  
			  /*
			  properties.put("mail.smtp.host", host);
			  properties.put("mail.smtp.port", "587");
			  properties.put("mail.smtp.auth", "true");
			  */

			  Session session = Session.getInstance(props, new Authenticator(){

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("piyushahir43@gmail.com", "piyushahir8881");
				}
				
				  
			});
			  session.setDebug(true);
			  
			  MimeMessage m=new MimeMessage(session);
			  
			  
			  try {
				m.setFrom(new InternetAddress(from));
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				m.setSubject(subject);
				m.setText(message);
				Transport.send(m);
				System.out.println("Email Sent Successfully");
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
			  
			
			  
			  
			  
			  
		}
		

		
		
		
		
}
 
  
	
	


