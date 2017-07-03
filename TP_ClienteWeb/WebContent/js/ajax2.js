
function setAjaxOutputColor() {
	document.getElementById('color').innerHTML = xmlhttpObject.responseText;
}


function handleServerResponseColor() {
	if (xmlhttpObject.readyState == 4) {
		if (xmlhttpObject.status == 200) {
			setAjaxOutputColor();
		} else {
			alert("Error during AJAX call. Please try again");
		}
	}
}


function doAjaxCallTalleaColor() {
	xmlhttpObject = getXMLHTTPObject();
	if (xmlhttpObject != null) {
		var x = document.getElementById("prenda").selectedIndex;
	    var y = document.getElementById("prenda").options;
	    
		var x1 = document.getElementById("talle").selectedIndex;
	    var y1 = document.getElementById("talle").options;
		
//	    var params = "prenda="+y[x].text+"&talle="+y1[x1].text;
	    
		var URL = "AjaxAction?talle="y1[x1].text;
		xmlhttpObject.open("POST", URL, true);
		xmlhttpObject.onreadystatechange = handleServerResponseColor;
	}	
}


