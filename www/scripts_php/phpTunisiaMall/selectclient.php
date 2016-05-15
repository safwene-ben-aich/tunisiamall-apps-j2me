<?php
require_once('connect.php');
$login=$_GET['login'];


$sql = "SELECT * FROM user where username='$login'";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $xml->addChild('Client');
        $mydata->addChild('ID',$row['ID']);
        $mydata->addChild('username',$row['username']);
		 
       
         }
} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	 echo($xml->asXML());
?>