function addToCart(id) {
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/khach-hang/them-gio-hang";
    var params = "id=" + id;
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var responseText = xhr.responseText;
            // Xử lý phản hồi từ máy chủ
            window.location.href = "http://localhost:8080/khach-hang/gio-hang";
        }
    };
    xhr.send(params);
}