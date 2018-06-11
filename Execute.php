<?php

$option=$_POST['opt'];
$conn=mysql_connect("localhost","root","");
if(! $conn)
	die("could not connect to server :".mysql_error());
$sel=mysql_select_db("customer",$conn);
if(! $sel)
{
	$cre="create database customer";
	$create=mysql_query($cre,$conn);
	echo "NO DATABASE : database will be created<br>";
	if(! $cre)
		die("Could not create database ".mysql_error());
	else 
		
		echo "Database created successfully";
}
else
{
	switch($option){
		case "create":
			
			echo "<form action=\"create.php\" method=\"POST\">";
			echo "<fieldset>";
			echo "<legend align=\"center\">CUSTOMER INFORMATION</legend>";
			echo "NAME   : <input type=\"text\" name=\"cname\" required=\"required\"><br>";
			echo "ACC_NO : <input type=\"number\" name=\"acn\" required=\"required\ maxlength=\"13\"><br>";
			echo "ACC_TYPE :<SELECT name=\"act\">";
			echo "<option value=\"FD\">FIXED DEPOSIT</option>";
			echo "<option value=\"RD\">RECURRING DEPOSIT</option>";
			echo "<option value=\"CU\">CURRENT ACCOUNT</option>";
			echo "<option value=\"SA\">SAVINGS ACCOUNT</option>";
			echo"</Select>";
			
			echo "<input type=\"submit\" name=\"submit\">";
			echo "</fieldset>";
			echo "</form>";
			echo'<img src="bank.jpg" width="690" height="690">';
		break;
		case "disp1":
				echo "Enter the name of the account holder<br>";
				echo "<form action=\"disp1.php\" method=\"POST\">";
				echo "NAME   : <input type=\"text\" name=\"cname\" required=\"required\"><br>";
				echo "<input type=\"submit\" name=\"submit\">";
				echo "</form>";
				echo'<img src="bank.jpg" width="690" height="690">';
		break;
		case "disp2":
				echo "Enter the account number of the account holder<br>";
				echo "<form action=\"disp2.php\" method=\"POST\">";
				echo "ACC_NO : <input type=\"number\" name=\"acn\" required=\"required\ maxlength=\"13\"><br>";
				echo "<input type=\"submit\" name=\"submit\">";
				echo "</form>";
				echo'<img src="bank.jpg" width="690" height="690">';
		break;
		case "disp3":
				require("disp3.php");
				echo'<img src="bank.jpg" width="690" height="690">';
		break;
		case "del":
				echo "Enter the account number of the account holder<br>";
				echo "<form action=\"del.php\" method=\"POST\">";
				echo "ACC_NO : <input type=\"number\" name=\"acn\" required=\"required\ maxlength=\"13\"><br>";
				echo "<input type=\"submit\" name=\"submit\">";
				echo "</form>";
				echo'<img src="bank.jpg" width="690" height="690">';
		break;
	}
}

?>