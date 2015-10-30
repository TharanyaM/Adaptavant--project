var viewColor = null;
var colorPicker = null;
var tempColor = null;
(
	
	function() {
		viewColor = document.getElementById('viewColor');
		colorPicker = document.getElementById('colorPicker');
		viewColor.style.backgroundColor = "#FFFFFF";
		colorPicker.innerHTML = " \
			<div class='color-box' style='background-color:#F00' onClick='onColorBoxClick(this)'></div> \
			<div class='color-box' style='background-color:#0F0' onClick='onColorBoxClick(this)'></div><br> \
<div class='color-box' style='background-color:	#FFDEAD' onClick='onColorBoxClick(this)'></div> \
			<div class='color-box' style='background-color:#8A2BE2' onClick='onColorBoxClick(this)'></div><br> \
<div class='color-box' style='background-color:	#00CED1' onClick='onColorBoxClick(this)'></div> \
			<div class='color-box' style='background-color:#8B0000' onClick='onColorBoxClick(this)'></div><br> \
			<div class='color-box' style='background-color:#FF1493' onClick='onColorBoxClick(this)'></div> \
			<div class='color-box' style='background-color:#FF0' onClick='onColorBoxClick(this)'></div> \
		";
		viewColor.onclick = function() {
			viewColor.style.backgroundColor = tempColor;
		}
	}
)();
function onColorBoxClick(obj) {
	tempColor = obj.style.backgroundColor;
}