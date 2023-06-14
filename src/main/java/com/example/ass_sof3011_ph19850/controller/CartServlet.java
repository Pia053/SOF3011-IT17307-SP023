package com.example.ass_sof3011_ph19850.controller;

import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;
import com.example.ass_sof3011_ph19850.entity.GioHang;
import com.example.ass_sof3011_ph19850.entity.GioHangChiTiet;
import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.entity.NhanVien;
import com.example.ass_sof3011_ph19850.service.ChiTietSanPhamService;
import com.example.ass_sof3011_ph19850.service.GioHangChiTietService;
import com.example.ass_sof3011_ph19850.service.GioHangService;
import com.example.ass_sof3011_ph19850.service.impl.ChiTietSanPhamServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.GioHangChiTietServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.GioHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CartServlet", value = {
        "/khach-hang/them-gio-hang",
        "/khach-hang/gio-hang"
})
public class CartServlet extends HttpServlet {
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();

    private GioHangService gioHangService = new GioHangServiceImpl();

    private GioHangChiTietService gioHangChiTietService = new GioHangChiTietServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("khach-hang/gio-hang")) {
            this.viewGioHang(request, response);
        }
    }

    private void thongTinSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/customer/cart.jsp").forward(request, response);

    }

    private void viewGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GioHang gioHangSession = (GioHang) session.getAttribute("gioHangSession");
        KhachHang khacHang = (KhachHang) session.getAttribute("acc");

        GioHang gioHang;
        if (gioHangSession == null) {
            gioHang = new GioHang();
            if (khacHang == null) {
                gioHang.setKhachHang(KhachHang.builder().id("").build());
            } else {
                gioHang.setKhachHang(khacHang);
            }
            gioHang.setNhanVien(NhanVien.builder().id("CFE4DA65-F947-4AC4-B3D3-AF65C73ECF81").build());
            gioHang.setMa(gioHangService.genGioHang());
            gioHang.setNgayTao(new Date());

            List<GioHangChiTiet> listGioHangChiTiets = new ArrayList<>();
            gioHang.setChiTietGioHang(listGioHangChiTiets);
            double tongTien = 0;
            for (int i = 0; i < listGioHangChiTiets.size(); i++) {
                tongTien += listGioHangChiTiets.get(i).getDonGia().intValue() * listGioHangChiTiets.get(i).getSoLuong();
            }
            session.setAttribute("listGH", gioHangSession.getChiTietGioHang());
            request.getRequestDispatcher("/views/customer/cart.jsp").forward(request, response);

        } else {
            double tongTien = 0;
            for (int i = 0; i < gioHangSession.getChiTietGioHang().size(); i++) {
                tongTien += gioHangSession.getChiTietGioHang().get(i).getDonGia().intValue() * gioHangSession.getChiTietGioHang().get(i).getSoLuong();
            }
            session.setAttribute("listGH", gioHangSession.getChiTietGioHang());
            request.getRequestDispatcher("/views/customer/cart.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("them-gio-hang")) {
            this.addToCart(request, response);
        }

    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer soLuong = 1;
        String idSP = request.getParameter("id");
        System.out.println(idSP);
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(idSP);

        HttpSession httpSession = request.getSession();
        KhachHang khacHang = (KhachHang) httpSession.getAttribute("acc");
        GioHang gioHangSession = (GioHang) httpSession.getAttribute("gioHangSession");
        // check session gioHangCT Xem có chưa? nếu chưa có thì vào if()
        if (gioHangSession == null) {
            GioHang gioHang = new GioHang();
            if (khacHang == null) {
                gioHang.setKhachHang(KhachHang.builder().id("").build());
            } else {
                gioHang.setKhachHang(khacHang);
            }
            gioHang.setNhanVien(NhanVien.builder().id("CFE4DA65-F947-4AC4-B3D3-AF65C73ECF81").build());
            gioHang.setMa(gioHangService.genGioHang());
            gioHang.setNgayTao(new Date());

            List<GioHangChiTiet> listGioHangChiTiets = new ArrayList<>();
            GioHangChiTiet gioHangCT = new GioHangChiTiet();
            gioHangCT.setIdChiTietSanPham(chiTietSanPham);
            gioHangCT.setIdGioHang(gioHang);
            gioHangCT.setSoLuong(soLuong);
            gioHangCT.setDonGia(chiTietSanPham.getGiaBan());
            listGioHangChiTiets.add(gioHangCT);
            gioHang.setChiTietGioHang(listGioHangChiTiets);
            gioHang.setTinhTrang(0);
            double tongTien = 0;
            for (int i = 0; i < listGioHangChiTiets.size(); i++) {
                tongTien += listGioHangChiTiets.get(i).getDonGia().intValue() * listGioHangChiTiets.get(i).getSoLuong();
            }
            httpSession.setAttribute("gioHangSession", gioHang);
            response.setContentType("text/plain");
            request.setCharacterEncoding("UTF-8");
            response.getWriter().write("Data saved successfully!");
        } else {
            // kiểm tra sp nêu co thi tang so luong neu chua thì check = false
            List<GioHangChiTiet> listGioHangChiTiets = gioHangSession.getChiTietGioHang();
            boolean check = false;
            if (listGioHangChiTiets.size() > 0) {
                for (int i = 0; i < listGioHangChiTiets.size(); i++) {
                    if (listGioHangChiTiets.get(i).getIdChiTietSanPham().getId().equals(chiTietSanPham.getId())) {
                        listGioHangChiTiets.get(i).setSoLuong(listGioHangChiTiets.get(i).getSoLuong() + 1);
                        check = true;
                    }
                }
            }
            if (check == false) {
                GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setIdChiTietSanPham(chiTietSanPham);
                gioHangChiTiet.setIdGioHang(gioHangSession);
                gioHangChiTiet.setSoLuong(soLuong);
                double tongTien = 0;
                for (int i = 0; i < listGioHangChiTiets.size(); i++) {
                    tongTien += listGioHangChiTiets.get(i).getDonGia().intValue() * listGioHangChiTiets.get(i).getSoLuong();
                }
                httpSession.setAttribute("gioHangSession", gioHangSession);
                response.setContentType("text/plain");
                request.setCharacterEncoding("UTF-8");
                response.getWriter().write("Data saved successfully!");
            } else {
                double tongTien = 0;
                for (int i = 0; i < listGioHangChiTiets.size(); i++) {
                    tongTien += listGioHangChiTiets.get(i).getDonGia().intValue() * listGioHangChiTiets.get(i).getSoLuong();
                }
                httpSession.setAttribute("gioHangSession", gioHangSession);
                response.setContentType("text/plain");
                request.setCharacterEncoding("UTF-8");
                response.getWriter().write("Data saved successfully!");
            }
        }
    }
}
