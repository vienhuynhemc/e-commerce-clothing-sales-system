
function completesuccess() {
    document.getElementById('success').classList.remove("showsuccessee");
}

function displayNoti() {
    document.getElementById('notifi1').style.display = 'flex';
    document.getElementById('notifi2').style.display = 'none';
    document.getElementById('success').style.transform = 'scaleY(1)';
}

function gotocomplete() {

    hiddendivpassword();

    document.getElementById('success').classList.add("showsuccessee");

}

function displaydivpassword() {
    document.getElementById('divpassword').classList.add("showdivsuccess");
}

function hiddendivpassword() {
    document.getElementById("formForgotPasswordAdminRemoveAllController").submit();
}

function email() {
    document.getElementById('left1divpassword').classList.add("left1divpasswordhidden");

    document.getElementById('left2divpassword1').classList.add('left2divpassword1show');
}

function hiddendivpasswordBack1() {
    document.getElementById('left2divpassword1').classList.remove('left2divpassword1show');

    document.getElementById('left1divpassword').classList.remove("left1divpasswordhidden");
}

function veryemail() {

    document.getElementById('left2divpassword1').classList.remove('left2divpassword1show');

    document.getElementById('left2divpassword2').classList.add("left2divpassword2show");
}

function hiddendivpasswordBack2() {

    document.getElementById('left2divpassword2').classList.remove("left2divpassword2show");

    document.getElementById('left2divpassword1').classList.add('left2divpassword1show');
}

function gotochange() {

    document.getElementById('left2divpassword2').classList.remove("left2divpassword2show");

    document.getElementById('left3divpassword').classList.add("left3divpasswordshow");
}

function toPublic() {
    window.location = "../index.html";
}

function showPassword(){
    let x = document.getElementById("matkhau");
    let icon = document.getElementById("iconshowpassword");
    if(x.type == "password"){
        x.type = "text";
        icon.classList.remove("fa-eye-slash");
        icon.classList.add("fa-eye");
    }else{
        x.type = "password";
        icon.classList.add("fa-eye-slash");
        icon.classList.remove("fa-eye");
    }
}

function guilaima(){
    document.getElementById("left2divpassword11").submit();
}

setInterval(function(){

    let value = parseInt(document.getElementById("timeout").innerText);
    if(value >=1){
        value = value-1;
    }
    document.getElementById("timeout").innerText = value;


}, 1000);