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
  TAMBAH DATA SURVEY  
  </title>   
  </head>   
  <body bgcolor="#7FFFD4">
	<div id="canvas" style="font-family: Calibri;">
	 <img src="../../img/banner.png" align="center" width="960px"/>
        <div id="header">
            SURVEY PLN
			<table align="right">
			    <tr>
                    <td><?php echo anchor('login/logout','Logout'); ?></a></td>
					<td><?php echo anchor('register','Register'); ?></a></td>
                </tr>				
			</table>
        </div>
		
		<div id="menu">
            <ul>
	            <li class="utama"><?php echo anchor(site_url().'','BERANDA'); ?></li>
		        <li class="utama"><?php echo anchor('dashboard','DASHBOARD'); ?></li>
	        </ul>
        </div>
		<div id="isi">
		<center>
   <?php echo form_open('Dashboard/form_insert'); ?>   
   <table border=0 width="45%" cellpadding="5" cellspacing="0">   
    <tr>   
     <td Colspan="3" align="center"><H2>DATA SURVEY PLN</H2></td>   
    </tr>    
    <tr>   
     <td>Id Pelanggan</td>   
     <td>:</td>   
     <td><input type="text" name="id_pelanggan" value="<?php echo set_value('id_pelanggan'); ?>" size="50"><?php echo form_error('id_pelanggan'); ?></td>   
    </tr>    
    <tr>   
     <td>Nama</td>   
     <td>:</td>   
     <td><input type="text" name="nama" value="<?php echo set_value('nama'); ?>" size="50"><?php echo form_error('nama'); ?></td>   
    </tr>    
    <tr>   
     <td>Tanggal Survey</td>   
     <td>:</td>   
     <td>
		<input type="date" name="tanggal" value="<?php echo set_value('tanggal'); ?>" size="50"><?php echo form_error('tanggal'); ?>
	 </td>
	</tr>    
    <tr>   
     <td>Jumlah</td>   
     <td>:</td>   
     <td><input type="text" name="jumlah" value="<?php echo set_value('jumlah'); ?>" size="50"><?php echo form_error('jumlah'); ?></td>   
    </tr>
    <tr>   
     <td>ID User</td>   
     <td>:</td>   
     <td>
		<input type="radio" name="userid" checked value="1">1   
		<input type="radio" name="userid" value="2">2
		<input type="radio" name="userid" value="3">3
	 </td>
	</tr>   
    <tr align="center">   
     <td colspan="3">   
      <input type="submit" value="TAMBAH">   
      <input type="reset" value="BATAL">   
      [<a href="<?php echo base_url(); ?>index.php/dashboard">Lihat Data Survey</a>]   
     </td>   
    </tr>    
   </table>   
   <?php echo form_close(); ?> 
	</center>
	</div>
	</div>
  </body>   
  </html>   