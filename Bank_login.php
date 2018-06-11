<?php
$username=$_POST['b_name'];
$password=$_POST['b_pass'];
$conn=mysql_connect("localhost","root","");
if(! $conn)
	die("Unable to connect to server ".mysql_error());
mysql_select_db("bank_login",$conn) or die(mysql_error());
$sql="Select * from details";
$retval=mysql_query($sql,$conn);
while($row=mysql_fetch_array($retval,MYSQL_ASSOC))
{
	$name=$row['NAME'];
	$pass=$row['PASSWORD'];
	if($username==$name && $password==$pass)
	{
		print'<script>alert("Authentication Successful");</script>';
		print'<script>window.location.assign("Execute.html");</script>';
	}
}
print'<script>alert("Authentication unuccessful check username and password");</script>';
print'<script>window.location.assign("Bank.html");</script>';
?>