<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/25/2023
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    <div>
        <h4 style="font-weight: bold" class="text-center">Thêm Mới Khách Hàng</h4>
        <div class="row">
            <div class="col-sm-6 offset-sm-3">
                <form action="/admin/khach-hang-add" method="post">
                    <div class="mb-3">
                        <label class="form-label">Mã khách Hàng</label>
                        <input type="text" class="form-control" name="ma" value="${kh.ma}" disabled>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Họ Khách Hàng</label>
                        <input type="text" class="form-control" name="ho" value="${kh.ho}">
                        <span style="color: red">${err.get('ERR_HO')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Tên Đệm Khách Hàng</label>
                        <input type="text" class="form-control" name="tenDem" value="${kh.tenDem}">
                        <span style="color: red">${err.get('ERR_TENDEM')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Tên Khách Hàng</label>
                        <input type="text" class="form-control" name="ten" value="${kh.ten}">
                        <span style="color: red">${err.get('ERR_TEN')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày Sinh</label>
                        <input type="date" class="form-control" name="ngaySinh" value="${kh.ngaySinh}" required>
                        <%--                        <input type="text" class="form-control" name="ngaySinh" value="${kh.ngaySinh}"--%>
                        <%--                               pattern="\d{4}-\d{2}-\d{2}" required>--%>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Địa Chỉ</label>
                        <input type="text" class="form-control" name="diaChi" value="${kh.diaChi}">
                        <span style="color: red">${err.get('ERR_DIACHI')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Thành Phố</label>
                        <input type="text" class="form-control" name="thanhPho" value="${kh.thanhPho}">
                        <span style="color: red">${err.get('ERR_THANHPHO')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Quốc Gia</label>
                        <input type="text" class="form-control" name="quocGia" value="${kh.quocGia}">
                        <span style="color: red">${err.get('ERR_QUOCGIA')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label"> Điện Thoại</label>
                        <input type="text" class="form-control" name="sdt" value="${kh.sdt}">
                        <span style="color: red">${err.get('ERR_SODIENTHOAI')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Mật Khẩu</label>
                        <input type="text" class="form-control" name="matKhau" value="${kh.matKhau}">
                        <span style="color: red">${err.get('ERR_MATKHAU')}</span>
                    </div>
                    <button type="submit" class="btn btn-primary">Thêm Mới Khách Hàng</button>
                </form>
            </div>
        </div>
    </div>
</section>

