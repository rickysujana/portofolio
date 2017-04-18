<?php
 defined('BASEPATH') OR exit('No direct script access allowed');
 ?>
 
 <center></center>
 <!DOCTYPE html>
 <html>
 <head>
	<link href="<?=base_url();?>assets/bootstrap.css" rel="stylesheet" />
     <meta charset="UTF-8">
     <title>
         Beranda 
     </title>
	 
 </head>
 <body bgcolor="#7FFFD4">
 
     <div id="canvas" style="font-family: Calibri;">
	 <img src="img/banner.png" align="center" width="960px"/>
        <div id="header">
            SURVEY PLN
			<table align="right">
			    <tr>
                    <td><?php echo anchor('login','Masuk'); ?></td>
					<td><?php echo anchor('register','Daftar'); ?></td>
                </tr>				
			</table>
        </div>
		
		<div id="menu">
            <ul>
		        <li class="utama"><a href="index.php/dashboard">Dashboard</a></li>
	        </ul>
        </div>
		
		<div id="isi">
		
        <h1 align="center" colspan="3">Selamat Datang di Web Kami</h1>
		
        
		</div>
	</div>
 
 </body>
 </html>