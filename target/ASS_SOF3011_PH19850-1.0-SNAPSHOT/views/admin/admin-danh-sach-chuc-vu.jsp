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
            <h4 class="text-center" style="font-weight: bold">Quản Lý Chức Vụ</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/chuc-vu-add" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã Chức Vụ</label>
                            <input type="text" class="form-control" name="ma" value="${cv.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Chức Vụ</label>
                            <input type="text" class="form-control" name="ten" value="${cv.ten}">
                            <span style="color: red">${err.get('ERR_TEN')}</span>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm Mới</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="mt-5">
            <div>
                <h5 class="text-center">Danh Sách Chức Vụ</h5>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">AcTion</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listChucVu}" var="cv">
                    <tr>
                        <th>${cv.ma}</th>
                        <td> ${cv.ten}</td>
                        <td>
                            <a role="button" href="/admin/chuc-vu-detail?id=${cv.id}"><i
                                    class="fa-solid fa-pen-to-square fa-xl" style="color: #1f3551;">Linh</i></a>

                            <a href="/admin/chuc-vu-delete?id=${cv.id}"><i class="fa-solid fa-trash fa-xl"
                                                                             style="color: #e71708;"></i></a>

                            <a href="/admin/chuc-vu-giao-dien-update?id=${cv.id}"><i
                                    class="fa-solid fa-pen fa-xl"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>

