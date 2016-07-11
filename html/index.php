<html>
  <head>
    <title> Cluster search </title>
  </head>

  <body>
    <!-- <input id="in" type="text">
    <button type="buttton" onclick="f()">Result </button>
    <script src=myScripts.js></script>
    <p id="para">hello</p> -->

    <div style="text-align:left;font-size:40px;font-weight:bold"> CLUSTER SEARCH </div> <br><br>

    <form action="result.php" method="post">
      Enter Cluster number
      <input type="text" name="name" ></input>
      <input type="submit"></input>
    </form>

    <?php

    $db=mysqli_connect('localhost','root','root','BOOKS') or die('Error');
    $query="SELECT TABLE_NAME,TABLE_ROWS FROM information_schema.tables WHERE table_type = 'BASE TABLE' AND table_schema='BOOKS' ORDER BY TABLE_ROWS DESC";
    $result=mysqli_query($db,$query) or die ('error here');
    while($row=mysqli_fetch_assoc($result))
    {
      $s=$row["TABLE_NAME"];
      $count=$row["TABLE_ROWS"];

    echo "<a href='result.php?name=$s'> $s ( $count ) </a> <br><br>";

    }

    mysqli_close($db);
    ?>

</body>


</html>
