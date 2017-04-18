<%@ Page Title="About" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Tentang.aspx.cs" Inherits="akademik_ccdp.About" %>

<asp:Content runat="server" ID="BodyContent" ContentPlaceHolderID="MainContent">
    <hgroup class="title">
        <h2>Jumlah Mahasiswa</h2>
    </hgroup>

    <asp:EntityDataSource ID="EntityDataSourceJmlMhs" runat="server" EnableFlattening="False" EntitySetName="mahasiswas" GroupBy="it.kode_program" OrderBy="it.kode_program" Select="it.kode_program, Count(it.kode_program) as JmlMahasiswa" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" OnContextCreating="EntityDataSourceJmlMhs_ContextCreating"></asp:EntityDataSource>

    <article>
        <p>        
            <asp:GridView ID="GridViewJmlMhs" runat="server" AutoGenerateColumns="False" DataSourceID="EntityDataSourceJmlMhs">
                <Columns>
                    <asp:BoundField DataField="kode_program" HeaderText="kode_program" ReadOnly="True" SortExpression="kode_program" />
                    <asp:BoundField DataField="JmlMahasiswa" HeaderText="JmlMahasiswa" ReadOnly="True" SortExpression="JmlMahasiswa" />
                </Columns>
            </asp:GridView>
        </p>
    </article>

    <aside>
        <h3>Aside Title</h3>
        <p>        
            Use this area to provide additional information.
        </p>
        <ul>
            <li><a runat="server" href="~/">Home</a></li>
            <li><a runat="server" href="~/About.aspx">About</a></li>
            <li><a runat="server" href="~/Contact.aspx">Contact</a></li>
        </ul>
    </aside>
</asp:Content>