package com.zzm.applications.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <b>Description</b>  CustomizedServlet
 *
 * @Author Zhenzhen
 * @Since 2020-06-24 周三 22:40
 * @Info CustomizedServlet
 */
public class CustomizedServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello, CustomizedServlet");//.doPost(req, resp);
    }
}
