package com.example.ass_sof3011_ph19850.repository.impl;


import com.example.ass_sof3011_ph19850.entity.NhanVien;
import com.example.ass_sof3011_ph19850.repository.NhanVienRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;


public class NhanVienRepositoryImpl implements NhanVienRepository {


    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> listsNhanVien = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM NhanVien";
            Query query = session.createQuery(hql);
            listsNhanVien = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsNhanVien;
    }

    @Override
    public Boolean saveOrUpdate(NhanVien nhanVien) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            System.out.println("" + nhanVien.getIdCH());
            session.saveOrUpdate(nhanVien);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(NhanVien nhanVien) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(nhanVien);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public NhanVien getOne(String id) {
        NhanVien nhanVien = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhanVien where id = :id");
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nhanVien;
    }

    @Override
    public int genMaNhanVien() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from NhanVien ";
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
        NhanVien nv = new NhanVienRepositoryImpl().getOne("0422349E-6E08-4A01-B9B2-0E6C8140E263");
        System.out.println("" + nv.toString());


    }
}
