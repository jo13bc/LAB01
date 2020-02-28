/* global parameters_classes */

function loaded_error_message(event) {
    load_error_modal_label();
    load_error_modal_button();
    load_error_modal_body();
}

let modal_error_body;
let modal_error_label_title;
function load_error_modal_label() {
    modal_error_label_title = document.getElementById('modal_error_label');
    modal_error_label_title.className = parameters_classes.CLASS_TITLE;
    modal_error_label_title.innerHTML = '';
}

function load_error_modal_body() {
    modal_error_body = document.getElementById("modal_error_body");
    modal_error_body.className = parameters_classes.CLASS_BODY;
    modal_error_body.innerHTML = '';
}

let modal_error_btn_primary;
let modal_error_btn_secondary;
function load_error_modal_button() {
    modal_error_btn_secondary = document.getElementById("button_cerrar");
    modal_error_btn_secondary.className = parameters_classes.CLASS_BUTTON_SECONDARY;
    modal_error_btn_secondary.innerHTML = 'Cerrar';
}

function error_message(title, message) {
    modal_error_label_title.innerHTML = title;
    modal_error_body.innerHTML = label_error_modal('', message);
    $('#modal_error').modal('toggle');
}

function label_error_modal(property, value) {
    return (value !== undefined) ? "<label class='" + parameters_classes.CLASS_LABEL +
            "'>" + property + value + "</label>" : '';
}

document.addEventListener("DOMContentLoaded", loaded_error_message);