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
        if (list2[9] == item) {
            index = i;
            break;
        }
    }

    if (index < 8) {
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
        listItem[4].style.top = "-155px"
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
        let list2 = list[9].children;
        let list3 = list2[4].children;
        if (list3[2] == item) {
            list2[1].checked = false;
            let ma_sp = list3[3].value;
            let ma_mau = list3[4].value;
            let ma_size = list3[5].value;
            let ten_mau = list3[6].value;
            let ten_size = list3[7].value;

            document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn xóa #' + ma_sp + ", Size: " + ten_size + ", Màu: " + ten_mau;
            document.getElementById("formYesNoTitle2").innerText = 'Việc xóa sẽ thay đổi dữ liệu của bạn ';
            let item = document.createElement("i");
            item.classList.add("fa");
            item.classList.add("fa-hand-grab-o");

            document.getElementById("formYesNoLink").style.display = 'flex';
            document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
            document.getElementById("formYesNoLink").href = "../../ProductRemoveController?type=single&&ma_sp=" + ma_sp + "&&ma_mau=" + ma_mau + "&&ma_size=" + ma_size + "&&ten_mau=" + ten_mau + "&&ten_size=" + ten_size;
            document.getElementById("formYesNoTitle2").appendChild(item);
            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
            return;

        }
    }
}

function capnhaphienthi() {
    let listItem = document.getElementById("maindiv2").children;
    for (let i = 0; i < listItem.length; i++) {
        if (i <= 10) {
            listItem[i].style.display = "flex";
        } else {
            listItem[i].style.display = "none";
        }
    }
}

function xoacacmuadachon() {
    let listItem = document.getElementById("maindiv2").children;
    let danh_sach_thong_tin = '';
    for (let i = 1; i < listItem.length; i++) {
        let list2 = listItem[i].children;
        let list3 = list2[0].children;
        if (list3[0].checked == true) {
            danh_sach_thong_tin += list3[1].value + ":" + list3[2].value + ":" + list3[3].value + " ";
        }
    }
    if (danh_sach_thong_tin.length > 0) {
        danh_sach_thong_tin = danh_sach_thong_tin.trim();
        let size = danh_sach_thong_tin.split(" ").length;

        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn xóa ' + size + ' mục';
        document.getElementById("formYesNoTitle2").innerText = 'Việc xóa sẽ thay đổi dữ liệu của bạn ';
        let item = document.createElement("i");
        item.classList.add("fa");
        item.classList.add("fa-hand-grab-o");
        document.getElementById("formYesNoLink").style.display = 'flex';
        document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
        document.getElementById("formYesNoLink").href = "../../ProductRemoveController?type=group&&danh_sach_thong_tin=" + danh_sach_thong_tin;
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

function themsanphammoi() {
    document.getElementById("action").value = "them_moi";
    document.getElementById("mainForm").submit();
}

function trove() {
    document.getElementById("action").value = "tro_ve";
    document.getElementById("mainForm").submit();
}

function editkhachhang(item) {

    let listItem = document.getElementById("maindiv2").children;
    for (let i = 1; i < listItem.length; i++) {
        let list = listItem[i].children;
        let list2 = list[9].children;
        let list3 = list2[4].children;
        if (list3[0] == item) {

            document.getElementById("action").value = "sua_don";
            document.getElementById("mainForm1").value = list3[3].value;
            document.getElementById("mainForm2").value = list3[4].value;
            document.getElementById("mainForm").submit();

            return;
        }
    }
}

function editkhachhangDa(item) {

    let listItem = document.getElementById("maindiv2").children;
    for (let i = 1; i < listItem.length; i++) {
        let list = listItem[i].children;
        let list2 = list[9].children;
        let list3 = list2[4].children;
        if (list3[1] == item) {

            document.getElementById("action").value = "sua_da";
            document.getElementById("mainForm1").value = list3[3].value;
            document.getElementById("mainForm").submit();

            return;
        }
    }
}

function nam(item) {
    let l1 = document.getElementById("div1").children;
    let l2 = l1[0].children;
    let l3 = l2[0].children;
    let l4 = l3[5].children;
    let l5 = l4[1].children;
    l5[1].classList.remove("activebutton");
    l5[0].classList.add("activebutton")
}

function nu(item) {
    let l1 = document.getElementById("div1").children;
    let l2 = l1[0].children;
    let l3 = l2[0].children;
    let l4 = l3[5].children;
    let l5 = l4[1].children;
    l5[0].classList.remove("activebutton");
    l5[1].classList.add("activebutton")
}

function nam2(item) {
    let l1 = document.getElementById("div3").children;
    let l2 = l1[0].children;
    let l3 = l2[0].children;
    let l4 = l3[5].children;
    let l5 = l4[1].children;
    l5[1].classList.remove("activebutton");
    l5[0].classList.add("activebutton")
}

function nu2(item) {
    let l1 = document.getElementById("div3").children;
    let l2 = l1[0].children;
    let l3 = l2[0].children;
    let l4 = l3[5].children;
    let l5 = l4[1].children;
    l5[0].classList.remove("activebutton");
    l5[1].classList.add("activebutton")
}

function ao() {

    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;
    let list4 = list3[2].children;
    let list5 = list4[1].children;

    if (list5[1].classList.contains("activebutton")) {
        list5[1].classList.remove("activebutton");
        list5[0].classList.add("activebutton");

        // size
        list6 = list3[5].children;

        list7 = list6[1].children;
        let count = list7.length;
        while (count > 0) {
            count--;
            list6[1].removeChild(list7[count]);
        }

        //color
        let list8 = list2[1].children;
        let list9 = list8[4].children;
        let list10 = list9[1].children;

        count = list10.length;
        while (count > 0) {
            count--;
            list9[1].removeChild(list10[count]);
        }
    }
}

function quan() {

    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;
    let list4 = list3[2].children;
    let list5 = list4[1].children;
    if (list5[0].classList.contains("activebutton")) {
        list5[0].classList.remove("activebutton");
        list5[1].classList.add("activebutton");

        // size
        list6 = list3[5].children;

        list7 = list6[1].children;
        let count = list7.length;
        while (count > 0) {
            count--;
            list6[1].removeChild(list7[count]);
        }

        //color
        let list8 = list2[1].children;
        let list9 = list8[4].children;
        let list10 = list9[1].children;

        count = list10.length;
        while (count > 0) {
            count--;
            list9[1].removeChild(list10[count]);
        }
    }
}

function ao2() {

    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;
    let list4 = list3[2].children;
    let list5 = list4[1].children;

    if (list5[1].classList.contains("activebutton")) {
        list5[1].classList.remove("activebutton");
        list5[0].classList.add("activebutton");

        // size
        list6 = list3[5].children;

        list7 = list6[1].children;
        let count = list7.length;
        while (count > 0) {
            count--;
            list6[1].removeChild(list7[count]);
        }

        //color
        let list8 = list2[1].children;
        let list9 = list8[4].children;
        let list10 = list9[1].children;

        count = list10.length;
        while (count > 0) {
            count--;
            list9[1].removeChild(list10[count]);
        }
    }
}

function quan2() {

    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;
    let list4 = list3[2].children;
    let list5 = list4[1].children;
    if (list5[0].classList.contains("activebutton")) {
        list5[0].classList.remove("activebutton");
        list5[1].classList.add("activebutton");

        // size
        list6 = list3[5].children;

        list7 = list6[1].children;
        let count = list7.length;
        while (count > 0) {
            count--;
            list6[1].removeChild(list7[count]);
        }

        //color
        let list8 = list2[1].children;
        let list9 = list8[4].children;
        let list10 = list9[1].children;

        count = list10.length;
        while (count > 0) {
            count--;
            list9[1].removeChild(list10[count]);
        }
    }
}

function removeSize(button) {
    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;

    list6 = list3[5].children;

    list7 = list6[1].children;
    for (let i = 0; i < list7.length; i++) {
        list8 = list7[i].children;
        if (list8[1] == button) {
            let id = list8[2].value;

            document.getElementById("actionDiv1").value = "removeSize";
            document.getElementById("idDiv1").value = id;
            document.getElementById("div1").submit();

            return;
        }
    }
}

function removeSize2(button) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;

    list6 = list3[5].children;

    list7 = list6[1].children;
    for (let i = 0; i < list7.length; i++) {
        list8 = list7[i].children;
        if (list8[1] == button) {
            let id = list8[2].value;

            document.getElementById("actionDiv2").value = "removeSize";
            document.getElementById("idDiv2").value = id;
            document.getElementById("div31").submit();

            return;
        }
    }
}

function removeSizeChangeImg(button) {
    let list = document.getElementById("listSizeDiv3").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == button) {

            let id = list[i].children[2].value;

            document.getElementById("changeImgAction").value = "removeSize";
            document.getElementById("changeImgData").value = id;
            document.getElementById("changImg").submit();

        }
    }
}


