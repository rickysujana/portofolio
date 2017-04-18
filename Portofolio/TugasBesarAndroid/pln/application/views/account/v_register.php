 <?php
 defined('BASEPATH') OR exit('No direct script access allowed');
 ?>
 <center></center>
 <!DOCTYPE html>  
 <head>
	<link href="<?=base_url();?>assets/bootstrap.css" rel="stylesheet" />
   <meta charset="UTF-8">
   <title>
     Pendaftaran Akun
   </title>
 </head>
 <body bgcolor="#7FFFD4">
 <div id="canvas" style="font-family: Calibri;">
	 <img src="../img/banner.png" align="center" width="960px"/>
        <div id="header">
            SURVEY PLN
			<table align="right">
			    <tr>
                    <td><?php echo anchor('login','Masuk'); ?></a></td>
					<td><?php echo anchor('register','Daftar'); ?></a></td>
                </tr>				
			</table>
        </div>
		
		<div id="menu">
            <ul>
	            <li class="utama"><?php echo anchor(site_url().'','BERANDA'); ?></li>
		        <li class="utama"><a href="">Tentang Kami</a></li>
	        </ul>
        </div>
		
		<div id="isi">
		<center>
	<div id="inputan">
        <form action="" method="post">
            <table>
                <tbody>
                    <tr>
                        <td colspan="2" align="center">
                            <h1>Daftar Baru</h1>
                        </td>
                    </tr>
				
                    <tr>
                        <td>Username</td>
                        <td>: <input type="text" name="username" value="<?php echo set_value('username'); ?>"/> 
								<p> <?php echo form_error('username'); ?> </p> </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>: <input type="password" name="password" value="<?php echo set_value('password'); ?>"/><p> <?php echo form_error('password'); ?> </p></td>
                    </tr>
					<tr>
                        <td>Password Confim</td>
                        <td>: <input type="password" name="password_conf" value="<?php echo set_value('password_conf'); ?>"/><p> <?php echo form_error('password_conf'); ?> </p></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right"><input type="submit" name="btnSubmit" value="Daftar" /> <input type="reset" value="Batal" /></td>
                    </tr>
				
                </tbody>
            </table>
        </form>
	</div>
    </center> 
	
	 </div>
	 </div>
 </body>
 </html>