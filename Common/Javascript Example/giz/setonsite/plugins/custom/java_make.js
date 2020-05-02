function tap2checkboxchanged(){
	if(!(document.getElementById("tap2checkbox").checked)){
		var inp1 = document.getElementById("tab-12");
		inp1.style.borderColor = "#000";
		inp1.style.backgroundColor = "#aaa";
		inp1.style.color = "#fff";
		inp1.removeAttribute("onclick");
		inp1.style.cursor = "default";
		inp1 = document.getElementById("tab-13");
		inp1.style.borderColor = "#000";
		inp1.style.backgroundColor = "#aaa";
		inp1.style.color = "#fff";
		inp1.removeAttribute("onclick");
		inp1.style.cursor = "default";
		showwindow(1);
	}else{
		var inp1 = document.getElementById("tab-12");
		inp1.style.borderColor = "#00a";
		inp1.style.backgroundColor = "#fff";
		inp1.style.color = "#000";
		inp1.setAttribute("onclick", "showwindow(12);");
		inp1.style.cursor = "pointer";
		inp1 = document.getElementById("tab-13");
		inp1.style.borderColor = "#00a";
		inp1.style.backgroundColor = "#fff";
		inp1.style.color = "#000";
		inp1.setAttribute("onclick", "showwindow(13);");
		inp1.style.cursor = "pointer";
	}
}
function get_1_current(){
	var inp1 = parseFloat(document.getElementById("1-capacity").value);
	var inp2 = parseFloat(document.getElementById("1-hvvoltage").value);
	var inp3 = document.getElementById("1-con-type-select1").options[document.getElementById("1-con-type-select1").selectedIndex].value;
	if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
		if(inp3 == 1 || inp3 == 4){
			multiplier = 1;
		}else if(inp3 == 2){
			multiplier = Math.sqrt(3);
		}else if(inp3 == 3){
			multiplier = 1 / Math.sqrt(3);
		}
		document.getElementById("1-hvcurrent").value = ((inp1 / inp2) / multiplier).toFixed(3);
	}
	inp2 = parseFloat(document.getElementById("1-lvvoltage").value);
	var multiplier = 1;
	if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
		if(inp3 == 1 || inp3 == 4){
			multiplier = 1;
		}else if(inp3 == 2){
			multiplier = Math.sqrt(3);
		}else if(inp3 == 3){
			multiplier = 1 / Math.sqrt(3);
		}
		document.getElementById("1-lvcurrent").value = ((inp1 / inp2) / multiplier).toFixed(3);
	}
}
function put_1_names(){
	if(document.getElementById("1-make").value){
		document.getElementById("2-make").value = document.getElementById("1-make").value;
	}
	if(document.getElementById("1-serialnumber").value){
		document.getElementById("2-serialno").value = document.getElementById("1-serialnumber").value;
	}
	if(document.getElementById("1-hvvoltage").value){
		document.getElementById("2-hvvoltageoriginal").value = document.getElementById("1-hvvoltage").value;
	}
	if(document.getElementById("1-lvvoltage").value){
		document.getElementById("2-lvvoltageoriginal").value = document.getElementById("1-lvvoltage").value;
	}
	if(document.getElementById("1-capacity").value){
		document.getElementById("2-capacity").value = document.getElementById("1-capacity").value;
	}
	if(document.getElementById("1-tappingrange1").value){
		document.getElementById("2-tappingrange1").value = document.getElementById("1-tappingrange1").value;
	}
	if(document.getElementById("1-tappingrange2").value){
		document.getElementById("2-tappingrange2").value = document.getElementById("1-tappingrange2").value;
	}
}
function getphasevoltage(){
	var inp2 = parseFloat(document.getElementById("1-lvvoltage").value);
	var inp3 = document.getElementById("1-con-type-select1").options[document.getElementById("1-con-type-select1").selectedIndex].value;
	if(!isNaN(inp2) && !isNaN(inp3)){
		if(inp3 == 1 || inp3 == 4){
			multiplier = 1;
		}else if(inp3 == 2){
			multiplier = Math.sqrt(3);
		}else if(inp3 == 3){
			multiplier = 1 / Math.sqrt(3);
		}
		document.getElementById("3-phasevoltage").value = (inp2 * 1000 * multiplier).toFixed(3);
	}
}

function corediaovercorecylinder_existing_2_changed(){
	if(!isNaN(parseFloat(document.getElementById("2-corediaovercorecylinder-existing").value))){
		document.getElementById("4-coremaxdia").value = parseFloat(document.getElementById("2-corediaovercorecylinder-existing").value);
		lvwindingspt1mgr();
	}
}
function maketable(){
	var no_of_rows = document.getElementById("what-index-1").value;
	var totalArea = 0;
	for(i = 0; i < no_of_rows; i++){
		var core_width = parseFloat(document.getElementById("core-input-width-"+i).value);
		var stackwidth_i = parseFloat(document.getElementById("core-input-stackwidth-"+i).value);
		var stackwidth_i2 = 0;
		if(i+1 == no_of_rows || isNaN(parseFloat(document.getElementById("core-input-stackwidth-"+(i+1)).value))){
			stackwidth_i2 = 0;
		}else{
			stackwidth_i2 = parseFloat(document.getElementById("core-input-stackwidth-"+(i+1)).value);
		}
		if(!isNaN(stackwidth_i) && !isNaN(stackwidth_i2) && !isNaN(core_width)){
			document.getElementById("core-input-netstack-"+i).value = stackwidth_i - stackwidth_i2;
			document.getElementById("core-input-area-"+i).value = (stackwidth_i - stackwidth_i2)*core_width;
			totalArea += parseFloat(document.getElementById("core-input-area-"+i).value);
		}
	}
	var woodenstrip = parseFloat(document.getElementById("3-core-input-woodenstrip").value);
	if(!isNaN(woodenstrip)){
		totalArea += woodenstrip;
	}
	if(!isNaN(totalArea)){
		document.getElementById("3-core-input-total-area").value = totalArea;
		compactingfactor_changed_3();
	}
}
function compactingfactor_changed_3(){
	var totalArea = parseFloat(document.getElementById("3-core-input-total-area").value);
	var compactingFactor = parseFloat(document.getElementById("3-compactingfactor").value);
	if(!isNaN(totalArea) && !isNaN(compactingFactor)){
		document.getElementById("3-netcoreareammsq").value = Math.round(totalArea * compactingFactor);
		//document.getElementById("3-netcoreareacmsq").value = (totalArea * compactingFactor) / 100;
		getphasevoltage();
	}
}

