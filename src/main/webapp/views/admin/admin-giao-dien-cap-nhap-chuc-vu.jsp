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
            <h4 class="text-center" style="font-weight: bold">Cập Nhập Chức Vụ</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/chuc-vu-update?id=${cv.id}" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã Chức Vụ</label>
                            <input type="text" class="form-control" name="ma" value="${cv.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Chức Vụ</label>
                            <input type="text" class="form-control" name="ten" value="${cv.ten}">
                            <span style="color: red">${err.get('ERR_TEN')}</span>
                        </div>
                        <button type="submit" class="btn btn-primary">Cập Nhâp</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

