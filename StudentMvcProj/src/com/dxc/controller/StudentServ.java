package com.dxc.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.dao.StudentDao;
import com.dxc.pojo.Student;
import com.dxc.service.StudentService;

	
@WebServlet("/stu")
public class StudentServ extends HttpServlet{
	
	StudentService ss=new StudentService();
	List<Student> lst=new ArrayList<Student>();
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		StudentDao dao=new StudentDao();
		HttpSession session=request.getSession();
		String val="";
		val=request.getParameter("op");
		if(val.equals("add_student"))
		{
			int rollNo=Integer.parseInt(request.getParameter("rn"));
			String name=request.getParameter("name");
			double perc=Double.parseDouble(request.getParameter("perc"));
			String str=ss.addStudent(rollNo,name,perc);
			response.getWriter().println(str);
		}
		else if(val.equals("show_students_details"))
		{

			lst=ss.showStudent();
			session.setAttribute("lst", lst);
			response.sendRedirect("view.jsp");
		}else if(val.equals("find"))
		{
			int rollNo=Integer.parseInt(request.getParameter("rn"));
			boolean b=ss.findStudent(rollNo);
			if(b==true)
			{
				session.setAttribute("rollno", rollNo);
				response.sendRedirect("update2.jsp");
			}else
			{
				response.getWriter().println("Student can't find!!!..");
			}
			
		}else if(val.equals("update_student"))
		{
			int rollNo=(int)session.getAttribute("rollno");
			String name=request.getParameter("name");
			double perc=Double.parseDouble(request.getParameter("perc"));
			String str=ss.updateStudent(rollNo,name,perc);
			response.getWriter().println(str);
			
		}else if(val.equals("delete_student"))
		{
			int rollNo=Integer.parseInt(request.getParameter("rn"));
			String str=ss.deleteStudent(rollNo);
			response.getWriter().println(str);
		}
	}
}
