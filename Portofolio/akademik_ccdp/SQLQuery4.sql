CREATE PROCEDURE dbo.UbahMahasiswa  
	@nim char(10),  
	@kode_program char(3),  
	@nama varchar(45),  
	@tgl_lahir date,  
	@alamat varchar(50),  
	@telp varchar(11)  
	AS  
	UPDATE mahasiswa SET kode_program = @kode_program,       
						nama = @nama,       
						tgl_lahir = @tgl_lahir,       
						alamat = @alamat,       
						telp = @telp 
	WHERE nim = @nim; 
 
