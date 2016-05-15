<?php
require_once('connect.php');

$idm=$_GET['idm'];

$sql = "SELECT * from produit where ID_MARQUE=$idm";
$result = $conn->query($sql);
$xml = new SimpleXMLElement('<xml/>');
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $mydata = $xml->addChild('Produit');
        $mydata->addChild('ID',$row['ID']);
        $mydata->addChild('REFERENCE',$row['REFERENCE']);
	    $mydata->addChild('ID_MARQUE',$row['ID_MARQUE']);
	    $mydata->addChild('NOM',$row['NOM']);
        $mydata->addChild('TYPE',$row['TYPE']);
        $mydata->addChild('PRIX',$row['PRIX']);
        
        $mydata->addChild('PHOTO',$row['PHOTO']);
      
         
}

} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	 echo($xml->asXML());
?>