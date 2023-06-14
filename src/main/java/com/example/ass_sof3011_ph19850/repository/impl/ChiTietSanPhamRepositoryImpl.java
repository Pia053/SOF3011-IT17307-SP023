package com.example.ass_sof3011_ph19850.repository.impl;

import com.example.ass_sof3011_ph19850.entity.ChiTietSanPham;
import com.example.ass_sof3011_ph19850.repository.ChiTietSanPhamRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSanPhamRepositoryImpl implements ChiTietSanPhamRepository {

    @Override
    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> listsChiTietSanPham = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM ChiTietSanPham";
            Query query = session.createQuery(hql);
            listsChiTietSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsChiTietSanPham;
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        ChiTietSanPham chiTietSanPham = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From ChiTietSanPham where id = :id");
            query.setParameter("id", id);
            chiTietSanPham = (ChiTietSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chiTietSanPham;
    }

    @Override
    public Boolean saveOrUpdate(ChiTietSanPham chiTietSanPham) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(chiTietSanPham);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(ChiTietSanPham chiTietSanPham) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(chiTietSanPham);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public List<ChiTietSanPham> getByIdNSX(String idNSX) {
        List<ChiTietSanPham> listsChiTietSanPham = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM ChiTietSanPham Where idNhaSanXuat.id = :idnsx";
            Query query = session.createQuery(hql);
            query.setParameter("idnsx", idNSX);
            listsChiTietSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsChiTietSanPham;
    }

    @Override
    public int genMaChiTietSP() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from ChiTietSP ";
            NativeQuery query = session.createNativeQuery(hql);
            maAC = query.getSingleResult().toString();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        if (maAC == "") {
            maAC = "1";
            int ma = Integer.valueOf(maAC);
            return ma;
        }
        int ma = Integer.valueOf(maAC);
        return ++ma;
    }

    public static void main(String[] args) {
//        new ChiTietSanPhamRepositoryImpl().getAll().forEach(
//                c -> System.out.println("" + c.getIdSanPham().getTen())
//        );
        System.out.println(new ChiTietSanPhamRepositoryImpl().getByIdNSX("E61CE221-09C3-4F4B-BCFA-50ED32B8D9D1"));
    }
}