function getlvturns(){
	var inp1 = parseFloat(document.getElementById("3-phasevoltage").value);
	var inp2 = parseFloat(document.getElementById("3-netcoreareammsq").value) / 100;
	var inp6 = parseFloat(document.getElementById("3-fluxdensity").value);
	var inp4 = parseFloat(document.getElementById("2-frequency").value);
	var inp7 = 0;
	if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp6) && !isNaN(inp4)){
		document.getElementById("3-lvturns").value = (((inp1) / (4.44 * inp2 * inp6 * inp4)) * 10000).toFixed(3);
	}
	inp7 = parseFloat(document.getElementById("3-lvturnstaken").value);
	if(!isNaN(inp1) && !isNaN(inp7) && !isNaN(inp2) && !isNaN(inp6) && !isNaN(inp4)){
		document.getElementById("3-sofluxdensity").value = (((inp1) / (4.44 * inp2 * inp7 * inp4)) * 10000).toFixed(2);
	}
	//getfluxdensity();
}
function getfluxdensity(){
	var inp1 = parseFloat(document.getElementById("3-lvturnstaken").value);
	var inp2 = parseFloat(document.getElementById("3-netcoreareammsq").value) / 100;
	inp1 = (2.22 * inp1 * inp2)/1000;
	inp2 = parseFloat(document.getElementById("3-phasevoltage").value);
	document.getElementById("3-sofluxdensity").value = (inp2 / inp1).toFixed(3);
	lvwindingspt1mgr();
}

