ALTER PROCEDURE [dbo].[TampilMahasiswa]
AS 
SELECT nim, kode_program, nama, tgl_lahir, alamat, telp FROM dbo.mahasiswa 

execute [dbo].[TampilMahasiswa]