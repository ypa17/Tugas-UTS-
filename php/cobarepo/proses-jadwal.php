<?php

include("config.php");

	$dhuha= $_POST['dhuha'];
	$shubuh= $_POST['shubuh'];
	$dhuhur= $_POST['dhuhur'];
	$ashar= $_POST['ashar'];
	$maghrib= $_POST['maghrib'];
	$isha= $_POST['isha'];

	$sql = "UPDATE jadwal_sholat SET dhuha='$dhuha', shubuh='$shubuh', dhuhur='$dhuhur', ashar='$ashar', maghrib='$maghrib', isha='$isha'";
	$query = mysqli_query($db, $sql);

	if( $query ){

	}else {
		die("Gagal menyimpan perubahan...");
	}

?>	