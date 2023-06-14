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
                    <form action="/admin/nha-san-xuat-update?id=${nsx.id}" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã NSX</label>
                            <input type="text" class="form-control" name="ma" value="${nsx.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên NSX</label>
                            <input type="text" class="form-control" name="ten" value="${nsx.ten}">
                            <span style="color: red">${err.get('TEN_ISEMPTY')}</span>
                        </div>
                        <button type="submit" class="btn btn-success">Cập Nhập NSX</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

