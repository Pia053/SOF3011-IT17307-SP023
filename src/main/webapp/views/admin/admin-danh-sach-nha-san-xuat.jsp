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
            <h4 class="text-center" style="font-weight: bold">Quản Lý Nhà Sản Xuất</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/nha-san-xuat-add" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã Nhà Sản Xuất</label>
                            <input type="text" class="form-control" name="ma" value="${nsx.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Nhà Sản Xuất</label>
                            <input type="text" class="form-control" name="ten" value="${nsx.ten}">
                            <span style="color: red">${err.get('TEN_ISEMPTY')}</span>
                        </div>
                        <button type="submit" class="btn btn-primary">Thêm Mới</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="mt-5">
            <div>
                <h5 class="text-center">Danh Sách Nhà Sản Xuất</h5>
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
                <c:forEach items="${listNSX}" var="nsx">
                    <tr>
                        <th>${nsx.ma}</th>
                        <td> ${nsx.ten}</td>
                        <td>
                            <a role="button" href="/admin/nha-san-xuat-detail?id=${nsx.id}"><i
                                    class="fa-solid fa-pen-to-square fa-xl" style="color: #1f3551;">Linh</i></a>

                            <a href="/admin/nha-san-xuat-delete?id=${nsx.id}"><i class="fa-solid fa-trash fa-xl"
                                                                                 style="color: #e71708;"></i></a>

                            <a href="/admin/nha-san-xuat-giao-dien-update?id=${nsx.id}"><i
                                    class="fa-solid fa-pen fa-xl"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>

