<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="matakuliah.aspx.cs" Inherits="akademik_ccdp.Matakuliah" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
    <h2>Matakuliah Berdasarkan Program</h2> 
    <asp:EntityDataSource ID="EntityDataSourceProgram" runat="server" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" EnableFlattening="False" EntitySetName="programs" OnContextCreating="EntityDataSourceProgram_ContextCreating"></asp:EntityDataSource>
    <br />
    Pilih Program :
    <asp:DropDownList ID="DropDownListProgram" runat="server" DataSourceID="EntityDataSourceProgram" DataTextField="kode_program" DataValueField="kode_program" AutoPostBack="True"></asp:DropDownList>
    <asp:EntityDataSource ID="EntityDataSourceMatakuliah" runat="server" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" EnableFlattening="False" EntitySetName="matakuliahs" OnContextCreating="EntityDataSourceMatakuliah_ContextCreating" AutoGenerateWhereClause="True" EnableInsert="True" Where="" ConnectionString="name=akademik_dbEntities" DefaultContainerName="akademik_dbEntities" EnableDelete="True" EnableUpdate="True">
        <WhereParameters>
            <asp:ControlParameter ControlID="DropDownListProgram" Name="kode_program" PropertyName="SelectedValue" Type="String" />
        </WhereParameters>
    </asp:EntityDataSource>
    <asp:GridView ID="GridViewMatakuliah" runat="server" AutoGenerateColumns="False" DataKeyNames="kode_matakuliah" DataSourceID="EntityDataSourceMatakuliah" AllowPaging="True" BackColor="Black" ForeColor="White">
        <Columns>
            <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowSelectButton="True" />
            <asp:TemplateField HeaderText="kode_matakuliah" SortExpression="kode_matakuliah">
                <EditItemTemplate>
                   <asp:DynamicControl ID="KodeMatakuliahTextBox" runat="server" DataField="kode_matakuliah" Mode="Edit" />
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="KodeMatakuliahLabel" runat="server" DataField="kode_matakuliah" Mode="ReadOnly" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="kode_program" SortExpression="kode_program">
                <EditItemTemplate>
                    <asp:DynamicControl ID="KodeProgramTextBox" runat="server" DataField="kode_program" Mode="Edit" />
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="KodeProgramLabel" runat="server" DataField="kode_program" Mode="ReadOnly" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="nama_matakuliah" SortExpression="nama_matakuliah">
                <EditItemTemplate>
                    <asp:DynamicControl ID="NamaMatakuliahTextBox" runat="server" DataField="nama_matakuliah" Mode="Edit" />
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="NamaMatakuliahLabel" runat="server" DataField="nama_matakuliah" Mode="ReadOnly" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="sks" SortExpression="sks">
                <EditItemTemplate>
                    <asp:DynamicControl ID="SksTextBox" runat="server" DataField="sks" Mode="Edit" />
                </EditItemTemplate>
                <ItemTemplate>
                     <asp:DynamicControl ID="SksLabel" runat="server" DataField="sks" Mode="ReadOnly" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="semester" SortExpression="semester">
                <EditItemTemplate>
                    <asp:DynamicControl ID="SemesterTextBox" runat="server" DataField="semester" Mode="Edit" />
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:DynamicControl ID="SemesterLabel" runat="server" DataField="semester" Mode="ReadOnly" />
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
        <HeaderStyle BackColor="Gray" />
    </asp:GridView>
    <asp:ValidationSummary ID="ValidationSummaryMatakuliah" runat="server" ShowSummary="true" DisplayMode="BulletList" Style="color: red"/>

    <h2>Pencarian Mata Kuliah</h2>
    Masukan Mata Kuliah <asp:TextBox ID="CariTextBox" runat="server"></asp:TextBox> 
    <asp:Button ID="CariButton" runat="server" Text="Cari" />
    <asp:EntityDataSource ID="EntityDataSourceCari" runat="server" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" EnableFlattening="False" EntitySetName="matakuliahs" Include="program" OnContextCreating="EntityDataSourceCari_ContextCreating" ConnectionString="name=akademik_dbEntities" DefaultContainerName="akademik_dbEntities"></asp:EntityDataSource>
    <asp:QueryExtender ID="QueryExtenderCari" runat="server" TargetControlID="EntityDataSourceCari">
        <asp:SearchExpression SearchType="Contains" DataFields="nama_matakuliah">
            <asp:ControlParameter ControlID="CariTextBox" />
        </asp:SearchExpression>
        <asp:OrderByExpression DataField="Program.nama_program" Direction="Ascending">
            <asp:ThenBy DataField="nama_matakuliah" Direction="Ascending" />
        </asp:OrderByExpression>
    </asp:QueryExtender>

    <asp:GridView ID="GridViewCari" runat="server" AutoGenerateColumns="False" DataKeyNames="kode_matakuliah" DataSourceID="EntityDataSourceCari" AllowPaging="true">
        <Columns>
            <asp:BoundField DataField="kode_program" HeaderText="Kode Program" SortExpression="kode_program" />
            <asp:BoundField DataField="kode_matakuliah" HeaderText="Kode Matakuliah" ReadOnly="True" SortExpression="kode_matakuliah" />
            <asp:BoundField DataField="nama_matakuliah" HeaderText="Matakuliah" SortExpression="nama_matakuliah" />
            <asp:BoundField DataField="sks" HeaderText="SKS" SortExpression="sks" />
            <asp:BoundField DataField="semester" HeaderText="Semester" SortExpression="semester" />
        </Columns>
    </asp:GridView>

</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">
</asp:Content>
