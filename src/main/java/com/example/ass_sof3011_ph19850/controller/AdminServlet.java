package com.example.ass_sof3011_ph19850.controller;

import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;
import com.example.ass_sof3011_ph19850.entity.ChucVu;
import com.example.ass_sof3011_ph19850.entity.CuaHang;
import com.example.ass_sof3011_ph19850.entity.DongSanPham;
import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.entity.MauSac;
import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;
import com.example.ass_sof3011_ph19850.entity.NhanVien;
import com.example.ass_sof3011_ph19850.entity.SanPham;
import com.example.ass_sof3011_ph19850.service.ChiTietSanPhamService;
import com.example.ass_sof3011_ph19850.service.ChucVuService;
import com.example.ass_sof3011_ph19850.service.CuaHangService;
import com.example.ass_sof3011_ph19850.service.DongSanPhamService;
import com.example.ass_sof3011_ph19850.service.KhachHangService;
import com.example.ass_sof3011_ph19850.service.MauSacService;
import com.example.ass_sof3011_ph19850.service.NhaSanXuatService;
import com.example.ass_sof3011_ph19850.service.NhanVienService;
import com.example.ass_sof3011_ph19850.service.SanPhamService;
import com.example.ass_sof3011_ph19850.service.impl.ChiTietSanPhamServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.ChucVuServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.CuaHangServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.DongSanPhamServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.KhachHangServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.MauSacServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.NhaSanXuatServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.NhanVienServiceImpl;
import com.example.ass_sof3011_ph19850.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "AdminServlet", value = {
        "/admin/nhan-vien-hien-thi", "/admin/nhan-vien-detail", "/admin/nhan-vien-update", "/admin/nhan-vien-delete", "/admin/nhan-vien-add", "/admin/nhan-vien-giao-dien-update",
        "/admin/chuc-vu-hien-thi", "/admin/chuc-vu-detail", "/admin/chuc-vu-update", "/admin/chuc-vu-delete", "/admin/chuc-vu-add", "/admin/chuc-vu-giao-dien-update",
        "/admin/cua-hang-hien-thi", "/admin/cua-hang-detail", "/admin/cua-hang-update", "/admin/cua-hang-delete", "/admin/cua-hang-add", "/admin/cua-hang-giao-dien-update",
        "/admin/chi-tiet-san-pham-hien-thi", "/admin/chi-tiet-san-pham-them-moi", "/admin/chi-tiet-san-pham-add", "/admin/chi-tiet-san-pham-detail", "/admin/chi-tiet-san-pham-delete", "/admin/chi-tiet-san-pham-giao-dien-update", "/admin/chi-tiet-san-pham-update",
        "/admin/khach-hang-hien-thi", "/admin/khach-hang-detail", "/admin/khach-hang-update", "/admin/khach-hang-delete", "/admin/khach-hang-add", "/admin/khach-hang-giao-dien-update", "/admin/khach-hang-giao-dien-them-moi"

})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class AdminServlet extends HttpServlet {
    private List<KhachHang> listsKhachHang = new ArrayList<>();
    private List<ChiTietSanPham> listsChiTietSanPham = new ArrayList<>();
    private List<NhanVien> listsNhanVien = new ArrayList<>();
    private List<CuaHang> listsCuaHang = new ArrayList<>();
    private List<ChucVu> listsChucVu = new ArrayList<>();
    private List<NhaSanXuat> listsNhaSanXuats = new ArrayList<>();
    private List<SanPham> listsSanPham = new ArrayList<>();
    private List<DongSanPham> listsDongSanPham = new ArrayList<>();
    private List<MauSac> listsMauSac = new ArrayList<>();
    private NhaSanXuatService nhaNhaSanXuatService = new NhaSanXuatServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private DongSanPhamService dongSanPhamService = new DongSanPhamServiceImpl();

    private MauSacService mauSacService = new MauSacServiceImpl();
    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    private CuaHangService cuaHangService = new CuaHangServiceImpl();
    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImpl();
    private KhachHangService khachHangService = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("nhan-vien-hien-thi")) {
            this.adminHienThiNhanVien(request, response);
        } else if (uri.contains("nhan-vien-detail")) {
            this.adminDetailNhanVien(request, response);
        } else if (uri.contains("nhan-vien-delete")) {
            this.adminDeleteNhanVien(request, response);
        } else if (uri.contains("nhan-vien-giao-dien-update")) {
            this.adminGiaoDienUpdate(request, response);
        } else if (uri.contains("chuc-vu-hien-thi")) {  //
            this.adminHienThiChucVu(request, response);
        } else if (uri.contains("chuc-vu-detail")) {
            this.adminDetailChucVu(request, response);
        } else if (uri.contains("chuc-vu-delete")) {
            this.adminDeleteChucVu(request, response);
        } else if (uri.contains("chuc-vu-giao-dien-update")) {
            this.adminGiaoDienUpdateChucVu(request, response);
        } else if (uri.contains("cua-hang-hien-thi")) {  //
            this.adminHienThiCuaHang(request, response);
        } else if (uri.contains("cua-hang-detail")) {
            this.adminDetailCuaHang(request, response);
        } else if (uri.contains("cua-hang-delete")) {
            this.adminDeleteCuaHang(request, response);
        } else if (uri.contains("cua-hang-giao-dien-update")) {
            this.adminGiaoDienUpdateCuaHang(request, response);
        } else if (uri.contains("chi-tiet-san-pham-hien-thi")) {  // sanr pham ct
            this.adminCTHienThi(request, response);
        } else if (uri.contains("chi-tiet-san-pham-them-moi")) {
            this.adminCTViewAdd(request, response);
        } else if (uri.contains("chi-tiet-san-pham-detail")) {
            this.adminDetailCT(request, response);
        } else if (uri.contains("chi-tiet-san-pham-delete")) {
            this.adminDeleteCT(request, response);
        } else if (uri.contains("chi-tiet-san-pham-giao-dien-update")) {
            this.adminCTViewUpdate(request, response);
        } else if (uri.contains("khach-hang-hien-thi")) {  //
            this.adminViewKhachHang(request, response);
        } else if (uri.contains("khach-hang-giao-dien-them-moi")) {
            this.adminViewThemMoi(request, response);
        } else if (uri.contains("khach-hang-giao-dien-update")) {
            this.adminViewCapNhapKH(request, response);
        } else if (uri.contains("khach-hang-detail")) {
            this.adminKhachHangDetail(request, response);
        } else if (uri.contains("khach-hang-delete")) {
            this.adminKhachHangDelete(request, response);
        }
    }

    private void adminKhachHangDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String test = khachHangService.delete(khachHangService.getOne(request.getParameter("id")));
        System.out.println(test);
        response.sendRedirect("/admin/khach-hang-hien-thi");
    }

    private void adminKhachHangDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang kh = khachHangService.getOne(request.getParameter("id"));
        request.setAttribute("kh", kh);
        request.setAttribute("viewAdmin", "/views/admin/admin-khach-hang-giao-dien-them-moi.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminViewCapNhapKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang kh = khachHangService.getOne(request.getParameter("id"));
        request.setAttribute("kh", kh);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-khach-hang.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminViewThemMoi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("viewAdmin", "/views/admin/admin-khach-hang-giao-dien-them-moi.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminViewKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsKhachHang = khachHangService.getAll();
        request.setAttribute("listKH", listsKhachHang);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-khach-hang.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminCTViewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(request.getParameter("id"));
        request.setAttribute("sp", chiTietSanPham);
        listsSanPham = sanPhamService.getAll();
        listsNhaSanXuats = nhaNhaSanXuatService.getAll();
        listsDongSanPham = dongSanPhamService.getAll();
        listsMauSac = mauSacService.getAll();
        request.setAttribute("listSanPham", listsSanPham);
        request.setAttribute("listNSX", listsNhaSanXuats);
        request.setAttribute("listMauSac", listsMauSac);
        request.setAttribute("listsDongSP", listsDongSanPham);
        //view detail
        request.setAttribute("viewAdmin", "/views/admin/admin-sp-ct-giao-dien-cap-nhap.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteCT(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String test = chiTietSanPhamService.delete(chiTietSanPhamService.getOne(request.getParameter("id")));
        System.out.println(test);
        response.sendRedirect("/admin/chi-tiet-san-pham-hien-thi");
    }

    private void adminDetailCT(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(request.getParameter("id"));
        request.setAttribute("sp", chiTietSanPham);
        listsSanPham = sanPhamService.getAll();
        listsNhaSanXuats = nhaNhaSanXuatService.getAll();
        listsDongSanPham = dongSanPhamService.getAll();
        listsMauSac = mauSacService.getAll();
        request.setAttribute("listSanPham", listsSanPham);
        request.setAttribute("listNSX", listsNhaSanXuats);
        request.setAttribute("listMauSac", listsMauSac);
        request.setAttribute("listsDongSP", listsDongSanPham);
        // view add
        request.setAttribute("viewAdmin", "/views/admin/admin-sp-ct-giao-dien-them-moi.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminCTViewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsSanPham = sanPhamService.getAll();
        listsNhaSanXuats = nhaNhaSanXuatService.getAll();
        listsDongSanPham = dongSanPhamService.getAll();
        listsMauSac = mauSacService.getAll();
        request.setAttribute("listSanPham", listsSanPham);
        request.setAttribute("listNSX", listsNhaSanXuats);
        request.setAttribute("listMauSac", listsMauSac);
        request.setAttribute("listsDongSP", listsDongSanPham);
        request.setAttribute("viewAdmin", "/views/admin/admin-sp-ct-giao-dien-them-moi.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminCTHienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsChiTietSanPham = chiTietSanPhamService.getAll();
        request.setAttribute("listsChiTietSP", listsChiTietSanPham);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-san-pham-ct.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminHienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsCuaHang = cuaHangService.getAll();
        request.setAttribute("listCuaHang", listsCuaHang);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-cua-hang.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);

    }

    private void adminDetailCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang cuaHang = cuaHangService.getOne(request.getParameter("id"));
        request.setAttribute("ch", cuaHang);
        request.setAttribute("listCuaHang", listsCuaHang);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-cua-hang.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tt = cuaHangService.delete(cuaHangService.getOne(request.getParameter("id")));
        System.out.println(tt);
        response.sendRedirect("/admin/cua-hang-hien-thi");
    }

    private void adminGiaoDienUpdateCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang cuaHang = cuaHangService.getOne(request.getParameter("id"));
        request.setAttribute("ch", cuaHang);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-cua-hang.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminHienThiChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsChucVu = chucVuService.getAll();
        request.setAttribute("listChucVu", listsChucVu);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-chuc-vu.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminGiaoDienUpdateChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu cv = chucVuService.getOne(request.getParameter("id"));
        request.setAttribute("cv", cv);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-chuc-vu.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String test = chucVuService.delete(chucVuService.getOne(request.getParameter("id")));
        System.out.println(test);
        response.sendRedirect("/admin/chuc-vu-hien-thi");
    }

    private void adminDetailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu chucVu = chucVuService.getOne(request.getParameter("id"));
        request.setAttribute("cv", chucVu);
        request.setAttribute("listChucVu", listsChucVu);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-chuc-vu.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminGiaoDienUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        NhanVien nhanVien = nhanVienService.getOne(request.getParameter("id"));
        String formattedDate = dateFormat.format(nhanVien.getNgaySinh());
        listsCuaHang = cuaHangService.getAll();
        listsChucVu = chucVuService.getAll();
        System.out.println("" + listsChucVu.size());
        request.setAttribute("nhanVien", nhanVien);
        request.setAttribute("listCuaHang", listsCuaHang);
        request.setAttribute("listChucVu", listsChucVu);
        request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminDeleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String test = nhanVienService.delete(nhanVienService.getOne(request.getParameter("id")));
        System.out.println(test);
        response.sendRedirect("/admin/nhan-vien-hien-thi");
    }

    private void adminDetailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nhanVien = nhanVienService.getOne(request.getParameter("id"));
        request.setAttribute("listNhanVien", listsNhanVien);
        request.setAttribute("listCuaHang", listsCuaHang);
        request.setAttribute("listChucVu", listsChucVu);
        request.setAttribute("nhanVien", nhanVien);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-nhan-vien.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void adminHienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listsNhanVien = nhanVienService.getAll();
        listsCuaHang = cuaHangService.getAll();
        listsChucVu = chucVuService.getAll();
        request.setAttribute("listNhanVien", listsNhanVien);
        request.setAttribute("listCuaHang", listsCuaHang);
        request.setAttribute("listChucVu", listsChucVu);
        request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-nhan-vien.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("nhan-vien-add")) {
            this.nhanVienAdd(request, response);
        } else if (uri.contains("nhan-vien-update")) {
            this.nhanVienUpdate(request, response);
        } else if (uri.contains("chuc-vu-add")) {
            this.chucVuAdd(request, response);
        } else if (uri.contains("chuc-vu-update")) {
            this.chucVuUpdate(request, response);
        } else if (uri.contains("cua-hang-add")) {
            this.cuaHangAdd(request, response);
        } else if (uri.contains("cua-hang-update")) {
            this.cuaHangUpdate(request, response);
        } else if (uri.contains("chi-tiet-san-pham-add")) {
            this.chiTietSanPhamAdd(request, response);
        } else if (uri.contains("chi-tiet-san-pham-update")) {
            this.chiTietSanPhamUpdate(request, response);
        } else if (uri.contains("khach-hang-add")) {
            this.khachHangAdd(request, response);
        } else if (uri.contains("khach-hang-update")) {
            this.khachHangUpdate(request, response);
        }
    }

    private void khachHangUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        KhachHang khachHang = khachHangService.getOne(id);
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        KhachHang khachHangUpdate = KhachHang.builder().id(id).ma(khachHang.getMa()).ten(ten)
                .tenDem(tenDem).ho(ho).ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt).diaChi(diaChi).quocGia(quocGia).thanhPho(thanhPho).matKhau(matKhau).build();
        HashMap<String, String> listsERR = khachHangService.update(khachHangUpdate);
        if (!listsERR.isEmpty()) {
            request.setAttribute("kh", khachHangUpdate);
            request.setAttribute("err", listsERR);
            request.setAttribute("viewAdmin", "/views/admin/admin-khach-hang-giao-dien-them-moi.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/khach-hang-hien-thi");
        }
    }

    private void khachHangAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");

        HashMap<String, String> listsERR = khachHangService.save(
                KhachHang.builder().ma(khachHangService.genKhachHang()).ten(ten)
                        .tenDem(tenDem).ho(ho).ngaySinh(Date.valueOf(ngaySinh))
                        .sdt(sdt).diaChi(diaChi).quocGia(quocGia).thanhPho(thanhPho).matKhau(matKhau).build()
        );
        if (!listsERR.isEmpty()) {
            request.setAttribute("err", listsERR);
            request.setAttribute("viewAdmin", "/views/admin/admin-khach-hang-giao-dien-them-moi.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/khach-hang-hien-thi");
        }
    }

    private void chiTietSanPhamUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Part filePart = request.getPart("assets");
            String fileName = filePart.getSubmittedFileName();
            String id = request.getParameter("id");
            String namBH = request.getParameter("namBaoHanh");
            String moTa = request.getParameter("moTa");
            String soLuongTon = request.getParameter("soLuongTonSanPham");
            String giaNhap = request.getParameter("giaNhap");
            String giaBan = request.getParameter("giaBan");
            String idSanPham = request.getParameter("idSanPham");
            String idNSX = request.getParameter("idNhaSanXuat");
            String idMauSac = request.getParameter("idMauSac");
            String idDongSP = request.getParameter("idDongSanPham");

            ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(id);
            String oldImg = chiTietSanPham.getAnh();
            chiTietSanPham.setAnh(fileName);
            chiTietSanPham.setNamBH(Integer.valueOf(namBH));
            chiTietSanPham.setMoTa(moTa);
            chiTietSanPham.setSoLuongTon(Integer.valueOf(soLuongTon));
            chiTietSanPham.setGiaNhap(BigDecimal.valueOf(Long.valueOf(giaNhap)));
            chiTietSanPham.setGiaBan(BigDecimal.valueOf(Long.valueOf(giaBan)));
            chiTietSanPham.setIdSanPham(SanPham.builder().id(idSanPham).build());
            chiTietSanPham.setIdNhaSanXuat(NhaSanXuat.builder().id(idNSX).build());
            chiTietSanPham.setIdMauSac(MauSac.builder().id(idMauSac).build());
            chiTietSanPham.setIdDongSanPham(DongSanPham.builder().id(idDongSP).build());
            String appPath = getServletContext().getRealPath("/views/assets") + "\\" + fileName;
            String oldPath = getServletContext().getRealPath("/views/assets") + "\\" + oldImg;
            File imageFile = new File(oldPath);
            filePart.write(appPath);
            imageFile.delete();
            HashMap<String, String> listsERR = chiTietSanPhamService.update(chiTietSanPham);
            if (!listsERR.isEmpty()) {
                request.setAttribute("sp", chiTietSanPham);
                request.setAttribute("err", listsERR);
                request.setAttribute("listSanPham", sanPhamService.getAll());
                request.setAttribute("listNSX", nhaNhaSanXuatService.getAll());
                request.setAttribute("listMauSac", mauSacService.getAll());
                request.setAttribute("listsDongSP", dongSanPhamService.getAll());
                request.setAttribute("viewAdmin", "/views/admin/admin-sp-ct-giao-dien-cap-nhap.jsp");
                request.getRequestDispatcher("/views/index.jsp").forward(request, response);
            } else {
                response.sendRedirect("/admin/chi-tiet-san-pham-hien-thi");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void chiTietSanPhamAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // lấy dữ liệu nhận từ input file
            Part filePart = request.getPart("assets");
            String fileName = filePart.getSubmittedFileName();
            String appPath = getServletContext().getRealPath("/views/assets") + "\\" + fileName;
            filePart.write(appPath);

            String namBH = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon = request.getParameter("soLuongTonSanPham");
            String giaNhap = request.getParameter("giaNhap");
            String giaBan = request.getParameter("giaBan");
            String idSanPham = request.getParameter("idSanPham");
            String idNSX = request.getParameter("idNhaSanXuat");
            String idMauSac = request.getParameter("idMauSac");
            String idDongSP = request.getParameter("idDongSanPham");

            ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
                    .namBH(Integer.parseInt(namBH)).
                    moTa(moTa)
                    .soLuongTon(Integer.parseInt(soLuongTon)).
                    giaBan(BigDecimal.valueOf(Long.valueOf(giaBan))).
                    giaNhap(BigDecimal.valueOf(Long.valueOf(giaNhap))).
                    idSanPham(SanPham.builder().id(idSanPham).build()).
                    idNhaSanXuat(NhaSanXuat.builder().id(idNSX).build()).
                    idMauSac(MauSac.builder().id(idMauSac).build()).
                    idDongSanPham(DongSanPham.builder().id(idDongSP).build()).anh(String.valueOf(fileName)).
                    build();
            HashMap<String, String> listsERR = chiTietSanPhamService.save(chiTietSanPham);
            if (!listsERR.isEmpty()) {
                listsSanPham = sanPhamService.getAll();
                listsNhaSanXuats = nhaNhaSanXuatService.getAll();
                listsDongSanPham = dongSanPhamService.getAll();
                listsMauSac = mauSacService.getAll();
                request.setAttribute("sp", chiTietSanPham);
                request.setAttribute("err", listsERR);
                request.setAttribute("listSanPham", listsSanPham);
                request.setAttribute("listNSX", listsNhaSanXuats);
                request.setAttribute("listMauSac", listsMauSac);
                request.setAttribute("listsDongSP", listsDongSanPham);
                request.setAttribute("viewAdmin", "/views/admin/admin-sp-ct-giao-dien-them-moi.jsp");
                request.getRequestDispatcher("/views/index.jsp").forward(request, response);
            } else {
                response.sendRedirect("/admin/chi-tiet-san-pham-hien-thi");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private void cuaHangUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang cuaHang = cuaHangService.getOne(id);
        cuaHang.setTen(ten);
        cuaHang.setDiaChi(diaChi);
        cuaHang.setThanhPho(thanhPho);
        cuaHang.setQuocGia(quocGia);

        HashMap<String, String> listsERR = cuaHangService.save(cuaHang);
        if (!listsERR.isEmpty()) {
            request.setAttribute("ch", cuaHang);
            request.setAttribute("err", listsERR);
            request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-cua-hang.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/cua-hang-hien-thi");
        }
    }

    private void cuaHangAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang cuaHang = CuaHang.builder().ma(cuaHangService.genCuaHang()).ten(ten).diaChi(diaChi).thanhPho(thanhPho).quocGia(quocGia).build();
        HashMap<String, String> listsERR = cuaHangService.save(cuaHang);
        if (!listsERR.isEmpty()) {
            listsCuaHang = cuaHangService.getAll();
            request.setAttribute("err", listsERR);
            request.setAttribute("ch", cuaHang);
            request.setAttribute("listCuaHang", listsCuaHang);
            request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-cua-hang.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/cua-hang-hien-thi");
        }
    }

    private void chucVuUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        ChucVu chucVu = chucVuService.getOne(id);
        chucVu.setTen(ten);

        HashMap<String, String> listsERR = chucVuService.save(chucVu);
        if (!listsERR.isEmpty()) {
            request.setAttribute("err", listsERR);
            request.setAttribute("cv", chucVu);
            request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap-chuc-vu.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/chuc-vu-hien-thi");
        }
    }

    private void chucVuAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        ChucVu chucVu = ChucVu.builder().ma(chucVuService.genChucVu()).ten(ten).build();
        HashMap<String, String> listsERR = chucVuService.save(chucVu);

        if (!listsERR.isEmpty()) {
            listsChucVu = chucVuService.getAll();
            request.setAttribute("listChucVu", listsChucVu);
            request.setAttribute("err", listsERR);
            request.setAttribute("cv", chucVu);
            request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-chuc-vu.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/chuc-vu-hien-thi");
        }
    }

    private void nhanVienUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        CuaHang cuaHang = CuaHang.builder().id(request.getParameter("idCH")).build();
        ChucVu chucVu = ChucVu.builder().id(request.getParameter("idCV")).build();
        String trangThai = request.getParameter("trangThai");

        NhanVien nhanVien = nhanVienService.getOne(id);
        nhanVien.setHo(ho);
        nhanVien.setTen(ten);
        nhanVien.setGioiTinh(gioiTinh);
        nhanVien.setTenDem(tenDem);
        nhanVien.setNgaySinh(Date.valueOf(ngaySinh));
        nhanVien.setDiaChi(diaChi);
        nhanVien.setSdt(sdt);
        nhanVien.setMatKhau(matKhau);
        nhanVien.setIdCH(cuaHang);
        nhanVien.setIdCV(chucVu);
        nhanVien.setTrangThai(Integer.parseInt(trangThai));

        HashMap<String, String> lists = nhanVienService.update(nhanVien);
        if (!lists.isEmpty()) {
            listsNhanVien = nhanVienService.getAll();
            listsCuaHang = cuaHangService.getAll();
            listsChucVu = chucVuService.getAll();
            request.setAttribute("nhanVien", nhanVien);
            request.setAttribute("err", lists);
            request.setAttribute("listNhanVien", listsNhanVien);
            request.setAttribute("listCuaHang", listsCuaHang);
            request.setAttribute("listChucVu", listsChucVu);
            request.setAttribute("viewAdmin", "/views/admin/admin-giao-dien-cap-nhap.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/nhan-vien-hien-thi");
        }
    }

    private void nhanVienAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String matKhau = request.getParameter("matKhau");
        CuaHang cuaHang = CuaHang.builder().id(request.getParameter("idCH")).build();
        ChucVu chucVu = ChucVu.builder().id(request.getParameter("idCV")).build();
        String trangThai = request.getParameter("trangThai");

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa(nhanVienService.genNhanVien());
        nhanVien.setHo(ho);
        nhanVien.setTen(ten);
        nhanVien.setGioiTinh(gioiTinh);
        nhanVien.setTenDem(tenDem);
        nhanVien.setNgaySinh(Date.valueOf(ngaySinh));
        nhanVien.setDiaChi(diaChi);
        nhanVien.setSdt(sdt);
        nhanVien.setMatKhau(matKhau);
        nhanVien.setIdCH(cuaHang);
        nhanVien.setIdCV(chucVu);
        nhanVien.setTrangThai(Integer.parseInt(trangThai));
        HashMap<String, String> lists = nhanVienService.save(nhanVien);
        if (!lists.isEmpty()) {
            listsNhanVien = nhanVienService.getAll();
            listsCuaHang = cuaHangService.getAll();
            listsChucVu = chucVuService.getAll();
            request.setAttribute("nhanVien", nhanVien);
            request.setAttribute("listNhanVien", listsNhanVien);
            request.setAttribute("listCuaHang", listsCuaHang);
            request.setAttribute("listChucVu", listsChucVu);
            request.setAttribute("err", lists);
            request.setAttribute("viewAdmin", "/views/admin/admin-danh-sach-nhan-vien.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/admin/nhan-vien-hien-thi");
        }
    }
}


