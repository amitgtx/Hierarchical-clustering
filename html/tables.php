<?php

$db=mysqli_connect('localhost','root','root','BOOKS') or die('Error');
$query="SELECT TABLE_NAME FROM information_schema.tables WHERE table_type = 'BASE TABLE' AND table_schema='BOOKS' ORDER BY TABLE_ROWS DESC";
$result=mysqli_query($db,$query) or die ('error here');
while($row=mysqli_fetch_assoc($result))
{
echo $row["TABLE_NAME"]."<br><br>";
}

mysqli_close($db);
?>
