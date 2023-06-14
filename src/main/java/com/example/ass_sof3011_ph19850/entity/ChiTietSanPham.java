package com.example.ass_sof3011_ph19850.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSanPham implements Serializable {
    @Id
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP")
    private SanPham idSanPham;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx")
    private NhaSanXuat idNhaSanXuat;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac")
    private MauSac idMauSac;
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP")
    private DongSanPham idDongSanPham;

    @Column(name = "Anh")
    private String anh;

}
