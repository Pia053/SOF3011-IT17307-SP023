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
            <h4 class="text-center" style="font-weight: bold">Quản Lý Màu Sắc</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/mau-sac-add" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã Màu</label>
                            <input type="text" class="form-control" name="ma" value="${ms.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Màu</label>
                            <input type="text" class="form-control" name="ten" value="${ms.ten}">
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
                <c:forEach items="${listMS}" var="ms">
                    <tr>
                        <th>${ms.ma}</th>
                        <td> ${ms.ten}</td>
                        <td>
                            <a role="button" href="/admin/mau-sac-detail?id=${ms.id}"><i
                                    class="fa-solid fa-pen-to-square fa-xl" style="color: #1f3551;">Linh</i></a>

                            <a href="/admin/mau-sac-delete?id=${ms.id}"><i class="fa-solid fa-trash fa-xl"
                                                                           style="color: #e71708;"></i></a>

                            <a href="/admin/mau-sac-giao-dien-update?id=${ms.id}"><i
                                    class="fa-solid fa-pen fa-xl"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>

