<?php
 defined('BASEPATH') OR exit('No direct script access allowed');
 ?>
 <center></center>
 <!DOCTYPE html>  
 <head>
	<link href="<?=base_url();?>assets/bootstrap.css" rel="stylesheet" />
   <meta charset="UTF-8">
   <title>
     Dashboard Data Survey PLN
   </title>
 </head>
<body bgcolor="#7FFFD4">
 <div id="canvas" style="font-family: Calibri;">
	 <img src="../img/banner.png" align="center" width="960px"/>
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
	        </ul>
        </div>
		<div id="isi">
		<center>
	  <H3>Data Survey PLN</H3>  
  <table border=1 width=80% cellpadding=2 cellspacing=0>  
    <tr bgcolor=silver align=center>  
     <td>ID</td>  
     <td>Id Pelanggan</td>  
     <td>Nama</td>  
     <td>Tanggal</td>  
     <td>Jumlah</td>  
	 <td>Foto</td>
     <td>ID User</td>  
     <td colspan=2>AKSI</td>  
    </tr>  
    <?php  
    if ($jumlah_data > 0) {  
   
      
    foreach ($data_survey as $row)   
     { ?>  
      <tr align=center>  
       <td><?php echo $row['id'];?></td>  
       <td><?php echo $row['id_pelanggan'];?></td>  
       <td><?php echo $row['nama'];?></td>  
       <td><?php echo $row['tanggal'];?></td>  
       <td><?php echo $row['jumlah'];?></td> 
	   <td><img  src="<?php echo base_url()?>assets/upload/<?php echo $row['id'];?>"></td>	   
       <td><?php echo $row['userid'];?></td>  
       <td><a href="<?php echo base_url(); ?>index.php/dashboard/edit/<?php echo $row['id']; ?>">Ubah</a></td>   
       <td><a href="<?php echo base_url(); ?>index.php/dashboard/hapus/<?php echo $row['id']; ?>">Hapus</a></td>   
      </tr>  
      <?php  
    }  
      
   
   
   
    } else { ?>  
     <tr align='center'>  
     <td colspan=7>Data Survey kosong</td>  
     </tr>  
    <?php } ?>  
   
   </table>  
   <p>Jumlah data : <?php echo $jumlah_data;?> [<a href="<?php echo base_url(); ?>index.php/dashboard/form_insert">Tambah Data</a>] </p> 
			</center>
			</div>
			</div>
 </body>
 </html>