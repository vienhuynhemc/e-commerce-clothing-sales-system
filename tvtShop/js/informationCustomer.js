function loadIMG(event) {
    if (event.target.files.length > 0) {
        var src = URL.createObjectURL(event.target.files[0]);
        document.getElementById('avatar').src = src;
        document.getElementById('avatar2').src = src;
    }
}

function removeAvatar() {
    document.getElementById('avatar').src = 'img/user.jpg';
    document.getElementById('avatar2').src = 'img/user.jpg';
}

function gobackpassword() {
    document.getElementById('changepassword').style.transform = 'scaleY(0)';
    document.getElementById('changepassworddiv').style.opacity = '1';
    document.getElementById('changepassworddiv').style.zIndex = '2';
    document.getElementById('changepasswordsuccess').style.opacity = '0';
    document.getElementById('changepasswordsuccess').style.zIndex = '1';
}

function gotosuccesspassword() {
    document.getElementById('changepassworddiv').style.opacity = '0';
    document.getElementById('changepassworddiv').style.zIndex = '1';
    document.getElementById('changepassworddiv').style.transform = 'scaleY(0)';
    document.getElementById('changepasswordsuccess').style.opacity = '1';
    document.getElementById('changepasswordsuccess').style.zIndex = '2';
}

function doimatkhau() {
    document.getElementById('changepassworddiv').style.transform = 'scaleY(1)';
    document.getElementById('changepassword').style.transform = 'scaleY(1)';
}