function lvwindingspt1mgr(){
	var inp1 = parseFloat(document.getElementById("4-coremaxdia").value);
	var inp2 = parseFloat(document.getElementById("4-coremaxdiatolerance").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("4-cylinderid").value = inp1 + inp2;
	}
}
function make_4_cylinderod(cylinder_4_index){
	var inp1 = parseFloat(document.getElementById("4-cylinderid").value);
	var inp2 = parseFloat(document.getElementById("4-fordia").value);
	var inp5 = parseFloat(document.getElementById("what-index-7").value);
	cylinder_4_index = parseInt(cylinder_4_index);
	if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp5)){
		if(cylinder_4_index == 1){
			document.getElementById("4-cylinder-x-" + (cylinder_4_index - 1)).value = inp1;
		}else if(cylinder_4_index > 1){
			inp1 = parseFloat(document.getElementById("4-cylinder-xid-" + (cylinder_4_index - 2)).value);
			document.getElementById("4-cylinder-x-" + (cylinder_4_index - 1)).value = inp1;
		}
		var inp6 = 0, inp7 = 0;
		if(cylinder_4_index >= 1){
			var inp3 = parseFloat(document.getElementById("4-cylinder-duct-" + (cylinder_4_index - 1)).value);
			inp1 = parseFloat(document.getElementById("4-cylinder-x-" + (cylinder_4_index - 1)).value);
			var inp4 = (inp3 * inp2) + inp1;
			document.getElementById("4-cylinder-xid-" + (cylinder_4_index - 1)).value = inp4;
			inp6 = parseInt(document.getElementById("4-cylinder-xid-" + (inp5 - 1)).value);
			if(!isNaN(inp6)){
				document.getElementById("4-mstotal").value = inp6;
			}
		}else{
			inp6 = parseInt(document.getElementById("4-cylinder-xid-" + (inp5 - 1)).value);
			if(!isNaN(inp6)){
				document.getElementById("4-mstotal").value = inp6;				
				inp7 = parseFloat(document.getElementById("4-lvidtolerance").value);
				if(!isNaN(inp7)){
					document.getElementById("4-lvid").value = inp6 + inp7;
				}
			}
		}
	}
}
function condsizebare4_1(){
	var inp1 = parseFloat(document.getElementById("4-2p2klesscs").value);
	var inp2 = parseFloat(document.getElementById("4-2p2k").value);
	var paper_covering = parseFloat(document.getElementById("4-papercovering").value);
	document.getElementById("4-condsizebare").value = (inp1 * inp2).toFixed(3);
	document.getElementById("4-2p2klessccs").value = (inp1 + paper_covering).toFixed(3);
	document.getElementById("4-2p2kppc").value = (inp2 + paper_covering).toFixed(3);
	document.getElementById("4-covcondsize").value = ((inp1 + paper_covering) * (inp2 + paper_covering)).toFixed(3);
}
function get_4_totalareaofconductors(){
	var inp1 = parseFloat(document.getElementById("4-condsizebare").value);
	var inp2 = parseFloat(document.getElementById("4-reductionareaduetoedge").value);
	var inp3 = parseFloat(document.getElementById("4-noofcond").value);
	var actual_area = inp1 - inp2;
	var total_area = actual_area * inp3;
	document.getElementById("4-actualarea").value = actual_area;
	document.getElementById("4-totalareaofconductors").value = total_area;
}
function noofcond_4_changed(){
	var inp1 = parseInt(document.getElementById("4-noofcondradial").value);
	var inp2 = parseInt(document.getElementById("4-noofcondaxial").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("4-noofcond").value = inp1 * inp2;
		document.getElementById("4-crosssectionareabare").value = inp1 * inp2 * parseFloat(document.getElementById("4-condsizebare").value);
	}
}
function get_4_crosssectionareabare(){
	var condsizebare = parseFloat(document.getElementById("4-condsizebare").value);
	var noofconds = parseFloat(document.getElementById("4-noofcond").value);
	document.getElementById("4-crosssectionareabare").value = (condsizebare * noofconds).toFixed(3);
}
function get_4_fullloadcurrentlv(){
	var d4 = parseFloat(document.getElementById("1-capacity").value);
	var d8 = parseFloat(document.getElementById("2-lvvoltageconverted").value);
	document.getElementById("4-fullloadcurrentlv").value = (d4 / (Math.sqrt(3)*d8)).toFixed(3);
}
function get_4_currentdensity(){
	var inp1 = parseFloat(document.getElementById("4-crosssectionareabare").value);
	var inp2 = parseFloat(document.getElementById("4-fullloadcurrentlv").value);
	document.getElementById("4-currentdensity").value = (inp2 / inp1).toFixed(3);
}
function managewindingtype(index){
	var inp1 = parseInt(document.getElementById(index + "-wdg-type-select1").options[document.getElementById(index + "-wdg-type-select1").selectedIndex].value);
	if(inp1 == 1){
		document.getElementById(index + "-wdg-type-discdiv").style.display = "none";
		document.getElementById(index + "-wdg-type-layerdiv").style.display = "block";
	}else if(inp1 == 2){
		document.getElementById(index + "-wdg-type-discdiv").style.display = "block";
		document.getElementById(index + "-wdg-type-layerdiv").style.display = "none";
	}
}
function get_4_turns_in_actual_winding(index){
	var inpx = parseInt(document.getElementById(index + "-wdg-type-select1").options[document.getElementById(index + "-wdg-type-select1").selectedIndex].value);
	if(inpx == 2){
		var inp1 = parseFloat(document.getElementById(index + "-totalnoofdiscs").value);
		var inp2 = parseFloat(document.getElementById(index + "-turnsperdisc").value);
		var inp3 = parseFloat(document.getElementById(index + "-lessdrop").value);
		if(!isNaN(inp1) && !isNaN(inp2)){
			document.getElementById(index + "-totalturnsalldiscs").value = inp1 * inp2;
			if(!isNaN(inp3)){
				document.getElementById(index + "-turnsinactualwinding").value = (inp1 * inp2) - inp3;
			}
		}
	}else if(inpx == 1){
		var inp1 = parseFloat(document.getElementById(index + "-layernooflayers").value);
		var inp2 = parseFloat(document.getElementById(index + "-layerturnsperlayer").value);
		var inp3 = parseFloat(document.getElementById(index + "-layerlessdrop").value);
		if(!isNaN(inp1) && !isNaN(inp2)){
			document.getElementById(index + "-layertotalturns").value = inp1 * inp2;
			if(!isNaN(inp3)){
				document.getElementById(index + "-layeractualturns").value = (inp1 * inp2) - inp3;
			}
		}
		var inp1 = parseFloat(document.getElementById(index + "-layeredgestrip").value);
		var inp4 = parseFloat(document.getElementById(index + "-layeredgestriptol").value);
		var inp2 = parseFloat(document.getElementById(index + "-2p2klessccs").value);
		var inp3 = parseFloat(document.getElementById(index + "-noofcondaxial").value);
		if(!isNaN(inp3) && !isNaN(inp2)){
			if(!isNaN(inp1) && !isNaN(inp4)){
				document.getElementById("4-layeredgestripmax").value = inp3 * inp2 + inp1 + inp4;
			}else{
				document.getElementById("4-layeredgestripmax").value = inp3 * inp2;
			}
		}
	}
}
function get_4_windingodradial(){
	var inp1 = parseInt(document.getElementById("4-wdg-type-select1").options[document.getElementById("4-wdg-type-select1").selectedIndex].value);
	if(inp1 == 2){
		var inp1 = parseFloat(document.getElementById("4-2p2kppc").value);
		var inp2 = parseFloat(document.getElementById("4-turnsperdisc").value);
		var inp3 = parseFloat(document.getElementById("4-noofcondradial").value);
		var inp5 = parseFloat(document.getElementById("4-lvid").value);
		var inp4 = parseFloat(document.getElementById("4-toleranceforcrossoverwinding").value);
		if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
			document.getElementById("4-windingodradial").value = Math.round(inp1 * inp2 * inp3);
			document.getElementById("4-totalwindingod").value = Math.round(inp1 * inp2 * inp3) * 2;
			if(!isNaN(inp5)){
				document.getElementById("4-lvwindingod").value = (Math.round(inp1 * inp2 * inp3) * 2) + inp5;
				if(!isNaN(inp4)){
					document.getElementById("4-totallvwindingod").value = Math.round((Math.round(inp1 * inp2 * inp3) * 2) + inp5 + inp4);
				}
			}
		}
	}else if(inp1 == 1){
		var inp1 = parseFloat(document.getElementById("4-layernooflayers").value);
		var inp2 = parseFloat(document.getElementById("4-noofcondradial").value);
		var inp3 = parseFloat(document.getElementById("4-2p2kppc").value);
		var inp4 = parseFloat(document.getElementById("4-layerinsulationbetweenlayers").value);
		var inp5 = parseFloat(document.getElementById("4-lvid").value);
		var inp6 = parseFloat(document.getElementById("4-toleranceforcrossoverwinding").value);
		if(!isNaN(inp1) && !isNaN(inp2)){
			document.getElementById("4-windingodradial").value = Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2));
			document.getElementById("4-totalwindingod").value = Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2;
			if(!isNaN(inp3)){
				document.getElementById("4-lvwindingod").value = ( Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2) + inp5;
				if(!isNaN(inp4)){
					document.getElementById("4-totallvwindingod").value = ( Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2) + inp5 + inp6;
				}
			}
		}
	}
}
function make_4_botins(){
	var index = parseInt(document.getElementById("what-index-5").value);
	var total_botins = 0;
	for(i = 0; i < index; i++){
		var bilvval = parseFloat(document.getElementById("4-bilv-value-" + i).value);
		if(!isNaN(bilvval)){
			total_botins += bilvval;
		}
	}
	document.getElementById("4-totalbotins").value = total_botins;
}
function make_4_topins(){
	var index = parseInt(document.getElementById("what-index-6").value);
	var total_topins = 0;
	for(i = 0; i < index; i++){
		var tilvval = parseFloat(document.getElementById("4-tilv-value-" + i).value);
		if(!isNaN(tilvval)){
			total_topins += tilvval;
		}
	}
	document.getElementById("4-totaltopins").value = total_topins;
}
function blocksinlv_changed(index){
	var inp1 = parseFloat(document.getElementById("4-thkfrom-" + index).value);
	var inp2 = parseFloat(document.getElementById("4-thkto-" + index).value);
	var inp3 = parseFloat(document.getElementById("4-thkthicknessperblock-" + index).value);
	if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
		document.getElementById("4-thkthickness-" + index).value = ((inp2 - inp1) * inp3).toFixed(0);
	}
	var t_index = parseInt(document.getElementById("what-index-8").value);
	var total_thickness = 0;
	for(i = 0; i < t_index; i++){
		inp1 = parseFloat(document.getElementById("4-thkthickness-" + i).value);
		if(!isNaN(inp1)){
			total_thickness += inp1;
		}
	}
	document.getElementById("4-totalthickness").value = total_thickness;
}
function getwindingheight(){
	var inp1 = parseInt(document.getElementById("4-wdg-type-select1").options[document.getElementById("4-wdg-type-select1").selectedIndex].value);
	if(inp1 == 2){
		var inp2 = parseFloat(document.getElementById("4-totalnoofdiscs").value);
		var inp3 = parseFloat(document.getElementById("4-2p2klessccs").value);
		var inp4 = parseFloat(document.getElementById("4-totalthickness").value);
		if(!isNaN(inp2) && !isNaN(inp3) && !isNaN(inp4)){
			document.getElementById("4-windingheight").value = inp2 * inp3 + inp4;
			document.getElementById("4-windingheighttolerance").value = inp4 * 0.03;
			document.getElementById("4-totalwindingheight").value = (inp2 * inp3 + inp4 - (inp4 * 0.03)).toFixed(3);
		}
		var inp2 = (inp2 * inp3 + inp4 - (inp4 * 0.03));
		var inp5 = parseFloat(document.getElementById("4-totaltopins").value);
		var inp6 = parseFloat(document.getElementById("4-totalbotins").value);
		if(!isNaN(inp2) && !isNaN(inp5) && !isNaN(inp6)){
			document.getElementById("4-whptipbi").value = (inp2 + inp5 + inp6).toFixed(3);
		}
	}else if(inp1 == 1){
		var inp2 = parseFloat(document.getElementById("4-layerturnsperlayer").value);
		var inp3 = parseFloat(document.getElementById("4-2p2klessccs").value);
		var inp4 = parseFloat(document.getElementById("4-noofcondaxial").value);
		var inp5 = parseFloat(document.getElementById("4-layercenterstrip").value);
		var inp6 = parseFloat(document.getElementById("4-layeredgestripmax").value);
		var inp7 = parseFloat(document.getElementById("4-layertranspositiontobedone").value);
		document.getElementById("4-windingheight").value = (inp2 * inp3 * inp4) + inp5 + inp6 + inp7;		
		inp1 = parseFloat(document.getElementById("4-windingheight").value);
		var inp2 = 0.03 * parseFloat(document.getElementById("4-noofcondaxial").value);
		if(!isNaN(inp1) && !isNaN(inp2)){
			document.getElementById("4-windingheighttolerance").value = inp2;
			document.getElementById("4-totalwindingheight").value = inp1 + inp2;
		}
		var inp3 = parseFloat(document.getElementById("4-totaltopins").value);
		var inp4 = parseFloat(document.getElementById("4-totalbotins").value);
		if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3) && !isNaN(inp4)){
			document.getElementById("4-whptipbi").value = inp1 + inp2 + inp3 + inp4;
		}
	}
}
function insulationmanager(index){
	var inp1 = parseInt(document.getElementById("5-iolv-label-" + index).options[document.getElementById("5-iolv-label-" + index).selectedIndex].value);
	if(inp1 == 3){
		var inp5 = parseFloat(document.getElementById("5-iolv-radial-" + index).value);
		if((isNaN(inp5) || (inp5 == 0))){
			document.getElementById("5-iolv-length-" + index).value = 0;
		}else{
			var totalradial = 0;
			for(i = 0; i <= index; i++){
				var inp3 = parseInt(document.getElementById("5-iolv-label-" + i).options[document.getElementById("5-iolv-label-" + i).selectedIndex].value);
				var inp4 = parseFloat(document.getElementById("5-iolv-radial-" + i).value);
				if(i == index){
					totalradial += (inp4);
				}else{
					totalradial += (2 * inp4);
				}
			}
			var inp6 = parseFloat(document.getElementById("4-totallvwindingod").value);
			var length = Math.round(Math.PI * (inp6 + totalradial) + 80);
			if(!isNaN(inp6)){
				document.getElementById("5-iolv-length-" + index).value = length;
			}
		}
	}
	var maxindex = parseInt(document.getElementById("what-index-9").value);
	var totalthickness = 0;
	for(i = 0; i < maxindex; i++){
		var inp4 = parseFloat(document.getElementById("5-iolv-radial-" + i).value);
		if(!isNaN(inp4)){
			totalthickness += inp4;
		}
	}
	var inp6 = parseFloat(document.getElementById("4-totallvwindingod").value);
	document.getElementById("5-totalthickness").value = totalthickness * 2;
	document.getElementById("5-thktolerance").value = Math.round((totalthickness * 2) * 0.14);
	document.getElementById("5-lvodhvid").value = (totalthickness * 2) + Math.round((totalthickness * 2) * 0.14) + inp6;
}
function manage_6_hvcondsize(){
	var inp1 = parseFloat(document.getElementById("6-condsizebare1").value);
	var inp2 = parseFloat(document.getElementById("6-condsizebare2").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-condsizebare3").value = (inp1 * inp2).toFixed(3);		
		var inp3 = parseFloat(document.getElementById("6-papercovering").value);
		if(!isNaN(inp3)){
			document.getElementById("6-covcondsize1").value = (inp1 + inp3).toFixed(3);
			document.getElementById("6-covcondsize2").value = (inp2 + inp3).toFixed(3);
			document.getElementById("6-covcondsize3").value = ((inp1 + inp3) * (inp2 + inp3)).toFixed(3);
		}	
	}
}
function manage_6_hvextracondsize(){
	var inp1 = parseFloat(document.getElementById("6-condsizebare1fl4").value);
	var inp2 = parseFloat(document.getElementById("6-condsizebare2fl4").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-condsizebare3fl4").value = (inp1 * inp2).toFixed(3);		
		var inp3 = parseFloat(document.getElementById("6-papercoveringfl4").value);
		if(!isNaN(inp3)){
			document.getElementById("6-covcondsize1fl4").value = (inp1 + inp3).toFixed(3);
			document.getElementById("6-covcondsize2fl4").value = (inp2 + inp3).toFixed(3);
			document.getElementById("6-covcondsize3fl4").value = ((inp1 + inp3) * (inp2 + inp3)).toFixed(3);
		}
	}
}
function make_6_tapturns(){
	var inp1 = parseFloat(document.getElementById("3-lvturnstaken").value);
	if(!isNaN(inp1)){
		document.getElementById("6-hvturns").value = inp1;
		var inp2 = parseFloat(document.getElementById("2-hvvoltageconverted").value);
		var inp3 = parseFloat(document.getElementById("2-lvvoltageconverted").value);
		if(!isNaN(inp2) && !isNaN(inp2)){
			document.getElementById("6-ratiotsf").value = ((inp2 / inp3)).toFixed(3);
			document.getElementById("6-hvintoratio").value = (((inp2 / inp3)) * inp1).toFixed(3);
			var inp6 = (((inp2 / inp3)) * inp1).toFixed(3);
			var inp4 = parseFloat(document.getElementById("1-tappingrange1").value);
			var inp5 = parseFloat(document.getElementById("1-tappingrange2").value);
			var inp8 = Math.abs(inp4) + Math.abs(inp5);
			document.getElementById("6-taprangepercent").value = inp8;
			var inp7 = 0;
			if(inp4 > 0){
				inp7 = inp4;
			}else{
				inp7 = inp5;
			}
			document.getElementById("6-tapturns").value = Math.round(inp6 * (inp7 / 100));
			document.getElementById("6-tapturnstotal").value = Math.round(inp6 * (inp8 / 100));
			document.getElementById("6-normalhvturns").value = Math.round(inp6 - (inp6 * (inp7 / 100)));
		}
	}
	var inp4 = document.getElementById("");
	var inp1 = parseFloat(document.getElementById("6-hvturns").value);
	var inp3 = parseFloat(document.getElementById("6-taprangepercent").value);
	var inp4 = parseFloat(document.getElementById("6-taprangemultiplier").value);
	if(!isNaN(inp1) && !isNaN(inp4)){
		document.getElementById("6-taprangetotal").value = inp4 * inp1;
		document.getElementById("6-sostaprangetotal").value = inp4 * inp2;
		document.getElementById("6-totalhvturns").value = (inp4 * inp2) + inp1;
		if(!isNaN(inp3)){
			document.getElementById("6-taprangemultiplier2").value = inp3 / 100;
			document.getElementById("6-taprangetotal2").value = (inp3 / 100) * inp1;
			document.getElementById("6-sostaprangetotal2").value = (inp3 / 100) * inp2;
			document.getElementById("6-normalhvturns").value = ((inp4 * inp2) + inp1) - ((inp3 / 100) * inp1);
		}
	}
}
function get_6_turnsinxdiscs(){
	var inp1 = parseFloat(document.getElementById("6-noofplaindiscs").value);
	var inp2 = parseFloat(document.getElementById("6-turnsdivdiscs").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-turnsinxdiscs").value = inp1 * inp2;
		var inp3 = parseFloat(document.getElementById("6-lessdrop").value);
		if(!isNaN(inp3)){
			document.getElementById("6-actualturnsinxdiscs").value = inp1 * inp2 - inp3;
		}
	}
	var inp1 = parseFloat(document.getElementById("6-turnsinxdiscs").value);
	var inp2 = parseFloat(document.getElementById("6-lessdrop").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-actualturnsinxdiscs").value = inp1 - inp2;
	}
}
function get_6_turnsinterleaved(){
	var inp1 = parseFloat(document.getElementById("6-noofinterleaveddiscs1").value);
	var inp2 = parseFloat(document.getElementById("6-noofinterleaveddiscs2").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-noofinterleaveddiscs3").value = inp1 + inp2;
	}
	var inp3 = parseFloat(document.getElementById("6-turnsdivdiscs2").value);
	var inp4 = parseFloat(document.getElementById("6-turnsdivdiscs3").value);
	if(!isNaN(inp1) && !isNaN(inp3) && !isNaN(inp2) && !isNaN(inp4)){
		document.getElementById("6-noofinterleaveddiscs4").value = ((inp1 * inp3) + (inp2 * inp4));
	}
	var inp1 = parseFloat(document.getElementById("6-noofinterleaveddiscs4").value);
	var inp2 = parseFloat(document.getElementById("6-lessdrops").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-actualturnsininterleavedwdg").value = (inp1 - inp2);
	}
	var inp1 = parseFloat(document.getElementById("6-actualturnsinxdiscs").value);
	var inp2 = parseFloat(document.getElementById("6-actualturnsininterleavedwdg").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-turnsinactualwinding").value = (inp1 + inp2);
	}
	var inp1 = parseFloat(document.getElementById("6-condsizebare3").value);
	var inp2 = parseFloat(document.getElementById("6-noofcondperturn").value);
	var inp3 = parseFloat(document.getElementById("2-capacity").value);
	var inp4 = parseFloat(document.getElementById("2-hvvoltageconverted").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("6-crosssectionareabare").value = (inp1 * inp2);
		if(!isNaN(inp3) && !isNaN(inp4)){
			document.getElementById("6-fullloadcurrenthv").value = inp3 / (inp4 * Math.sqrt(3));
			document.getElementById("6-currentdensity").value = (inp3 / (inp4 * Math.sqrt(3))) / (inp1 * inp2);
		}
	}
}
function get_7_totalwindingod(){
	var inp1 = parseFloat(document.getElementById("6-turnsdivdiscs").value);
	var inp2 = parseFloat(document.getElementById("6-covcondsize2").value);
	if(!isNaN(inp1)){
		document.getElementById("7-totalnoofturnsperdisc").value = inp1;
	}
	if(!isNaN(inp2)){
		document.getElementById("7-thicknessofcondwithcovering").value = inp2;
		document.getElementById("7-toleranceforcrossoverwinding").value = inp2;
	}
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("7-windingodradial").value = Math.round(inp1 * inp2);
		document.getElementById("7-totalwindingod").value = (Math.round(inp1 * inp2)) * 2;
	}
	var inp3 = parseFloat(document.getElementById("5-lvodhvid").value);
	var inp4 = parseFloat(document.getElementById("6-covcondsize3").value);
	if(!isNaN(inp3) && !isNaN(inp4)){
		document.getElementById("7-hvwindingod").value = (Math.round(inp1 * inp2)) * 2 + inp3;
	}
	if(!isNaN(inp3)){
		document.getElementById("7-totalhvwindingod").value = (Math.round(inp1 * inp2)) * 2 + inp3 + inp2;
	}
}
function make_7_botins(){
	var index = parseInt(document.getElementById("what-index-10").value);
	var total_botins = 0;
	for(i = 0; i < index; i++){
		var bilvval = parseFloat(document.getElementById("6-bilv-value-" + i).value);
		if(!isNaN(bilvval)){
			total_botins += bilvval;
		}
	}
	document.getElementById("7-bitotal").value = total_botins;
}
function make_7_topins(){
	var index = parseInt(document.getElementById("what-index-11").value);
	var total_topins = 0;
	for(i = 0; i < index; i++){
		var tilvval = parseFloat(document.getElementById("6-tilv-value-" + i).value);
		if(!isNaN(tilvval)){
			total_topins += tilvval;
		}
	}
	document.getElementById("7-titotal").value = total_topins;
}
function blocksinhv_changed(index){
	var inp1 = parseFloat(document.getElementById("form-input-hv-" + index).value);
	var inp2 = parseFloat(document.getElementById("to-input-hv-" + index).value);
	var inp3 = parseFloat(document.getElementById("thicknessperblock-input-hv-" + index).value);
	if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
		document.getElementById("thickness-input-hv-" + index).value = ((inp2 - inp1) * inp3).toFixed(0);
	}
	var t_index = parseInt(document.getElementById("what-index-2").value);
	var total_thickness = 0;
	for(i = 0; i < t_index; i++){
		inp1 = parseFloat(document.getElementById("thickness-input-hv-" + i).value);
		if(!isNaN(inp1)){
			total_thickness += inp1;
		}
	}
	document.getElementById("7-thicknesstotal").value = total_thickness;
}
function hvsummarized(){
	document.getElementById("8-ohvid").value = parseFloat(document.getElementById("5-lvodhvid").value);
	document.getElementById("8-ohvod").value = parseFloat(document.getElementById("7-totalhvwindingod").value);
	document.getElementById("8-ohvradial").value = parseFloat(document.getElementById("7-totalhvwindingod").value) / 2;
	document.getElementById("8-ohvwindingheight").value = parseFloat(document.getElementById("7-tttotalwindingheight").value);
	document.getElementById("8-ohvturns").value = parseFloat(document.getElementById("6-turnsinactualwinding").value);
	document.getElementById("8-ototalwindingheight").value = parseFloat(document.getElementById("7-tttotalwindingheight").value);
}
function getwindingheighthv(){
	var inp2 = parseFloat(document.getElementById("4-totalnoofdiscs").value);
	var inp3 = parseFloat(document.getElementById("6-covcondsize1fl4").value);
	var inp4 = parseFloat(document.getElementById("7-thicknesstotal").value);
	if(!isNaN(inp2) && !isNaN(inp3) && !isNaN(inp4)){
		document.getElementById("7-ttwindingheight").value = inp2 * inp3 + inp4;
		document.getElementById("7-tttolerance").value = inp4 * 0.03;
		document.getElementById("7-tttotalwindingheight").value = (inp2 * inp3 + inp4 - (inp4 * 0.03)).toFixed(3);
	}/*
	var inp2 = (inp2 * inp3 + inp4 - (inp4 * 0.03));
	var inp5 = parseFloat(document.getElementById("4-totaltopins").value);
	var inp6 = parseFloat(document.getElementById("4-totalbotins").value);
	if(!isNaN(inp2) && !isNaN(inp5) && !isNaN(inp6)){
		document.getElementById("4-whptipbi").value = (inp2 + inp5 + inp6).toFixed(3);
	}*/
}
function insulationmanager2(index){
	var inp1 = parseInt(document.getElementById("12-iohv-select-" + index).options[document.getElementById("12-iohv-select-" + index).selectedIndex].value);
	if(inp1 == 3){
		var inp5 = parseFloat(document.getElementById("9-iohv-radial-" + index).value);
		if((isNaN(inp5) || (inp5 == 0))){
			document.getElementById("9-iohv-length-" + index).value = 0;
		}else{
			var totalradial = 0;
			for(i = 0; i <= index; i++){
				var inp3 = parseInt(document.getElementById("12-iohv-select-" + i).options[document.getElementById("12-iohv-select-" + i).selectedIndex].value);
				var inp4 = parseFloat(document.getElementById("9-iohv-radial-" + i).value);
				if(i == index){
					totalradial += (inp4);
				}else{
					totalradial += (2 * inp4);
				}
			}
			var inp6 = parseFloat(document.getElementById("7-totalhvwindingod").value);
			var length = Math.round(Math.PI * (inp6 + totalradial) + 80);
			if(!isNaN(inp6)){
				document.getElementById("9-iohv-length-" + index).value = length;
			}
		}
	}
	var maxindex = parseInt(document.getElementById("what-index-12").value);
	var totalthickness = 0;
	for(i = 0; i < maxindex; i++){
		var inp4 = parseFloat(document.getElementById("9-iohv-radial-" + i).value);
		if(!isNaN(inp4)){
			totalthickness += inp4;
		}
	}
	var inp6 = parseFloat(document.getElementById("7-totalhvwindingod").value);
	document.getElementById("9-totalthickness").value = totalthickness * 2;
	document.getElementById("9-thktolerance").value = Math.round((totalthickness * 2) * 0.14);
	document.getElementById("9-hvodt1id").value = (totalthickness * 2) + Math.round((totalthickness * 2) * 0.14) + inp6;
}
function manage_10_tapcondsizes(){
	var inp1 = parseFloat(document.getElementById("10-itwcondsizebareinput1").value);
	var inp2 = parseFloat(document.getElementById("10-itwcondsizebareinput2").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("10-itwcondsizebareoutput1").value = (inp1 * inp2).toFixed(3);		
		var inp3 = parseFloat(document.getElementById("10-itwpapercoovering").value);
		if(!isNaN(inp3)){
			document.getElementById("10-itwcovcondsizeinput1").value = (inp1 + inp3).toFixed(3);
			document.getElementById("10-itwcovcondsizeinput2").value = (inp2 + inp3).toFixed(3);
			document.getElementById("10-itwcovcondsizeoutput1").value = ((inp1 + inp3) * (inp2 + inp3)).toFixed(3);
		}	
	}
}
function make_9_part_1(){
	var inpx = parseInt(document.getElementById("10-wdg-type-select1").options[document.getElementById("10-wdg-type-select1").selectedIndex].value);
	if(inpx == 2){
		var inp1 = parseFloat(document.getElementById("10-nooflayers").value);
		var inp2 = parseFloat(document.getElementById("10-turnsperlayer").value);
		var inp3 = parseFloat(document.getElementById("10-lessdrop").value);
		var inp4 = parseFloat(document.getElementById("10-lessdrop").value);
		var inp5 = parseFloat(document.getElementById("10-actualtotalturns").value);
		var inp6 = parseFloat(document.getElementById("10-insulationbetweenlayers").value);
		if(!isNaN(inp1) && !isNaN(inp2)){
			document.getElementById("10-totalturns").value = inp1 * inp2;
			if(!isNaN(inp4)){
				document.getElementById("10-actualtotalturns").value = (inp1 * inp2) + inp4;
			}
		}
		document.getElementById("10-windingodradial").value = Math.round(inp3 * inp1);
		document.getElementById("10-tapwindingod").value = (Math.round(inp3 * inp1) * 2) + inp4;
		document.getElementById("10-innertapwindingod").value = ((Math.round(inp3 * inp1) * 2) + inp4) + inp5;
		document.getElementById("10-legcentre").value = inp6;
		document.getElementById("10-gap").value = inp6 - (((Math.round(inp3 * inp1) * 2) + inp4) + inp5);
	}else if(inpx == 1){
		
	}
}
function get_10_windingodradial(){	
	var inp3 = parseFloat(document.getElementById("10-noofconds1").value);
	var inp2 = parseFloat(document.getElementById("10-noofconds2").value);
	if(!isNaN(inp3) && !isNaN(inp2)){
		document.getElementById("10-noofconds").value = inp3 * inp2;
	}
	var inp1 = parseInt(document.getElementById("4-wdg-type-select1").options[document.getElementById("4-wdg-type-select1").selectedIndex].value);
	if(inp1 == 2){
		var inp1 = parseFloat(document.getElementById("10-itwcovcondsizeinput2").value);
		var inp2 = parseFloat(document.getElementById("10-noofconds").value);
		var inp3 = parseFloat(document.getElementById("10-turnsperdisc").value);
		var inp5 = parseFloat(document.getElementById("9-hvodt1id").value);
		if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
			document.getElementById("10-windingodradial").value = Math.round(inp1 * inp2 * inp3) * 2;
			if(!isNaN(inp5)){
				document.getElementById("10-tapwindingod").value = ((Math.round(inp1 * inp2 * inp3) * 2) + inp5);
				document.getElementById("10-toleranceforcrossoverwinding").value = inp1;
				document.getElementById("10-innertapwindingod").value = Math.round((Math.round(inp1 * inp2 * inp3) * 2) + inp5 + inp1);
			}
		}
	}else if(inp1 == 1){
		var inp1 = parseFloat(document.getElementById("10-layernooflayers").value);
		var inp2 = parseFloat(document.getElementById("10-noofconds1").value);
		var inp3 = parseFloat(document.getElementById("10-itwcovcondsizeinput2").value);
		var inp4 = parseFloat(document.getElementById("10-layerinsulationbetweenlayers").value);
		var inp5 = parseFloat(document.getElementById("9-hvodt1id").value);
		document.getElementById("10-toleranceforcrossoverwinding").value = inp3;
		if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
			document.getElementById("10-windingodradial").value = Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2;
			if(!isNaN(inp4)){
				document.getElementById("10-tapwindingod").value = ( Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2) + inp5;
				if(!isNaN(inp5)){
					document.getElementById("10-innertapwindingod").value = ( Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2) + inp5 + inp3;
				}
			}
		}
	}
	var inp1 = parseFloat(document.getElementById("10-innertapwindingod").value);
	var inp2 = parseFloat(document.getElementById("2-legcentre-existing").value);
	document.getElementById("10-gap").value = inp2 - inp1;
	document.getElementById("10-legcentre").value = inp1;
}

