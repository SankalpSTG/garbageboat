<?php

 
 
 $response = array();

 // Check if we got the field from the user
if (isset($_GET['id']) && isset($_GET['name']) && isset($_GET['age'])) {

$id = $_GET['id'];
$name = $_GET['name'];
$age = $_GET['age'];

include("DBConnection.php");


$query = "INSERT INTO users(id, name,age) VALUES('$id', '$name', '$age')";
 


if (mysqli_query($db,$query)) {
    // successfully inserted 
    $response["success"] = 1;
    $response["message"] = "record successfully Inserted.";

    // Show JSON response
    echo json_encode($response);
} else {
    // Failed to insert data in database
    $response["success"] = 0;
    $response["message"] = "Something has been wrong";

    // Show JSON response
    echo json_encode($response);
}
} else {
  // If required parameter is missing
$response["success"] = 0;
$response["message"] = "Parameter(s) are missing. Please check the 
request";

// Show JSON response
echo json_encode($response);
 }
?>