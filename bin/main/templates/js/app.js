
const buttons = document.getElementsByClassName("category");

const buttonPressed = e => {
let catID = e.target.id;  // Get ID of Clicked Element
console.log(catID);
let hides = document.getElementsByClassName("dcontent");
for (let hide of hides) {
    hide.style.display = "none";
}
document.getElementById("dcontent" + catID).style.display = "grid";
}

for (let button of buttons) {
button.addEventListener("click", buttonPressed);
}

buttons[0].click();

/* Function to open the pop-up form */
function openForm() {
    document.getElementById("myForm").style.display = "block";
}

/* Function to close the pop-up form */
function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

/* Function to open the pop-up form */
function openCal() {
    document.getElementById("myForm2").style.display = "block";
}

/* Function to close the pop-up form */
function closeCal() {
    document.getElementById("myForm2").style.display = "none";
}