function make_10_botins(){
	var index = parseInt(document.getElementById("what-index-13").value);
	var total_botins = 0;
	for(i = 0; i < index; i++){
		var bilvval = parseFloat(document.getElementById("10-bilv-value-" + i).value);
		if(!isNaN(bilvval)){
			total_botins += bilvval;
		}
	}
	document.getElementById("10-bittotal").value = total_botins;
}
function make_10_topins(){
	var index = parseInt(document.getElementById("what-index-14").value);
	var total_topins = 0;
	for(i = 0; i < index; i++){
		var tilvval = parseFloat(document.getElementById("10-tilv-value-" + i).value);
		if(!isNaN(tilvval)){
			total_topins += tilvval;
		}
	}
	document.getElementById("10-tittotal").value = total_topins;
}
function blocksintap_changed(index){
	var inp1 = parseFloat(document.getElementById("form-input-tap-" + index).value);
	var inp2 = parseFloat(document.getElementById("to-input-tap-" + index).value);
	var inp3 = parseFloat(document.getElementById("thicknessperblock-input-tap-" + index).value);
	if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
		document.getElementById("thickness-input-tap-" + index).value = ((inp2 - inp1) * inp3).toFixed(0);
	}
	var t_index = parseInt(document.getElementById("what-index-18").value);
	var total_thickness = 0;
	for(i = 0; i < t_index; i++){
		inp1 = parseFloat(document.getElementById("thickness-input-tap-" + i).value);
		if(!isNaN(inp1)){
			total_thickness += inp1;
		}
	}
	document.getElementById("10-thicknesstotal").value = total_thickness;
	var inp1 = parseInt(document.getElementById("10-wdg-type-select1").options[document.getElementById("10-wdg-type-select1").selectedIndex].value);
	if(inp1 == 2){
		var inp2 = parseFloat(document.getElementById("10-itwcovcondsizeinput1").value);
		var inp3 = parseFloat(document.getElementById("10-noofconds2").value);
		var inp4 = parseFloat(document.getElementById("10-totalnoofdiscs").value);
		var inp5 = parseFloat(document.getElementById("10-thicknesstotal").value);
		document.getElementById("10-ttwindingheight").value = inp2 * inp3 * inp4 + inp5;
		document.getElementById("10-tttolerance").value = inp2;
		document.getElementById("10-tttotalwindingheight").value = inp2 * inp3 * inp4 + inp5 - inp2;
	}else if(inp == 1){
		var inp2 = parseFloat(document.getElementById("10-itwcovcondsizeinput1").value);
		var inp3 = parseFloat(document.getElementById("10-noofconds2").value);
		var inp4 = parseFloat(document.getElementById("10-layerturnsperlayer").value);
		var inp5 = parseFloat(document.getElementById("10-thicknesstotal").value);
		document.getElementById("10-ttwindingheight").value = inp2 * inp3 * inp4 + inp5;
		document.getElementById("10-tttolerance").value = inp2;
		document.getElementById("10-tttotalwindingheight").value = inp2 * inp3 * inp4 + inp5 - inp2;
	}
}
function insulationmanager3(index){
	var inp1 = parseInt(document.getElementById("12-iot1-select-" + index).options[document.getElementById("12-iot1-select-" + index).selectedIndex].value);
	if(inp1 == 3){
		var inp5 = parseFloat(document.getElementById("12-iot1-radial-" + index).value);
		if((isNaN(inp5) || (inp5 == 0))){
			document.getElementById("12-iot1-length-" + index).value = 0;
		}else{
			var totalradial = 0;
			for(i = 0; i <= index; i++){
				var inp3 = parseInt(document.getElementById("12-iot1-select-" + i).options[document.getElementById("12-iot1-select-" + i).selectedIndex].value);
				var inp4 = parseFloat(document.getElementById("12-iot1-radial-" + i).value);
				if(i == index){
					totalradial += (inp4);
				}else{
					totalradial += (2 * inp4);
				}
			}
			var inp6 = parseFloat(document.getElementById("10-innertapwindingod").value);
			var length = Math.round(Math.PI * (inp6 + totalradial) + 80);
			if(!isNaN(inp6)){
				document.getElementById("12-iot1-length-" + index).value = length;
			}
		}
	}
	var maxindex = parseInt(document.getElementById("what-index-15").value);
	var totalthickness = 0;
	for(i = 0; i < maxindex; i++){
		var inp4 = parseFloat(document.getElementById("12-iot1-radial-" + i).value);
		if(!isNaN(inp4)){
			totalthickness += inp4;
		}
	}
	var inp6 = parseFloat(document.getElementById("10-innertapwindingod").value);
	document.getElementById("12-totalthickness").value = totalthickness * 2;
	document.getElementById("12-thktolerance").value = Math.round((totalthickness * 2) * 0.14);
	document.getElementById("12-t1odt2id").value = (totalthickness * 2) + Math.round((totalthickness * 2) * 0.14) + inp6;
}
function manage_10_tapcondsizes2(){
	var inp1 = parseFloat(document.getElementById("13-itwcondsizebareinput1").value);
	var inp2 = parseFloat(document.getElementById("13-itwcondsizebareinput2").value);
	if(!isNaN(inp1) && !isNaN(inp2)){
		document.getElementById("13-itwcondsizebareoutput1").value = (inp1 * inp2).toFixed(3);		
		var inp3 = parseFloat(document.getElementById("13-itwpapercoovering").value);
		if(!isNaN(inp3)){
			document.getElementById("13-itwcovcondsizeinput1").value = (inp1 + inp3).toFixed(3);
			document.getElementById("13-itwcovcondsizeinput2").value = (inp2 + inp3).toFixed(3);
			document.getElementById("13-itwcovcondsizeoutput1").value = ((inp1 + inp3) * (inp2 + inp3)).toFixed(3);
		}	
	}
}

