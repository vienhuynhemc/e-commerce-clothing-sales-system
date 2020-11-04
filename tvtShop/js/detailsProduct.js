
    var m = document.getElementById('m_size');
    var l = document.getElementById('l_size');
    var xl = document.getElementById('xl_size');

    // m.onclick = function(){
    //     document.getElementById('m_size').style.border = "border: 3px solid #f5b505";
    //     document.getElementById('l_size').style.border = "border: 3px solid #d5cece";
    //     document.getElementById('xl_size').style.border = "border: 3px solid #d5cece";
    // }   
    // l.onclick = function(){
    //     document.getElementById('m_size').style.border = "border: 3px solid #d5cece";
    //     document.getElementById('l_size').style.border = "border: 3px solid #f5b505";
    //     document.getElementById('xl_size').style.border = "border: 3px solid #d5cece";
    // }
    // xl.onclick = function(){
    //     document.getElementById('m_size').style.border = "border: 3px solid #d5cece";
    //     document.getElementById('l_size').style.border = "border: 3px solid #d5cece";
    //     document.getElementById('xl_size').style.border = "border: 3px solid #f5b505";
    // }
function add(){
    var index = parseInt(document.getElementById('value').value);
        document.getElementById('value').value = index+1;
        console.log(index+1);
}
function sub(){
    var index = parseInt(document.getElementById('value').value);
    if (index == 0) {
        document.getElementById('value').value = 0;
    }
    else{
        document.getElementById('value').value = index-1;
        console.log(index-1);
    }
}
//mo ta san pham




