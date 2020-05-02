var glob_wind_ind = 0;
function showwindow(window_index){
	glob_wind_ind = window_index;
	var windowelements = document.getElementsByClassName("windows"); //divsToHide is an array
    for(var i = 0; i < windowelements.length; i++){
        windowelements[i].style.display = "none"; // depending on what you're doing
    }
	var tabelements = document.getElementsByClassName("class-tabs"); //divsToHide is an array
    for(var i = 0; i < tabelements.length; i++){
        tabelements[i].style.color = "#000"; // depending on what you're doing
        tabelements[i].style.fontWeight = "normal"; // depending on what you're doing
    }
	document.getElementById("window-" + window_index).style.display = "block";
	document.getElementById("tab-" + window_index).style.color = "#a00";
	document.getElementById("tab-" + window_index).style.fontWeight = "bold";
}
function init(){
	showwindow(1);
}
function addmore(what){
	var index = 0;
	switch(what){
		case 1:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("coredata");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("input");
			coreinput.id= "core-input-core-" + index;
			coreinput.classList.add("print3");//print3 of10 ofkey
			coreinput.classList.add("of10");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onkeyup", "maketable();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Core";
			coreinput.value = index + 1;
			coreinput.readOnly = true;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "core-input-width-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.classList.add("print3");//print3 of10 ofkey
			coreinput.classList.add("of11");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.setAttribute("onkeyup", "maketable();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Width";
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "core-input-stackwidth-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.classList.add("print3");//print3 of10 ofkey
			coreinput.classList.add("of12");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.setAttribute("onkeyup", "maketable();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Stack Width";
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "core-input-netstack-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.classList.add("print3");//print3 of10 ofkey
			coreinput.classList.add("of13");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.setAttribute("onfocus", "maketable();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Net Stack";
			coreinput.readOnly = true;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "core-input-area-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.classList.add("print3");//print3 of10 ofkey
			coreinput.classList.add("of14");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.setAttribute("onfocus", "maketable();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Area";
			coreinput.readOnly = true;
			cell.appendChild(coreinput);
			document.getElementById("core-input-width-" + index).focus();
		break;
		case 2:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("7thblockdata");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("input");
			coreinput.id= "form-input-hv-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onkeyup", "blocksinhv_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Form";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "to-input-hv-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onkeyup", "blocksinhv_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "To";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "thicknessperblock-input-hv-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onkeyup", "blocksinhv_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness per Block";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "thickness-input-hv-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onfocus", "blocksinhv_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			document.getElementById("form-input-hv-" + index).focus();
		break;
		case 3:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("8thblockdata");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("input");
			coreinput.id= "tapno-input-hv-" + index;
			coreinput.style.width = "40px"; 
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Tap No";
			coreinput.value = index + 1;
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "lvturns-input-hv-" + index;
			coreinput.style.width = "75px";
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "LV Turns";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "hvturns-input-hv-" + index;
			coreinput.style.width = "75px";
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "HV Turns";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "tapturns-input-hv-" + index;
			coreinput.style.width = "75px";
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Tap Turns";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "totalhvandtap-input-hv-" + index;
			coreinput.style.width = "80px";
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Total HV and Tap Turns";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "ratio-input-hv-" + index;
			coreinput.style.width = "60px";
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Ratio";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "voltage-input-hv-" + index;
			coreinput.style.width = "60px";
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Voltage";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "standardratio-input-hv-" + index;
			coreinput.style.width = "80px";
			coreinput.setAttribute("onfocus", "make_8thblockdata("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Standard Ratio";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
		break;
		case 4:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("11thblockdata");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("input");
			coreinput.id= "11-itw-dummytable-1-" + index;
			coreinput.style.width = "125px"; 
			coreinput.setAttribute("onkeyup", "make_dummy_table();");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of10");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "11-itw-dummytable-2-" + index;
			coreinput.style.width = "125px"; 
			coreinput.setAttribute("onkeyup", "make_dummy_table();");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of11");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "11-itw-dummytable-3-" + index;
			coreinput.style.width = "125px"; 
			coreinput.setAttribute("onkeyup", "make_dummy_table();");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of12");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "11-itw-dummytable-4-" + index;
			coreinput.style.width = "125px"; 
			coreinput.setAttribute("onkeyup", "make_dummy_table();");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of13");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
		break;
		case 5:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("4thblockdata1");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "4-bilv-label-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onchange", "");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of10");//print3 of10 ofkey
			coreinput.classList.add("ofkey");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "4-bilv-value-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onkeyup", "make_4_botins();");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of11");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("4-bilv-label-"+index).focus();
			break;
		case 6:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("4thblockdata2");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "4-tilv-label-" + index;
			coreinput.style.width = "200px";
			coreinput.setAttribute("onchange", "");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of10");//print3 of10 ofkey
			coreinput.classList.add("ofkey");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "4-tilv-value-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onkeyup", "make_4_topins();");
			coreinput.classList.add("print4");//print3 of10 ofkey
			coreinput.classList.add("of11");//print3 of10 ofkey
			coreinput.classList.add("ofvalue");//print3 of10 ofkey
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("4-tilv-label-" + index).focus();
			break;
		case 7:
			index = parseInt(document.getElementById("what-index-" + what).value);
			if(index < 4){
				document.getElementById("what-index-" + what).value = index + 1;
				var coredatatable = document.getElementById("4thblockdatacylinder");
				var row = coredatatable.insertRow();
				var cell = row.insertCell();
				var coreinput = document.createElement("input");
				coreinput.id= "4-cylinder-srno-" + index;
				coreinput.style.width = "80px"; 
				coreinput.setAttribute("onfocus", "make_4_cylinderod("+(index+1)+");");
				coreinput.name= "oneofthecases." + index + "." + what;
				coreinput.type= "text";
				coreinput.value = index + 1;
				coreinput.readOnly = true;
				cell.appendChild(coreinput);
				cell = row.insertCell();
				coreinput = document.createElement("input");
				coreinput.id= "4-cylinder-x-" + index;
				coreinput.style.width = "125px"; 
				coreinput.setAttribute("onfocus", "make_4_cylinderod("+(index+1)+");");
				coreinput.name= "oneofthecases." + index + "." + what;
				coreinput.type= "text";
				coreinput.placeholder = "Cylinder " + (parseInt(index) + 1);
				coreinput.readOnly = true;
				cell.appendChild(coreinput);
				cell = row.insertCell();
				coreinput = document.createElement("input");
				coreinput.id= "4-cylinder-duct-" + index;
				coreinput.style.width = "125px"; 
				coreinput.setAttribute("onkeyup", "make_4_cylinderod("+(index+1)+");");
				coreinput.setAttribute("onfocus", "make_4_cylinderod("+(index+1)+");");
				coreinput.name= "oneofthecases." + index + "." + what;
				coreinput.type= "text";
				coreinput.placeholder = "Duct " + (parseInt(index) + 1);
				coreinput.readOnly = false;
				cell.appendChild(coreinput);
				cell = row.insertCell();
				coreinput = document.createElement("input");
				coreinput.id= "4-cylinder-xid-" + index;
				coreinput.style.width = "125px"; 
				coreinput.setAttribute("onkeyup", "make_4_cylinderod("+(index+1)+");");
				coreinput.name= "oneofthecases." + index + "." + what;
				coreinput.type= "text";
				coreinput.placeholder = "Cylinder ID " + (parseInt(index) + 1);
				coreinput.readOnly = true;
				cell.appendChild(coreinput);
				document.getElementById("4-cylinder-duct-" + index).focus();
			}else{
				alert("Maximum Cylinder Index Reached!");
			}
			break;
		case 8:			
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("4thblockdata3");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("input");
			coreinput.id= "4-thkfrom-" + index;
			coreinput.style.width = "100px"; 
			coreinput.setAttribute("onkeyup", "blocksinlv_changed("+parseInt(index)+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "From " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "4-thkto-" + index;
			coreinput.style.width = "100px"; 
			coreinput.setAttribute("onkeyup", "blocksinlv_changed("+parseInt(index)+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "To " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "4-thkthicknessperblock-" + index;
			coreinput.style.width = "125px"; 
			coreinput.setAttribute("onkeyup", "blocksinlv_changed("+parseInt(index)+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness Per Block " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "4-thkthickness-" + index;
			coreinput.style.width = "125px"; 
			coreinput.setAttribute("onfocus", "blocksinlv_changed("+parseInt(index)+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness " + (parseInt(index) + 1);
			coreinput.readOnly = true;
			cell.appendChild(coreinput);
			document.getElementById("4-thkfrom-" + index).focus();
			break;
		case 9:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("5thblockdata1");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Plain Duct", "T Duct", "Cylinder"];
			coreinput.id= "5-iolv-label-" + index;
			coreinput.style.width = "100px"; 
			coreinput.setAttribute("onchange", "insulationmanager("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "5-iolv-radial-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Radial " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "5-iolv-height-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Height " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "5-iolv-length-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Length " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "5-iolv-Thickness-" + index;
			coreinput.style.width = "75px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "5-iolv-marsizein-" + index;
			coreinput.style.width = "80px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "MAR Size(in) " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "5-iolv-marsizeover-" + index;
			coreinput.style.width = "80px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "MAR Size(over) " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("5-iolv-label-" + index).focus();
			break;
		case 10:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("6thblockdata1");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "6-bilv-label-" + index;
			coreinput.style.width = "200px";
			coreinput.setAttribute("onchange", "make_7_botins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "6-bilv-value-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onkeyup", "make_7_botins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("6-bilv-label-"+index).focus();
			break;
		case 11:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("6thblockdata2");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "6-tilv-label-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onchange", "make_7_topins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "6-tilv-value-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onkeyup", "make_7_topins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("6-tilv-label-"+index).focus();
			break;
		case 12:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("9thblockdata1");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Plain Duct", "T Duct", "Cylinder"];
			coreinput.style.width = "100px"; 
			coreinput.id= "12-iohv-select-" + index;
			coreinput.setAttribute("onchange", "insulationmanager2("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "9-iohv-radial-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager2("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "9-iohv-height-" + index;
			coreinput.style.width = "60px"; 
			//coreinput.setAttribute("onkeyup", "make_dummy_table();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Height " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "9-iohv-length-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager2("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Length " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "9-iohv-Thickness-" + index;
			coreinput.style.width = "75px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager2("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "9-iohv-marsizein-" + index;
			coreinput.style.width = "80px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager2("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "MAR Size(in) " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "9-iohv-marsizeover-" + index;
			coreinput.style.width = "80px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager2("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "MAR Size(over) " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("12-iohv-select-" + index).focus();
			break;
		case 13:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("10thblockdata1");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "10-bilv-label-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onchange", "make_10_botins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "10-bilv-value-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onkeyup", "make_10_botins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("10-bilv-label-"+index).focus();
			break;
		case 14:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("10thblockdata2");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "10-tilv-label-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onchange", "make_10_topins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "10-tilv-value-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onkeyup", "make_10_topins();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("10-tilv-label-"+index).focus();
			break;
		case 15:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("12thblockdata1");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Plain Duct", "T Duct", "Cylinder"];
			coreinput.style.width = "100px"; 
			coreinput.id= "12-iot1-select-" + index;
			coreinput.setAttribute("onchange", "insulationmanager3("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "12-iot1-radial-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager3("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Radial " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "12-iot1-height-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager3("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Height " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "12-iot1-length-" + index;
			coreinput.style.width = "60px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager3("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Length " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "12-iot1-Thickness-" + index;
			coreinput.style.width = "75px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager3("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "12-iot1-marsizein-" + index;
			coreinput.style.width = "80px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager3("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "MAR Size(in) " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "12-iot1-marsizeover-" + index;
			coreinput.style.width = "80px"; 
			coreinput.setAttribute("onkeyup", "insulationmanager3("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "MAR Size(over) " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("12-iot1-select-" + index).focus();
			break;
		case 16:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("13thblockdata1");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "10-bilv-label-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onchange", "");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "10-bilv-value-" + index;
			coreinput.style.width = "200px"; 
			//coreinput.setAttribute("onkeyup", "make_dummy_table();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			document.getElementById("10-bilv-value-"+index).focus();
			break;
		case 17:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("13thblockdata2");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("select");
			var optarray = ["Permali Ring", "Common Ring", "Common Block", "LV Block", "LV SER", "LV Ring", "HV Block", "HV SER", "HV Ring", "HV + Tap Block", "HV + Tap Ring", "Tap Block", "Tap SER", "Tap Ring", "MAR", "Levelling Permali"];
			coreinput.id= "10-tilv-label-" + index;
			coreinput.style.width = "200px"; 
			coreinput.setAttribute("onchange", "");
			coreinput.name= "oneofthecases." + index + "." + what;
			for(i = 0; i < optarray.length; i++){
				var coreinputopt = document.createElement("option");
				coreinputopt.value = (i + 1);
				coreinputopt.text = optarray[i];
				coreinput.add(coreinputopt);
			}
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "10-tilv-value-" + index;
			coreinput.style.width = "200px"; 
			//coreinput.setAttribute("onkeyup", "make_dummy_table();");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Value " + (parseInt(index) + 1);
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			break;
		case 18:
			index = parseInt(document.getElementById("what-index-" + what).value);
			document.getElementById("what-index-" + what).value = index + 1;
			var coredatatable = document.getElementById("10thblockdata3");
			var row = coredatatable.insertRow();
			var cell = row.insertCell();
			var coreinput = document.createElement("input");
			coreinput.id= "form-input-tap-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onkeyup", "blocksintap_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Form";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "to-input-tap-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onkeyup", "blocksintap_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "To";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "thicknessperblock-input-tap-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onkeyup", "blocksintap_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness per Block";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			coreinput = document.createElement("input");
			coreinput.id= "thickness-input-tap-" + index;
			coreinput.className = coreinput.className + " input-core";
			coreinput.setAttribute("onfocus", "blocksintap_changed("+index+");");
			coreinput.name= "oneofthecases." + index + "." + what;
			coreinput.type= "text";
			coreinput.placeholder = "Thickness";
			coreinput.readOnly = false;
			cell.appendChild(coreinput);
			cell = row.insertCell();
			document.getElementById("form-input-tap-" + index).focus();
		break;
		
	}
}
window.onbeforeunload = function() {
	return "Are You Sure?"
}
