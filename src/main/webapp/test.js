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

function removeImg() {
    firebase.storage().ref('email_thong_bao/email_3/nv_5.jpg').delete();
}

function loadIMG(fileImg) {

    const ref = firebase.storage().ref();
    const file = fileImg;
    const name = file.name;
    let link;
    let nameData = name.split('.')[0];
    const folder = "test/" + nameData;
    const metadata = { contentType: file.type };
    const task = ref.child(folder).put(file, metadata);
    task
        .then(snapshot => snapshot.ref.getDownloadURL())
        .then(url => {
            alert("Thanh cong");
            console.log(url);
        });
}

CKEDITOR.replace('test');

function getFile() {
    let data = CKEDITOR.instances['test'].getData();
    let div = document.createElement("div");
    div.innerHTML = data;
    let list = div.children;
    for (let i = 0; i < list.length; i++) {
        if (list[i].nodeName == 'FIGURE') {

            let theBlob = list[i].children[0].src;
            if (theBlob.startsWith('blob')) {
                console.log(theBlob)
                var xhr = new XMLHttpRequest();
                xhr.open('GET', theBlob, true);
                xhr.responseType = 'blob';
                xhr.onload = function (e) {
                    if (this.status == 200) {
                        var myBlob = this.response;
                        console.log(myBlob);
                        const file = new File([myBlob], 'untitled', { type: myBlob.type })
                        console.log(file);
                    }
                };
                xhr.send();
            }
        }
    }

}

