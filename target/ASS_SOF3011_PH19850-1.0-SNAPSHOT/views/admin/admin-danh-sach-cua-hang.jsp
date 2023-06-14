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
            <h4 class="text-center" style="font-weight: bold">Quản Lý Cửa Hàng</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/cua-hang-add" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã Cửa Hàng</label>
                            <input type="text" class="form-control" name="ma" value="${ch.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Cửa Hàng</label>
                            <input type="text" class="form-control" name="ten" value="${ch.ten}">
                            <span style="color: red">${err.get('ERR_TEN')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Địa Chỉ</label>
                            <input type="text" class="form-control" name="diaChi" value="${ch.diaChi}">
                            <span style="color: red">${err.get('ERR_DIACHI')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Thành Phố</label>
                            <input type="text" class="form-control" name="thanhPho" value="${ch.thanhPho}">
                            <span style="color: red">${err.get('ERR_THANHPHO')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Quốc Gia</label>
                            <input type="text" class="form-control" name="quocGia" value="${ch.quocGia}">
                            <span style="color: red">${err.get('ERR_QUOCGIA')}</span>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm Mới</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="mt-5">
            <div>
                <h5 class="text-center">Danh Sách Cửa Hàng</h5>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Địa Chỉ</th>
                    <th scope="col">Thành Phố</th>
                    <th scope="col">Quốc Gia</th>
                    <th scope="col">AcTion</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCuaHang}" var="cv">
                    <tr>
                        <th>${cv.ma}</th>
                        <td> ${cv.ten}</td>
                        <th>${cv.diaChi}</th>
                        <td> ${cv.thanhPho}</td>
                        <td> ${cv.quocGia}</td>
                        <td>
                            <a role="button" href="/admin/cua-hang-detail?id=${cv.id}"><i
                                    class="fa-solid fa-pen-to-square fa-xl" style="color: #1f3551;">Linh</i></a>

                            <a href="/admin/cua-hang-delete?id=${cv.id}"><i class="fa-solid fa-trash fa-xl"
                                                                            style="color: #e71708;"></i></a>

                            <a href="/admin/cua-hang-giao-dien-update?id=${cv.id}"><i
                                    class="fa-solid fa-pen fa-xl"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>

