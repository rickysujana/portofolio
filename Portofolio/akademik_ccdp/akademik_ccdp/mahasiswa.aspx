<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="mahasiswa.aspx.cs" Inherits="akademik_ccdp.Mahasiswa" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">

</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
    <h2>Data Mahasiswa</h2>
    <asp:EntityDataSource ID="EntityDataSourceMahasiswa" runat="server" EnableDelete="True" EnableFlattening="False" EnableUpdate="True" EntitySetName="mahasiswas" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" OnContextCreating="EntityDataSourceMahasiswa_ContextCreating" Include="nilais" OrderBy="it.nama" Where="it.kode_program='ADP'"></asp:EntityDataSource>
    <asp:GridView ID="GridViewMahasiswa" runat="server" AllowPaging="True" AllowSorting="True" DataSourceID="EntityDataSourceMahasiswa" AutoGenerateColumns="False" DataKeyNames="nim" PageSize="5" BackColor="Black" ForeColor="White">
        <Columns>
            <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowSelectButton="True" />
            <asp:TemplateField HeaderText="nama" SortExpression="nama">
                <EditItemTemplate>
                    <asp:DynamicControl ID="NamaTextBox" runat="server" DataField="nama" Mode="Edit" /> 
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="NamaLabel" runat="server" DataField="nama" Mode="ReadOnly" /> 
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="kode_program" SortExpression="kode_program">
                <EditItemTemplate>
                    <asp:DynamicControl ID="KodeProgramTextBox" runat="server" DataField="kode_program" Mode="Edit"/>
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="KodeProgramLabel" runat="server" DataField="kode_program" Mode="ReadOnly" /> 
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="tgl_lahir" SortExpression="tgl_lahir">
                <EditItemTemplate>
                    <asp:DynamicControl ID="TglLahirTextBox" runat="server" DataField="tgl_lahir" Mode="Edit" /> 
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="TglLahirLabel" runat="server" DataField="tgl_lahir" Mode="ReadOnly" /> 
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="alamat" SortExpression="alamat">
                <EditItemTemplate>
                    <asp:DynamicControl ID="AlamatTextBox" runat="server" DataField="alamat" Mode="Edit" /> 
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="AlamatLabel" runat="server" DataField="alamat" Mode="ReadOnly" /> 
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="telp" SortExpression="telp">
                <EditItemTemplate>
                    <asp:DynamicControl ID="TelpTextBox" runat="server" DataField="telp" Mode="Edit" /> 
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="TelpLabel" runat="server" DataField="telp" Mode="ReadOnly" /> 
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Jml Matakuliah" SortExpression="jml_matakuliah">
                <ItemTemplate>
                    <asp:Label ID="JmlMatakuliahLabel" runat="server" Text='<%# Eval("nilais.count") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
        <HeaderStyle BackColor="Gray" ForeColor="Black" />
    </asp:GridView>
    <asp:ValidationSummary ID="ValidationSummaryMahasiswa" runat="server" ShowSummary="true" DisplayMode="BulletList" Style="color: red"/> 

    <h2>Pencarian Mahasiswa</h2>
    Masukan Nama Mahasiswa <asp:TextBox ID="TextBoxCariMhs" runat="server"></asp:TextBox>
    <asp:Button ID="ButtonCariMhs" runat="server" Text="Cari" />
    <asp:EntityDataSource ID="EntityDataSourceCari" runat="server" EnableFlattening="False" EntitySetName="mahasiswas" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" OnContextCreating="EntityDataSourceCari_ContextCreating" Where="it.nama Like '%' + @nama_mhs  + '%'" EntityTypeFilter="" Select="">
        <WhereParameters>
            <asp:ControlParameter ControlID="TextBoxCariMhs" Name="nama_mhs" PropertyName="Text" Type="String" DefaultValue="%"/>
        </WhereParameters>
    </asp:EntityDataSource>
    <asp:GridView ID="GridViewCariMhs" runat="server" AutoGenerateColumns="False" DataKeyNames="nim" DataSourceID="EntityDataSourceCari">
        <Columns>
            <asp:TemplateField HeaderText="NIM" SortExpression="nim">          
                <ItemTemplate>             
                    <asp:DynamicControl ID="Labelnim" runat="server" DataField="nim" Mode="ReadOnly" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Nama" SortExpression="nama">
                <ItemTemplate>
                    <asp:DynamicControl ID="Labelnama" runat="server" DataField="nama" Mode="ReadOnly" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Kode Program" SortExpression="kode_program">                  
                <ItemTemplate>     
                    <asp:DynamicControl ID="Labelkode_program" runat="server" DataField="kode_program" Mode="ReadOnly" />            
                </ItemTemplate>       
            </asp:TemplateField> 
        </Columns>
    </asp:GridView>

</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">
</asp:Content>
