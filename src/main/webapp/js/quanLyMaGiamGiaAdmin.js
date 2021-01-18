capnhaphienthi();

function showsearch2(item) {
    let l1 = document.getElementById("div2").children;
    let l2 = l1[0].children;
    let l3 = l2[0].children;
    let l4 = l3[0].children;
    let l5 = l4[1].children;
    let l6 = l5[1].children;
    if (l6[0] == item) {
        l6[1].style.display = "flex";
        l6[0].style.display = "none";
        return;
    }
}

function hiddensearch2(item) {
    let l1 = document.getElementById("div2").children;
    let l2 = l1[0].children;
    let l3 = l2[0].children;
    let l4 = l3[0].children;
    let l5 = l4[1].children;
    let l6 = l5[1].children;
    let l7 = l6[1].children;
    if (l7[0] == item) {
        l6[0].style.display = "flex";
        l6[1].style.display = "none";
        return;
    }
}

function changesort2(item) {
    let list = item.children;
    if (list[2].checked == false) {
        list[2].checked = true;
        list[0].style.display = "none";
        list[1].style.display = "block";
        item.style.marginTop = "0px";
    } else {
        list[2].checked = false;
        list[1].style.display = "none";
        list[0].style.display = "block";
        item.style.marginTop = "-5px";
    }
}

function showselect(item) {

    let index = 0;

    let list = document.getElementById("maindiv2").children;
    for (let i = 1; i < list.length; i++) {
        list2 = list[i].children;
        if (list2[11] == item) {
            index = i;
            break;
        }
    }

    if (index < 10) {
        let listItem = item.children;
        if (listItem[0].checked == true) {
            listItem[0].checked = false;
            listItem[4].style.display = "none";
        } else {
            listItem[0].checked = true;
            listItem[4].style.display = "block";
        }
    } else {


        let listItem = item.children;
        listItem[4].style.top = "-115px"
        if (listItem[0].checked == true) {
            listItem[0].checked = false;
            listItem[4].style.display = "none";
        } else {
            listItem[0].checked = true;
            listItem[4].style.display = "block";
        }
    }
}

function removekhachhang(item) {
    let listItem = document.getElementById("maindiv2").children;
    for (let i = 1; i < listItem.length; i++) {
        let list = listItem[i].children;
        let list2 = list[11].children;
        let list3 = list2[4].children;
        if (list3[1] == item) {
            list2[1].checked = false;
            document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn xóa #' + list3[2].value;
            document.getElementById("formYesNoTitle2").innerText = 'Việc xóa sẽ thay đổi dữ liệu của bạn ';
            let item = document.createElement("i");
            item.classList.add("fa");
            item.classList.add("fa-hand-grab-o");
            document.getElementById("formYesNoLink").href = "../../DiscountCodeRemoveController?type=single&&id=" + list3[2].value;
            document.getElementById("formYesNoTitle2").appendChild(item);
            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
            return;
        }
    }
}

function capnhaphienthi() {
    let listItem = document.getElementById("maindiv2").children;
    for (let i = 0; i < listItem.length; i++) {
        if (i <= 13) {
            listItem[i].style.display = "flex";
        } else {
            listItem[i].style.display = "none";
        }
    }
}

function xoacacmuadachon() {
    let listItem = document.getElementById("maindiv2").children;
    let discountCodes = '';
    for (let i = 1; i < listItem.length; i++) {
        let list2 = listItem[i].children;
        let list3 = list2[0].children;
        if (list3[0].checked == true) {
            discountCodes += list3[1].value + " ";
        }
    }

    if (discountCodes.length > 0) {
        discountCodes = discountCodes.trim();
        let size = discountCodes.split(" ").length;

        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn xóa ' + size + ' mục';
        document.getElementById("formYesNoTitle2").innerText = 'Việc xóa sẽ thay đổi dữ liệu của bạn ';
        let item = document.createElement("i");
        item.classList.add("fa");
        item.classList.add("fa-hand-grab-o");
        document.getElementById("formYesNoLink").href = "../../DiscountCodeRemoveController?type=group&&discountCodes=" + discountCodes;
        document.getElementById("formYesNoTitle2").appendChild(item);
        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
    }
}

function allselect() {
    let listItem = document.getElementById("maindiv2").children;
    let a = 0;
    for (let i = 1; i < listItem.length; i++) {
        let list2 = listItem[i].children;
        let list3 = list2[0].children;
        if (list3[0].checked == true) {
            a = 1;
            break;
        }
    }

    if (a == 1) {
        for (let i = 1; i < listItem.length; i++) {
            let list2 = listItem[i].children;
            let list3 = list2[0].children;
            if (list3[0].checked == true) {
                list3[0].checked = false;
            }
        }
    } else {
        for (let i = 1; i < listItem.length; i++) {
            let list2 = listItem[i].children;
            let list3 = list2[0].children;
            list3[0].checked = true;
        }
    }
}

