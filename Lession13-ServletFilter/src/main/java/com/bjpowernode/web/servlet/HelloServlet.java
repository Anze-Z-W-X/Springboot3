package com.bjpowernode.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet：等同于web.xml中有关Servlet的声明
/* <servlet>
*    <servlet-name>HelloServlet</servlet-name>
*    <servlet-class>xxxx</servlet-class>
*  </servlet>
*  <servlet-mapping>
*    <servlet-name>HelloServlet</servlet-name>
*    <url-pattern>/helloServlet</url-pattern>
*  </servlet-mapping>
*/
@WebServlet(urlPatterns = "/helloServlet",name = "HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("这是一个SpringBoot中的Servlet");
        out.flush();
        out.close();
    }
}
