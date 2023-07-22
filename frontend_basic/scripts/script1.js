// console.log(a);
// var a = 10;

var a = undefined;
console.log(a);
a = 10;


const PI = 3.14;
// PI = 30;

const Persion = {
    fullName: "luu quoc thang",
    "nam sinh": dayjs(),
    show: function () {
        console.log("name:", this.fullName);
        console.log("nam sinh:", this["nam sinh"].format('DD/MM/YYYY'));
    }
}

Persion.fullName = "l2t";
console.log(Persion["nam sinh"].format('DD/MM/YYYY'));
console.log(Persion.show());
// Persion = {
//     abc: "luu quoc thang"
// }

function sum(...list) {
    let sum = 0
    for (const ele of list) {
        sum += ele;
    }
    return sum;
}


console.log(sum(1, 2, 3));
console.log(sum(1, 2, 3, 4, 5));


var str1 = "this is str1. You can use ''<br>";
var str2 = 'this is str2. You can use ""<br>';
var str3 = `this is str1. ${PI}
You can use`;
// document.writeln(str1);
// document.writeln(str2);
console.log(str3);

if (5 === "5") {
    console.log("Ok")
} else {
    console.log("NG")
}
function test() {
    try {
        console.log(b);
        let b = 10;
    } catch (error) {
        console.log("code have an error");
    }
}

test();
var studentTbl = document.getElementById("studentTbl");
var addStudentForm = document.getElementById("addStudentForm");
var nameipt = document.getElementById("nameipt");
var dob = document.getElementById("dob");
var mark = document.getElementById("mark");
var male = document.getElementById("male");
var female = document.getElementById("female");
var other = document.getElementById("other");
var abcBtn = document.querySelector("#other button");
var studentFromTitle = document.getElementById("studentFromTitle");

var studentFromTitle1 = $("#studentFromTitle")
var addStudentForm1 = $("#addStudentForm");
var changeStylePlaceholder = function() {
    studentFromTitle.style.fontSize = "40px";
    // const list = studentFromTitle.classList;
    // list.add("under");
    studentFromTitle1.addClass("under");
}
// function deleleStudent(event) {
//     let target = event.target;
//     let td = target.parentElement;
//     let tr = td.parentElement;
//     tr.remove();
//     // let tbody = tr.parentElement;
//     // console.log(tbody)
// }

function deleleStudent(event) {
    let target = event.target;
    let td = target.parentElement;
    let tr = td.parentElement;
    tr.outerHTML = null;
}

// function deleleStudent(event, index) {
//     studentTbl.deleteRow(index);
// }
var currentRow = 4;
var id = 3;
var addRowToTable = function(id, name, dob, mark, check) {
    var row = studentTbl.insertRow(currentRow);
    var cell0 = row.insertCell(0);
    var cell1 = row.insertCell(1);
    var cell2 = row.insertCell(2);
    var cell3 = row.insertCell(3);
    var cell4 = row.insertCell(4);
    var cell5 = row.insertCell(5);
    var cell6 = row.insertCell(6);
    var cell7 = row.insertCell(7);
    
    cell0.innerHTML = id;
    cell1.innerHTML = name;
    cell2.innerHTML = dob;
    cell3.innerHTML = mark;
    cell4.innerHTML = `<input type="radio" name="genderr${id}">`;
    cell5.innerHTML = `<input type="radio" name="genderr${id}">`;
    cell6.innerHTML = `<input type="radio" name="genderr${id}">`;
    switch(check) {
        case 1:
            cell4.innerHTML = `<input type="radio" name="genderr${id}" checked>`;
            break;
        case 2:
            cell5.innerHTML = `<input type="radio" name="genderr${id}" checked>`;
            break;
        case 3:
            cell6.innerHTML = `<input type="radio" name="genderr${id}" checked>`;
            break;
        case 0:
            break;
        default:
            break;
    }
    cell7.innerHTML = `<button onclick="deleleStudent(event)">Delete</button>`;
    
}


var submitHandle = function(event) {
    event.preventDefault();
    let fullName = nameipt.value;
    let dobValue = dob.value;
    let markValue = mark.value;
    let maleValue = male.checked;
    let femaleValue = female.checked;
    let otherValue = other.checked;
    let checked = (maleValue) ? 1 : ((femaleValue) ? 2 : ((otherValue) ? 3 : 0))
    // alert(maleValue);
    $.ajax({
        url:"http://localhost:3006/test1",
        type: "get",
        dataType: "json",
        data:{"fullName": fullName, "dobValue": dobValue, "markValue": markValue, checked},
        headers: {token: "abc"},
        beforeSend: function() {
            alert("before send")
        },
        success: function(response) {
            console.log(response);
            alert("success")
        },
        error: function() {
            alert("error")
        },
        complete: function() {
            alert("complete")
        },
    })
    addRowToTable(id, fullName, dobValue, markValue, checked);
    id++;
    currentRow++;
}

// addStudentForm.addEventListener("submit", submitHandle);
abcBtn.addEventListener("click", changeStylePlaceholder);

addStudentForm1.on("submit", submitHandle);