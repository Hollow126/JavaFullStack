


var barElements = document.getElementsByClassName("bar");
var dataValues = [];

for (var i = 0; i < barElements.length; i++) {
  var dataValue = barElements[i].getAttribute("dataValue");
  dataValues.push(dataValue);
}

console.log(dataValues);



const bars = document.querySelectorAll(".bar");

bars.forEach((bar) => {
  const progressValue = bar.getAttribute("dataValue");

//   setTimeout(() => {
//     bar.style.setProperty("--progress", progressValue);
//   }, 250);
bar.style.setProperty("--progress", progressValue);
});