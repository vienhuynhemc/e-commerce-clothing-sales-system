function indexleftselectitemlv2(item) {
    let listItem = item.children;

    let itemarrow = listItem[0].children;

    if (listItem[2].checked == false) {
        listItem[2].checked = true;
        item.classList.remove("dontactiveindexleftselectitemlv2");

        itemarrow[1].style.transform = "rotate(90deg)"
    } else {
        listItem[2].checked = false;
        item.classList.add("dontactiveindexleftselectitemlv2");

        itemarrow[1].style.transform = "rotate(0deg)"
    }
}

function indextopbellinfor(item) {
    let listItem = item.children;
    if (listItem[3].checked == false) {
        listItem[3].checked = true;
        item.classList.remove("dontindextopbellinfor");
    } else {
        listItem[3].checked = false;
        item.classList.add("dontindextopbellinfor");
    }
}