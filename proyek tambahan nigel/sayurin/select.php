
<?php 

header('Access-Control-Allow-Origin:*');
header('Access-Control-Allow-Methods:PUT,GET,DELETE,POST,OPTIONS');
header('Access-Control-Allow-Headers:Content-Type,x-xsrf-token');

	include "koneksi.php";
	
	$query = mysqli_query($con,"SELECT * FROM users ORDER BY username ASC");
	
	$json = array();
	
	while($row = mysqli_fetch_assoc($query)){
		$json[] = $row;
	}
	
	echo json_encode($json);
	
	mysqli_close($con);
	
?>



