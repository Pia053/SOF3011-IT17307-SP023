package com.example.ass_sof3011_ph19850.util;

import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;
import com.example.ass_sof3011_ph19850.entity.ChucVu;
import com.example.ass_sof3011_ph19850.entity.CuaHang;
import com.example.ass_sof3011_ph19850.entity.DongSanPham;
import com.example.ass_sof3011_ph19850.entity.GioHang;
import com.example.ass_sof3011_ph19850.entity.GioHangChiTiet;
import com.example.ass_sof3011_ph19850.entity.HoaDon;
import com.example.ass_sof3011_ph19850.entity.HoaDonChiTiet;
import com.example.ass_sof3011_ph19850.entity.KhachHang;
import com.example.ass_sof3011_ph19850.entity.MauSac;
import com.example.ass_sof3011_ph19850.entity.NhaSanXuat;
import com.example.ass_sof3011_ph19850.entity.NhanVien;
import com.example.ass_sof3011_ph19850.entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * @author hangnt169
 */
public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "songlong");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(DongSanPham.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }

}
