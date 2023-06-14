<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/27/2023
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!--  -->
    <!-- Bootstrap CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
            integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />
    <link rel="stylesheet" href="/views/css/rigister.css"/>
    <link rel="stylesheet" href="/views/css/style.css"/>
    <link rel="stylesheet" href="/views/css/form-login.css"/>
    <link rel="stylesheet" href="/views/css/detail.css"/>
    <link rel="stylesheet" href="/views/css/home-page.css"/>
    <title>XNew</title>
</head>
<body>
<!-- header web -->
<jsp:include page="header-customer.jsp"></jsp:include>
<!-- header end -->
<!-- content web -->
<section class="h-100 h-custom" style="background-color: #f1f1f1">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
                <!-- card -->
                <div
                        class="card card-registration card-registration-2"
                        style="border-radius: 15px"
                >
                    <div class="card-body p-0">
                        <div class="row g-0">
                            <div class="col-lg-8">
                                <div class="p-5">
                                    <div
                                            class="d-flex justify-content-between align-items-center mb-5"
                                    >
                                        <h3 class="fw-bold mb-0 text-black">Giỏ Hàng</h3>
                                    </div>

                                    <hr class="my-4"/>
                                    <!-- bắt đầu row -->
                                    <c:if test="${listGH == null}">
                                        <h4 class="text-center">Không có sản phẩm nào trong giỏ hàng</h4>
                                    </c:if>
                                    <c:if test="${listGH != null}">
                                        <c:forEach var="cart" items="${listGH}">
                                            <div
                                                    class="row mb-4 d-flex justify-content-between align-items-center"
                                            >
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <img
                                                            src="/views/assets/${cart.idChiTietSanPham.anh}"
                                                            class="img-fluid rounded-3"
                                                    />
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                    <h6 class="text-muted"></h6>
                                                    <h6 class="text-black mb-0">${cart.idChiTietSanPham.idSanPham.ten}</h6>
                                                </div>
                                                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                    <input
                                                            id="form1"
                                                            min="1"
                                                            name="quantity"
                                                            value="${cart.soLuong}"
                                                            type="number"
                                                            class="form-control form-control-sm"
                                                    />
                                                </div>
                                                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h6 class="mb-0">
                                                        <fmt:formatNumber value="${cart.donGia}" type="currency"
                                                                          currencySymbol="$"/>
                                                    </h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a
                                                            class="btn btn-primary"
                                                            href=""
                                                    >
                                                        <i class="fas fa-times"></i>
                                                    </a>
                                                </div>
                                            </div>
                                        </c:forEach>

                                    </c:if>
                                    <hr class="my-4"/>

                                    <div class="pt-5">
                                        <h6 class="mb-0">
                                            <a href="/khach-hang/san-pham" class="text-body"
                                            ><i class="fas fa-long-arrow-alt-left me-2"></i>Trang
                                                chủ</a
                                            >
                                        </h6>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 bg-grey">
                                <div class="p-5">
                                    <h3 class="fw-bold mb-5 mt-2 pt-1">Bản Tóm Tắt</h3>
                                    <hr class="my-4"/>

                                    <div class="d-flex justify-content-between mb-4">
                                        <h5 class="text-uppercase">Tổng Tiền</h5>
                                        <h5>
                                            <fmt:formatNumber value="${sessionScope.tongTien}" type="currency"
                                                              currencySymbol="$"/>
                                        </h5>
                                    </div>
                                    <h5 class="text-uppercase mb-3">Cung cấp mã</h5>

                                    <div class="mb-5">
                                        <div class="form-outline">
                                            <input
                                                    ng-model="maThanhToan"
                                                    type="text"
                                                    id="form3Examplea2"
                                                    class="form-control form-control-lg"
                                            />
                                            <label class="form-label" for="form3Examplea2"
                                            >Nhập mã của bạn.</label
                                            >
                                        </div>
                                    </div>

                                    <hr class="my-4"/>

                                    <div class="d-flex justify-content-between mb-5">
                                        <h5 class="text-uppercase">Thành tiền</h5>
                                        <h5>{{tongGia() - maThanhToan | currency:"":0}} VND</h5>
                                    </div>

                                    <button
                                            type="button"
                                            class="btn btn-dark btn-block btn-lg"
                                            data-mdb-ripple-color="dark"
                                            ng-click="thanhToan($event)"
                                    >
                                        Thanh Toán
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- content end -->
<!-- footer web -->
<jsp:include page="footer-customer.jsp"></jsp:include>
<!-- footer end -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"
></script>
<!-- Option 2: Separate Popper and Bootstrap JS -->
<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"
></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"
></script>
<script src="../js/cart.js"></script>
</body>
</html>

