let countImg = 4;
let now = 0;
let slide = false;
let lastTime = 0;
function goback() {
    window.location.href = '../tvtShopAdmin/products.html'
}

function loadIMG(event) {
    if (event.target.files.length > 0) {
        var src = URL.createObjectURL(event.target.files[0]);

        let box = document.createElement('div');
        let img = document.createElement('img');
        let img2 = document.createElement('img');
        let remove = document.createElement('div');
        img.src = src;
        img2.src = src;
        remove.classList.add('removeImg');
        remove.innerText = 'Xóa';
        remove.onclick = function () { removeDiv(box, img2) };
        box.appendChild(img);
        box.appendChild(remove);
        document.getElementById('layout-img').appendChild(box);
        document.getElementById('list-img').appendChild(img2);
        countImg++;
    }
}

function removeDiv(box, img2) {
    document.getElementById('layout-img').removeChild(box);
    document.getElementById('list-img').removeChild(img2);
    let step = 100 * countImg - 100;
    if (countImg > 1) {
        if (now >= step) {
            now = 0;
        }
        else if (now <= 0) {
            now = step - 100;
        }
        document.getElementById('list-img').style.left = `-${now}%`;
    }
    countImg--;
}

function checkSlide() {
    let date = new Date();
    let time = date.getTime();
    if (time - lastTime > 1000) {
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

