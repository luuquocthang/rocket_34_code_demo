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
document.writeln(str1);
document.writeln(str2);
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

function deleleStudent(event) {
    alert("Bạn có muốn xoá không");
}