<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="tambah_mahasiswa.aspx.cs" Inherits="akademik_ccdp.Tambah_Mahasiswa" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
    <h2>Tambah Data Mahasiswa</h2>
    <asp:EntityDataSource ID="EntityDataSourceMahasiswa" runat="server" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" EnableFlattening="False" EnableInsert="True" EntitySetName="mahasiswas" OnContextCreating="EntityDataSourceMahasiswa_ContextCreating">
    </asp:EntityDataSource>
    <asp:DetailsView ID="DetailsViewMahasiswa" runat="server" Height="50px" Width="125px" AutoGenerateRows="False" DataKeyNames="nim" DataSourceID="EntityDataSourceMahasiswa" DefaultMode="Insert">
        <Fields>
            <asp:BoundField DataField="nim" HeaderText="nim" ReadOnly="True" SortExpression="nim" />
            <asp:TemplateField HeaderText="kode_program" SortExpression="kode_program">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("kode_program") %>'></asp:TextBox>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("kode_program") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label1" runat="server" Text='<%# Bind("kode_program") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:BoundField DataField="nama" HeaderText="nama" SortExpression="nama" />
            <asp:BoundField DataField="tgl_lahir" HeaderText="tgl_lahir" SortExpression="tgl_lahir" />
            <asp:BoundField DataField="alamat" HeaderText="alamat" SortExpression="alamat" />
            <asp:BoundField DataField="telp" HeaderText="telp" SortExpression="telp" />
            <asp:CommandField ShowInsertButton="True" />
        </Fields>
    </asp:DetailsView>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">
</asp:Content>
