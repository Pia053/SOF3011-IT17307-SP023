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
            <h4 class="text-center" style="font-weight: bold">Quản Lý Nhân Viên</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/nhan-vien-add" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã Nhân Viên</label>
                            <input type="text" class="form-control" name="ma" value="${nhanVien.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Họ Nhân Viên</label>
                            <input type="text" class="form-control" name="ho" value="${nhanVien.ho}">
                            <span style="color: red">${err.get('ERR_HO')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Đệm Nhân Viên</label>
                            <input type="text" class="form-control" name="tenDem" value="${nhanVien.tenDem}">
                            <span style="color: red">${err.get('ERR_TENDEM')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Nhân Viên</label>
                            <input type="text" class="form-control" name="ten" value="${nhanVien.ten}">
                            <span style="color: red">${err.get('ERR_TEN')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giới Tính</label>
                            <input type="text" class="form-control" name="gioiTinh" value="${nhanVien.gioiTinh}">
                            <span style="color: red">${err.get('ERR_GIOITINH')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày Sinh</label>
                            <%--                            <input type="date" id="date-input" value="${nhanVien.ngaySinh}" name="ngaSinh" pattern="\d{4}-\d{2}-\d{2}" required>--%>
                            <input type="date" class="form-control" name="ngaySinh" value="${nhanVien.ngaySinh}" required>
                            <span style="color: red">${err.get('ERR_NGAYSINH')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Địa Chỉ</label>
                            <input type="text" class="form-control" name="diaChi" value="${nhanVien.diaChi}">
                            <span style="color: red">${err.get('ERR_DIACHI')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số Điện Thoại</label>
                            <input type="text" class="form-control" name="sdt" value="${nhanVien.sdt}">
                            <span style="color: red">${err.get('ERR_SODIENTHOAI')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Mật Khẩu</label>
                            <input type="text" class="form-control" name="matKhau" value="${nhanVien.matKhau}">
                            <span style="color: red">${err.get('ERR_MATKHAU')}</span>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Cửa Hàng</label>
                            <select name="idCH" class="form-select" aria-label="Default select example">
                                <c:forEach items="${listCuaHang}" var="ch">
                                    <option ${nhanVien.idCH.id ==ch.id?"selected":""}
                                            value="${ch.id}">${ch.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Chức Vụ</label>
                            <select name="idCV" class="form-select" aria-label="Default select example">
                                <c:forEach items="${listChucVu}" var="cv">
                                    <option ${nhanVien.idCV.id == cv.id? "selected":""}
                                            value="${cv.id}">${cv.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Trạng Thái</label>
                            <select name="trangThai" class="form-select" aria-label="Default select example">
                                <option ${nhanVien.trangThai== 0 ? "selected":""} value="0">Đang Làm</option>
                                <option ${nhanVien.trangThai== 1 ? "selected":""} value="1">Đã Nghỉ</option>
                                <option ${nhanVien.trangThai== 2 ? "selected":""} value="2">Thời Vụ</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm Mới</button>
                    </form>
                </div>
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
                    <th scope="col">Giới Tính</th>
                    <th scope="col">Ngày Sinh</th>
                    <th scope="col">SDT</th>
                    <th scope="col">Mật Khẩu</th>
                    <th scope="col">Cửa Hàng</th>
                    <th scope="col">Chức Vụ</th>
                    <th scope="col">Trạng Thái</th>
                    <th scope="col">AcTion</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listNhanVien}" var="nv">
                    <tr>
                        <th>${nv.ma}</th>
                        <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                        <td>${nv.gioiTinh}</td>
                        <td>${nv.ngaySinh}</td>
                        <td>${nv.sdt}</td>
                        <td>${nv.matKhau}</td>
                        <td>${nv.idCH.ten}</td>
                        <td>${nv.idCV.ten}</td>
                        <td>
                            <c:if test="${nv.trangThai==0}">Đang Làm</c:if>
                            <c:if test="${nv.trangThai==1}">Đã Nghỉ</c:if>
                            <c:if test="${nv.trangThai==2}">Thời Vụ</c:if>
                        </td>
                        <td>
                            <a role="button" href="/admin/nhan-vien-detail?id=${nv.id}"><i
                                    class="fa-solid fa-pen-to-square fa-xl" style="color: #1f3551;">Linh</i></a>

                            <a href="/admin/nhan-vien-delete?id=${nv.id}"><i class="fa-solid fa-trash fa-xl"
                                                                             style="color: #e71708;"></i></a>

                            <a href="/admin/nhan-vien-giao-dien-update?id=${nv.id}"><i
                                    class="fa-solid fa-pen fa-xl"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>