function themsize(item) {

    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;
    if (item == list3[4]) {

        //lấy value size
        let list4 = list3[3].children;
        let select = list4[1];
        let value = select.value;

        // lấy listItemsize
        list6 = list3[5].children;
        list7 = list6[1].children;

        let check = 0;
        for (let i = 0; i < list7.length; i++) {
            let l1 = list7[i].children;
            if (l1[2].value == value) {
                check = 1;
                break;
            }
        }


        if (check == 0) {
            document.getElementById("actionDiv1").value = "addSize";
            document.getElementById("idDiv1").value = value;
            document.getElementById("div1").submit();
        }

    }
}

function themsize2(item) {

    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;
    //--
    let list3 = list2[2].children;
    if (item == list3[4]) {

        //lấy value size
        let list4 = list3[3].children;
        let select = list4[1];
        let value = select.value;

        // lấy listItemsize
        list6 = list3[5].children;
        list7 = list6[1].children;

        let check = 0;
        for (let i = 0; i < list7.length; i++) {
            let l1 = list7[i].children;
            if (l1[2].value == value) {
                check = 1;
                break;
            }
        }


        if (check == 0) {
            document.getElementById("actionDiv2").value = "addSize";
            document.getElementById("idDiv2").value = value;
            document.getElementById("div31").submit();
        }

    }
}

function themsize3() {

    let check = 0;
    let value = document.getElementById("valueSize").value;
    let list = document.getElementById("listSizeDiv3").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[2].value == value) {
            check = 1;
            break;
        }
    }

    if (check == 0) {
        document.getElementById("changeImgAction").value = "addSize";
        document.getElementById("changeImgData").value = value;
        document.getElementById("changImg").submit();
    }
}

function removeSize3(item) {
    let list = document.getElementById("listSizeDiv3").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("listSizeDiv3").removeChild(list[i]);
            break;
        }
    }
}


function removehinhitem(item) {
    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[0].children;

        // listhinh va 2 angle
        list13 = list12[1].children;

        // listhinh
        list14 = list13[0].children;
        for (let j = 0; j < list14.length; j++) {
            list15 = list14[j].children;
            if (list15[1] == item) {

                document.getElementById("actionDiv1").value = "removeImage";
                document.getElementById("idDiv1").value = list15[2].value;
                document.getElementById("idDiv12").value = list15[0].src;
                document.getElementById("div1").submit();

                // let newValue = parseInt(list13[3].value);
                // if (newValue < 0) {
                //     newValue += 50;
                //     let space = newValue / -50;
                //     list13[3].value = newValue;
                //     if (space > 0) {
                //         list13[0].style.marginLeft = `${newValue - space * 10}px`;
                //     } else {
                //         list13[0].style.marginLeft = `${newValue}px`;
                //     }
                // }

                return;
            }
        }
    }
}

