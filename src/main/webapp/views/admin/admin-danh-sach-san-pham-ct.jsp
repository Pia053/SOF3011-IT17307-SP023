<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/25/2023
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    <div>
        <h4 style="font-weight: bold" class="text-center">Quản Lý Sản Phẩm Chi Tiết</h4>
        <p>Danh Sách Sản Phẩm Chi Tiết</p>
        <div>
            <div class="button">
                <a class="btn btn-success" href="/admin/chi-tiet-san-pham-them-moi" role="button">Thêm Mới</a>
            </div>
            <div class="mt-5">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Ảnh</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Giá Nhập</th>
                        <th scope="col">Giá Bán</th>
                        <th scope="col">Số Lượng</th>
                        <th scope="col">Màu Sắc</th>
                        <th scope="col">NSX</th>
                        <th scope="col">Dòng SP</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listsChiTietSP}" var="sp">
                        <tr>
                            <th>
                            <img src="/views/assets/${sp.anh}" style="width: 100px; height: 100px">
                            </th>
                            <td>${sp.idSanPham.ten}</td>
                            <td>${sp.giaNhap}</td>
                            <td>${sp.giaBan}</td>
                            <td>${sp.soLuongTon}</td>
                            <td>${sp.idMauSac.ten}</td>
                            <td>${sp.idNhaSanXuat.ten}</td>
                            <td>${sp.idDongSanPham.ten}</td>
                            <td>
                                <a role="button" href="/admin/chi-tiet-san-pham-detail?id=${sp.id}"><i class="fa-solid fa-pen-to-square fa-xl" style="color: #1f3551;">Linh</i></a>

                                <a href="/admin/chi-tiet-san-pham-delete?id=${sp.id}"><i class="fa-solid fa-trash fa-xl" style="color: #e71708;"></i></a>

                                <a href="/admin/chi-tiet-san-pham-giao-dien-update?id=${sp.id}"><i class="fa-solid fa-pen fa-xl"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
