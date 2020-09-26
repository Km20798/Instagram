function inDialog() {
    var white = document.getElementById("free");
    var dialog = document.getElementById("da");
    white.style.display = "none";
    dialog.style.display = "none";
}

function showDialog() {
    var white = document.getElementById("free");
    var dialog = document.getElementById("da");
    white.style.display = "block";
    dialog.style.display = "block";

}

$("button").click(function () {
    return false;
});
$("a[href='#']").click(function () {
    return false;
});
