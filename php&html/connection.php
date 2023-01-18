<?php

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "tit";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

$data = json_decode(file_get_contents('php://input'), true);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
if ($data) {
$username = $data['email'];
$password = $data['password'];

$sql = "SELECT * FROM user WHERE email = '$username' AND password = '$password'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        // $state = 'ok'; 
        // $result_code = 1;
        // echo json_encode(array('state'=>$state, 'code'=>$result_code));
        echo "done";
    }
} else {
    // $state = 'ok'; 
    // $result_code = 0;
    // echo json_encode(array('state'=>$state, 'code'=>$result_code));
    echo "Invalid login";
}
$conn->close();
}else {
    // $state = 'failed';
    // echo json_encode(array('state'=>$state),JSON_FORCE_OBJECT);
    echo "error";
}
?>
