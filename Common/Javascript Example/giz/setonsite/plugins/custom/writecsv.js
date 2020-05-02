function makesafe(){	
	var fname = "IJGResults";
	var csvContent = "data:csv/csv;charset=utf-8,";
	var nameplatedetails_Array = document.querySelectorAll("input[type=text]");
	var csvContent_Array = [];
	for(i = 0; i < nameplatedetails_Array.length; i++){
		csvContent_Array.push([nameplatedetails_Array[i].id, nameplatedetails_Array[i].name, nameplatedetails_Array[i].value]);
	}
	nameplatedetails_Array = document.querySelectorAll("select");
	for(i = 0; i < nameplatedetails_Array.length; i++){
		csvContent_Array.push([nameplatedetails_Array[i].id, nameplatedetails_Array[i].name, (nameplatedetails_Array[i].selectedIndex + 1)]);
	}
	csvContent_Array.forEach(function(infoArray, index){
		dataString = infoArray.join(",");
		csvContent += dataString + "\n";
	});
	var datevar = new Date();
	var downloadablecontent = encodeURI(csvContent);
	var downloadable = document.createElement('a');
	downloadable.setAttribute("href", downloadablecontent);
	downloadable.setAttribute("download", "SOS_SAVE_" + (datevar.getMilliseconds() % 100000) + ".csv");
	downloadable.click();
}

