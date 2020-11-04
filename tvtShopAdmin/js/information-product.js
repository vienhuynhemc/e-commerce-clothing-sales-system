let countImg = 4;
let now = 0;
let slide = false;
let lastTime = 0;
function goback() {
    window.location.href = '../tvtShopAdmin/products.html'
}

function checkSlide() {
    let date = new Date();
    let time = date.getTime();
    if (time - lastTime > 500) {
        slide = false;
        lastTime = time;
    }
}

setInterval(() => {
    checkSlide();
    if (!slide) {
        slide = true;
        let step = 100 * countImg - 100;
        if (countImg > 1) {
            if (now >= step) {
                now = 0;
            } else {
                now += 100;
            }
        }
        document.getElementById('list-img').style.left = `-${now}%`;
    }
}, 3000);

function leftslide() {
    checkSlide();
    if (!slide) {
        slide = true;
        let step = 100 * countImg - 100;
        if (countImg > 1) {
            if (now <= 0) {
                now = step;
            } else {
                now -= 100;
            }
        }
        document.getElementById('list-img').style.left = `-${now}%`;
    }
}

function rightslide() {
    checkSlide();
    if (!slide) {
        slide = true;
        let step = 100 * countImg - 100;
        if (countImg > 1) {
            if (now >= step) {
                now = 0;
            } else {
                now += 100;
            }
        }
        document.getElementById('list-img').style.left = `-${now}%`;
    }

}
