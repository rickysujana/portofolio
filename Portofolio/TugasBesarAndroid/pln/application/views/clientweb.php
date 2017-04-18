<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?><!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Welcome to CodeIgniter</title>

	<style type="text/css">

	::selection { background-color: #E13300; color: white; }
	::-moz-selection { background-color: #E13300; color: white; }

	body {
		background-color: #fff;
		margin: 40px;
		font: 13px/20px normal Helvetica, Arial, sans-serif;
		color: #4F5155;
	}
        span{
            background-color: #ccc;
            color: #00cc99;
            
        }
        div{
            margin: 30px;
        }
        #semuadata{
            background-color: #0000cc;
            color: #33ff00;
        }
	a {
		color: #003399;
		background-color: transparent;
		font-weight: normal;
	}

	h1 {
		color: #444;
		background-color: transparent;
		border-bottom: 1px solid #D0D0D0;
		font-size: 19px;
		font-weight: normal;
		margin: 0 0 14px 0;
		padding: 14px 15px 10px 15px;
	}

	code {
		font-family: Consolas, Monaco, Courier New, Courier, monospace;
		font-size: 12px;
		background-color: #f9f9f9;
		border: 1px solid #D0D0D0;
		color: #002166;
		display: block;
		margin: 14px 0 14px 0;
		padding: 12px 10px 12px 10px;
	}

	#body {
		margin: 0 15px 0 15px;
	}

	p.footer {
		text-align: right;
		font-size: 11px;
		border-top: 1px solid #D0D0D0;
		line-height: 32px;
		padding: 0 10px 0 10px;
		margin: 20px 0 0 0;
	}

	#container {
		margin: 10px;
		border: 1px solid #D0D0D0;
		box-shadow: 0 0 8px #D0D0D0;
	}
	</style>
</head>
<body>

<div id="container">
    <h1>Welcome to CodeIgniter! Client <span class="judul"> Sedang mengambil data ....</span></h1>

        <div id="nama"> <h1> Data diri</h1>
            Nama <span id="namadepan"></span>
            <span id="namabelakang"></span>
            <br>
            e-mail : <span id="email"></span>		
	</div>
	<div id="kerja"><h1> Data kerja</h1>
            Alamat   <span id="alamat"></span><br>
            kantor   <span id="kantor"></span><br>		
            pekerjaan <span id="pekerjaan"></span><br>		
	</div>
        <h1> Semua data</h1>
        <div id="semuadata">
            
        </div>
</div>
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    <script>

        $(document).ready(function() {

                $.ajax({
                    url: "<?php echo base_url()?>index.php/welcome/contohApi",
                    success: function(data) {

                        var json = $.parseJSON(data);
                        $('#namadepan').text(json.isi[0]);
                        $('#namabelakang').text(json.isi[1]);
                        $('#email').text(json.isi[2]);
                        $('#alamat').text(json.isi2[0]);
                        $('#kantor').text(json.isi2[1]);
                        $('#pekerjaan').text(json.isi2[2]);
                        $('#semuadata').html('isi data is ' + json.isi[0] +','+json.isi[1]+ ','+json.isi[2]+ '<br />data isi2: ' + json.isi2[0]+','+json.isi2[1]+','+json.isi[2]);
                        $('.judul').text('data sudah diambil');
                        }
                });
        });
    </script>
</body>
</html>