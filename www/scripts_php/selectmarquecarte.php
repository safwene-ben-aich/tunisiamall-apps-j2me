<?php
require_once('connect.php');
$login=$_GET['login'];



$sql = "select c.NOM ,b.ID,b.Nom,b.seuilAchat,b.ID_RESPONSABLE,b.image from  user c inner join carte_fidilite a on
 c.ID=a.ID_CLIENT inner join marque b on b.ID=a.ID_MARQUE WHERE c.username='$login'";
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
		 
        $mydata->addChild('image',$row['image']);
       
         }
} else {
    echo "0 results";
}
$conn->close();
header ("Content-Type:text/xml");
	 echo($xml->asXML());
?>