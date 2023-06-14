package com.example.ass_sof3011_ph19850.repository.impl;

import com.example.ass_sof3011_ph19850.entity.GioHangChiTiet;
import com.example.ass_sof3011_ph19850.repository.GioHangChiTietRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;


public class GioHangChiTietRepositoryImpl implements GioHangChiTietRepository {
    @Override
    public List<GioHangChiTiet> getAll() {
        List<GioHangChiTiet> listsGioHangCHiTiet = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GioHangChiTiet", GioHangChiTiet.class);
            listsGioHangCHiTiet = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listsGioHangCHiTiet;
    }

    @Override
    public GioHangChiTiet getOne(String idSP) {
        GioHangChiTiet gioHangCt;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM GioHangChiTiet Where idChiTietSP.id = :idSP", GioHangChiTiet.class);
            query.setParameter("idSP", idSP);
            return gioHangCt = (GioHangChiTiet) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Boolean saveOrUpdate(GioHangChiTiet gioHangChiTiet) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(gioHangChiTiet);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("" + new GioHangChiTietRepositoryImpl().getOne("C2B9CD64-337A-4F98-BFE2-4E63049170AE"));
    }
}
