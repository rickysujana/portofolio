CREATE PROCEDURE dbo.HapusMahasiswa  
	@nim char(10) 
AS  
	DELETE dbo.mahasiswa  
	FROM dbo.mahasiswa  
	WHERE nim = @nim; 