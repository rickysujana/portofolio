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
  Ubah Data Survey PLN   
  </title>   
  </head>   
  <body bgcolor="#7FFFD4">
 <div id="canvas" style="font-family: Calibri;">
	 <img src="../../../img/banner.png" align="center" width="960px"/>
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
				<li class="utama"><?php echo anchor(site_url().'/dashboard','Dashboard'); ?></li>
	        </ul>
        </div>
		<div id="isi">  
<center>		
   <?php echo form_open('dashboard/edit_simpan'); ?>
   <?php echo form_hidden('id',$this->uri->segment(3)); ?>   
   <table border=0 width="45%" cellpadding="5" cellspacing="0">   
    <tr>   
     <td Colspan="3" align="center"><H2>DATA SURVEY PLN</H2></td>   
    </tr>    
    <tr>   
     <td>Id Pelanggan</td>   
     <td>:</td>   
     <td><?php echo form_input('id_pelanggan', $data ['id_pelanggan'] ); ?></td>   
    </tr>    
    <tr>   
     <td>Nama</td>   
     <td>:</td>   
     <td><?php echo form_input('nama', $data ['nama']); ?></td>   
    </tr>    
    <tr>   
     <td>Tanggal Survey</td>   
     <td>:</td>   
     <td>
		<?php echo form_input('tanggal', $data ['tanggal']); ?>
	 </td>
	</tr>    
    <tr>   
     <td>Jumlah</td>   
     <td>:</td>   
     <td><?php echo form_input('jumlah', $data ['jumlah']); ?></td>   
    </tr>
    <tr>   
     <td>ID User</td>   
     <td>:</td>   
     <td>
		<?php echo form_input('userid', $data ['userid']); ?>
	 </td>
	</tr>   
    <tr align="center">   
     <td colspan="3">   
      <?php echo form_submit('simpan', 'SIMPAN');?>  
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