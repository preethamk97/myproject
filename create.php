<?php
session_start();
if(isset($_POST["act"]))
			{
				$type=$_POST["act"];
				echo"<form action=\"create.php\" method=\"POST\">";
				switch($type)
				{
					case "FD":
						echo"BALANCE :<input type=\"number\" name=\"bal\" required=\"required\" min=\"5000\" step=\"0.01\">";
						break;
					case "RD":
						echo"BALANCE :<input type=\"number\" name=\"bal\" required=\"required\" min=\"500\">";
						break;
					case "CU":
						echo"BALANCE :<input type=\"number\" name=\"bal\" required=\"required\" min=\"5000\">";
						break;
					case "SA":
						echo"BALANCE :<input type=\"number\" name=\"bal\" required=\"required\" min=\"1000\">";
						break;
				}
				echo"<br>";
				echo "DATE OF CREATION :<input type=\"date\" name=\"doc\"><br>";
				echo"<input type=\"submit\" name=\"submit\">";
				echo "</form>";
				$_SESSION['act']=$_POST['act'];
				$_SESSION['cname']=$_POST['cname'];
				$_SESSION['acn']=$_POST['acn'];
				
			}
			if(isset($_POST['bal']) && isset($_POST['doc']))
			{
				$balance=$_POST['bal'];
				$doc=$_POST['doc'];
				$act=$_SESSION['act'];
				$cname=$_SESSION['cname'];
				$acn=$_SESSION['acn'];
			$conn=mysql_connect("localhost","root","");
			if(! $conn)
				die("Could not connect to server : ".mysql_error());
			$sel=mysql_select_db("customer",$conn);
			if(! $sel)
				die("DATABASE NOT FOUND : ".mysql_error());
			
			$ins="INSERT INTO Acc_Holders (NAME,ACC_NUM,ACC_TYPE,BALANCE,CREATION_DATE) VALUES ('$cname',$acn,'$act',$balance,'$doc')";
			$insinto=mysql_query($ins,$conn);
			if(! $insinto)
			{
				echo"Could not insert values : ".mysql_error()."<br>";
				$tab="Create table Acc_Holders(
					NAME VARCHAR(30) NOT NULL,
					ACC_NUM BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
					ACC_TYPE VARCHAR(30) NOT NULL,
					BALANCE FLOAT NOT NULL,
					CREATION_DATE DATE NOT NULL,
					LAST_TRANSACTION TIMESTAMP
					)";
					$ctable=mysql_query($tab,$conn);
					if(! $ctable)
						die("Could not create table : ".mysql_error());
					print'<script>alert("CREATION OF TABLE SUCCESSFULL");</script>';
					
					print'<script>window.location.assign("Execute.html");</script>';
			}
				print'<script>alert("VALUES INSERTED INTO DATABASE");</script>';
				print'<script>window.location.assign("Execute.html");</script>';
			}
			
?>			