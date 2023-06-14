<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/24/2023
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    <div class="form">
        <div>
            <h4 class="text-center" style="font-weight: bold">Quản Lý Khách Hàng</h4>
            <p>Danh Sách Khách Hàng Chi Tiết</p>
            <div class="button">
                <a class="btn btn-success" href="/admin/khach-hang-giao-dien-them-moi" role="button">Thêm Mới</a>
            </div>
        </div>

        <div class="mt-5">
            <div>
                <h5 class="text-center">Danh Sách Sinh Nhân Viên</h5>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Họ & Tên</th>
                    <th scope="col">Ngày Sinh</th>
                    <th scope="col">SDT</th>
                    <th scope="col">Mật Khẩu</th>
                    <th scope="col">Địa Chỉ</th>
                    <th scope="col">AcTion</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listKH}" var="kh">
                    <tr>
                        <th>${kh.ma}</th>
                        <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
                        <td>${kh.ngaySinh}</td>
                        <td>${kh.sdt}</td>
                        <td>${kh.matKhau}</td>
                        <td>${kh.diaChi}</td>
                        <td>
                            <a role="button" href="/admin/khach-hang-detail?id=${kh.id}"><i
                                    class="fa-solid fa-pen-to-square fa-xl" style="color: #1f3551;"></i></a>
                            <a href="/admin/khach-hang-delete?id=${kh.id}"><i class="fa-solid fa-trash fa-xl"
                                                                              style="color: #e71708;"></i></a>
                            <a href="/admin/khach-hang-giao-dien-update?id=${kh.id}"><i
                                    class="fa-solid fa-pen fa-xl"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>

