<?php
require_once('connect.php');

$marque=$_GET['marque'];


$login=$_GET['login'];

$sql ="select c.NOMBRE_POINT,c.ID_MARQUE,m.Nom from carte_fidilite c inner join marque m inner join user u 
on c.ID_MARQUE=m.ID and c.ID_CLIENT=u.ID where m.ID=$marque and u.username='$login'";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
      $mydata = $xml->addChild('Carte');
        $mydata->addChild('NOMBRE_POINT',$row['NOMBRE_POINT']);
        $mydata->addChild('ID_MARQUE',$row['ID_MARQUE']);
        
        $mydata->addChild('Nom',$row['Nom']);
         }
} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	 echo($xml->asXML());
?>