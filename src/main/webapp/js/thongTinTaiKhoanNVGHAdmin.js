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

                        document.getElementById("fullName2").value = document.getElementById("fullName").value;
                        document.getElementById("displayName2").value = document.getElementById("displayName").value;
                        document.getElementById("phoneNumber2").value = document.getElementById("phoneNumber").value;
                        document.getElementById("provincial2").value = document.getElementById("provincial").value;
                        document.getElementById("district2").value = document.getElementById("district").value;
                        document.getElementById("commune2").value = document.getElementById("commune").value;
                        document.getElementById("password2").value = document.getElementById("password").value;
                        document.getElementById("checkPassword2").value = document.getElementById("checkPassword").value;
                        document.getElementById("introduct2").value = CKEDITOR.instances['gioiThieu'].getData();
                        document.getElementById("action2").value = "change";
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
    document.getElementById("formYesNoLink").href = 'javascript:void(0)';
    document.getElementById("formYesNoLink").onclick = function () {
        document.getElementById("fullName2").value = document.getElementById("fullName").value;
        document.getElementById("displayName2").value = document.getElementById("displayName").value;
        document.getElementById("phoneNumber2").value = document.getElementById("phoneNumber").value;
        document.getElementById("provincial2").value = document.getElementById("provincial").value;
        document.getElementById("district2").value = document.getElementById("district").value;
        document.getElementById("commune2").value = document.getElementById("commune").value;
        document.getElementById("password2").value = document.getElementById("password").value;
        document.getElementById("checkPassword2").value = document.getElementById("checkPassword").value;
        document.getElementById("introduct2").value = CKEDITOR.instances['gioiThieu'].getData();
        document.getElementById("action2").value = "remove";
        document.getElementById("changeAvatar").submit();
    }
}


//  Khai báo editor
var editor = '';

$(document).ready(function () {

    //  Khởi tạo editor
    editor = CKEDITOR.replace('gioiThieu');

    CKEDITOR.instances['gioiThieu'].setData(document.getElementById("introductuser").innerHTML);
});


var arraya = [];
var array2a = [];
var dataSenda = '';
var countRefresha = 0;
var countRefreshMaxa = 0;
var actiona = 0;
var interVela;

function getData() {

    //  Check full name
    let fullName = document.getElementById("fullName").value;
    if (fullName.length == 0) {
        document.getElementById("error1").classList.remove("hidden");
    } else {
        if (!document.getElementById("error1").classList.contains("hidden")) {
            document.getElementById("error1").classList.add("hidden");
        }

        //  Checl displayName
        let displayName = document.getElementById("displayName").value;
        if (displayName.length == 0) {
            document.getElementById("error2").classList.remove("hidden");
        } else {
            if (!document.getElementById("error2").classList.contains("hidden")) {
                document.getElementById("error2").classList.add("hidden");
            }

            //  Check phone number
            let phoneNumber = document.getElementById("phoneNumber").value;
            if (phoneNumber.length != 10) {
                document.getElementById("error3").innerText = "Số điện thoại phải có 10 số";
                document.getElementById("error3").classList.remove("hidden");
            } else if (!isInteger(phoneNumber)) {
                document.getElementById("error3").innerText = "Số điện thoại phải là số";
                document.getElementById("error3").classList.remove("hidden");
            } else {
                if (!document.getElementById("error3").classList.contains("hidden")) {
                    document.getElementById("error3").classList.add("hidden");
                }

                //  Check huyện
                let district = document.getElementById("district").value;
                if (district == 'none') {
                    document.getElementById("error4").classList.remove("hidden");
                } else {
                    if (!document.getElementById("error4").classList.contains("hidden")) {
                        document.getElementById("error4").classList.add("hidden");
                    }

                    //  check xa
                    let commune = document.getElementById("commune").value;
                    if (commune == 'none') {
                        document.getElementById("error5").classList.remove("hidden");
                    } else {
                        if (!document.getElementById("error5").classList.contains("hidden")) {
                            document.getElementById("error5").classList.add("hidden");
                        }

                        //  Check pass word
                        let password = document.getElementById("password").value;
                        if (password.length == 0) {
                            document.getElementById("error6").classList.remove("hidden");
                        } else {
                            if (!document.getElementById("error6").classList.contains("hidden")) {
                                document.getElementById("error6").classList.add("hidden");
                            }

                            //  Check checkpassword
                            let checkPassword = document.getElementById("checkPassword").value;
                            if (checkPassword != password) {
                                document.getElementById("error7").classList.remove("hidden");
                            } else {
                                if (!document.getElementById("error7").classList.contains("hidden")) {
                                    document.getElementById("error7").classList.add("hidden");
                                }

                                let data = CKEDITOR.instances['gioiThieu'].getData();
                                let nextId = document.getElementById("ma_nv").value;

                                let div = document.createElement("div");
                                div.innerHTML = data;
                                let listDiv = div.children;
                                let count = parseInt(document.getElementById("hinh_anh_trong_firebase").value);
                                for (let i = 0; i < listDiv.length; i++) {
                                    if (listDiv[i].nodeName == 'FIGURE') {
                                        countRefreshMaxa += 1;
                                    }
                                }
                                for (let i = 0; i < listDiv.length; i++) {
                                    if (listDiv[i].nodeName == 'FIGURE') {

                                        let img = listDiv[i].children[0];
                                        if (img.src.startsWith('blob')) {
                                            array2a.push(img.src);
                                            let url = img.src;
                                            var xhr = new XMLHttpRequest();
                                            xhr.open('GET', url, true);
                                            xhr.responseType = 'blob';
                                            xhr.onload = function (e) {
                                                if (this.status == 200) {
                                                    var myBlob = this.response;
                                                    const file = new File([myBlob], count + '', {type: myBlob.type})
                                                    updateImgIntroduct(file);
                                                    count++;
                                                }
                                            };
                                            xhr.send();
                                        }
                                    }
                                }

                                dataSenda = div.innerHTML + '';
                                actiona = 0;
                                waitDownloada();

                            }
                        }
                    }
                }
            }
        }
    }
}

