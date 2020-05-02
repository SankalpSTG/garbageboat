<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
	<head>
		<link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
		<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
		<link rel="stylesheet" href="plugins/w3/w3.css">
		<link rel="stylesheet" href="plugins/custom/custom_style.css">
		<link rel="stylesheet" href="plugins/custom/custom_kits.css">
		<script src="plugins/custom/custom_javascript.js"></script>
		<link rel="shortcut icon" href="resources/images/icon/favicon4.ico" />
		<title>SET ON SITE: Calculator</title>
	</head>
	<body onload="init();">
		<header class="row">
			<div class="company-header row">
				<div class="company-logo">
					<img src="resources/images/setonsitelogo.webp">	
				</div>
				<div class="company-name">
					SET<br>ON SITE<br>ELECTRICALS
				</div>
			</div>
			<div class="section-container row">
				<a href="#"><div class="section-body">
					Calculator
				</div></a>
				<a href="#"><div class="section-body">
					Defaults
				</div></a>
				<a href="#"><div class="section-body">
					Instructions
				</div></a>
				<a href="#"><div class="section-body">
					About
				</div></a>
			</div>
		</header>
		<div class="c-container">
			<div class="calc-container row">
				<div class="tab-out">
					<div class="tab-container">
						<div class="tab-groups">
							<div class="tab-group-header">
								Name Plate Details
							</div>
							<div class="tab-list">
								<div id="tab-1" class="class-tabs" onclick="showwindow(1);">
									Name Plate
								</div>
								<div id="tab-2" class="class-tabs" onclick="showwindow(2);">
									Specifications
								</div>
							</div>
						</div>
						<div class="tab-groups">
							<div class="tab-group-header">
								Internal Details
							</div>
							<div class="tab-list">
								<div id="tab-3" class="class-tabs" onclick="showwindow(3);">
									Core Details
								</div>
								<div id="tab-4" class="class-tabs" onclick="showwindow(4);">
									LV Windings
								</div>
								<div id="tab-5" class="class-tabs" onclick="showwindow(5);">
									Insulation Over LV
								</div>
								<div id="tab-6" class="class-tabs" onclick="showwindow(6);">
									HV Windings 1
								</div>
								<div id="tab-7" class="class-tabs" onclick="showwindow(7);">
									HV Windings 2
								</div>
								<div id="tab-8" class="class-tabs" onclick="showwindow(8);">
									HV Windings 3
								</div>
								<div id="tab-9" class="class-tabs" onclick="showwindow(9);">
									Insulation Over HV
								</div>
								<div id="tab-10" class="class-tabs" onclick="showwindow(10);">
									Inner Tap Winding 1
								</div>
								<div id="tab-11" class="class-tabs" onclick="showwindow(11);">
									Inner Tap Winding 2
								</div>
								<div id="tab-12" class="class-tabs" onclick="showwindow(12);">
									Insulation Over In Tap
								</div>
								<div id="tab-13" class="class-tabs" onclick="showwindow(13);">
									Outer Tap Winding
								</div>
								<div id="tab-14" class="class-tabs" onclick="showwindow(14);">
									Calculate Impedance
								</div>
								<div id="tab-15" class="class-tabs" onclick="showwindow(15);">
									Cov. Cu. Wt. Calc.
								</div>
								<div id="tab-16" class="class-tabs" onclick="showwindow(16);">
									Calculate Weight
								</div>
							</div>
						</div>
						<div class="tab-groups">
							<div class="tab-group-header">
								External Details
							</div>
							<div class="tab-list">								
								<div id="tab-17" class="class-tabs" onclick="showwindow(17);">
									OLTC Details
								</div>
								<div id="tab-18" class="class-tabs" onclick="showwindow(18);">
									Accessories
								</div>
								<div id="tab-19" class="class-tabs" onclick="showwindow(19);">
									Impedance Calculated
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="window-out">
					<div class="window-container">
						<div id="window-1" class="windows">
							<div id="window-header-1" class="window-headers">
								Name Plate Details
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="1-capacity">Capacity(MVA)</label></td>
										<td><input id="1-capacity" name="name" type="text" placeholder="Capacity(MVA)"></td>
									</tr>
									<tr>
										<td><label for="1-make">Make</label></td>
										<td><input id="1-make" name="name" type="text" placeholder="Make"></td>
									</tr>
									<tr>
										<td><label for="1-serialnumber">Serial Number</label></td>
										<td><input id="1-serialnumber" name="name" type="text" placeholder="Serial Number"></td>
									</tr>
									<tr>
										<td><label for="1-manufactureyear">Manufacture Year</label></td>
										<td><input id="1-manufactureyear" name="name" type="text" placeholder="Manufacture Year"></td>
									</tr>
									<tr>
										<td><label for="1-hvvoltage">HV Voltage(KV)</label></td>
										<td><input id="1-hvvoltage" name="name" type="text" placeholder="HV Voltage(KV)"></td>
									</tr>
									<tr>
										<td><label for="1-lvvoltage">LV Voltage(KV)</label></td>
										<td><input id="1-lvvoltage" name="name" type="text" placeholder="LV Voltage(KV)"></td>
									</tr>
									<tr>
										<td><label for="1-hvcurrent">HV Current(A)</label></td>
										<td><input id="1-hvcurrent" name="name" type="text" placeholder="HV Current(A)"></td>
									</tr>
									<tr>
										<td><label for="1-lvcurrent">LV Current(A)</label></td>
										<td><input id="1-lvcurrent" name="name" type="text" placeholder="LV Current(A)"></td>
									</tr>
									<tr>
										<td><label for="1-impedance">% Impedance - Name Plate</label></td>
										<td><input id="1-impedance" name="name" type="text" placeholder="% Impedance - Name Plate"></td>
									</tr>
									<tr>
										<td><label for="1-vectorgroup">Vector Group</label></td>
										<td><input id="1-vectorgroup" name="name" type="text" placeholder="Vector Group"></td>
									</tr>
									<tr>
										<td><label for="1-coreandwindingmass">Core & Winding Mass(Kgs)</label></td>
										<td><input id="1-coreandwindingmass" name="name" type="text" placeholder="Core & Winding Mass(Kgs)"></td>
									</tr>
									<tr>
										<td><label for="1-transportationmass">Transportation Mass(Kgs)</label></td>
										<td><input id="1-transportationmass" name="name" type="text" placeholder="Transportation Mass(Kgs)"></td>
									</tr>
									<tr>
										<td><label for="1-massofoil">Mass Of Oil(Ltr's)</label></td>
										<td><input id="1-massofoil" name="name" type="text" placeholder="Mass Of Oil(Ltr's)"></td>
									</tr>
									<tr>
										<td><label for="1-volumeofoil">Volume Of Oil(Ltr's)</label></td>
										<td><input id="1-volumeofoil" name="name" type="text" placeholder="Volume Of Oil(Ltr's)"></td>
									</tr>
									<tr>
										<td><label for="1-totalweight">Total Weight(Kgs)</label></td>
										<td><input id="1-totalweight" name="name" type="text" placeholder="Total Weight(Kgs)"></td>
									</tr>
									<tr>
										<td><label for="1-tappingrange">Tapping Range</label></td>
										<td><input id="1-tappingrange" name="name" type="text" placeholder="Tapping Range"></td>
									</tr>
									<tr>
										<td><label for="1-covermountingplain">Cover Mounting / Plain</label></td>
										<td><input id="1-covermountingplain" name="name" type="text" placeholder="Cover Mounting / Plain"></td>	
									</tr>
								</table>
							</div>
						</div>
						<div id="window-2" class="windows">
							<div id="window-header-1" class="window-headers">
								Transformer Specifications
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-Make">Make</label></td>
										<td><input id="2-Make" name="name" type="text" placeholder="Make"></td>
									</tr>
									<tr>
										<td><label for="2-capacity">Capacity(KVA)</label></td>
										<td><input id="2-capacity" name="name" type="text" placeholder="Capacity(KVA)"></td>
									</tr>
									<tr>
										<td><label for="2-hvvoltageoriginal">HV Voltage(Original)(KVA)</label></td>
										<td><input id="2-hvvoltageoriginal" name="name" type="text" placeholder="HV Voltage(Original)(KVA)"></td>
									</tr>
									<tr>
										<td><label for="2-lvvoltageoriginal">LV Voltage(Original)(KVA)</label></td>
										<td><input id="2-lvvoltageoriginal" name="name" type="text" placeholder="LV Voltage(Original)(KVA)"></td>
									</tr>
									<tr>
										<td><label for="2-hvvoltageconverted">HV Voltage(Converted)(KVA)</label></td>
										<td><input id="2-hvvoltageconverted" name="name" type="text" placeholder="HV Voltage(Converted)(KVA)"></td>
									</tr>
									<tr>
										<td><label for="2-lvvoltageconverted">LV Voltage(Converted)(KVA)</label></td>
										<td><input id="2-lvvoltageconverted" name="name" type="text" placeholder="LV Voltage(Converted)(KVA)"></td>
									</tr>
									<tr>
										<td><label for="2-serialno">Serial No</label></td>
										<td><input id="2-serialno" name="name" type="text" placeholder="Serial No"></td>
									</tr>
									<tr>
										<td><label for="2-place">Place</label></td>
										<td><input id="2-place" name="name" type="text" placeholder="Place"></td>
									</tr>
									<tr>
										<td><label for="2-tappings">Tappings</label></td>
										<td><input id="2-tappings" name="name" type="text" placeholder="Tappings"></td>
									</tr>
								</table>
								<table>
									<tr>
										<th></th>
										<th>Existing</th>
										<th>As Per SOS</th>
									</tr>
									<tr>
										<td><label for="2-windowheight">Window Height</label></td>
										<td><input id="2-windowheight-existing" name="name" type="text" placeholder="Window Height (Existing)"></td>
										<td><input id="2-windowheight-sos" name="name" type="text" placeholder="Window Height (As Per SOS)"></td>
									</tr>
									<tr>
										<td><label for="2-legcentre">Leg Centre</label></td>
										<td><input id="2-legcentre-existing" name="name" type="text" placeholder="Leg Centre (Existing)"></td>
										<td><input id="2-legcentre-sos" name="name" type="text" placeholder="Leg Centre (As Per SOS)"></td>
									</tr>
									<tr>
										<td><label for="2-cylinderheight">Cylinder Height</label></td>
										<td><input id="2-cylinderheight-existing" name="name" type="text" placeholder="Cylinder Height (Existing)"></td>
										<td><input id="2-cylinderheight-sos" name="name" type="text" placeholder="Cylinder Height (As Per SOS)"></td>
									</tr>
									<tr>
										<td><label for="2-coredia">Core Dia</label></td>
										<td><input id="2-coredia-existing" name="name" type="text" placeholder="Core Dia (Existing)"></td>
										<td><input id="2-coredia-sos" name="name" type="text" placeholder="Core Dia (As Per SOS)"></td>
									</tr>
									<tr>
										<td><label for="2-corediawithcorebelts">Core Dia With Core Belts</label></td>
										<td><input id="2-corediawithcorebelts-existing" name="name" type="text" placeholder="Core Dia With Core Belts (Existing)"></td>
										<td><input id="2-corediawithcorebelts-sos" name="name" type="text" placeholder="Core Dia With Core Belts (As Per SOS)"></td>
									</tr>
									<tr>
										<td><label for="2-corediaovercorecylinder">Core Dia Over Core Cylinder</label></td>
										<td><input id="2-corediaovercorecylinder-existing" name="name" type="text" placeholder="Core Dia Over Core Cylinder (Existing)"></td>
										<td><input id="2-corediaovercorecylinder-sos" name="name" type="text" placeholder="Core Dia Over Core Cylinder (As Per SOS)"></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-3" class="windows">
							<div id="window-header-3" class="window-headers">
								Core Details
							</div>
							<div id="window-body" class="class-window-body">
								<table id="coredata">
									<tr>
										<th>Core</th>
										<th>Width</th>
										<th>Stack Width</th>
										<th>Net Stack</th>
										<th>Area</th>
									</tr>
								</table>
								<input type="hidden" id="what-index-1" value=0>
								<div id="addmorecores" class="addmore row" onclick="addmore(1)">
									<div class="addmore-rule">
										<hr class="addmore-hr">
									</div>
									<div class="addmore-image">
										<img src="resources/images/plus.png" width="100%" height="100%">
									</div>
								</div>
								<div style="text-align:center">
									<input id="3-core-input-woodenstrip" class="input-core-2" type="text" placeholder="Wooden Strip">
									<input id="3-core-input-total-area" class="input-core-2" type="text" placeholder="Total Area" readonly>
								</div>
								<button class="funny-buts" onclick="maketable();">Make Table</button><br><br>
								<table>
									<tr>
										<td><label for="3-compactingfactor">Compacting Factor</label></td>
										<td><input id="3-compactingfactor" name="name" type="text" placeholder="Compacting Factor"></td>
									</tr>
									<tr>
										<td><label for="3-netcoreareammsq">Net Core Area in mm<sup>2</sup></label></td>
										<td><input id="3-netcoreareammsq" name="name" type="text" placeholder="Net Core Area"></td>
									</tr>
									<tr>
										<td><label for="3-netcoreareacmsq">Net Core Area in cm<sup>2</sup></label></td>
										<td><input id="3-netcoreareacmsq" name="name" type="text" placeholder="Net Core Area"></td>
									</tr>
									<tr>
										<td><label for="3-noofphases">No Of Phases</label></td>
										<td><input id="3-noofphases" name="name" type="text" placeholder="No Of Phases"></td>
									</tr>
									<tr>
										<td><button class="funny-buts-2" onclick="getphasevoltage();">Phase Voltage</button></td>
										<td><input id="3-netcoreareacmsq" name="name" type="text" placeholder="Phase Voltage" readonly></td>
									</tr>
									<tr>
										<td><label for="3-fluxdensity">Flux Density</label></td>
										<td><input id="3-fluxdensity" name="name" type="text" placeholder="Flux Density"></td>
									</tr>
									<tr>
										<td><button class="funny-buts-2" onclick="getlvturns();">LV Turns</button></td>
										<td><input id="3-lvturns" name="name" type="text" placeholder="LV Turns" readonly></td>
									</tr>
									<tr>
										<td><label for="3-originallvturns">Original LV Turns</label></td>
										<td><input id="3-originallvturns" name="name" type="text" placeholder="Original LV Turns"></td>
									</tr>
									<tr>
										<td><button class="funny-buts-2" onclick="getfluxdensity();">Calculated Flux Density</button></td>
										<td><input id="3-actualfluxdensity" name="name" type="text" placeholder="Actual Flux Density" readonly></td>
									</tr>
									<tr>
										<td><label for="3-lvturnstaken">LV Turns Taken</label></td>
										<td><input id="3-lvturnstaken" name="name" type="text" placeholder="LV Turns Taken"></td>
									</tr>
									<tr>
										<td><button class="funny-buts-2" onclick="getfluxdensity2();">So Flux Density</button></td>
										<td><input id="3-sofluxdensity" name="name" type="text" placeholder="Flux Density" readonly></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-4" class="windows">
							<div id="window-header-1" class="window-headers">
								LV Windings
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="4-coremaxdia">Core Max Dia</label></td>
										<td><input id="4-coremaxdia" name="name" type="text" placeholder="Core Max Dia"></td>
									</tr>
									<tr>
										<td><label for="4-coremaxdiatolerance">Tolerance</label></td>
										<td><input id="4-coremaxdiatolerance" name="name" type="text" placeholder="Tolerance"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
									<tr>
										<td><label for="4-cylinderid">Cylinder ID</label></td>
										<td><input id="4-cylinderid" name="name" type="text" placeholder="Cylinder ID"></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-5" class="windows">
							<div id="window-header-1" class="window-headers">
								Insulation Over LV
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-6" class="windows">
							<div id="window-header-1" class="window-headers">
								HV Windings 1
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-7" class="windows">
							<div id="window-header-1" class="window-headers">
								HV Windings 2
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-8" class="windows">
							<div id="window-header-1" class="window-headers">
								HV Windings 3
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-9" class="windows">
							<div id="window-header-1" class="window-headers">
								Insulation Over HV
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-10" class="windows">
							<div id="window-header-1" class="window-headers">
								Inner Tap Winding 1
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-11" class="windows">
							<div id="window-header-1" class="window-headers">
								Inner Tap Winding 2
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-12" class="windows">
							<div id="window-header-1" class="window-headers">
								Insulation Over In Tap
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-13" class="windows">
							<div id="window-header-1" class="window-headers">
								Outer Tap Winding
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-14" class="windows">
							<div id="window-header-1" class="window-headers">
								Calculate Impedance
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-15" class="windows">
							<div id="window-header-1" class="window-headers">
								Covered Cu. Weight Calculation
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-16" class="windows">
							<div id="window-header-1" class="window-headers">
								Calculate Weight
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-17" class="windows">
							<div id="window-header-1" class="window-headers">
								OLTC Details
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-18" class="windows">
							<div id="window-header-1" class="window-headers">
								Accessories
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
						<div id="window-19" class="windows">
							<div id="window-header-1" class="window-headers">
								Impedance Calculated
							</div>
							<div id="window-body" class="class-window-body">
								<table>
									<tr>
										<td><label for="2-"></label></td>
										<td><input id="2-" name="name" type="text" placeholder=""></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<footer>
			&copy; Set On Site Electricals
		</footer>
	</body>
</html>