function loadIMG(event) {
    if (event.target.files.length > 0) {
        var src = URL.createObjectURL(event.target.files[0]);
        document.getElementById('avatar').src = src;
    }
}

function goback2() {
    window.history.back()
}

function goback3() {
    window.location.href = '../tvtShopAdmin/quanLyKhachHang.html';
}