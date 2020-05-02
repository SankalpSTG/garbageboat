function readsafe(){
	var csvfile = document.getElementById("file-input-1");
	var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.txt)$/;
	if (regex.test(csvfile.value.toLowerCase())) {
		if (typeof (FileReader) != "undefined") {
			var reader = new FileReader();
			reader.onload = function (e) {
				var chain = e.target.result.split("\n");
				for (var i = 0; i < chain.length; i++) {
					var keys = chain[i].split(",");
					var keystring = keys[1];
					var foundat = keystring.search("oneofthecases");
					if(foundat >= 0){
						var elem = document.getElementById(keys[0]);
						if(elem){
							if(elem.type = "text"){
								elem.value = keys[2];
							}else{
								elem.selectedIndex = parseInt(keys[2]);
							}
						}else{
							var whatts = keys[1].split(".");
							var limit = 75;
							while(limit > 0){
								addmore(parseInt(whatts[2]));
								elem = document.getElementById(keys[0]);
								if(elem){
									if(elem.type = "text"){
										elem.value = keys[2];
									}else{
										elem.selectedIndex = parseInt(keys[2]);
									}
									break;
								}
								limit--;
							}
						}
					}else{
						var elem = document.getElementById(keys[0]);
						if(elem){
							if(elem.type = "text"){
								elem.value = keys[2];
							}else{
								elem.selectedIndex = parseInt(keys[2]);
							}
						}
					}
					
				}
			}
			reader.readAsText(csvfile.files[0]);
			alert("Successful");
		} else {
			alert("This browser does not support HTML5.");
		}
	} else {
		alert("Please upload a valid CSV file.");
	}
}
function readcsvfile() {
	var csvfile = document.getElementById("file-input-0");
	var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.txt)$/;
	if (regex.test(csvfile.value.toLowerCase())) {
		if (typeof (FileReader) != "undefined") {
			var reader = new FileReader();
			reader.onload = function (e) {
				var dispstr = "";
				var table = document.createElement("table");
				var rows = e.target.result.split("\n");
				for (var i = 0; i < rows.length; i++) {
					var row = table.insertRow(-1);
					var cells = rows[i].split(",");
					for (var j = 0; j < cells.length; j++) {
						var cell = row.insertCell(-1);
						cell.innerHTML = cells[j];
						dispstr += cells[j];
					}
				}
				//var dvCSV = document.getElementById("dvCSV");
				//dvCSV.innerHTML = "";
				//dvCSV.appendChild(table);
				alert(dispstr);
			}
			reader.readAsText(csvfile.files[0]);
		} else {
			alert("This browser does not support HTML5.");
		}
	} else {
		alert("Please upload a valid CSV file.");
	}
}