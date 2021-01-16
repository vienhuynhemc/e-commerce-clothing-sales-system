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
    list3[0].src = "../../img/user.jpg";
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

    CKEDITOR.instances['gioiThieu'].setData('<p>Ng&acirc;y thơ trong s&aacute;ng như ch&uacute; m&egrave;o trong ảnh :v&nbsp;</p> <figure class="easyimage easyimage-full"><img alt="" src="https://firebasestorage.googleapis.com/v0/b/ecommerce-b6c08.appspot.com/o/hinh_anh_gioi_thieu%2Fnv_1%2FMS_3.jpg?alt=media&amp;token=1df7945a-df19-4a4b-9c44-2b350d0c598c" width="200" /> <figcaption></figcaption> </figure> <hr/> <p>V&agrave; best dasua 10tr th&ocirc;ng thạo :3&nbsp;</p> <figure class="easyimage easyimage-full"><img alt="" src="https://firebasestorage.googleapis.com/v0/b/ecommerce-b6c08.appspot.com/o/hinh_anh_gioi_thieu%2Fnv_1%2F1.png?alt=media&amp;token=1abc7f1f-eca5-4282-8281-a08e127f1dc1" width="1920" /> <figcaption></figcaption> </figure> <hr /> <p>Contact:&nbsp;<img alt="wink" height="23" src="http://localhost:8080/ltw_thayLong_group5_war_exploded/ckeditor/plugins/smiley/images/wink_smile.png" title="wink" width="23" /><a href="https://www.facebook.com/vientamthuong">www.facebook.com/vientamthuong<img alt="wink" height="23" src="http://localhost:8080/ltw_thayLong_group5_war_exploded/ckeditor/plugins/smiley/images/wink_smile.png" title="wink" width="23" /></a></p>')

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
