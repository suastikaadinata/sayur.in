<?php

	$server		= "localhost"; 
	$user		= "root"; 
	$password	= ""; 
	$database	= "sayurin"; 
	
	//$connect = mysql_connect($server, $user, $password) or die ("Koneksi gagal!");
	//mysql_select_db($database) or die ("Database belum siap!");


	 $con = mysqli_connect($server, $user, $password, $database);
		if (mysqli_connect_errno()) {
		echo "Gagal terhubung MySQL: " . mysqli_connect_error();
	 }

?>