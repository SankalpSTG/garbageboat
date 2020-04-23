function afterload(){
	
}
function trucksizechanged(){
	let distance = parseInt(document.getElementById("distapprox").value);
	let truckcost = parseInt(document.getElementById("trucksize").value);
	if(!isNaN(distance) && !isNaN(truckcost)){
		let fuelCostPerKm = truckcost / 100;
		let totalCost = distance * fuelCostPerKm + truckcost;
		document.getElementById("estimatedcost").value = totalCost;
	}
}
function truckchanged(sel){
	let selector = document.getElementById("trucksize");
	document.getElementById("trucksizelit").value = selector.options[selector.selectedIndex].text;
}