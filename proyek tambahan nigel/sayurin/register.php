<?php


header('Access-Control-Allow-Origin:*');
header('Access-Control-Allow-Methods:PUT,GET,DELETE,POST,OPTIONS');
header('Access-Control-Allow-Headers:Content-Type,x-xsrf-token');

 include_once "koneksi.php";

	class usr{}

	$username = $_POST["username"];
	$notelp = $_POST["notelp"];
	$email = $_POST["email"];
	$password = $_POST["password"];
	$confirm_password = $_POST["confirm_password"];

	 if ((empty($username))) {
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Kolom username tidak boleh kosong";
	 	die(json_encode($response));
	 } elseif ((empty($notelp))) {
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Kolom notelp tidak boleh kosong";
	 	die(json_encode($response));
	 } elseif ((empty($email))) {
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Kolom email tidak boleh kosong";
	 	die(json_encode($response));
	 } else if ((empty($password))) {
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Kolom password tidak boleh kosong";
	 	die(json_encode($response));
	 } else if ((empty($confirm_password)) || $password != $confirm_password) {
	 	$response = new usr();
	 	$response->success = 0;
	 	$response->message = "Konfirmasi password tidak sama";
		die(json_encode($response));
	 } else {
		 if (!empty($username && $notelp && $email ) && $password == $confirm_password){
		 	$num_rows = mysqli_num_rows(mysqli_query($con, "SELECT * FROM users WHERE username='".$username."'"));

			if ($num_rows == 0){
		 		$query = mysqli_query($con, "INSERT INTO users (id, username, notelp, email, password) VALUES(0,'".$username."','".$notelp."','".$email."','".$password."')");

		 		if ($query){
		 			$response = new usr();
		 			$response->success = 1;
		 			$response->message = "Register berhasil, silahkan login.";
		 			die(json_encode($response));

		 		} else {
		 			$response = new usr();
		 			$response->success = 0;
		 			$response->message = "Username sudah ada";
		 			die(json_encode($response));
		 		}
		 	} else {
		 		$response = new usr();
		 		$response->success = 0;
		 		$response->message = "Username sudah ada";
		 		die(json_encode($response));
			}
		 }
	 }

	 mysqli_close($con);

?>