function edit() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('form-edit-qlbl').style.transform = 'scaleY(1)';
    document.getElementById('form-edit-qlbl').style.transition = 'all 0.5s ease 0.6s'
}

function remove() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transition = 'all 0.5s ease 0.6s'
}

function hiddenDiv() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(0)';
    document.getElementById('yes-no-question').style.transform = 'scaleY(0)';
    document.getElementById('form-edit-qlbl').style.transform = 'scaleY(0)';
}

function nhapHang() {
    document.getElementById('mainPhieuNhap').style.display = 'flex';
    document.getElementById('mainInformationLS').style.display = 'none';
    document.getElementById('mainLSPhieuNhap').style.display = 'none';
    document.getElementById('week').style.display = 'none';
    document.getElementById('div-search-qlbl').style.display = 'none';
    document.getElementById('user').style.transform = 'translateX(0px)';
    document.getElementById('nhapHang').style.backgroundColor = '#ff7315';
    document.getElementById('lsNhapHang').style.backgroundColor = '#232020';
}

function lsNhapHang() {
    document.getElementById('mainPhieuNhap').style.display = 'none';
    document.getElementById('mainInformationLS').style.display = 'none';
    document.getElementById('mainLSPhieuNhap').style.display = 'block';
    document.getElementById('week').style.display = 'block';
    document.getElementById('div-search-qlbl').style.display = 'flex';
    document.getElementById('user').style.transform = 'translateX(223px)';
    document.getElementById('lsNhapHang').style.backgroundColor = '#ff7315';
    document.getElementById('nhapHang').style.backgroundColor = '#232020';
}
function information() {
    document.getElementById('mainPhieuNhap').style.display = 'none';
    document.getElementById('mainInformationLS').style.display = 'block';
    document.getElementById('mainLSPhieuNhap').style.display = 'none';
    document.getElementById('week').style.display = 'none';
    document.getElementById('div-search-qlbl').style.display = 'none';
}

function goback() {
    document.getElementById('mainPhieuNhap').style.display = 'none';
    document.getElementById('mainInformationLS').style.display = 'none';
    document.getElementById('mainLSPhieuNhap').style.display = 'block';
    document.getElementById('week').style.display = 'block';
    document.getElementById('div-search-qlbl').style.display = 'flex';
}