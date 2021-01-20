function changesort(item) {
    let list = item.children;
    if (list[2].checked == false) {
        list[2].checked = true;
        document.getElementById("leftheadersort1").style.display = "none";
        document.getElementById("leftheadersort2").style.display = "block";
        item.style.marginTop = "0px";
    } else {
        list[2].checked = false;
        document.getElementById("leftheadersort2").style.display = "none";
        document.getElementById("leftheadersort1").style.display = "block";
        item.style.marginTop = "-5px";
    }
}

function showsearch() {
    let list = document.getElementById("leftheadersearch").children;
    list[0].style.display = "none";
    list[1].style.display = "flex";
}

function hiddensearch() {
    let list = document.getElementById("leftheadersearch").children;
    list[1].style.display = "none";
    list[0].style.display = "flex";
}

function changerightdonhang(item) {
    let listItem = document.getElementById("listleftitem").children;
    for (let i = 0; i < listItem.length; i++) {
        listItem[i].classList.remove("activeleftitem");
    }

    item.classList.add("activeleftitem");

    let right = document.getElementById("right").children;
    if (right.length > 1) {
        document.getElementById("right").removeChild(right[1]);
    }

    let itemNew = item.children;
    document.getElementById("right").appendChild(itemNew[3].cloneNode(true));

    document.getElementById("vietThongBaoMoi").style.display = "none";
}