function removehinhitem2(item) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[0].children;

        // listhinh va 2 angle
        list13 = list12[1].children;

        // listhinh
        list14 = list13[0].children;
        for (let j = 0; j < list14.length; j++) {
            list15 = list14[j].children;
            if (list15[1] == item) {

                document.getElementById("actionDiv2").value = "removeImage";
                document.getElementById("idDiv2").value = list15[2].value;
                document.getElementById("idDiv22").value = list15[0].src;
                document.getElementById("div31").submit();

                // let newValue = parseInt(list13[3].value);
                // if (newValue < 0) {
                //     newValue += 50;
                //     let space = newValue / -50;
                //     list13[3].value = newValue;
                //     if (space > 0) {
                //         list13[0].style.marginLeft = `${newValue - space * 10}px`;
                //     } else {
                //         list13[0].style.marginLeft = `${newValue}px`;
                //     }
                // }

                return;
            }
        }
    }
}


function removehinhitem2(item) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[0].children;

        // listhinh va 2 angle
        list13 = list12[1].children;

        // listhinh
        list14 = list13[0].children;
        for (let j = 0; j < list14.length; j++) {
            list15 = list14[j].children;
            if (list15[1] == item) {
                list13[0].removeChild(list14[j]);

                let newValue = parseInt(list13[3].value);
                if (newValue < 0) {
                    newValue += 50;
                    let space = newValue / -50;
                    list13[3].value = newValue;
                    if (space > 0) {
                        list13[0].style.marginLeft = `${newValue - space * 10}px`;
                    } else {
                        list13[0].style.marginLeft = `${newValue}px`;
                    }
                }

                return;
            }
        }
    }
}

function movehinhleft(item) {
    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[0].children;

        // listhinh va 2 angle
        list13 = list12[1].children;

        if (list13[1] == item) {
            let value = parseInt(list13[3].value);
            let sizeHinh = list13[0].children.length;
            if (sizeHinh > 6) {
                if (value == 0) {
                    value = -(sizeHinh * 50 - 300);
                    list13[3].value = value;
                    let space = value / 50;
                    list13[0].style.marginLeft = `${value + space * 10}px`;
                } else {
                    value += 50;
                    let space = value / 50;
                    list13[3].value = value;
                    list13[0].style.marginLeft = `${value + space * 10}px`;
                }
            }
        }
    }
}

function movehinhleft2(item) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[0].children;

        // listhinh va 2 angle
        list13 = list12[1].children;

        if (list13[1] == item) {
            let value = parseInt(list13[3].value);
            let sizeHinh = list13[0].children.length;
            if (sizeHinh > 6) {
                if (value == 0) {
                    value = -(sizeHinh * 50 - 300);
                    list13[3].value = value;
                    let space = value / 50;
                    list13[0].style.marginLeft = `${value + space * 10}px`;
                } else {
                    value += 50;
                    let space = value / 50;
                    list13[3].value = value;
                    list13[0].style.marginLeft = `${value + space * 10}px`;
                }
            }
        }
    }
}

function movehinhright(item) {
    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[0].children;

        // listhinh va 2 angle
        list13 = list12[1].children;

        if (list13[2] == item) {
            let value = parseInt(list13[3].value);
            let sizeHinh = list13[0].children.length;
            if (sizeHinh > 6) {
                if (sizeHinh * 50 - (-value) == 300) {
                    value = 0;
                    list13[3].value = value;
                    list13[0].style.marginLeft = `${value}px`;
                } else {
                    value -= 50;
                    let space = value / -50;
                    list13[3].value = value;
                    list13[0].style.marginLeft = `${value - space * 10}px`;
                }
            }
        }
    }
}

function movehinhright2(item) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[0].children;

        // listhinh va 2 angle
        list13 = list12[1].children;

        if (list13[2] == item) {
            let value = parseInt(list13[3].value);
            let sizeHinh = list13[0].children.length;
            if (sizeHinh > 6) {
                if (sizeHinh * 50 - (-value) == 300) {
                    value = 0;
                    list13[3].value = value;
                    list13[0].style.marginLeft = `${value}px`;
                } else {
                    value -= 50;
                    let space = value / -50;
                    list13[3].value = value;
                    list13[0].style.marginLeft = `${value - space * 10}px`;
                }
            }
        }
    }
}

function removecolor(item) {
    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[1].children;
        if (list12[1] == item) {

            document.getElementById("actionDiv1").value = "removeColor";
            document.getElementById("idDiv1").value = list12[3].value;
            document.getElementById("div1").submit();

        }
    }
}

function removecolor2(item) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[1].children;
        if (list12[1] == item) {

            document.getElementById("actionDiv2").value = "removeColor";
            document.getElementById("idDiv2").value = list12[3].value;
            document.getElementById("div31").submit();

        }
    }
}

function themhinh(item) {
    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[1].children;
        if (list12[0] == item) {
            list12[2].click();
        }
    }
}

function themhinh2(item) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[1].children;
        if (list12[0] == item) {
            list12[2].click();
        }
    }
}

