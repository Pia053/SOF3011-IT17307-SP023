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
            <h4 class="text-center" style="font-weight: bold">Cập Nhập Cửa Hàng</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/cua-hang-update?id=${ch.id}" method="post">
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
                        <button type="submit" class="btn btn-primary">Cập Nhập</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

