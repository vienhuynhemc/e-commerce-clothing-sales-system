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