function themmau(item) {
    let l1 = document.getElementById("div1").children;
    let l2 = l1[0].children;
    let l3 = l2[1].children;
    let l4 = l3[3].children;
    if (l4[0] == item) {

        //l5[1] = la listMau
        let l5 = l3[4].children;

        //lay du lieu
        let l6 = l3[2].children;
        let value = l6[1].value;

        let check = 0;
        let listMau = l5[1].children;
        for (let j = 0; j < listMau.length; j++) {
            let a1 = listMau[j].children;
            let a2 = a1[0].children;
            let a3 = a2[0].children;
            if (a3[2].value == value) {
                check = 1;
            }
        }
        if (check == 0) {

            document.getElementById("actionDiv1").value = "addColor";
            document.getElementById("idDiv1").value = value;
            document.getElementById("div1").submit();

        }
    }
}

function themmau2(item) {
    let l1 = document.getElementById("div3").children;
    let l2 = l1[0].children;
    let l3 = l2[1].children;
    let l4 = l3[3].children;
    if (l4[0] == item) {

        //l5[1] = la listMau
        let l5 = l3[4].children;

        //lay du lieu
        let l6 = l3[2].children;
        let value = l6[1].value;

        let check = 0;
        let listMau = l5[1].children;
        for (let j = 0; j < listMau.length; j++) {
            let a1 = listMau[j].children;
            let a2 = a1[0].children;
            let a3 = a2[0].children;
            if (a3[2].value == value) {
                check = 1;
            }
        }
        if (check == 0) {

            document.getElementById("actionDiv2").value = "addColor";
            document.getElementById("idDiv2").value = value;
            document.getElementById("div31").submit();

        }
    }
}

function taomaumoi() {
    document.getElementById("taomaumoi").style.display = "block";
}

function taomauxong() {
    document.getElementById("taomaumoi").style.display = "none";
}

let arrayMau = [];

function loadIMGMau(event) {
    if (event.target.files.length > 0) {
        var src = URL.createObjectURL(event.target.files[0]);
        document.getElementById("psm").src = src;
        arrayMau = [];
        arrayMau.push(event.target.files[0]);
    }
}

function themGioiThieu() {
    let div = document.createElement("div");
    div.classList.add("itemGioiThieu");
    let input = document.createElement("input");
    input.type = "text";
    input.placeholder = "Nhập giới thiệu ở đây";
    input.value = "";
    input.name = "gioi_thieu" + (parseInt(document.getElementById("size_gioi_thieu").value) + 1);
    div.appendChild(input);
    let i = document.createElement("i");
    i.classList.add("fa");
    i.classList.add("fa-close");
    i.onclick = function () {
        removeGioiThieu(this);
    }
    div.appendChild(i);
    document.getElementById("listGioiThieu").appendChild(div);

    let newValue = parseInt(document.getElementById("size_gioi_thieu").value) + 1;
    document.getElementById("size_gioi_thieu").value = newValue;
}

function themGioiThieu2() {
    let div = document.createElement("div");
    div.classList.add("itemGioiThieu");
    let input = document.createElement("input");
    input.type = "text";
    input.placeholder = "Nhập giới thiệu ở đây";
    input.value = "";
    input.name = "gioi_thieu" + (parseInt(document.getElementById("size_gioi_thieu_edit").value) + 1);
    div.appendChild(input);
    let i = document.createElement("i");
    i.classList.add("fa");
    i.classList.add("fa-close");
    i.onclick = function () {
        removeGioiThieu2(this);
    }
    div.appendChild(i);
    document.getElementById("listGioiThieuEdit").appendChild(div);

    let newValue = parseInt(document.getElementById("size_gioi_thieu_edit").value) + 1;
    document.getElementById("size_gioi_thieu_edit").value = newValue;
}

function removeGioiThieu(item) {
    let list = document.getElementById("listGioiThieu").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("listGioiThieu").removeChild(list[i]);
            break;
        }
    }
    list = document.getElementById("listGioiThieu").children;
    for (let i = 0; i < list.length; i++) {
        list[i].children[0].name = "gioi_thieu" + (i + 1);
    }
    let newValue = parseInt(document.getElementById("size_gioi_thieu").value) - 1;
    document.getElementById("size_gioi_thieu").value = newValue;
}

function removeGioiThieu2(item) {
    let list = document.getElementById("listGioiThieuEdit").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("listGioiThieuEdit").removeChild(list[i]);
            break;
        }
    }
    list = document.getElementById("listGioiThieuEdit").children;
    for (let i = 0; i < list.length; i++) {
        list[i].children[0].name = "gioi_thieu" + (i + 1);
    }
    let newValue = parseInt(document.getElementById("size_gioi_thieu_edit").value) - 1;
    document.getElementById("size_gioi_thieu_edit").value = newValue;
}


function themCauTao() {
    let div = document.createElement("div");
    div.classList.add("itemGioiThieu");
    let input = document.createElement("input");
    input.type = "text";
    input.placeholder = "Nhập giới thiệu ở đây";
    input.value = "";
    input.name = "cau_tao" + (parseInt(document.getElementById("size_cau_tao").value) + 1);
    div.appendChild(input);
    let i = document.createElement("i");
    i.classList.add("fa");
    i.classList.add("fa-close");
    i.onclick = function () {
        removeCauTao(this);
    }
    div.appendChild(i);
    document.getElementById("listCauTao").appendChild(div);

    let newValue = parseInt(document.getElementById("size_cau_tao").value) + 1;
    document.getElementById("size_cau_tao").value = newValue;
}

