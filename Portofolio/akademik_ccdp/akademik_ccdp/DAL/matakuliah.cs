//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace akademik_ccdp.DAL
{
    using System;
    using System.Collections.Generic;
    
    public partial class matakuliah
    {
        public matakuliah()
        {
            this.pengajarans = new HashSet<pengajaran>();
        }
    
        public string kode_matakuliah { get; set; }
        public string kode_program { get; set; }
        public string nama_matakuliah { get; set; }
        public byte sks { get; set; }
        public byte semester { get; set; }
    
        public virtual program program { get; set; }
        public virtual ICollection<pengajaran> pengajarans { get; set; }
    }
}