<?php

   $message = array();

 // Check if we got the field from the user
   if (isset($_GET['id']) && isset($_GET['name']) && isset($_GET['age'])) {

       $id = $_GET['id'];
       $name = $_GET['name'];
       $age = $_GET['age'];

       include("DBConnection.php");


       $query = "INSERT INTO users(id, name,age) VALUES('$id', '$name', '$age')";
 


            if (mysqli_query($conn,$query)) {
				
                // successfully inserted 
                $message["error"] = true;
                $message["error_message"] = "record successfully Inserted.";

               // Show JSON response
               echo die(json_encode($message));
            } else {
				
                // Failed to insert data in database
                $message["error"] = false;
                $message["error_message"] = "Something has been wrong";

                // Show JSON response
                 echo die(json_encode($message));
    }
    } else {
        // If required parameter is missing
        $message["error"] = false;
        $message["error_message"] = "Parameter(s) are missing. Please check the 
        request";

        // Show JSON response
        echo die(json_encode($message));
       }
?>
