let count = 1;
function contentKH() {
    let o = document.getElementById(`bar-value${count}`);
    let n = document.getElementById('bar-value1');
    o.style.backgroundColor = '#232020';
    o.style.border = '2px solid #232020';
    o.style.borderBottom = 'none';
    o.style.color = 'white';
    n.style.backgroundColor = 'white';
    n.style.border = '2px solid #ff7315';
    n.style.borderBottom = 'none';
    n.style.color = '#232020';

    document.getElementById(`ql${count}`).style.display = 'none';
    document.getElementById(`ql1`).style.display = 'block';
    count = 1;

}

function contentGH() {
    let o = document.getElementById(`bar-value${count}`);
    let n = document.getElementById('bar-value2');
    o.style.backgroundColor = '#232020';
    o.style.border = '2px solid #232020';
    o.style.borderBottom = 'none';
    o.style.color = 'white';
    n.style.backgroundColor = 'white';
    n.style.border = '2px solid #ff7315';
    n.style.borderBottom = 'none';
    n.style.color = '#232020';

    document.getElementById(`ql${count}`).style.display = 'none';
    document.getElementById(`ql2`).style.display = 'block';
    count = 2;
}

function contentKK() {
    let o = document.getElementById(`bar-value${count}`);
    let n = document.getElementById('bar-value3');
    o.style.backgroundColor = '#232020';
    o.style.border = '2px solid #232020';
    o.style.borderBottom = 'none';
    o.style.color = 'white';
    n.style.backgroundColor = 'white';
    n.style.border = '2px solid #ff7315';
    n.style.borderBottom = 'none';
    n.style.color = '#232020';

    document.getElementById(`ql${count}`).style.display = 'none';
    document.getElementById(`ql3`).style.display = 'block';
    count = 3;
}

function editKH() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('form-edit-qlbl').style.transform = 'scaleY(1)';
    document.getElementById('form-edit-qlbl').style.transition = 'all 0.5s ease 0.6s'
}

function removeKH() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transition = 'all 0.5s ease 0.6s'
}

function removeGH() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transform = 'scaleY(1)';
    document.getElementById('yes-no-question').style.transition = 'all 0.5s ease 0.6s'
}

function hiddenDiv() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(0)';
    document.getElementById('yes-no-question').style.transform = 'scaleY(0)';
    document.getElementById('form-edit-qlbl').style.transform = 'scaleY(0)';
    document.getElementById('form-information-kh').style.transform = 'scaleY(0)';
    document.getElementById('form-add-kh').style.transform = 'scaleY(0)';
}

function informationKH() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('form-information-kh').style.transform = 'scaleY(1)';
    document.getElementById('form-information-kh').style.transition = 'all 0.5s ease 0.6s'
}

function addKH() {
    document.getElementById('hidden-div-help').style.transform = 'scaleY(1)';
    document.getElementById('form-add-kh').style.transform = 'scaleY(1)';
    document.getElementById('form-add-kh').style.transition = 'all 0.5s ease 0.6s'
}

function addNhanVienGH() {
    window.location.href = '../tvtShopAdmin/themNhanVienGiaoHang.html';
}

function informationGH() {
    window.location.href = '../tvtShopAdmin/informationNhanVienGiaoHang.html';
}

function editGH() {
    window.location.href = '../tvtShopAdmin/editNhanVienGiaoHang.html';
}