function themdanhmuc() {
    document.getElementById("div1").style.display = "block";
    document.getElementById("div2").style.display = "none";
    document.getElementById("div3").style.display = "none";
}

function trove() {
    document.getElementById("div2").style.display = "block";
    document.getElementById("div1").style.display = "none";
    document.getElementById("div3").style.display = "none";
}

function editdanhmuc(item) {
    if (document.getElementById("div3").children.length > 0) {
        document.getElementById("div3").removeChild(document.getElementById("div3").children[0]);
    }

    let listItem = document.getElementById("maindiv2").children;
    for (let i = 1; i < listItem.length; i++) {
        let list = listItem[i].children;
        let list2 = list[11].children;
        let list3 = list2[4].children;
        if (list3[0] == item) {
            document.getElementById("div3").appendChild(list[12].cloneNode(true));
            document.getElementById("div3").style.display = "block";
            document.getElementById("div1").style.display = "none";
            document.getElementById("div2").style.display = "none";
            return;
        }
    }
}

function hiddenFormYesNo() {
    document.getElementById("formYesNo").style.transform = 'scaleY(0)';
}

function hiddenNotifiSuccess() {
    document.getElementById("notifiSuccess").style.transform = 'scaleY(0)';
}


function themmoi() {
    let l1 = document.getElementById("div1").children[0].children;
    let l2 = l1[1].children;

    let l3 = l2[2].children;
    let type = l3[1].value;
    let l4 = l2[3].children;
    let value = l4[1].value.trim();
    let l5 = l2[4].children;
    let maNhap = l5[1].value.trim();
    let l6 = l2[5].children;
    let soLanSuDung = l6[1].value.trim();
    let l7 = l2[6].children;
    let hanSuDUng = l7[1].value;

    let slsd = parseInt(soLanSuDung);
    if (slsd > 0) {
        if (type == 'mpvc') {
            if (isInteger(soLanSuDung) && hanSuDUng.length != 0 && maNhap.length != 0) {

                document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn thêm mã giảm giá mới';
                document.getElementById("formYesNoTitle2").innerText = 'Việc thêm vào sẽ thay đổi dữ liệu của bạn ';
                let item = document.createElement("i");
                item.classList.add("fa");
                item.classList.add("fa-hand-grab-o");
                document.getElementById("formYesNoLink").href = `../../DiscountCodeAddController?type=${type}&&value=${0}&&name=${maNhap}&&maximunNumberOfUse=${soLanSuDung}&&deadline=${hanSuDUng}`;
                document.getElementById("formYesNoTitle2").appendChild(item);
                document.getElementById("formYesNo").style.transform = 'scaleY(1)';

            }
        } else {
            if (isInteger(value) && isInteger(soLanSuDung) && hanSuDUng.length != 0 && maNhap.length != 0) {

                if (type == 'ggtpt') {
                    let valuegg = parseInt(value);
                    if (value <= 100 && value >= 0) {
                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn thêm mã giảm giá mới';
                        document.getElementById("formYesNoTitle2").innerText = 'Việc thêm vào sẽ thay đổi dữ liệu của bạn ';
                        let item = document.createElement("i");
                        item.classList.add("fa");
                        item.classList.add("fa-hand-grab-o");
                        document.getElementById("formYesNoLink").href = `../../DiscountCodeAddController?type=${type}&&value=${value}&&name=${maNhap}&&maximunNumberOfUse=${soLanSuDung}&&deadline=${hanSuDUng}`;
                        document.getElementById("formYesNoTitle2").appendChild(item);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                    }

                } else {
                    let valuegg = parseInt(value);
                    if (value >= 0) {
                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn thêm mã giảm giá mới';
                        document.getElementById("formYesNoTitle2").innerText = 'Việc thêm vào sẽ thay đổi dữ liệu của bạn ';
                        let item = document.createElement("i");
                        item.classList.add("fa");
                        item.classList.add("fa-hand-grab-o");
                        document.getElementById("formYesNoLink").href = `../../DiscountCodeAddController?type=${type}&&value=${value}&&name=${maNhap}&&maximunNumberOfUse=${soLanSuDung}&&deadline=${hanSuDUng}`;
                        document.getElementById("formYesNoTitle2").appendChild(item);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                    }
                }
            }
        }
    }

}

