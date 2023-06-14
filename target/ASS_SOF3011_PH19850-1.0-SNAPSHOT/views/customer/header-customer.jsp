<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/26/2023
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header-index">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/customer/trang-chu"
                ><img
                        src="/views/assets/logo-chu-X-x_logo_2x-2-removebg.png"
                        alt=""
                        srcset=""
                        width="150"
                        height="90"
                /></a>
                <button
                        class="navbar-toggler"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a
                                    class="nav-link active"
                                    aria-current="page"
                                    href="/khach-hang/trang-chu"
                            >Trang Chủ</a
                            >
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/khach-hang/san-pham">Sản Phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/khach-hang/gioi-thieu">Giới Thiệu</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/khach-hang/tin-tuc">Tin Tức</a>
                        </li>
                    </ul>
                    <form class="d-flex ms-auto">
                        <div class="dropdown">
                            <a
                                    class="dropdown-toggle"
                                    id="dropdownMenuButton1"
                                    data-bs-toggle="dropdown"
                                    aria-expanded="false"
                                    style="text-decoration: none"
                            >
                                <i
                                        class="fas fa-user"
                                        style="font-size: 17px; color: white"
                                ></i>
                                <span style="font-size: 17px; color: white"
                                >Tài khoản: ${sessionScope.acc.ten}</span
                                >
                            </a>
                            <ul
                                    class="dropdown-menu"
                                    aria-labelledby="dropdownMenuButton1"
                                    style="font-size: 17px; color: white"
                            >
                                <li>
                                    <a class="dropdown-item" href="/dang-nhap">Đăng Nhập</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/khach-hang/dang-ky"
                                    >Đăng Kí</a
                                    >
                                </li>
                                <li>
                                    <a class="dropdown-item" href="#change-password"
                                    >Lấy Lại Mật Khẩu</a
                                    >
                                </li>
                                <hr class="dropdown-divider"/>
                            </ul>
                        </div>
                    </form>
                    <a href="/khach-hang/gio-hang" class="position-relative">
                        <i
                                class="fa fa-shopping-cart"
                                style="font-size: 17px; color: white"
                        ></i>
                        <span
                                class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"
                        >
                            ${sessionScope.size}
                         </span>
                    </a>
                </div>
            </div>
        </nav>
    </div>
</header>
