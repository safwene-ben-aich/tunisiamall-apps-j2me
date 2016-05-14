<?php
if(isset($_GET['to'])) {
    $to = $_GET['to'];
}
else{
    $to = '';
}
if(isset($_GET['subject'])) {
    $subject = $_GET['subject'];
}
else{
    $subject = '';
}
if(isset($_GET['message'])) {
    $message = $_GET['message'];
}
else{
    $message = '';
}
if(isset($_GET['headers'])) {
    $headers = $_GET['headers'];
}
else{
    $headers = '';
}

if (mail($to, $subject, $message, $headers))
    echo "true";
else
    echo "false";

?>