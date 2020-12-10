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
    console.log(list)
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

    if (index < 9) {
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
        console.log("a")
        let list = listItem[i].children;
        let list2 = list[9].children;
        let list3 = list2[4].children;
        if (list3[1] == item) {
            document.getElementById("maindiv2").removeChild(listItem[i]);
            capnhaphienthi();
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
    let array = [];
    for (let i = 1; i < listItem.length; i++) {
        let list2 = listItem[i].children;
        let list3 = list2[0].children;
        if (list3[0].checked == true) {
            array.push(listItem[i]);
        }
    }

    for (let i = 0; i < array.length; i++) {
        document.getElementById("maindiv2").removeChild(array[i]);
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

function themkhachhang(){
    document.getElementById("div1").style.display = "block";
    document.getElementById("div2").style.display = "none";
}