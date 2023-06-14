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
    <div class="mt-5">
        <h4 style="font-weight: bold" class="text-center">Thêm Mới Chi Tiết Sản Phẩm</h4>
        <div class="row">
            <div class="col-sm-6 offset-sm-3">
                <form action="/admin/chi-tiet-san-pham-add" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label class="form-label">Tên Sản Phẩm</label>
                        <select name="idSanPham" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listSanPham}" var="spV">
                                <option ${sp.idSanPham.id == spV.id?"selected":""} value="${spV.id}">${spV.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Năm Bảo Hành</label>
                        <input type="number" min="1" step="1" class="form-control" name="namBH" value="${sp.namBH}"
                               required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Số Lượng Tồn</label>
                        <input type="number" min="1" step="1" class="form-control" name="soLuongTonSanPham"
                               value="${sp.soLuongTon}" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Giá Nhập</label>
                        <input type="number" min="100000" step="50" class="form-control" name="giaNhap"
                               value="${sp.giaNhap}" required>
                        <span style="color: red">${err.get('ERR_GIANHAP')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Giá Bán</label>
                        <input type="number" min="100000" step="50" class="form-control" name="giaBan"
                               value="${sp.giaBan}" required>
                        <span style="color: red">${err.get('ERR_GIABAN')}</span>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nhà Sản Xuất</label>
                        <select name="idNhaSanXuat" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listNSX}" var="nhaSanXuat">
                                <option ${sp.idNhaSanXuat.id == nhaSanXuat.id?"selected":""}
                                        value="${nhaSanXuat.id}">${nhaSanXuat.ten}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Màu Sắc</label>
                        <select name="idMauSac" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listMauSac}" var="ms">
                                <option ${sp.idMauSac.id == ms.id?"selected":""} value="${ms.id}">${ms.ten}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Dòng Sản Phẩm</label>
                        <select name="idDongSanPham" class="form-select" aria-label="Default select example">
                            <c:forEach items="${listsDongSP}" var="dSP">
                                <option ${sp.idDongSanPham.id == dSP.id?"selected":""}
                                        value="${dSP.id}">${dSP.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="formFileMultiple" class="form-label">Ảnh Sản Phẩm</label>
                        <input class="form-control" name="assets" type="file" id="formFileMultiple" required="Yêu cầu nhập ảnh">
                        <c:if test="${sp.anh != null}">
                            <div>Ảnh</div>
                            <img class="mt-2" src="/views/assets/${sp.anh}"
                                 style="height: 150px;width: 150px">
                        </c:if></div>
                    <%--                    <div class="mb-3">--%>
                    <%--                        <label class="form-label">Ảnh Sản Phẩm</label>--%>
                    <%--                        <input class="form-control" type="file" name="anh" size="60">--%>
                    <%--                        <c:if test="${sp.anh != null}">--%>
                    <%--                            <div>Ảnh</div>--%>
                    <%--                            <img class="mt-2" src="/views/assets/${sp.anh}"--%>
                    <%--                                 style="height: 150px;width: 150px">--%>
                    <%--                        </c:if>--%>
                    <%--                    </div>--%>
                    <div class="mb-3">
                        <label class="form-label">Mô Tả</label>
                        <input type="text" class="form-control" name="moTa"
                               value="${sp.moTa}">
                        <span style="color: red">${err.get('ERR_MOTA')}</span>
                    </div>
                    <button type="submit" class="btn btn-success">Thêm Mới</button>
                </form>
            </div>
        </div>
    </div>

</section>

