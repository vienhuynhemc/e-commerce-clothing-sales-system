function login() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    if (username == 'admin' && password == 'admin') {
        window.location.href = '../../tvtShopAdmin/index.html';
    } else if (username == 'nvgh' && password == 'nvgh') {
        window.location.href = '../../tvtShopAdmin/trangChuNhanVienGiaoHang.html';
    }
    else if (username == 'nvk' && password == 'nvk') {
        window.location.href = '../../tvtShopAdmin/trangChuNhanVienKho.html';
    } else {
        if (username == 'admin' || username == 'nvgh' || username == 'nvk') {
            document.getElementById('username').style.border = 'none';
            document.getElementById('password').style.border = '4px solid #ff3e3e';
            document.getElementById('error').innerText = 'Bạn nhập sai mật khẩu';
            document.getElementById('error').style.display = 'block';
            document.getElementById('password').value = '';
        } else {
            document.getElementById('username').style.border = '4px solid #ff3e3e';
            document.getElementById('password').style.border = 'none';
            document.getElementById('error').innerText = 'Bạn nhập sai tài khoản';
            document.getElementById('error').style.display = 'block';
            document.getElementById('password').value = '';
            document.getElementById('username').value = '';
        }
    }
}