function capnhat() {
    let l1 = document.getElementById("div3").children[0].children;
    let l2 = l1[1].children;

    let l3 = l2[2].children;
    let type = l3[1].value;
    let l4 = l2[3].children;
    let value = l4[1].value.trim();
    let l5 = l2[4].children;
    let maNhap = l5[1].value.trim();
    let l6 = l2[5].children;
    let soLanSuDung = l6[1].value.trim();
    let l7 = l2[6].children;
    let hanSuDUng = l7[1].value;
    let id = l2[7].value;
    let ngayTao = l2[8].value;

    let slsd = parseInt(soLanSuDung);
    if (slsd > 0) {
        if (type == 'mpvc') {
            if (isInteger(soLanSuDung) && hanSuDUng.length != 0 && maNhap.length != 0) {

                document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn lưu thay đổi';
                document.getElementById("formYesNoTitle2").innerText = 'Việc thay đổi sẽ thay đổi dữ liệu của bạn ';
                let item = document.createElement("i");
                item.classList.add("fa");
                item.classList.add("fa-hand-grab-o");
                document.getElementById("formYesNoLink").href = `../../DiscountCodeEditController?type=${type}&&value=${0}&&name=${maNhap}&&maximunNumberOfUse=${soLanSuDung}&&deadline=${hanSuDUng}&&id=${id}&&dateCreated=${ngayTao}`;
                document.getElementById("formYesNoTitle2").appendChild(item);
                document.getElementById("formYesNo").style.transform = 'scaleY(1)';

            }
        } else {
            if (isInteger(value) && isInteger(soLanSuDung) && hanSuDUng.length != 0 && maNhap.length != 0) {

                if (type == 'ggtpt') {
                    let valuegg = parseInt(value);
                    if (value < 100 && value > 0) {
                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn lưu thay đổi';
                        document.getElementById("formYesNoTitle2").innerText = 'Việc thay đổi sẽ thay đổi dữ liệu của bạn ';
                        let item = document.createElement("i");
                        item.classList.add("fa");
                        item.classList.add("fa-hand-grab-o");
                        document.getElementById("formYesNoLink").href = `../../DiscountCodeEditController?type=${type}&&value=${value}&&name=${maNhap}&&maximunNumberOfUse=${soLanSuDung}&&deadline=${hanSuDUng}&&id=${id}&&dateCreated=${ngayTao}`;
                        document.getElementById("formYesNoTitle2").appendChild(item);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                    }

                } else {
                    let valuegg = parseInt(value);
                    if (value > 0) {
                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn lưu thay đổi';
                        document.getElementById("formYesNoTitle2").innerText = 'Việc thay đổi sẽ thay đổi dữ liệu của bạn ';
                        let item = document.createElement("i");
                        item.classList.add("fa");
                        item.classList.add("fa-hand-grab-o");
                        document.getElementById("formYesNoLink").href = `../../DiscountCodeEditController?type=${type}&&value=${value}&&name=${maNhap}&&maximunNumberOfUse=${soLanSuDung}&&deadline=${hanSuDUng}&&id=${id}&&dateCreated=${ngayTao}`;
                        document.getElementById("formYesNoTitle2").appendChild(item);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                    }
                }
            }
        }
    }

}

function changeSelect(item) {
    let l = item.children;
    let check = false;
    for (let i = 0; i < l.length; i++) {
        if (l[i].selected == true) {
            if (i == 0) {
                check = true;
            }
        }
    }

    let list1 = document.getElementById("div1").children[0].children[1].children;
    if (!check) {
        list1[3].classList.remove("hidden");
    } else {
        if (!list1[3].classList.contains("hidden"))
            list1[3].classList.add("hidden");
    }

}


function changeSelect2(item) {
    let l = item.children;
    let check = false;
    for (let i = 0; i < l.length; i++) {
        if (l[i].selected == true) {
            if (i == 0) {
                check = true;
            }
        }
    }

    let list1 = document.getElementById("div3").children[0].children[1].children;
    if (!check) {
        list1[3].classList.remove("hidden");
    } else {
        if (!list1[3].classList.contains("hidden"))
            list1[3].classList.add("hidden");
    }

}


function showselectgopage(item) {

    let listItem = document.getElementById("leftnextpage").children;

    let listUl = listItem[2].children;

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

    let listUl = listItem[2].children;

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

function changeFilter() {
    document.getElementById("action").value = "changeFilter";
    document.getElementById("mainForm").submit();
}

function changesort() {
    document.getElementById("action").value = "sort";
    document.getElementById("mainForm").submit();
}

function loadPage() {
    document.getElementById("action").value = "load";
    document.getElementById("mainForm").submit();
}

function searchByClick(){
    document.getElementById("action").value = "search";
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

function nextPage(nowPage, maximumPage, item) {
    let n = parseInt(nowPage);
    let m = parseInt(maximumPage);
    if (n < m) {
        document.getElementById("numberOfPage").value = n + 1;
        document.getElementById("action").value = "nextPage";
        document.getElementById("mainForm").submit();
    }
}

function pageNavigation(nowPage) {
    document.getElementById("numberOfPage").value = parseInt(nowPage);
    document.getElementById("action").value = "nextPage";
    document.getElementById("mainForm").submit();
}

const node = document.getElementsByClassName("searchsubmit")[0];
node.addEventListener("keyup", function (event) {
    if (event.key == "Enter" || event.keyCode == 13) {
        document.getElementById("action").value = "search";
        document.getElementById("mainForm").submit();
    }
});

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