function themCauTao2() {
    let div = document.createElement("div");
    div.classList.add("itemGioiThieu");
    let input = document.createElement("input");
    input.type = "text";
    input.placeholder = "Nhập giới thiệu ở đây";
    input.value = "";
    input.name = "cau_tao" + (parseInt(document.getElementById("size_cau_tao_edit").value) + 1);
    div.appendChild(input);
    let i = document.createElement("i");
    i.classList.add("fa");
    i.classList.add("fa-close");
    i.onclick = function () {
        removeCauTao2(this);
    }
    div.appendChild(i);
    document.getElementById("listCauTaoEdit").appendChild(div);

    let newValue = parseInt(document.getElementById("size_cau_tao_edit").value) + 1;
    document.getElementById("size_cau_tao_edit").value = newValue;
}

function removeCauTao(item) {
    let list = document.getElementById("listCauTao").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("listCauTao").removeChild(list[i]);
        }
    }
    list = document.getElementById("listCauTao").children;
    for (let i = 0; i < list.length; i++) {
        list[i].children[0].name = "cau_tao" + (i + 1);
    }
    let newValue = parseInt(document.getElementById("size_cau_tao").value) - 1;
    document.getElementById("size_cau_tao").value = newValue;
}

function removeCauTao2(item) {
    let list = document.getElementById("listCauTaoEdit").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("listCauTaoEdit").removeChild(list[i]);
        }
    }
    list = document.getElementById("listCauTaoEdit").children;
    for (let i = 0; i < list.length; i++) {
        list[i].children[0].name = "cau_tao" + (i + 1);
    }
    let newValue = parseInt(document.getElementById("size_cau_tao_edit").value) - 1;
    document.getElementById("size_cau_tao_edit").value = newValue;
}

function themThongTin() {
    let div = document.createElement("div");
    div.classList.add("itemGioiThieu");
    let input = document.createElement("input");
    input.type = "text";
    input.placeholder = "Nhập giới thiệu ở đây";
    input.value = "";
    input.name = "thong_tin" + (parseInt(document.getElementById("size_thong_tin").value) + 1);
    div.appendChild(input);
    let i = document.createElement("i");
    i.classList.add("fa");
    i.classList.add("fa-close");
    i.onclick = function () {
        removeThongTin(this);
    }
    div.appendChild(i);
    document.getElementById("listThongTin").appendChild(div);

    let newValue = parseInt(document.getElementById("size_thong_tin").value) + 1;
    document.getElementById("size_thong_tin").value = newValue;
}

function themThongTin2() {
    let div = document.createElement("div");
    div.classList.add("itemGioiThieu");
    let input = document.createElement("input");
    input.type = "text";
    input.placeholder = "Nhập giới thiệu ở đây";
    input.value = "";
    input.name = "thong_tin" + (parseInt(document.getElementById("size_thong_tin_edit").value) + 1);
    div.appendChild(input);
    let i = document.createElement("i");
    i.classList.add("fa");
    i.classList.add("fa-close");
    i.onclick = function () {
        removeThongTin2(this);
    }
    div.appendChild(i);
    document.getElementById("listThongTinEdit").appendChild(div);

    let newValue = parseInt(document.getElementById("size_thong_tin_edit").value) + 1;
    document.getElementById("size_thong_tin_edit").value = newValue;
}


function removeThongTin2(item) {
    let list = document.getElementById("listThongTinEdit").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("listThongTinEdit").removeChild(list[i]);
        }
    }
    list = document.getElementById("listThongTinEdit").children;
    for (let i = 0; i < list.length; i++) {
        list[i].children[0].name = "thong_tin" + (i + 1);
    }
    let newValue = parseInt(document.getElementById("size_thong_tin_edit").value) - 1;
    document.getElementById("size_thong_tin_edit").value = newValue;
}

function removeThongTin(item) {
    let list = document.getElementById("listThongTin").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("listThongTin").removeChild(list[i]);
        }
    }
    list = document.getElementById("listThongTin").children;
    for (let i = 0; i < list.length; i++) {
        list[i].children[0].name = "thong_tin" + (i + 1);
    }
    let newValue = parseInt(document.getElementById("size_thong_tin").value) - 1;
    document.getElementById("size_thong_tin").value = newValue;
}


function removeHinh(item) {
    let list = document.getElementById("listHinh").children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].children[1] == item) {
            document.getElementById("changeImgAction").value = "removeImg";
            document.getElementById("changeImgData").value = list[i].children[0].src;
            document.getElementById("changImg").submit();
        }
    }
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