function removeitem(item) {

    let value = item.children[2].children[0].value;
    document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn xóa #' + value;
    document.getElementById("formYesNoTitle2").innerText = 'Việc xóa sẽ thay đổi dữ liệu của bạn ';
    let itemm = document.createElement("i");
    itemm.classList.add("fa");
    itemm.classList.add("fa-hand-grab-o");
    document.getElementById("formYesNoLink").style.display = 'flex';
    document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
    document.getElementById("formYesNoTitle2").appendChild(itemm);
    document.getElementById("formYesNo").style.transform = 'scaleY(1)';
    document.getElementById("formYesNoLink").href = "../../EmailNotificationRemoveController?id=" + value;
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
var array2 = [];
var dataSend = '';
var countRefresh = 0;
var countRefreshMax = 0;
var action = 0;
var interVel;

function guiEmail() {

    let title = document.getElementById("titleEmail").value;
    let data = CKEDITOR.instances['thongBaoMoi'].getData();
    let nextId = document.getElementById("nextId").value;
    if (title.length != 0 && data.length != 0) {

        //  Xóa nguyên folder với nextId trên fire base
        deleteFolderContents("email_thong_bao/" + nextId)

        //  Chuyển url của các figure trong data lên firebase
        let div = document.createElement("div");
        div.innerHTML = data;
        let listDiv = div.children;
        let count = 1;
        for (let i = 0; i < listDiv.length; i++) {
            if (listDiv[i].nodeName == 'FIGURE') {
                countRefreshMax += 1;
            }
        }
        for (let i = 0; i < listDiv.length; i++) {
            if (listDiv[i].nodeName == 'FIGURE') {

                let img = listDiv[i].children[0];
                array2.push(img.src);
                let url = img.src;
                var xhr = new XMLHttpRequest();
                xhr.open('GET', url, true);
                xhr.responseType = 'blob';
                xhr.onload = function (e) {
                    if (this.status == 200) {
                        var myBlob = this.response;
                        const file = new File([myBlob], count + '', {type: myBlob.type})
                        updateImg(file);
                        count++;
                    }
                };
                xhr.send();
            }
        }

        dataSend = div.innerHTML + '';
        action = 0;
        waitDownload();

    }
}

function submitAdd() {
    document.getElementById("fromSubmidAdd").submit();
}

function waitDownload() {
    if (action == 1) {
        if (interVel) {
            window.clearInterval(interVel);
            interVel = null;
            countRefresh = 0;
            countRefreshMax = 0;
            array = [];
            array2 = [];
        }
    } else {
        if (!interVel) {
            interVel = window.setInterval(
                function () {
                    if (array.length == array2.length) {
                        while (array.length > 0) {
                            dataSend = dataSend.replace(array2.shift(), array.shift());
                        }
                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn gửi thông báo này';
                        document.getElementById("formYesNoTitle2").innerText = 'Việc gửi thông báo sẽ thông báo tới tất cả những người tham gia  ';
                        let itemm = document.createElement("i");
                        itemm.classList.add("fa");
                        itemm.classList.add("fa-hand-grab-o");
                        document.getElementById("formYesNoLink").style.display = 'none';
                        document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
                        var newstr = "";
                        for (var i = 0; i < dataSend.length; i++) {
                            if (!(dataSend[i] == '\n' || dataSend[i] == '\r')) {
                                newstr += dataSend[i];
                            }
                        }
                        document.getElementById("dataSend").value = newstr;
                        document.getElementById("titleSend").value = document.getElementById("titleEmail").value;
                        document.getElementById("pFormYesNo").style.display = "flex";
                        document.getElementById("formYesNoTitle2").appendChild(itemm);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                        action = 1;
                        waitDownload();
                    } else {
                        countRefresh++;
                        console.log(countRefresh + " " + array.length + " " + array2.length);
                        if (countRefresh == countRefreshMax) {
                            document.getElementById("formYesNoTitle").innerText = 'Tải hình lên server không thành công';
                            document.getElementById("formYesNoTitle2").innerText = 'Đây là một lỗi nhỏ khi chúng tôi sử dụng firebase, hãy nhấn nút GỬI lại nhé  ';
                            let itemm = document.createElement("i");
                            itemm.classList.add("fa");
                            itemm.classList.add("fa-hand-grab-o");
                            document.getElementById("formYesNoLink").style.display = "none";
                            document.getElementById("pFormYesNo").style.display = "none";
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

function updateImg(img) {
    let nextId = document.getElementById("nextId").value;
    const ref = firebase.storage().ref();
    const file = img;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = "email_thong_bao/" + nextId + "/" + nameData;
    const metadata = {contentType: file.type};
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            link = url;
            array.push(link);
        });
}

function deleteFolderContents(path) {
    const ref = firebase.storage().ref(path);
    ref.listAll()
        .then(dir => {
            dir.items.forEach(fileRef => {
                this.deleteFile(ref.fullPath, fileRef.name);
            });
            dir.prefixes.forEach(folderRef => {
                this.deleteFolderContents(folderRef.fullPath);
            })
        })
        .catch(error => {
            console.log("Folder chưa được tạo");
        });
}

function deleteFile(pathToFile, fileName) {
    const ref = firebase.storage().ref(pathToFile);
    const childRef = ref.child(fileName);
    childRef.delete()
}

function vietThongBaoMoi(item) {
    let listItem = document.getElementById("listleftitem").children;
    for (let i = 0; i < listItem.length; i++) {
        listItem[i].classList.remove("activeleftitem");
    }

    let right = document.getElementById("right").children;
    if (right.length > 1) {
        document.getElementById("right").removeChild(right[1]);
    }

    item.classList.add("activeleftitem");
    document.getElementById("vietThongBaoMoi").style.display = "block";
}

function hiddenFormYesNo() {
    document.getElementById("formYesNo").style.transform = 'scaleY(0)';
}

function hiddenNotifiSuccess() {
    document.getElementById("notifiSuccess").style.transform = 'scaleY(0)';
}

function changeFilter() {
    document.getElementById("action").value = "changeFilter";
    document.getElementById("mainForm").submit();
}

function searchByClick() {
    document.getElementById("action").value = "search";
    document.getElementById("mainForm").submit();
}

function loadPage() {
    document.getElementById("action").value = "load";
    document.getElementById("mainForm").submit();
}

function changesort() {
    document.getElementById("action").value = "sort";
    document.getElementById("mainForm").submit();
}

function prePage(nowPage) {
    let n = parseInt(nowPage);
    if (n > 1) {
        document.getElementById("numberOfPage").value = parseInt(nowPage) - 1;
        document.getElementById("action").value = "nextPage";
        document.getElementById("mainForm").submit();
    }
}

function pageNavigation(nowPage) {
    document.getElementById("numberOfPage").value = parseInt(nowPage);
    document.getElementById("action").value = "nextPage";
    document.getElementById("mainForm").submit();
}


function showselectgopage(item) {

    let listItem = document.getElementById("leftnextpage").children;

    let listUl = listItem[1].children;

    for (let i = 0; i < listUl.length; i++) {

        let list = listUl[i].children;
        if (list[0] == item) {

            let l = list[1].children;
            if (l[0].checked == true) {
                list[1].style.display = "none";
                l[0].checked = false;
            } else {
                list[1].style.display = "flex";
                l[1].click();
                l[0].checked = true;
            }
        }
    }
}

function gopagefast(item) {

    let listItem = document.getElementById("leftnextpage").children;

    let listUl = listItem[1].children;

    for (let i = 0; i < listUl.length; i++) {

        let l = listUl[i].children;

        if (l.length == 2) {
            l = l[1].children;
            if (l[2] == item) {
                let value = l[1].value;

                let maxPage = parseInt(document.getElementById("maximunNumberOfPage").value);
                let nowPage = parseInt(document.getElementById("numberOfPage").value);

                if (Number.isInteger(value)) {

                    if (value != nowPage && value >= 1 && value <= maxPage) {
                        document.getElementById("numberOfPage").value = value;
                        document.getElementById("action").value = "nextPage";
                        document.getElementById("mainForm").submit();
                    }

                } else {
                    if (value.match(/^-{0,1}\d+$/)) {

                        let number = parseInt(value);

                        if (number != nowPage && number >= 1 && number <= maxPage) {
                            document.getElementById("numberOfPage").value = number;
                            document.getElementById("action").value = "nextPage";
                            document.getElementById("mainForm").submit();
                        }

                    }
                }
            }
        }
    }
}

function nextPage(nowPage, maximumPage, item) {
    let n = parseInt(nowPage);
    let m = parseInt(maximumPage);
    if (n < m) {
        document.getElementById("numberOfPage").value = n + 1;
        document.getElementById("action").value = "nextPage";
        document.getElementById("mainForm").submit();
    }
}

const node = document.getElementsByClassName("searchsubmit")[0];
node.addEventListener("keyup", function (event) {
    if (event.key == "Enter" || event.keyCode == 13) {
        document.getElementById("action").value = "search";
        document.getElementById("mainForm").submit();
    }
});


//  Khai báo editor
var editor = '';
$(document).ready(function () {
    //  Khởi tạo editor
    editor = CKEDITOR.replace('thongBaoMoi');
})