<?php
 defined('BASEPATH') OR exit('No direct script access allowed');
 ?>
 <center></center>
 <!DOCTYPE html>  
 <head>
	<link href="<?=base_url();?>assets/bootstrap.css" rel="stylesheet" />
   <meta charset="UTF-8">
   <title>
     Halaman Login
   </title>
 </head>
  <body bgcolor="#7FFFD4">
 <div id="canvas" style="font-family: Calibri;">
	 <img src="../img/banner.png" align="center" width="960px"/>
        <div id="header">
            SURVEY PLN
			<table align="right">
			    <tr>
                    <td><?php echo anchor('login','Login'); ?></a></td>
					<td><?php echo anchor('register','Register'); ?></a></td>
                </tr>				
			</table>
        </div>
		
		<div id="menu">
            <ul>
	            <li class="utama"><?php echo anchor(site_url().'','BERANDA'); ?></li>
		        <li class="utama"><a href="dashboard">Dashboard</a></li>
	        </ul>
        </div>
		
		<div id="isi">
   <h2><center>Silahkan Log In terlebih dahulu</center></h2>
    <center>
	
	<?php
   // Cetak jika ada notifikasi
      if($this->session->flashdata('sukses')) {
           echo '<p class="warning" style="margin: 10px 20px;">'.$this->session->flashdata('sukses').'</p>';
      }
      ?>
        <div id="utama">
            <div id="judul">
	        Halaman Login
			</div>
	
	    <div id="inputan">
	        <form action="" method="post">
				<?php echo form_open('login');?>
	            <div>
		            <input type="text" name="username" placeholder="Username" class="lg" value="<?php echo set_value('username'); ?>"/>
					<p> <?php echo form_error('username'); ?> </p>
		        </div>
		        <div style="margin-top:5px">
		            <input type="password" name="password" placeholder="Password" class="lg" value="<?php echo set_value('password'); ?>"/>
					<p> <?php echo form_error('password'); ?> </p>
		        </div>
		        <div style="margin-top:5px">
		            <input type="submit" name="btnSubmit" value="login" class="btn" />
		        </div>
				<?php echo form_close();?>
	        </form>
	    </div>
        </div>
	
	</center>
	</div>
	</div>
	
 </body>
 </html>