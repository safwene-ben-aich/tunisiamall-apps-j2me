<?php
require_once('connect.php');



$sql = "SELECT * FROM marque";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $mydata = $xml->addChild('Marque');
        $mydata->addChild('ID',$row['ID']);
        $mydata->addChild('Nom',$row['Nom']);
		$mydata->addChild('seuilAchat',$row['seuilAchat']);
		$mydata->addChild('ID_RESPONSABLE',$row['ID_RESPONSABLE']);
		 
        $mydata->addChild('image_marque',$row['image_marque']);
       
         }
} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	 echo($xml->asXML());
?>