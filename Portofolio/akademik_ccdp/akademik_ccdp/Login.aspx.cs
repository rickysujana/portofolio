using akademik_ccdp.DAL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace akademik_ccdp
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Login_Click(object sender, EventArgs e)
        {
            akademik_dbEntities db = new akademik_dbEntities();
            String username = UserName.Text;
            String password = Password.Text;
            string query = (from u in db.users
                            where u.username == username && u.password == password
                            select u.username).FirstOrDefault();
            if (query != null)
            {
                this.Session["username"] = username;
                Response.Redirect("Mahasiswa.aspx");
            }
            else
                Response.Write("Invalid User");
        }

    }
}