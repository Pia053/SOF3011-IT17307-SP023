<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/24/2023
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">QUẢN LÝ</div>
                        <a class="nav-link collapsed" href="/admin" data-bs-toggle="collapse"
                           data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            Nhân Viên
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne"
                             data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/admin/nhan-vien-hien-thi">Nhân Viên</a>
                                <a class="nav-link" href="/admin/chuc-vu-hien-thi">Chức Vụ</a>
                                <a class="nav-link" href="/admin/cua-hang-hien-thi">Cửa Hàng</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="/admin" data-bs-toggle="collapse"
                           data-bs-target="#collapseLayouts1" aria-expanded="false" aria-controls="collapseLayouts">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            Sản Phẩm
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseLayouts1" aria-labelledby="headingOne"
                             data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/admin/chi-tiet-san-pham-hien-thi">Chi Tiết Sản Phẩm</a>
                                <a class="nav-link" href="/admin/nha-san-xuat-hien-thi">Nhà Sản Xuất</a>
                                <a class="nav-link" href="/admin/mau-sac-hien-thi">Màu Sắc</a>
                                <a class="nav-link" href="/admin/san-pham-hien-thi">Sản Phẩm</a>
                                <a class="nav-link" href="/admin/dong-san-pham1-hien-thi">Dòng Sản Phẩm</a>
                            </nav>
                        </div>

                        <div class="sb-sidenav-menu-heading">Thông Tin</div>
                        <a class="nav-link" href="/admin/khach-hang-hien-thi">
                            <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                            Khách Hàng
                        </a>
                        <a class="nav-link" href="charts.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                            Hóa Đơn
                        </a>
                        <a class="nav-link" href="tables.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            Đơn Hàng
                        </a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</section>
