<?php
include("DBConnection.php");
$response = array();
$id =$_GET['id'];
$query = "INSERT INTO no (id) VALUES('$id')";
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
?>