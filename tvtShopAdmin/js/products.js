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
    document.getElementById('form-inf-qlbl').style.transform = 'scaleY(0)';
    document.getElementById('form-add-qlbl').style.transform = 'scaleY(0)';
}

function information() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('form-inf-qlbl').style.transform = 'scaleY(1)';
    document.getElementById('form-inf-qlbl').style.transition = 'all 0.5s ease 0.6s';
}

function taoDanhMuc() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('form-add-qlbl').style.transform = 'scaleY(1)';
    document.getElementById('form-add-qlbl').style.transition = 'all 0.5s ease 0.6s';
}

function removeSanPham() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transition = 'all 0.5s ease 0.6s';
}

function taoSanPham() {
    window.location.href = '../tvtShopAdmin/add-product.html';
}

function editSanPham() {
    window.location.href = '../tvtShopAdmin/edit-product.html';
}

function informationSanPham() {
    window.location.href = '../tvtShopAdmin/informationProduct.html';
}