function changesort() {
    document.getElementById("action").value = "sort";
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

var arrayMauHoanThanh = [];
var actionMau = 0;
var interVelMau;
var countRefreshMau;
var countRefreshMauMax = 3;

function taoMotMauMoi() {

    let src = document.getElementById("psm");
    let ten_mau = document.getElementById("tenmaumoi").value;

    if (arrayMau.length == 1 && ten_mau.length > 0) {
        taomauxong();
        taiMauMoi(arrayMau[0]);
        actionMau = 0;
        choTaiHinhMau();
    }
}

function choTaiHinhMau() {
    if (actionMau == 1) {
        if (interVelMau) {
            window.clearInterval(interVelMau);
            interVelMau = null;
            countRefreshMau = 0;
            arrayMau = [];
            arrayMauHoanThanh = [];
        }
    } else {
        if (!interVelMau) {
            interVelMau = window.setInterval(
                function () {
                    if (arrayMauHoanThanh.length == 1) {

                        actionMau = 1;
                        window.clearInterval(interVelMau);
                        interVelMau = null;
                        countRefreshMau = 0;

                        let link = arrayMauHoanThanh.pop();
                        let name = document.getElementById("tenmaumoi").value;
                        let id = document.getElementById("ma_mau_tiep_theo").value;

                        document.getElementById("tenmauthem").value = name;
                        document.getElementById("mamauthem").value = id;
                        document.getElementById("linkmauthem").value = link;

                        let itemm = document.createElement("i");
                        itemm.classList.add("fa");
                        itemm.classList.add("fa-hand-grab-o");
                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn thêm màu này';
                        document.getElementById("formYesNoTitle2").innerText = 'Việc thêm sẽ thay đổi dữ liệu của bạn ';
                        document.getElementById("formYesNoLink").style.display = 'flex';
                        document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
                        document.getElementById("formYesNoTitle2").appendChild(itemm);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                        document.getElementById("formYesNoLink").href = 'javascript:void(0)';
                        document.getElementById("formYesNoLink").onclick = function () {
                            document.getElementById("formthemmau").submit();
                        }


                    } else {
                        countRefreshMau++;
                        if (countRefreshMau == countRefreshMauMax) {
                            document.getElementById("formYesNoTitle").innerText = 'Tải hình lên server không thành công';
                            document.getElementById("formYesNoTitle2").innerText = 'Đây là một lỗi nhỏ khi chúng tôi sử dụng firebase, hãy thử lại nhé  ';
                            let itemm = document.createElement("i");
                            itemm.classList.add("fa");
                            itemm.classList.add("fa-hand-grab-o");
                            document.getElementById("formYesNoLink").style.display = "none";
                            document.getElementById("buttonNoFormYesNo").innerHTML = 'OK';
                            document.getElementById("formYesNoTitle2").appendChild(itemm);
                            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                            actionMau = 1;
                            choTaiHinhMau();
                        }
                    }
                }, 1000
            )
        }
    }
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

function taiMauMoi(img) {
    let nextId = document.getElementById("ma_mau_tiep_theo").value + "/" + "mau.jpg";
    const ref = firebase.storage().ref();
    const file = img;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = "mau/" + nextId;
    const metadata = {contentType: file.type};
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            link = url;
            arrayMauHoanThanh.push(link);
        });
}

var arrayHinhHoanThanh = [];
var actionHinh = 0;
var interVelHinh;
var countRefreshHinh;
var countRefreshHinhMax = 3;
var ma_mau_khi_tai_hinh;

function loadIMG(event, item) {
    //---
    let list1 = document.getElementById("div1").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[1].children;
        if (list12[2] == item) {
            if (event.target.files.length > 0) {

                let ma_mau = list12[3].value;
                let ma_sp = list12[4].value;
                let name_img = list12[5].value;

                let link_hinh = 'san_pham/' + ma_sp + "/" + ma_mau + "/" + name_img;
                taiHinhMoi(event.target.files[0], link_hinh)
                actionHinh = 0;
                ma_mau_khi_tai_hinh = ma_mau;
                choTaiHinhHinh();

                return;
            }
        }
    }
}

function choTaiHinhHinh() {
    if (actionHinh == 1) {
        if (interVelHinh) {
            window.clearInterval(interVelHinh);
            interVelHinh = null;
            countRefreshHinh = 0;
            arrayHinhHoanThanh = [];
        }
    } else {
        if (!interVelHinh) {
            interVelHinh = window.setInterval(
                function () {
                    if (arrayHinhHoanThanh.length == 1) {

                        actionHinh = 1;
                        window.clearInterval(interVelHinh);
                        interVelHinh = null;
                        countRefreshHinh = 0;

                        document.getElementById("actionDiv1").value = "addImage";
                        document.getElementById("idDiv1").value = ma_mau_khi_tai_hinh;
                        document.getElementById("idDiv12").value = arrayHinhHoanThanh.pop();
                        document.getElementById("div1").submit();

                    } else {
                        countRefreshHinh++;
                        if (countRefreshHinh == countRefreshHinhMax) {
                            document.getElementById("formYesNoTitle").innerText = 'Tải hình lên server không thành công';
                            document.getElementById("formYesNoTitle2").innerText = 'Đây là một lỗi nhỏ khi chúng tôi sử dụng firebase, hãy thử lại nhé  ';
                            let itemm = document.createElement("i");
                            itemm.classList.add("fa");
                            itemm.classList.add("fa-hand-grab-o");
                            document.getElementById("formYesNoLink").style.display = "none";
                            document.getElementById("buttonNoFormYesNo").innerHTML = 'OK';
                            document.getElementById("formYesNoTitle2").appendChild(itemm);
                            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                            actionHinh = 1;
                            choTaiHinhHinh();
                        }
                    }
                }, 1000
            )
        }
    }
}

function taiHinhMoi(img, linkImg) {
    const ref = firebase.storage().ref();
    const file = img;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = linkImg;
    const metadata = {contentType: file.type};
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            link = url;
            arrayHinhHoanThanh.push(link);
        });
}

