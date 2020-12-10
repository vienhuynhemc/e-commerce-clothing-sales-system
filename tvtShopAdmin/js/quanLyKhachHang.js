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
    let listItem = item.children;
    if (listItem[0].checked == true) {
        listItem[0].checked = false;
        listItem[4].style.display = "none";
    } else {
        listItem[0].checked = true;
        listItem[4].style.display = "block";
    }
}