function writecsv(){
	makesafe();
	var csvContent_Array = [];
	var csvContent = "data:csv/csv;charset=utf-8,";
	var thiselem = "";
	var keys = [];
	var values = [];
	var groupnames = ["NAMEPLATE DETAILS", "TRANSFORMER SPECIFICATIONS", "CORE DETAILS", "LV WINDINGS"];
	var classnames = [".print1", ".print2", ".print3", ".print4"];
	for(temp = 0; temp < classnames.length; temp++){
		csvContent += groupnames[temp] + "\n";
		var nameplatedetails_Array = document.querySelectorAll(classnames[temp]);
		for(i = 0; i < nameplatedetails_Array.length; i++){
			if(nameplatedetails_Array[i].classList.contains("of10")){
				if(values.length == 1){
					//alert("length is 1, printing " + keys[0] + "," + values[0]);
					csvContent += (keys[0] + "," + values[0] + "\n");
					keys = [];
					values = [];
				}else if(values.length > 1 && keys.length == 0){
					for(j = 0; j < values.length; j++){
						csvContent += (values[j] + ",");
					}
					csvContent += "\n";
					//alert("length is unknown");
					keys = [];
					values = [];
				}else if(values.length == 0 && keys.length > 1){
					for(j = 0; j < keys.length; j++){
						csvContent += (keys[j] + ",");
					}
					csvContent += "\n";
					keys = [];
					values = [];
				}else if(values.length > 1){
					for(j = 0; j < keys.length; j++){
						csvContent += (keys[j] + ",");
					}
					csvContent += "\n";
					for(j = 0; j < values.length; j++){
						csvContent += (values[j] + ",");
					}
					csvContent += "\n";
					
					keys = [];
					values = [];
				}
			}
			if(nameplatedetails_Array[i].classList.contains("ofkey")){
				if(nameplatedetails_Array[i].tagName == "LABEL"){
					keys.push(nameplatedetails_Array[i].innerHTML);
				}else if(nameplatedetails_Array[i].tagName == "TD"){
					keys.push(nameplatedetails_Array[i].innerHTML);
				}else if(nameplatedetails_Array[i].tagName == "TH"){
					keys.push(nameplatedetails_Array[i].innerHTML);
				}
			}else if(nameplatedetails_Array[i].classList.contains("ofvalue")){
				if(nameplatedetails_Array[i].tagName == "INPUT"){
					values.push(nameplatedetails_Array[i].value);
				}else if(nameplatedetails_Array[i].tagName == "SELECT"){
					values.push(nameplatedetails_Array[i].options[nameplatedetails_Array[i].selectedIndex].text);
				}
			}
		}
		if(keys.length != 0){
			if(values.length == 1){
				csvContent += (keys[0] + "," + values[0] + "\n");
			}else if(values.length > 1){
				for(j = 0; j < keys.length; j++){
					csvContent += (keys[j] + ",");
				}
				csvContent += "\n";
				for(j = 0; j < values.length; j++){
					csvContent += (values[j] + ",");
				}
				csvContent += "\n";
			}
			keys = [];
			values = [];
		}
		csvContent += "\n\n\n\n\n";
	}
	//alert("Reporting from outside");
	var datevar = new Date();
	var downloadablecontent = encodeURI(csvContent);
	var downloadable = document.createElement('a');
	downloadable.setAttribute("href", downloadablecontent);
	downloadable.setAttribute("download", "SOS_EXPORT_" + (datevar.getMilliseconds() % 100000) + ".csv");
	downloadable.click();/*
	nameplatedetails_Array.forEach(function(infoArray, index){
		dataString = infoArray.join(",");
		csvContent += dataString + "\n";
	});*/
	//var fname = "IJGResults";
	//var csvContent = "data:text/csv;charset=utf-8,";
	//nameplatedetails_Array.forEach(function(infoArray, index){
		//dataString = infoArray.join(",");
		//csvContent += dataString + "\n";
	//});
	//var test_array = [["name1", 2, 3], ["name2", 4, 5, 1, 2, 3], ["name3", 6, 7], ["name4", 8, 9], ["name5", 10, 11]];	
	//var test_array2 = [[1, 2, "heyy"], ["whats", 44, 67.1234, 2, 3, 5, , , 9]];
	/*test_array.forEach(function(infoArray, index){
		dataString = infoArray.join(",");
		csvContent += dataString + "\n";
	});
	test_array2.forEach(function(infoArray, index){
		dataString = infoArray.join(",");
		csvContent += dataString + "\n";
	});*/
	//var encodedUri = encodeURI(csvContent);
	//window.open(encodedUri);
}
function getnameplatedetails(){
	var nameplatedetails_Array = [];
	nameplatedetails_Array.push(["NAME PLATE DETAILS"]);
	nameplatedetails_Array.push(["Capacity(KVA)", document.getElementById("1-capacity").value]);
	nameplatedetails_Array.push(["Make", document.getElementById("1-make").value]);
	nameplatedetails_Array.push(["Serial Number", document.getElementById("1-serialnumber").value]);
	nameplatedetails_Array.push(["Manufacture Year", document.getElementById("1-manufactureyear").value]);
	nameplatedetails_Array.push(["HV Voltage(KV)", document.getElementById("1-hvvoltage").value]);
	nameplatedetails_Array.push(["LV Voltage(KV)", document.getElementById("1-lvvoltage").value]);
	nameplatedetails_Array.push(["HV Current(A)", document.getElementById("1-hvcurrent").value]);
	nameplatedetails_Array.push(["LV Current(A)", document.getElementById("1-lvcurrent").value]);
	nameplatedetails_Array.push(["Impedance Percent - Name Plate", document.getElementById("1-impedance").value]);
	nameplatedetails_Array.push(["Vector Group", document.getElementById("1-vectorgroup").value]);
	nameplatedetails_Array.push(["Core And Winding Mass(Kgs)", document.getElementById("1-coreandwindingmass").value]);
	var tptype = parseInt(document.getElementById("1-transport-type-select").options[document.getElementById("1-transport-type-select").selectedIndex].value);
	if(tptype == 1){
		tptype = "With Oil";
	}else{
		tptype = "With Gas / Without Oil";
	}
	nameplatedetails_Array.push(["Transportation Type", tptype]);
	nameplatedetails_Array.push(["Transportation Mass(Kgs)", document.getElementById("1-transportationmass").value]);
	nameplatedetails_Array.push(["Mass Of Oil(Kgs)", document.getElementById("1-massofoil").value]);
	nameplatedetails_Array.push(["Volume Of Oil(Ltr's)", document.getElementById("1-volumeofoil").value]);
	nameplatedetails_Array.push(["Total Weight(Kgs)", document.getElementById("1-totalweight").value]);
	nameplatedetails_Array.push(["Tapping Range", document.getElementById("1-tappingrange").value]);
	nameplatedetails_Array.push(["Cover Mounting / Plain", document.getElementById("1-covermountingplain").value]);
	return nameplatedetails_Array;
}