<!-- <!DOCTYPE html>
<html>
<body> -->
  <?php
$name=$_GET["name"];
$db=mysqli_connect('localhost','root','root','BOOKS') or die('Error');
$query="SELECT * FROM $name";
$result=mysqli_query($db,$query) or die ('error here');
while($row=mysqli_fetch_assoc($result))
{
  echo $row["BOOK_NAME"]."<br><br>";
}

mysqli_close($db);
 ?>
<!-- </body>
 </html> -->
