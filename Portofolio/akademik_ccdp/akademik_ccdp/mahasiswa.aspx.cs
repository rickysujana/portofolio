using akademik_ccdp.DAL;
using System;
using System.Collections.Generic;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace akademik_ccdp
{
    public partial class Mahasiswa : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string username = Session["username"] as string;

            if (String.IsNullOrEmpty(username))
            {
                Response.Redirect("Login.aspx");
            }
        }

        protected void EntityDataSourceMahasiswa_ContextCreating(object sender, EntityDataSourceContextCreatingEventArgs e)
        {
            var db = new akademik_dbEntities();
            e.Context = (db as IObjectContextAdapter).ObjectContext;
        }

        protected void EntityDataSourceCari_ContextCreating(object sender, EntityDataSourceContextCreatingEventArgs e)
        {
            var db = new akademik_dbEntities();
            e.Context = (db as IObjectContextAdapter).ObjectContext;
        }

        protected void Page_Init(object sender, EventArgs e) {
            GridViewMahasiswa.EnableDynamicData(typeof(mahasiswa));
            GridViewCariMhs.EnableDynamicData(typeof(mahasiswa));
        }  
    }
}