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

function loadIMG2(event) {
    if (event.target.files.length > 0) {
        var src = URL.createObjectURL(event.target.files[0]);

        let listItem = document.getElementById("div3").children;
        let l = listItem[0].children;
        let list = l[0].children;
        let list2 = list[2].children;
        let list3 = list2[0].children;
        list3[0].src = src;
    }
}

function removeIMG2() {
    let listItem = document.getElementById("div3").children;
    let l = listItem[0].children;
    let list = l[0].children;
    let list2 = list[2].children;
    let list3 = list2[0].children;
    list3[0].src = "/tvtShop/img/user.jpg";
}

function trove() {
    document.getElementById("div3").style.display = "none";
    document.getElementById("div2").style.display = "block";
}

function thaydoithongtin() {
    document.getElementById("div2").style.display = "none";
    document.getElementById("div3").style.display = "block";
}

//  Khai báo editor
var editor = '';

$(document).ready(function () {

    //  Khởi tạo editor
    editor = CKEDITOR.replace('gioiThieu');

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