function themsanpham() {

    let ten_sp = document.getElementById("ten_sp_add").value;
    if (ten_sp.length == 0) {
        document.getElementById("erroradd1").classList.remove("hidden");
    } else {
        if (!document.getElementById("erroradd1").classList.contains("hidden")) {
            document.getElementById("erroradd1").classList.add("hidden");
        }
        let gia = document.getElementById("gia_sp_add").value;
        if (gia.length == 0) {
            document.getElementById("erroradd2").classList.remove("hidden");
        } else {
            if (!document.getElementById("erroradd2").classList.contains("hidden")) {
                document.getElementById("erroradd2").classList.add("hidden");
            }
            let gia_nha = document.getElementById("gia_nhap_add").value;
            if (gia_nha.length == 0) {
                document.getElementById("erroradd3").classList.remove("hidden");
            } else {
                if (!document.getElementById("erroradd3").classList.contains("hidden")) {
                    document.getElementById("erroradd3").classList.add("hidden");
                }
                let listMau = document.getElementById("listMauAdd").children;
                if (listMau.length == 0) {
                    document.getElementById("erroradd4").classList.remove("hidden");
                } else {
                    if (!document.getElementById("erroradd4").classList.contains("hidden")) {
                        document.getElementById("erroradd4").classList.add("hidden");
                    }
                    let listSize = document.getElementById("listSizeAdd").children;
                    if (listSize.length == 0) {
                        document.getElementById("erroradd5").classList.remove("hidden");
                    } else {
                        if (!document.getElementById("erroradd5").classList.contains("hidden")) {
                            document.getElementById("erroradd5").classList.add("hidden");
                        }

                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn thêm sản phẩm này không ?'
                        document.getElementById("formYesNoTitle2").innerText = 'Việc thêm sẽ thay đổi dữ liệu của bạn ';
                        let item = document.createElement("i");
                        item.classList.add("fa");
                        item.classList.add("fa-hand-grab-o");

                        document.getElementById("formYesNoLink").style.display = 'flex';
                        document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
                        document.getElementById("formYesNoLink").href = 'javascript:void(0)';
                        document.getElementById("formYesNoLink").onclick = function () {
                            document.getElementById("actionDiv1").value = "addProduct";
                            document.getElementById("div1").submit();
                        }
                        document.getElementById("formYesNoTitle2").appendChild(item);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';

                    }
                }
            }
        }
    }
}

var arrayHinhHoanThanh5 = [];
var actionHinh5 = 0;
var interVelHinh5;
var countRefreshHinh5;
var countRefreshHinhMax5 = 3;
var ma_mau_khi_tai_hinh5;

function loadIMG2(event, item) {
    //---
    let list1 = document.getElementById("div3").children;
    let list2 = list1[0].children;

    //color
    let list8 = list2[1].children;
    let list9 = list8[4].children;
    let list10 = list9[1].children;
    for (let i = 0; i < list10.length; i++) {
        list11 = list10[i].children;
        list12 = list11[1].children;
        if (list12[2] == item) {
            if (event.target.files.length > 0) {

                let ma_mau = list12[3].value;
                let ma_sp = list12[4].value;
                let name_img = list12[5].value;

                let link_hinh = 'san_pham/' + ma_sp + "/" + ma_mau + "/" + name_img;
                taiHinhMoi5(event.target.files[0], link_hinh)
                actionHinh5 = 0;
                ma_mau_khi_tai_hinh5 = ma_mau;
                choTaiHinhHinh5();

                return;
            }
        }
    }
}

function choTaiHinhHinh5() {
    if (actionHinh5 == 1) {
        if (interVelHinh5) {
            window.clearInterval(interVelHinh5);
            interVelHinh5 = null;
            countRefreshHinh5 = 0;
            arrayHinhHoanThanh5 = [];
        }
    } else {
        if (!interVelHinh5) {
            interVelHinh5 = window.setInterval(
                function () {
                    if (arrayHinhHoanThanh5.length == 1) {

                        actionHinh5 = 1;
                        window.clearInterval(interVelHinh5);
                        interVelHinh5 = null;
                        countRefreshHinh5 = 0;

                        document.getElementById("actionDiv2").value = "addImage";
                        document.getElementById("idDiv2").value = ma_mau_khi_tai_hinh5;
                        document.getElementById("idDiv22").value = arrayHinhHoanThanh5.pop();
                        document.getElementById("div31").submit();

                    } else {
                        countRefreshHinh5++;
                        if (countRefreshHinh5 == countRefreshHinhMax5) {
                            document.getElementById("formYesNoTitle").innerText = 'Tải hình lên server không thành công';
                            document.getElementById("formYesNoTitle2").innerText = 'Đây là một lỗi nhỏ khi chúng tôi sử dụng firebase, hãy thử lại nhé  ';
                            let itemm = document.createElement("i");
                            itemm.classList.add("fa");
                            itemm.classList.add("fa-hand-grab-o");
                            document.getElementById("formYesNoLink").style.display = "none";
                            document.getElementById("buttonNoFormYesNo").innerHTML = 'OK';
                            document.getElementById("formYesNoTitle2").appendChild(itemm);
                            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                            actionHinh5 = 1;
                            choTaiHinhHinh5();
                        }
                    }
                }, 1000
            )
        }
    }
}

function taiHinhMoi5(img, linkImg) {
    const ref = firebase.storage().ref();
    const file = img;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = linkImg;
    const metadata = {contentType: file.type};
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            link = url;
            arrayHinhHoanThanh5.push(link);
        });
}

function luueditgroup() {

    let ten_sp = document.getElementById("ten_sp_edit").value;
    if (ten_sp.length == 0) {
        document.getElementById("erroredit1").classList.remove("hidden");
    } else {
        if (!document.getElementById("erroredit1").classList.contains("hidden")) {
            document.getElementById("erroredit1").classList.add("hidden");
        }
        let gia = document.getElementById("gia_sp_edit").value;
        if (gia.length == 0) {
            document.getElementById("erroredit2").classList.remove("hidden");
        } else {
            if (!document.getElementById("erroredit2").classList.contains("hidden")) {
                document.getElementById("erroredit2").classList.add("hidden");
            }
            let gia_nha = document.getElementById("gia_nhap_edit").value;
            if (gia_nha.length == 0) {
                document.getElementById("erroredit3").classList.remove("hidden");
            } else {
                if (!document.getElementById("erroredit3").classList.contains("hidden")) {
                    document.getElementById("erroredit3").classList.add("hidden");
                }
                let listMau = document.getElementById("listMauEdit").children;
                if (listMau.length == 0) {
                    document.getElementById("erroredit4").classList.remove("hidden");
                } else {
                    if (!document.getElementById("erroredit4").classList.contains("hidden")) {
                        document.getElementById("erroredit4").classList.add("hidden");
                    }
                    let listSize = document.getElementById("listSizeEdit").children;
                    if (listSize.length == 0) {
                        document.getElementById("erroredit5").classList.remove("hidden");
                    } else {
                        if (!document.getElementById("erroredit5").classList.contains("hidden")) {
                            document.getElementById("erroredit5").classList.add("hidden");
                        }

                        document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn cập nhật sản phẩm này không ?'
                        document.getElementById("formYesNoTitle2").innerText = 'Việc thêm sẽ thay đổi dữ liệu của bạn ';
                        let item = document.createElement("i");
                        item.classList.add("fa");
                        item.classList.add("fa-hand-grab-o");

                        document.getElementById("formYesNoLink").style.display = 'flex';
                        document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
                        document.getElementById("formYesNoLink").href = 'javascript:void(0)';
                        document.getElementById("formYesNoLink").onclick = function () {
                            document.getElementById("actionDiv2").value = "editProduct";
                            document.getElementById("div31").submit();
                        }
                        document.getElementById("formYesNoTitle2").appendChild(item);
                        document.getElementById("formYesNo").style.transform = 'scaleY(1)';

                    }
                }
            }
        }
    }
}