function get_10_windingodradial(){	
	var inp3 = parseFloat(document.getElementById("13-noofconds1").value);
	var inp2 = parseFloat(document.getElementById("13-noofconds2").value);
	if(!isNaN(inp3) && !isNaN(inp2)){
		document.getElementById("13-noofconds").value = inp3 * inp2;
	}
	var inp1 = parseInt(document.getElementById("13-wdg-type-select1").options[document.getElementById("13-wdg-type-select1").selectedIndex].value);
	if(inp1 == 2){
		var inp1 = parseFloat(document.getElementById("13-itwcovcondsizeinput2").value);
		var inp2 = parseFloat(document.getElementById("13-noofconds").value);
		var inp3 = parseFloat(document.getElementById("13-turnsperdisc").value);
		var inp5 = parseFloat(document.getElementById("12-t1odt2id").value);
		if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
			document.getElementById("13-windingodradial").value = Math.round(inp1 * inp2 * inp3) * 2;
			if(!isNaN(inp5)){
				document.getElementById("13-tapwindingod").value = ((Math.round(inp1 * inp2 * inp3) * 2) + inp5);
				document.getElementById("13-toleranceforcrossoverwinding").value = inp1;
				document.getElementById("13-innertapwindingod").value = Math.round((Math.round(inp1 * inp2 * inp3) * 2) + inp5 + inp1);
			}
		}
	}else if(inp1 == 1){
		var inp1 = parseFloat(document.getElementById("13-layernooflayers").value);
		var inp2 = parseFloat(document.getElementById("13-noofconds1").value);
		var inp3 = parseFloat(document.getElementById("13-itwcovcondsizeinput2").value);
		var inp4 = parseFloat(document.getElementById("13-layerinsulationbetweenlayers").value);
		var inp5 = parseFloat(document.getElementById("12-t1odt2id").value);
		document.getElementById("13-toleranceforcrossoverwinding").value = inp3;
		if(!isNaN(inp1) && !isNaN(inp2) && !isNaN(inp3)){
			document.getElementById("13-windingodradial").value = Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2;
			if(!isNaN(inp4)){
				document.getElementById("13-tapwindingod").value = ( Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2) + inp5;
				if(!isNaN(inp5)){
					document.getElementById("13-innertapwindingod").value = ( Math.round((inp1 * inp2 * inp3) + inp4 + (0.05 * inp3 * inp1 * inp2)) * 2) + inp5 + inp3;
				}
			}
		}
	}
	var inp1 = parseFloat(document.getElementById("13-innertapwindingod").value);
	var inp2 = parseFloat(document.getElementById("2-legcentre-existing").value);
	document.getElementById("13-gap").value = inp2 - inp1;
	document.getElementById("13-legcentre").value = inp1;
}

/*
Selected Value :
	var element = document.getElementById("ddlViewBy");
	var strUser = element.options[element.selectedIndex].value;

*/