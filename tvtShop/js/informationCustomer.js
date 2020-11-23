function loadIMG(event) {
    if (event.target.files.length > 0) {
        var src = URL.createObjectURL(event.target.files[0]);
        document.getElementById('avatar').src = src;
        document.getElementById('avatar2').src = src;
    }
}

function removeAvatar(){
    document.getElementById('avatar').src = 'img/user.jpg';
    document.getElementById('avatar2').src = 'img/user.jpg';
}

