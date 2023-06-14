package com.example.ass_sof3011_ph19850.repository.impl;

import com.example.ass_sof3011_ph19850.entity.ChucVu;
import com.example.ass_sof3011_ph19850.repository.ChucVuRepository;
import com.example.ass_sof3011_ph19850.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class ChucVuRepositoryImpl implements ChucVuRepository {

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> listsChucVu = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu", ChucVu.class);
            return listsChucVu = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public ChucVu getOne(String id) {
        ChucVu chucVu = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "FROM ChucVu WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            chucVu = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chucVu;
    }

    @Override
    public Boolean saveOrUpdate(ChucVu chucVu) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.saveOrUpdate(chucVu);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public Boolean delete(ChucVu chucVu) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(chucVu);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    @Override
    public int genMaChucVu() {
        String maAC = "";
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select MAX(CONVERT(INT,SUBSTRING(ma,5,100))) from ChucVu ";
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
//        new ChucVuRepositoryImpl().saveOrUpdate(ChucVu.builder().ten("Nhân Viên").ma("NV01").build());
//        new ChucVuRepositoryImpl().saveOrUpdate(ChucVu.builder().ten("Trưởng Phòng").ma("NV02").build());
        for (ChucVu cv : new ChucVuRepositoryImpl().getAll()) {
            System.out.println("" + cv.toString());
        }
    }
}
