
<?php
$conn=mysql_connect("localhost","root","");
if(! $conn)
	die("Could not connect to server : ".mysql_error());
mysql_select_db("customer",$conn);
$sel="SELECT * FROM Acc_Holders";
$seldb=mysql_query($sel,$conn);
$num=$_POST['acn'];
$bool=true;
echo '<table border=\"1\">';
echo '<tr>';
echo '<th>NAME</th>';
echo '<th>ACC_NUM</th>';
echo '<th>ACC_TYPE</th>';
echo '<th>BALANCE</th>';
echo "<th>CREATION_DATE</th>";
echo "<th>LAST_TRANSACTION</th>";
echo"<tr>";
while($row=mysql_fetch_array($seldb,MYSQL_ASSOC))
{
	
	if($num==$row['ACC_NUM'])
	{
		$del="Delete from Acc_Holders where ACC_NUM=$num";
		$dele=mysql_query($del,$conn);
		if(! $dele) die(mysql_error());
		print'<script>alert("DELETION SUCCESSFULL");</script>';
		print'<script>window.location.assign("Execute.html");</script>';
		$bool=false;
	}
}
echo'</table>';
if($bool)
{
		print'<script>alert("NO ENTRIES FOUND");</script>';
		print'<script>window.location.assign("Execute.html");</script>';
}

?>
<html>
<body>
<a href="Execute.html">Click Here to go to the start page</a>
</body>
</html>