function updateImgIntroduct(img) {
    let nextId = document.getElementById("ma_nv").value;
    const ref = firebase.storage().ref();
    const file = img;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = "hinh_anh_gioi_thieu/" + nextId + "/" + nameData;
    const metadata = {contentType: file.type};
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            link = url;
            arraya.push(link);
        });
}

function waitDownloada() {
    if (actiona == 1) {
        if (interVela) {
            window.clearInterval(interVela);
            interVela = null;
            countRefresha = 0;
            countRefreshMaxa = 0;
            arraya = [];
            array2a = [];
        }
    } else {
        if (!interVela) {
            interVela = window.setInterval(
                function () {
                    if (arraya.length == array2a.length) {
                        let sizeArray = arraya.length;
                        while (arraya.length > 0) {
                            dataSenda = dataSenda.replace(array2a.shift(), arraya.shift());
                        }
                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn lưu lại thay đổi';
                        document.getElementById("formYesNoTitle2").innerText = 'Việc lưu lại sẽ thay đổi dữ liệu của bạn  ';
                        let itemm = document.createElement("i");
                        itemm.classList.add("fa");
                        itemm.classList.add("fa-hand-grab-o");
                        document.getElementById("formYesNoLink").style.display = 'flex';
                        document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
                        var newstr = "";
                        for (var i = 0; i < dataSenda.length; i++) {
                            if (!(dataSenda[i] == '\n' || dataSenda[i] == '\r')) {
                                newstr += dataSenda[i];
                            }
                        }
                        document.getElementById("introduct").value = newstr;
                        document.getElementById("hinh_anh_trong_firebase").value = parseInt(document.getElementById("hinh_anh_trong_firebase").value)+parseInt(sizeArray);
                        document.getElementById("formYesNoTitle2").appendChild(itemm);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                        document.getElementById("formYesNoLink").onclick = function () {
                            document.getElementById("action").value = "save";
                            document.getElementById("div3").submit();
                        }
                        actiona = 1;
                        waitDownloada();
                    } else {
                        countRefresha++;
                        console.log(countRefresha + " " + arraya.length + " " + array2a.length);
                        if (countRefresha == countRefreshMaxa) {
                            document.getElementById("formYesNoTitle").innerText = 'Tải hình lên server không thành công';
                            document.getElementById("formYesNoTitle2").innerText = 'Đây là một lỗi nhỏ khi chúng tôi sử dụng firebase, hãy nhấn nút lưu lại nhé  ';
                            let itemm = document.createElement("i");
                            itemm.classList.add("fa");
                            itemm.classList.add("fa-hand-grab-o");
                            document.getElementById("formYesNoLink").style.display = "none";
                            document.getElementById("buttonNoFormYesNo").innerHTML = 'OK';
                            document.getElementById("formYesNoTitle2").appendChild(itemm);
                            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                            actiona = 1;
                            waitDownloada();
                        }
                    }
                }, 1000
            )
        }
    }
}

function hiddenFormYesNo() {
    document.getElementById("formYesNo").style.transform = 'scaleY(0)';
}

function hiddenNotifiSuccess() {
    document.getElementById("notifiSuccess").style.transform = 'scaleY(0)';
}

function loadTinh() {
    document.getElementById("action").value = "loadProvincial";
    document.getElementById("introduct").value = CKEDITOR.instances['gioiThieu'].getData();
    document.getElementById("div3").submit();
}

function loadHuyen() {
    document.getElementById("action").value = "loadDistrict";
    document.getElementById("introduct").value = CKEDITOR.instances['gioiThieu'].getData();
    document.getElementById("div3").submit();
}

function thayDoiThongTin() {
    document.getElementById("action").value = "goToEdit";
    document.getElementById("introduct").value = CKEDITOR.instances['gioiThieu'].getData();
    document.getElementById("div3").submit();
}

function troVeQuanLy() {
    document.getElementById("action").value = "backEdit";
    document.getElementById("introduct").value = CKEDITOR.instances['gioiThieu'].getData();
    document.getElementById("div3").submit();
}

function isInteger(value) {

    if (Number.isInteger(value)) {

        return true;

    } else {
        if (value.match(/^-{0,1}\d+$/)) {

            return true;

        }
    }

    return false;

}