var arrayHinhHoanThanh2 = [];
var actionHinh2 = 0;
var interVelHinh2;
var countRefreshHinh2;
var countRefreshHinhMax2 = 3;

function themHinhMoi2(event) {
    if (event.target.files.length > 0) {
        var src = URL.createObjectURL(event.target.files[0]);

        let ma_mau = document.getElementById("changeImgMa_mau").value;
        let ma_sp = document.getElementById("changeImgMa_sp").value;
        let name_img = document.getElementById("changeImgHinh_anh_trong_firebase").value;

        let link_hinh = 'san_pham/' + ma_sp + "/" + ma_mau + "/" + name_img;
        taiHinhMoi2(event.target.files[0], link_hinh)
        actionHinh2 = 0;
        choTaiHinhHinh2();

        return;

    }
}

function taiHinhMoi2(img, linkImg) {
    const ref = firebase.storage().ref();
    const file = img;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = linkImg;
    const metadata = {contentType: file.type};
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            link = url;
            arrayHinhHoanThanh2.push(link);
        });
}

function choTaiHinhHinh2() {
    if (actionHinh2 == 1) {
        if (interVelHinh2) {
            window.clearInterval(interVelHinh2);
            interVelHinh2 = null;
            countRefreshHinh2 = 0;
            arrayHinhHoanThanh2 = [];
        }
    } else {
        if (!interVelHinh2) {
            interVelHinh2 = window.setInterval(
                function () {
                    if (arrayHinhHoanThanh2.length == 1) {

                        actionHinh2 = 1;
                        window.clearInterval(interVelHinh2);
                        interVelHinh2 = null;
                        countRefreshHinh2 = 0;


                        document.getElementById("changeImgData").value = arrayHinhHoanThanh2.pop();
                        document.getElementById("changeImgAction").value = "addImage";
                        document.getElementById("changImg").submit();

                    } else {
                        countRefreshHinh2++;
                        if (countRefreshHinh2 == countRefreshHinhMax2) {
                            document.getElementById("formYesNoTitle").innerText = 'Tải hình lên server không thành công';
                            document.getElementById("formYesNoTitle2").innerText = 'Đây là một lỗi nhỏ khi chúng tôi sử dụng firebase, hãy thử lại nhé  ';
                            let itemm = document.createElement("i");
                            itemm.classList.add("fa");
                            itemm.classList.add("fa-hand-grab-o");
                            document.getElementById("formYesNoLink").style.display = "none";
                            document.getElementById("buttonNoFormYesNo").innerHTML = 'OK';
                            document.getElementById("formYesNoTitle2").appendChild(itemm);
                            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
                            actionHinh2 = 1;
                            choTaiHinhHinh2();
                        }
                    }
                }, 1000
            )
        }
    }
}

function luuEditSingle() {
    let sizeSize = document.getElementById("listSizeDiv3").children.length;
    let sizeImg = document.getElementById("listHinh").children.length;
    if (sizeSize == 0) {
        document.getElementById("errorEditSingle1").classList.remove("hidden");
    } else {
        if (!document.getElementById("errorEditSingle1").classList.contains("hidden")) {
            document.getElementById("errorEditSingle1").classList.add("hidden");
        }

        if (sizeImg == 0) {
            document.getElementById("errorEditSingle2").classList.remove("hidden");
        } else {
            if (!document.getElementById("errorEditSingle2").classList.contains("hidden")) {
                document.getElementById("errorEditSingle2").classList.add("hidden");
            }

            document.getElementById("formYesNoTitle").innerText = 'Bạn có chắc chắn cập nhật phẩm này không ?'
            document.getElementById("formYesNoTitle2").innerText = 'Việc cập nhật sẽ thay đổi dữ liệu của bạn ';
            let item = document.createElement("i");
            item.classList.add("fa");
            item.classList.add("fa-hand-grab-o");

            document.getElementById("formYesNoLink").style.display = 'flex';
            document.getElementById("buttonNoFormYesNo").innerHTML = 'Không, suy nghĩ thêm <i class="fa fa-close"></i>';
            document.getElementById("formYesNoLink").href = 'javascript:void(0)';
            document.getElementById("formYesNoLink").onclick = function () {
                document.getElementById("changeImgAction").value = "save";
                document.getElementById("changImg").submit();
            }
            document.getElementById("formYesNoTitle2").appendChild(item);
            document.getElementById("formYesNo").style.transform = 'scaleY(1)';
        }
    }
}