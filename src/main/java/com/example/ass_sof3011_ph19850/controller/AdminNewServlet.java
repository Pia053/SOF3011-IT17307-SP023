package com.example.ass_sof3011_ph19850.controller;

import com.example.ass_sof3011_ph19850.entity.DongSanPham;
import com.example.ass_sof3011_ph19850.entity.MauSac;
import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;
import com.example.ass_sof3011_ph19850.entity.SanPham;
import com.example.ass_sof3011_ph19850.service.DongSanPhamService;
import com.example.ass_sof3011_ph19850.service.MauSacService;
import com.example.ass_sof3011_ph19850.service.NhaSanXuatService;
import com.example.ass_sof3011_ph19850.service.SanPhamService;
import com.example.ass_sof3011_ph19850.service.impl.DongSanPhamServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.MauSacServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.NhaSanXuatServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AdminNewServlet", value = {
        "/admin/nha-san-xuat-hien-thi",
        "/admin/nha-san-xuat-detail",
        "/admin/nha-san-xuat-update",
        "/admin/nha-san-xuat-delete",
        "/admin/nha-san-xuat-add",
        "/admin/nha-san-xuat-giao-dien-update",
        "/admin/mau-sac-hien-thi",  //
        "/admin/mau-sac-detail",
        "/admin/mau-sac-update",
        "/admin/mau-sac-delete",
        "/admin/mau-sac-add",
        "/admin/mau-sac-giao-dien-update",
        "/admin/san-pham-hien-thi",  //
        "/admin/san-pham-detail",
        "/admin/san-pham-update",
        "/admin/san-pham-delete",
        "/admin/san-pham-add",
        "/admin/san-pham-giao-dien-update",
        "/admin/dong-san-pham1-hien-thi",  //
        "/admin/dong-san-pham1-detail",
        "/admin/dong-san-pham1-update",
        "/admin/dong-san-pham1-delete",
        "/admin/dong-san-pham1-add",
        "/admin/dong-san-pham1-giao-dien-update",
})
public class AdminNewServlet extends HttpServlet {
    private List<SanPham> listsSanPham = new ArrayList<>();
    private List<DongSanPham> listsDongSanPham = new ArrayList<>();
    private List<MauSac> listsMauSac = new ArrayList<>();
    private List<NhaSanXuat> listsNhaSanXuats = new ArrayList<>();
    private NhaSanXuatService nhaNhaSanXuatService = new NhaSanXuatServiceImpl();
    private MauSacService mauSacService = new MauSacServiceImpl();

    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    private DongSanPhamService dongSanPhamService = new DongSanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("nha-san-xuat-hien-thi")) {
            this.nhaSanXuatHienThi(request, response);
        } else if (uri.contains("nha-san-xuat-detail")) {
            this.adminDetailNhaSanXuat(request, response);
        } else if (uri.contains("nha-san-xuat-delete")) {
            this.adminDeleteNhaSanXuat(request, response);
        } else if (uri.contains("nha-san-xuat-giao-dien-update")) {
            this.adminGiaoDienUpdateNhaSanXuat(request, response);
        } else if (uri.contains("mau-sac-hien-thi")) {
            this.adminMauSacHienThi(request, response);
        } else if (uri.contains("mau-sac-detail")) {
            this.adminDetailMauSac(request, response);
        } else if (uri.contains("mau-sac-delete")) {
            this.adminDeleteMauSac(request, response);
        } else if (uri.contains("mau-sac-giao-dien-update")) { //
            this.adminGiaoDienUpdateMauSac(request, response);
        } else if (uri.contains("san-pham-hien-thi")) {
            this.adminSanPhamHienThi(request, response);
        } else if (uri.contains("san-pham-detail")) {
            this.adminDetailSanPham(request, response);
        } else if (uri.contains("san-pham-delete")) {
            this.adminDeleteSanPham(request, response);
        } else if (uri.contains("san-pham-giao-dien-update")) {
            this.adminGiaoDienUpdateSanPham(request, response);
        } else if (uri.contains("dong-san-pham1-hien-thi")) { //
            this.adminDongSanPhamHienThi(request, response);
        } else if (uri.contains("dong-san-pham1-detail")) {
            this.adminDetailDongSanPham(request, response);
        } else if (uri.contains("dong-san-pham1-delete")) {
            this.adminDeleteDongSanPham(request, response);
        } else if (uri.contains("dong-san-pham1-giao-dien-update")) {
            this.adminGiaoDienUpdateDongSanPham(request, response);
        }
    }

    private void adminGiaoDienUpdateDongSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSanPham dsp = dongSanPhamService.getOne(request.getParameter("id"));
        request.setAttribute("dsp", dsp);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-dong-san-pham.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteDongSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        dongSanPhamService.delete(dongSanPhamService.getOne(request.getParameter("id")));
        response.sendRedirect("/admin/dong-san-pham1-hien-thi");
    }

    private void adminDetailDongSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSanPham dsp = dongSanPhamService.getOne(request.getParameter("id"));
        request.setAttribute("dsp", dsp);
        request.setAttribute("listDSP", listsDongSanPham);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-dong-san-pham.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDongSanPhamHienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsDongSanPham = dongSanPhamService.getAll();
        request.setAttribute("listDSP", listsDongSanPham);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-dong-san-pham.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminGiaoDienUpdateSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham sp = sanPhamService.getOne(request.getParameter("id"));
        request.setAttribute("sp", sp);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-san-pham.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sanPhamService.delete(sanPhamService.getOne(request.getParameter("id")));
        response.sendRedirect("/admin/san-pham-hien-thi");
    }

    private void adminDetailSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham sp = sanPhamService.getOne(request.getParameter("id"));
        request.setAttribute("sp", sp);
        request.setAttribute("listSP", listsSanPham);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-san-pham.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminSanPhamHienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsSanPham = sanPhamService.getAll();
        request.setAttribute("listSP", listsSanPham);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-san-pham.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminGiaoDienUpdateMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSac ms = mauSacService.getOne(request.getParameter("id"));
        request.setAttribute("ms", ms);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-mau-sac.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        mauSacService.delete(mauSacService.getOne(request.getParameter("id")));
        response.sendRedirect("/admin/mau-sac-hien-thi");
    }

    private void adminDetailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSac ms = mauSacService.getOne(request.getParameter("id"));
        request.setAttribute("ms", ms);
        request.setAttribute("listMS", listsMauSac);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-mau-sac.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminMauSacHienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsMauSac = mauSacService.getAll();
        request.setAttribute("listMS", listsMauSac);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-mau-sac.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminGiaoDienUpdateNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaSanXuat nhaSanXuat = nhaNhaSanXuatService.getOne(request.getParameter("id"));
        request.setAttribute("nsx", nhaSanXuat);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-nsx.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        nhaNhaSanXuatService.delete(nhaNhaSanXuatService.getOne(request.getParameter("id")));
        response.sendRedirect("/admin/nha-san-xuat-hien-thi");
    }

    private void adminDetailNhaSanXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaSanXuat nhaSanXuat = nhaNhaSanXuatService.getOne(request.getParameter("id"));
        request.setAttribute("nsx", nhaSanXuat);
        request.setAttribute("listNSX", listsNhaSanXuats);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-nha-san-xuat.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void nhaSanXuatHienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsNhaSanXuats = nhaNhaSanXuatService.getAll();
        request.setAttribute("listNSX", listsNhaSanXuats);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-nha-san-xuat.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("nha-san-xuat-add")) {
            this.nSXAdd(request, response);
        } else if (uri.contains("nha-san-xuat-update")) {
            this.nSXUpdate(request, response);
        } else if (uri.contains("mau-sac-add")) {
            this.mauSacAdd(request, response);
        } else if (uri.contains("mau-sac-update")) {
            this.mauSacUpdate(request, response);
        } else if (uri.contains("san-pham-add")) {
            this.sanPhamAdd(request, response);
        } else if (uri.contains("san-pham-update")) {
            this.sanPhamUpdate(request, response);
        } else if (uri.contains("dong-san-pham1-add")) {
            this.dongSanPhamAdd(request, response);
        } else if (uri.contains("dong-san-pham1-update")) {
            this.dongSanPhamUpdate(request, response);
        }
    }

    private void dongSanPhamUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        DongSanPham dongSanPham = dongSanPhamService.getOne(id);
        dongSanPham.setTen(ten);
        HashMap<String, String> listsERR = dongSanPhamService.update(dongSanPham);
        if (!listsERR.isEmpty()) {
            request.setAttribute("err", listsERR);
            request.setAttribute("dsp", dongSanPham);
            request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-dong-san-pham.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/dong-san-pham1-hien-thi");
        }
    }

    private void dongSanPhamAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        DongSanPham dongSanPham = DongSanPham.builder().ma(dongSanPhamService.genDongSP()).ten(ten).build();
        HashMap<String, String> listsERR = dongSanPhamService.save(dongSanPham);
        if (!listsERR.isEmpty()) {
            listsDongSanPham = dongSanPhamService.getAll();
            request.setAttribute("err", listsERR);
            request.setAttribute("dsp", dongSanPham);
            request.setAttribute("listDSP", listsDongSanPham);
            request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-dong-san-pham.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/dong-san-pham1-hien-thi");
        }
    }

    private void sanPhamUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String maX = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPham sanPham = sanPhamService.getOne(id);
        String ma = sanPham.getMa();
        sanPham.setTen(ten);
        HashMap<String, String> listsERR = sanPhamService.update(SanPham.builder().id(id).ma(ma).ten(ten).build());
        if (!listsERR.isEmpty()) {
            Boolean check = true;
            request.setAttribute("ERR", listsERR);
            request.setAttribute("sp", sanPham);
            request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-san-pham.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/san-pham-hien-thi");
        }
    }

    private void sanPhamAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        HashMap<String, String> listsERR = sanPhamService.save(SanPham.builder().ma(sanPhamService.genSanPham()).ten(ten).build());
        if (!listsERR.isEmpty()) {
            listsSanPham = sanPhamService.getAll();
            request.setAttribute("listSP", listsSanPham);
            request.setAttribute("ERR", listsERR);
            request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-san-pham.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/san-pham-hien-thi");
        }
    }

    private void mauSacUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        MauSac mauSac = mauSacService.getOne(id);
        mauSac.setTen(ten);
        mauSac.setId(id);

        HashMap<String, String> listsERR = mauSacService.update(mauSac);
        if (!listsERR.isEmpty()) {
            request.setAttribute("err", listsERR);
            request.setAttribute("ms", mauSac);
            request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-mau-sac.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/mau-sac-hien-thi");
        }
    }

    private void mauSacAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        HashMap<String, String> listsERR = mauSacService.save(MauSac.builder().ma(mauSacService.genMauSac()).ten(ten).build());
        if (!listsERR.isEmpty()) {
            request.setAttribute("err", listsERR);
            listsMauSac = mauSacService.getAll();
            request.setAttribute("listMS", listsMauSac);
            request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-mau-sac.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/mau-sac-hien-thi");
        }
    }

    private void nSXUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        NhaSanXuat nhaSanXuat = nhaNhaSanXuatService.getOne(id);
        nhaSanXuat.setTen(ten);
        nhaSanXuat.setId(id);
        HashMap<String, String> listsERR = nhaNhaSanXuatService.save(nhaSanXuat);
        if (!listsERR.isEmpty()) {
            request.setAttribute("nsx", nhaSanXuat);
            request.setAttribute("err", listsERR);
            request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-nsx.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/nha-san-xuat-hien-thi");
        }
    }

    private void nSXAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        HashMap<String, String> listsERR = nhaNhaSanXuatService.save(NhaSanXuat.builder().ma(nhaNhaSanXuatService.genNSX()).ten(ten).build());
        if (!listsERR.isEmpty()) {
            listsNhaSanXuats = nhaNhaSanXuatService.getAll();
            request.setAttribute("listNSX", listsNhaSanXuats);
            request.setAttribute("err", listsERR);
            request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-nha-san-xuat.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/nha-san-xuat-hien-thi");
        }
    }
}
