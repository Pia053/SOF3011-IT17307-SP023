package com.example.ass_sof3011_ph19850.infrastructure;


import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
public class GenDB {
    public static void main(String[] args) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
//        Của Hàng
//            CuaHang cuaHang1 = CuaHang.builder().id("").ma("CH0024").ten("Phúc Long").thanhPho("Hà Nội").diaChi("HQV").quocGia("Việt NAM").build();
//            session.save(cuaHang1);
//            CuaHang cuaHang2 = CuaHang.builder().id("").ma("CH0035").ten("LaiKa").diaChi("HQV").thanhPho("Hà Nội").quocGia("Việt NAM").build();
//            session.save(cuaHang2);
//             chức Vụ
//            ChucVu chucVu1 = ChucVu.builder().id("").ma("CV001").ten("Giám Đốc Kinh Doanh").build();
//            session.save(chucVu1);
//            ChucVu chucVu2 = ChucVu.builder().id("").ma("CV002").ten("Kế Toán").build();
//            session.save(chucVu2);
//      Nhân Viên
//            NhanVien nhanVien1 = NhanVien.builder().id("").
//                    ma("NV001").
//                    ten("Kiên").
//                    tenDem("Anh").
//                    ho("Nguyễn").
//                    gioiTinh("Nam").
//                    ngaySinh(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2000")).
//                    diaChi("Hà Đông").
//                    sdt("091742990").
//                    matKhau("123456").
//                    idCH(cuaHang1).
//                    idCV(chucVu1).
//                    trangThai(1).
//                    build();
//            session.save(nhanVien1);
//            NhanVien nhanVien2 = NhanVien.builder().id("").
//                    ma("NV002").
//                    ten("Thy").
//                    tenDem("Anh").
//                    ho("Nguyễn").
//                    gioiTinh("Nam").
//                    ngaySinh(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2001")).
//                    diaChi("Hà Đông").
//                    sdt("091742999").
//                    matKhau("123456").
//                    idCH(cuaHang1).
//                    idCV(chucVu2).
//                    trangThai(1).
//                    build();
//            session.save(nhanVien2);
//            NhanVien nhanVien3 = NhanVien.builder().id("").
//                    ma("NV003").
//                    ten("Anh").
//                    tenDem("Vân").
//                    ho("Nguyễn").
//                    gioiTinh("Nữ").
//                    ngaySinh(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/1999")).
//                    diaChi("Hà Đông").
//                    sdt("091742954").
//                    matKhau("123456").
//                    idCH(cuaHang2).
//                    idCV(chucVu2).
//                    trangThai(1).
//                    build();
//            session.save(nhanVien3);
//            NhanVien nhanVien4 = NhanVien.builder().id("").
//                    ma("NV006").
//                    ten("Cường").
//                    tenDem("Anh").
//                    ho("Nguyễn").
//                    gioiTinh("Nam").
//                    ngaySinh(new SimpleDateFormat("dd/MM/yyyy").parse("15/02/1993")).
//                    diaChi("Hà Đông").
//                    sdt("091742477").
//                    matKhau("123456").
//                    idCH(cuaHang1).
//                    idCV(chucVu2).
//                    trangThai(0).
//                    build();
//            session.save(nhanVien4);
//      San Phẩm
//            SanPham sanPham1 = SanPham.builder().id("").ma("SP001").ten("AF1 âm Dương").build();
//            session.save(sanPham1);
//            SanPham sanPham2 = SanPham.builder().id("").ma("SP002").ten("JD1 travit xanh like auth").build();
//            session.save(sanPham2);
//            SanPham sanPham3 = SanPham.builder().id("").ma("SP003").ten("Gucci AF1 new 1:1").build();
//            session.save(sanPham3);
//            SanPham sanPham4 = SanPham.builder().id("").ma("SP004").ten("JD1 đen cao cổ like auth").build();
//            session.save(sanPham4);
//            SanPham sanPham5 = SanPham.builder().id("").ma("SP005").ten("JD1 loang bò").build();
//            session.save(sanPham5);
//            SanPham sanPham6 = SanPham.builder().id("").ma("SP006").ten("Nike trắng auth").build();
//            session.save(sanPham6);
//            SanPham sanPham7 = SanPham.builder().id("").ma("SP007").ten("Nike móc nâu kem rep 1:1").build();
//            session.save(sanPham7);
//            SanPham sanPham8 = SanPham.builder().id("").ma("SP008").ten("JD1 siêu cấp new").build();
//            session.save(sanPham8);
//            SanPham sanPham9 = SanPham.builder().id("").ma("SP009").ten("JD1 xám trắng like auth").build();
//            session.save(sanPham9);
//            SanPham sanPham10 = SanPham.builder().id("").ma("SP010").ten("JD1 low back").build();
//            session.save(sanPham10);
//            NSX
//            NSX nsx1 = NSX.builder().ma("NSX001").id("").ten("Nike AF1").build();
//            session.save(nsx1);
//            NSX nsx2 = NSX.builder().ma("NSX002").id("").ten("Jordan 1").build();
//            session.save(nsx2);
//            NSX nsx3 = NSX.builder().ma("NSX003").id("").ten("Gucci").build();
//            session.save(nsx3);
//            Dong SP
//            DongSP dongSP1 = DongSP.builder().id("").ma("DSP001").ten("Like Auth").build();
//            session.save(dongSP1);
//            DongSP dongSP2 = DongSP.builder().id("").ma("DSP002").ten("Auth").build();
//            session.save(dongSP2);
//            DongSP dongSP3 = DongSP.builder().id("").ma("DSP003").ten("Rep 1:1").build();
//            session.save(dongSP3);
//            Màu Sắc
//            MauSac mauSac1 = MauSac.builder().id("").ma("MS001").ten("Trắng").build();
//            session.save(mauSac1);
//            MauSac mauSac2 = MauSac.builder().id("").ma("MS002").ten("Kem").build();
//            session.save(mauSac2);
//            MauSac mauSac3 = MauSac.builder().id("").ma("MS003").ten("Đen").build();
//            session.save(mauSac3);
//            MauSac mauSac4 = MauSac.builder().id("").ma("MS004").ten("Đen Trắng").build();
//            session.save(mauSac4);
//            MauSac mauSac5 = MauSac.builder().id("").ma("MS005").ten("Xanh").build();
//            session.save(mauSac5);
//            Chi Tiết Sp
//            ChiTietSP chiTietSP1 = ChiTietSP.builder().id("").
//                    idNSX(nsx1).
//                    idSanPham(sanPham1).
//                    idMauSac(mauSac4).
//                    idDongSP(dongSP1).namBH(5).moTa("Đẹp, bền, hot").soLuongTon(13).
//                    giaNhap(BigDecimal.valueOf(500000)).
//                    giaBan(BigDecimal.valueOf(1000000)).anh("af1-am-duong-new-1.jpg").
//                    build();
//            session.save(chiTietSP1);
//            ChiTietSP chiTietSP2 = ChiTietSP.builder().id("").
//                    idNSX(nsx2).
//                    idSanPham(sanPham2).
//                    idMauSac(mauSac5).
//                    idDongSP(dongSP1).namBH(5).moTa("Đẹp, bền, hot").soLuongTon(13).
//                    giaNhap(BigDecimal.valueOf(500000)).
//                    giaBan(BigDecimal.valueOf(1000000)).anh("Giày-Jd1-Travit-xanh-hàng-like-auth-0.jpeg").
//                    build();
//            session.save(chiTietSP2);
//
//            ChiTietSP chiTietSP3 = ChiTietSP.builder().id("").
//                    idNSX(nsx3).
//                    idSanPham(sanPham3).
//                    idMauSac(mauSac5).
//                    idDongSP(dongSP2).namBH(5).moTa("Đẹp, bền, hot").soLuongTon(13).
//                    giaNhap(BigDecimal.valueOf(500000)).
//                    giaBan(BigDecimal.valueOf(1000000)).anh("gucci-af1-new-1.jpg").
//                    build();
//            session.save(chiTietSP3);
//
//            ChiTietSP chiTietSP4 = ChiTietSP.builder().id("").
//                    idNSX(nsx2).
//                    idSanPham(sanPham4).
//                    idMauSac(mauSac5).
//                    idDongSP(dongSP3).namBH(5).moTa("Đẹp, bền, hot").soLuongTon(13).
//                    giaNhap(BigDecimal.valueOf(500000)).
//                    giaBan(BigDecimal.valueOf(1000000)).anh("JD1-Den-Cao-Co-0.jpg").
//                    build();
//            session.save(chiTietSP4);
//
//            ChiTietSP chiTietSP5 = ChiTietSP.builder().id("").
//                    idNSX(nsx2).
//                    idSanPham(sanPham5).
//                    idMauSac(mauSac2).
//                    idDongSP(dongSP3).namBH(5).moTa("Đẹp, bền, hot").soLuongTon(13).
//                    giaNhap(BigDecimal.valueOf(500000)).
//                    giaBan(BigDecimal.valueOf(1000000)).anh("JD1-Loang-Bo-0.jpg").
//                    build();
//            session.save(chiTietSP5);
//
//            ChiTietSP chiTietSP6 = ChiTietSP.builder().id("").
//                    idNSX(nsx1).
//                    idSanPham(sanPham6).
//                    idMauSac(mauSac1).
//                    idDongSP(dongSP2).namBH(5).moTa("Đẹp, bền, hot").soLuongTon(13).
//                    giaNhap(BigDecimal.valueOf(500000)).
//                    giaBan(BigDecimal.valueOf(1000000)).anh("nike-trang-0.jpeg").
//                    build();
//            session.save(chiTietSP6);
//      Khách Hàng
            KhachHang kh = KhachHang.builder().
                    ma("KH001").
                    ten("Cường").
                    tenDem("Anh").
                    ho("Nguyễn").
                    ngaySinh(Date.valueOf("15/02/1993")).
                    diaChi("Hà Đông").
                    sdt("091742477").
                    matKhau("123456").
                    diaChi("63 th").
                    thanhPho("Hà Nội").
                    quocGia("Việt Nam").build();
            session.save(kh);
            KhachHang kh2 = KhachHang.builder().
                    ma("KH002").
                    ten("Vinh").
                    tenDem("Anh").
                    ho("Nguyễn").
                    ngaySinh(Date.valueOf("15/02/1993")).
                    diaChi("Hà Đông").
                    sdt("091742477").
                    matKhau("123456").
                    diaChi("63 th").
                    thanhPho("Hà Nội").
                    quocGia("Việt Nam").build();
            session.save(kh2);
            KhachHang kh3 = KhachHang.builder().
                    ma("KH003").
                    ten("Thy").
                    tenDem("Anh").
                    ho("Phạm").
                    ngaySinh(Date.valueOf("15/02/1993")).
                    diaChi("Hà Đông").
                    sdt("091742477").
                    matKhau("123456").
                    diaChi("63 th").
                    thanhPho("Hà Nội").
                    quocGia("Việt Nam").build();
            session.save(kh3);
            KhachHang kh4 = KhachHang.builder().
                    ma("KH004").
                    ten("Nhi").
                    tenDem("Diệu").
                    ho("Trần").
                    ngaySinh(Date.valueOf("15/02/1993")).
                    diaChi("Hà Đông").
                    sdt("091742477").
                    matKhau("123456").
                    diaChi("63 th").
                    thanhPho("Hà Nội").
                    quocGia("Việt Nam").build();
            session.save(kh4);
            KhachHang kh5 = KhachHang.builder().
                    ma("KH005").
                    ten("Nhi").
                    tenDem("Linh").
                    ho("Nguyễn").
                    ngaySinh(Date.valueOf("15/02/1993")).
                    diaChi("Hà Đông").
                    sdt("091742477").
                    matKhau("123456").
                    diaChi("63 th").
                    thanhPho("Hà Nội").
                    quocGia("Việt Nam").build();
            session.save(kh5);
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
