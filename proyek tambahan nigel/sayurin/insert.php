<?php
include "koneksi.php";
	
	
	$username 	= $_POST['username'];
	$password 	= $_POST['password'];
	$alamat = $_POST['alamat'];
	
	class emp{}
	
	if (empty($username) || empty($alamat)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Kolom isian tidak boleh kosong"; 
		die(json_encode($response));
	} else {
		$query = mysqli_query($con,"INSERT INTO users (id,username,password,alamat) VALUES(0,'".$username."','".$password."','".$alamat."')");
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data berhasil di simpan";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error simpan Data";
			die(json_encode($response)); 
		}	
	}

	?>