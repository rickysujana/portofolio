using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using akademik_ccdp.DAL;
using System.Data.Entity.Infrastructure;

namespace akademik_ccdp
{
    public partial class Pengajaran : System.Web.UI.Page
    {
        private TextBox NamaMatakuliahTextBox;

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void EntityDataSourcePengajaran_ContextCreating(object sender, EntityDataSourceContextCreatingEventArgs e)
        {
            var db = new akademik_dbEntities();
            e.Context = (db as IObjectContextAdapter).ObjectContext;
        }

        protected void GridViewPengajaran_SelectedIndexChanged(object sender, EventArgs e)
        {
           
        }

        protected void NamaMatakuliahTextBox_Init(object sender, EventArgs e)
        {
            NamaMatakuliahTextBox = sender as TextBox;
        }

        protected void GridViewPengajaran_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            using (var context = new akademik_dbEntities())
            {
                var kode_pengajaranBeingUpdate = Convert.ToInt32(e.Keys[0]);
                var NamaMatakuliah2 = (from o in context.pengajarans where o.kode_pengajaran == kode_pengajaranBeingUpdate select o).FirstOrDefault();

                try
                {
                    //MENGUBAH FIELD NAMA_KULIAH
                    if (String.IsNullOrWhiteSpace(NamaMatakuliahTextBox.Text) == false)
                    {
                        if (NamaMatakuliah2 == null)
                        {
                            context.matakuliahs.Add(new DAL.matakuliah
                            {
                                kode_matakuliah = NamaMatakuliah2.kode_matakuliah,
                                kode_program = null,
                                nama_matakuliah = NamaMatakuliahTextBox.Text,
                                sks = 0,
                                semester = 0
                            });
                        }
                        else
                        {
                            var NamaMatakuliah3 = (from n in context.matakuliahs where n.kode_matakuliah == NamaMatakuliah2.kode_matakuliah select n).FirstOrDefault();
                            NamaMatakuliah3.nama_matakuliah = NamaMatakuliahTextBox.Text;
                        }
                    }
                    else
                    {
                        if (NamaMatakuliah2 != null)
                        {
                            context.pengajarans.Remove(NamaMatakuliah2);
                        }
                    }
                    context.SaveChanges();
                }
                catch (Exception)
                {
                    e.Cancel = true;
                    ErrorMsgLabel.Visible = true;
                    ErrorMsgLabel.Text = "Update failed.";
                }
            }
        }

        protected void EntityDataSourceMatakuliah_ContextCreating(object sender, EntityDataSourceContextCreatingEventArgs e)
        {
            var db = new akademik_dbEntities();
            e.Context = (db as IObjectContextAdapter).ObjectContext;
        }

        protected void EntityDataSourceInstruktur_ContextCreating(object sender, EntityDataSourceContextCreatingEventArgs e)
        {
            var db = new akademik_dbEntities();
            e.Context = (db as IObjectContextAdapter).ObjectContext;
        }

        protected void EntityDataSourceInstruktur_Selected(object sender, EntityDataSourceSelectedEventArgs e)
        {

        }
    }
}