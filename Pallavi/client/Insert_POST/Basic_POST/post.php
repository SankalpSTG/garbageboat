<?php
include("DBConnection.php");
$message = array();
$id =$_GET['id'];
$query = "INSERT INTO no (id) VALUES('$id')";
if (mysqli_query($conn,$query)) {
    // successfully inserted 
    $message["error"] = true;
    $message["error_message"] = "record successfully Inserted.";

    // Show JSON response
    echo die(json_encode($message));
} else {
    // Failed to insert data in database
    $message["error"] = 0;
    $message["error_message"] = "Something has been wrong";

    // Show JSON response
    echo (json_encode($message));
} 
?>