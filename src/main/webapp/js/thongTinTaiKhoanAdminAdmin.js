function motchutvetoi() {
    document.getElementById("div121").style.display = "flex";
    document.getElementById("div122").style.display = "none";
    document.getElementById("motchutvetoi").classList.add("activebutton");
    document.getElementById("thongtinchitiet").classList.remove("activebutton");
}

function thongtinchitiet() {
    document.getElementById("div122").style.display = "flex";
    document.getElementById("div121").style.display = "none";
    document.getElementById("motchutvetoi").classList.remove("activebutton");
    document.getElementById("thongtinchitiet").classList.add("activebutton");
}

var firebaseConfig = {
    apiKey: "AIzaSyCNKrWfzyctIJeK4XgPlU5AKR1y2hY1zA0",
    authDomain: "ecommerce-b6c08.firebaseapp.com",
    databaseURL: "https://ecommerce-b6c08-default-rtdb.firebaseio.com",
    projectId: "ecommerce-b6c08",
    storageBucket: "ecommerce-b6c08.appspot.com",
    messagingSenderId: "390576423583",
    appId: "1:390576423583:web:efcf73909008a68dcd18aa",
    measurementId: "G-LR0V7PWKZN"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);
firebase.analytics();


var array = [];
var action = 0;
var interVel;
var countRefresh = 0;
var countRefreshMax = 5;
var file;

function loadIMG2(event) {
    if (event.target.files.length > 0) {
        file = event.target.files[0];
        updateImg(file);
        action = 0;
        waitDownload();
    }
}

function updateImg(img) {
    let nextId = document.getElementById("ma_nv").value + ".jpg";
    const ref = firebase.storage().ref();
    const file = img;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = "hinh_dai_dien_nv/" + nextId;
    const metadata = {contentType: file.type};
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            link = url;
            array.push(link);
        });
}

function waitDownload() {
    if (action == 1) {
        if (interVel) {
            window.clearInterval(interVel);
            interVel = null;
            countRefresh = 0;
            array = [];
        }
    } else {
        if (!interVel) {
            interVel = window.setInterval(
                function () {
                    if (array.length == 1) {

                        action = 1;
                        window.clearInterval(interVel);
                        interVel = null;
                        countRefresh = 0;

                        document.getElementById("dataSend").value = array.pop();
                        array = [];

                        document.getElementById("changeAvatar").submit();

                    } else {
                        countRefresh++;
                        if (countRefresh == countRefreshMax) {
                            document.getElementById("formYesNoTitle").innerText = 'Tải hình lên server không thành công';
                            document.getElementById("formYesNoTitle2").innerText = 'Đây là một lỗi nhỏ khi chúng tôi sử dụng firebase, hãy thử lại nhé  ';
                            let itemm = document.createElement("i");
                            itemm.classList.add("fa");
                            itemm.classList.add("fa-hand-grab-o");
                            document.getElementById("formYesNoLink").style.display = "none";
                            document.getElementById("buttonNoFormYesNo").innerHTML = 'OK';
                            document.getElementById("formYesNoTitle2").appendChild(itemm);
                            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                            action = 1;
                            waitDownload();
                        }
                    }
                }, 1000
            )
        }
    }
}

function removeIMG2() {
    document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn xóa ảnh đại diện';
    document.getElementById("formYesNoTitle2").innerText = 'Việc xóa sẽ thay đổi dữ liệu của bạn ';
    let itemm = document.createElement("i");
    itemm.classList.add("fa");
    itemm.classList.add("fa-hand-grab-o");
    document.getElementById("formYesNoLink").style.display = 'flex';
    document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
    document.getElementById("formYesNoTitle2").appendChild(itemm);
    document.getElementById("formYesNo").style.transform = 'scaleY(1)';
    document.getElementById("formYesNoLink").href = `../../InformationAccountAdminRemoveAvatarController`;
}


//  Khai báo editor
var editor = '';

$(document).ready(function () {

    //  Khởi tạo editor
    editor = CKEDITOR.replace('gioiThieu');

    CKEDITOR.instances['gioiThieu'].setData(document.getElementById("introductuser").innerHTML);
});

function getData() {
    let p = CKEDITOR.instances['gioiThieu'].getData();
    let div = document.createElement("div");
    div.innerHTML = p;
    let list = div.children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].nodeName == 'FIGURE') {
            let img = list[i].children[0];
            console.log(img.src);
        }
    }
}

function hiddenFormYesNo() {
    document.getElementById("formYesNo").style.transform = 'scaleY(0)';
}

function hiddenNotifiSuccess() {
    document.getElementById("notifiSuccess").style.transform = 'scaleY(0)';
}

function loadTinh(){
    document.getElementById("action").value = "loadProvincial";
    document.getElementById("div3").submit();
}

function loadHuyen(){
    document.getElementById("action").value = "loadDistrict";
    document.getElementById("div3").submit();
}

