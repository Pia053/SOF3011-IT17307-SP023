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
            <h4 class="text-center" style="font-weight: bold">Cập Nhập Dòng Sản Phẩm</h4>
            <div class="row">
                <div class="col-sm-6 offset-sm-3">
                    <form action="/admin/dong-san-pham1-update?id=${dsp.id}" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã Dòng Sản Phẩm</label>
                            <input type="text" class="form-control" name="ma" value="${dsp.ma}" disabled>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên Dòng Sản Phẩm</label>
                            <input type="text" class="form-control" name="ten" value="${dsp.ten}">
                            <span style="color: red">${err.get('ERR_TENDONGSP')}</span>
                        </div>
                        <button type="submit" class="btn btn-primary">Cập Nhập</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

