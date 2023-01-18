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
    $sql ="INSERT INTO user ( email, password) VALUES ('" . $username . "','" . $password . "')";
    $result = $conn->query($sql);
    if($result){
        echo "Sign Up Success";
    }else{
        echo "Sign Up Failure";
    }
}else{
    echo "Error: server down";
}
?>
