//Get XMLHTTP Object
function getXMLHTTPObject() {
	var xmlhttpObject = null;
	try {
		// For Old Microsoft Browsers
		xmlhttpObject = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
			// For Microsoft IE 6.0+
			xmlhttpObject = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (e1) {
			// No Browser accepts the XMLHTTP Object then false
			xmlhttpObject = false;
		}
	}
	if (!xmlhttpObject && typeof XMLHttpRequest != 'undefined') {
		// For Mozilla, Opera Browsers
		xmlhttpObject = new XMLHttpRequest();
	}
	// Mandatory Statement returning the ajax object created
	return xmlhttpObject;
}

// Change the value of the outputText field
function setAjaxOutput() {
	
	var stringla = xmlhttpObject.responseText.toString();
	if(stringla.indexOf("color") !=-1){
		document.getElementById('color').innerHTML = xmlhttpObject.responseText;
	}else{
		document.getElementById('talle').innerHTML = xmlhttpObject.responseText;
	}
	
}

function handleServerResponse() {
	if (xmlhttpObject.readyState == 4) {
		if (xmlhttpObject.status == 200) {
			setAjaxOutput();
		} else {
			alert("Error during AJAX call. Please try again");
		}
	}
}

// Implement business logic
function doAjaxCall() {
	xmlhttpObject = getXMLHTTPObject();
	if (xmlhttpObject != null) {
		var x = document.getElementById("prenda").selectedIndex;
		var y = document.getElementById("prenda").options;

		var x1 = document.getElementById("talle").selectedIndex;
		var y1 = document.getElementById("talle").options;
		if (x1 != null && y1 != null) {
			var URL = "AjaxAction?prenda=" + y[x].text + "&talle="
					+ y1[x1].text;
		} else {
			var URL = "AjaxAction?prenda=" + y[x].text;
		}

		xmlhttpObject.open("POST", URL, true);
		xmlhttpObject.send(null);
		xmlhttpObject.onreadystatechange = handleServerResponse;
	}

}
