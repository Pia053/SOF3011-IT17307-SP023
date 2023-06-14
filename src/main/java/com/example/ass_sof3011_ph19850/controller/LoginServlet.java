package com.example.ass_sof3011_ph19850.controller;

import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.service.KhachHangService;
import com.example.ass_sof3011_ph19850.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/dang-nhap")
public class LoginServlet extends HttpServlet {
    private KhachHangService khachHangService = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/customer/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoan = request.getParameter("taiKhoan");
        String matKhau = request.getParameter("matKhau");
        KhachHang kh = khachHangService.getOneByMaAndMatKhau(taiKhoan, matKhau);
        if (kh == null) {
            request.getRequestDispatcher("/views/customer/login.jsp").forward(request, response);
        } else {
            HttpSession sessionLogin = request.getSession();
            sessionLogin.setAttribute("acc", kh);
            response.sendRedirect("/khach-hang/trang-chu");
            System.out.println(taiKhoan + " " + matKhau);
        }
    }
}
