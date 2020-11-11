function plustocard() {
    let inputsl = document.getElementById('sladdtocard');
    inputsl.value = `${parseInt(inputsl.value) + 1}`;
}

function subtocard() {
    let inputsl = document.getElementById('sladdtocard');
    if (inputsl.value > 1) {
        inputsl.value = `${parseInt(inputsl.value) - 1}`;
    }
}