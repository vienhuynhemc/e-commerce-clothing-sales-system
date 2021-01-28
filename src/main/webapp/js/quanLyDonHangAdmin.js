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
    if (right.length > 0) {
        document.getElementById("right").removeChild(right[0]);
    }

    let itemNew = item.children;
    document.getElementById("right").appendChild(itemNew[3].cloneNode(true));
}

function hiddenFormYesNo() {
    document.getElementById("formYesNo").style.transform = 'scaleY(0)';
}

function submitAdd() {
    document.getElementById("fromSubmidAdd").submit();
}

function hiddenNotifiSuccess() {
    document.getElementById("notifiSuccess").style.transform = 'scaleY(0)';
}

function changeFilter() {
    document.getElementById("action").value = "changeFilter";
    document.getElementById("mainForm").submit();
}

function changesort() {
    document.getElementById("action").value = "sort";
    document.getElementById("mainForm").submit();
}

function searchByClick() {
    document.getElementById("action").value = "search";
    document.getElementById("mainForm").submit();
}

const node = document.getElementsByClassName("searchsubmit")[0];
node.addEventListener("keyup", function (event) {
    if (event.key == "Enter" || event.keyCode == 13) {
        document.getElementById("action").value = "search";
        document.getElementById("mainForm").submit();
    }
});

function loadPage() {
    document.getElementById("action").value = "load";
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
                            ndocument.getElementById("mainForm").submit();
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

function duyetHang(item) {
    let l = document.getElementById("right").children[0].children[8].children[0].children;
    let idnv = l[0].value;
    let iddh = l[2].value;
    window.location.href = "../../QuanLyDonHangDuyetAdmin?ma_dh=" + iddh + "&&ma_nv=" + idnv;
}

function duyetHang2(item) {
    let l = document.getElementById("right").children[0].children[8].children[0].children;
    let idnv = l[0].value;
    let iddh = l[2].value;
    window.location.href = "../../QuanLyDonHangDuyetAdminNVK?ma_dh=" + iddh + "&&ma_nv=" + idnv;
}

function duyetHang3(item) {
    let l = document.getElementById("right").children[0].children[8].children[0].children;
    let idnv = l[0].value;
    let iddh = l[2].value;
    window.location.href = "../../QuanLyDonHangDuyetAdminNVGH?ma_dh=" + iddh + "&&ma_nv=" + idnv;
}



