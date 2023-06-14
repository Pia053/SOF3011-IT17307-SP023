package com.example.ass_sof3011_ph19850.controller;

import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;
import com.example.ass_sof3011_ph19850.entity.GioHang;
import com.example.ass_sof3011_ph19850.entity.GioHangChiTiet;
import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;
import com.example.ass_sof3011_ph19850.entity.NhanVien;
import com.example.ass_sof3011_ph19850.service.ChiTietSanPhamService;
import com.example.ass_sof3011_ph19850.service.GioHangChiTietService;
import com.example.ass_sof3011_ph19850.service.GioHangService;
import com.example.ass_sof3011_ph19850.service.NhaSanXuatService;
import com.example.ass_sof3011_ph19850.service.impl.ChiTietSanPhamServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.GioHangChiTietServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.GioHangServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.NhaSanXuatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = {
        "/khach-hang/trang-chu",
        "/khach-hang/thong-tin-san-pham",
        "/khach-hang/san-pham",
        "/khach-hang/hang-giay",
        "/khach-hang/cart"
})
public class CustomerServlet extends HttpServlet {
    private List<ChiTietSanPham> listsChiTietSanPham = new ArrayList<>();

    private List<NhaSanXuat> listsNhaSanXuat = new ArrayList<>();

    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImpl();

    private GioHangChiTietService gioHangChiTietService = new GioHangChiTietServiceImpl();
    private GioHangService gioHangService = new GioHangServiceImpl();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("trang-chu")) {
            this.customerHomePage(request, response);
        } else if (uri.contains("san-pham")) {
            this.customerProduct(request, response);
        } else if (uri.contains("hang-giay")) {
            this.customerProductByBrand(request, response);
        } else if (uri.contains("cart")) {
            this.customerCart(request, response);
        }
    }

    private void customerCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("acc");
        GioHangChiTiet gioHangChiTiet = (GioHangChiTiet) session.getAttribute("cart");

        if (khachHang != null && gioHangChiTiet != null) {
            GioHang gioHang = new GioHang();
            gioHang.setMa(gioHangService.genGioHang());
            gioHang.setKhachHang(khachHang);
            gioHang.setNhanVien(new NhanVien().builder().id("0422349E-6E08-4A01-B9B2-0E6C8140E263").build());
            gioHangService.saveGioHang(gioHang);
            gioHangChiTiet.setIdGioHang(gioHang);

            String tt = gioHangChiTietService.saveGioHangChiTiet(gioHangChiTiet);
            System.out.println(tt);
        }

        List<GioHangChiTiet> lists =gioHangChiTietService.getAll();
        request.setAttribute("listGH",lists);
        request.getRequestDispatcher("/views/customer/cart.jsp").forward(request,response);
    }


    private void customerProductByBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<ChiTietSanPham> listsChiTietSanPhamByBrand = chiTietSanPhamService.getByIdNSX(id);
        request.setAttribute("tag", id);
        request.setAttribute("listsNSX", listsNhaSanXuat);
        request.setAttribute("listsChiTietSP", listsChiTietSanPhamByBrand);
        request.getRequestDispatcher("/views/customer/product.jsp").forward(request, response);
    }

    private void customerProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsNhaSanXuat = nhaSanXuatService.getAll();
        request.setAttribute("listsChiTietSP", listsChiTietSanPham);
        request.setAttribute("listsNSX", listsNhaSanXuat);
        request.getRequestDispatcher("/views/customer/product.jsp").forward(request, response);
    }

    private void customerHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsChiTietSanPham = chiTietSanPhamService.getAll();
        request.setAttribute("listsChiTietSP", listsChiTietSanPham);
        request.getRequestDispatcher("/views/customer/home-page.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
