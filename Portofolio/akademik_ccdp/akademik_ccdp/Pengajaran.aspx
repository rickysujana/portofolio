<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Pengajaran.aspx.cs" Inherits="akademik_ccdp.Pengajaran" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">

    <h2>Pengajaran</h2>
    <asp:EntityDataSource ID="EntityDataSourcePengajaran" runat="server" EnableFlattening="False" EntitySetName="pengajarans" Include="matakuliah" EnableInsert="True" EnableUpdate="True" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" OnContextCreating="EntityDataSourcePengajaran_ContextCreating"></asp:EntityDataSource>
    <asp:GridView ID="GridViewPengajaran" runat="server" AllowPaging="True" AllowSorting="True" AutoGenerateColumns="False" DataKeyNames="kode_pengajaran" DataSourceID="EntityDataSourcePengajaran" OnRowUpdating="GridViewPengajaran_RowUpdating" OnSelectedIndexChanged="GridViewPengajaran_SelectedIndexChanged">
        <Columns>
            <asp:CommandField ShowEditButton="True" ShowSelectButton="True" />
            <asp:TemplateField HeaderText="Kode Pengajaran" SortExpression="kode_pengajaran">
                <EditItemTemplate>
                    <asp:Label ID="Label1" runat="server" Text='<%# Bind("kode_pengajaran") %>'></asp:Label>
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label1" runat="server" Text='<%# Eval("kode_pengajaran") %>' Width="9em"></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Kode Instruktur" SortExpression="kode_instruktur">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("kode_instruktur") %>'></asp:TextBox>
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label2" runat="server" Text='<%# Eval("kode_instruktur") %>' Width="8em"></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Mata Kuliah" SortExpression="kode_matakuliah">
                <EditItemTemplate>
                    <asp:TextBox ID="NamaMatakuliahTextBox" runat="server" Text='<%# Eval("matakuliah.nama_matakuliah") %>' OnInit="NamaMatakuliahTextBox_Init"></asp:TextBox>
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="NamaMatakuliahLabel" runat="server" Text='<%# Eval("matakuliah.nama_matakuliah") %>' Width="15em"></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
        <SelectedRowStyle BackColor="#FF9933" />
    </asp:GridView>
    <asp:Label ID="ErrorMsgLabel" runat="server" Text="" Visible="false" ViewStateMode="Disabled"></asp:Label>
    <br />
    <br />
    <h2>Detail Mata Kuliah</h2>
     <asp:EntityDataSource ID="EntityDataSourceMatakuliah"   runat="server" EnableFlattening="False" EntitySetName="matakuliahs" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" Where="@KodeMatakuliah IN (SELECT VALUE kuliah.kode_pengajaran   FROM it.pengajarans AS kuliah)" OnContextCreating="EntityDataSourceMatakuliah_ContextCreating">
         <WhereParameters>
             <asp:ControlParameter ControlID="GridViewPengajaran" Name="KodeMatakuliah" PropertyName="SelectedValue" Type="Int32" />
         </WhereParameters> 
     </asp:EntityDataSource> 
    <asp:GridView ID="GridViewMatakuliah" runat="server" AllowSorting="True" AutoGenerateColumns="false" DataSourceID="EntityDataSourceMatakuliah" SelectedRowStyle-BackColor="#FF9908" DataKeyNames="kode_matakuliah">
        <EmptyDataTemplate>
            <p>Tidak Ada Mata Kuliah.</p>
        </EmptyDataTemplate>

        <Columns>
            <asp:CommandField ShowSelectButton="True" />           
                <asp:BoundField DataField="kode_matakuliah" HeaderText="Kode Mata Kuliah" 
                    ReadOnly="True" SortExpression="kode_matakuliah" HeaderStyle-Width="10em"      
                    ItemStyle-HorizontalAlign="Center"  /> 
                <asp:BoundField DataField="kode_program" HeaderText="Program"      
                    SortExpression="kode_program" HeaderStyle-Width="5em" ItemStyle-HorizontalAlign="Center" 
                    HeaderStyle-HorizontalAlign="Center" /> 
                <asp:BoundField DataField="nama_matakuliah" HeaderText="Mata Kuliah" 
                    SortExpression="nama_matakuliah" HeaderStyle-Width="15em" 
                    ItemStyle-HorizontalAlign="Center" HeaderStyle-HorizontalAlign="Center" /> 
                <asp:BoundField DataField="sks" HeaderText="SKS" SortExpression="sks" 
                    HeaderStyle-Width="5em" ItemStyle-HorizontalAlign="Center" 
                    HeaderStyle-HorizontalAlign="Center" />
                 <asp:BoundField DataField="semester" HeaderText="Semester" SortExpression="semester" 
                     HeaderStyle-Width="7em" ItemStyle-HorizontalAlign="Center" 
                     HeaderStyle-HorizontalAlign="Center" />    
        </Columns>
            <SelectedRowStyle BackColor="#FF9908" ></SelectedRowStyle>
    </asp:GridView> 
    <h2>Detail Instruktur</h2>
    <asp:EntityDataSource ID="EntityDataSourceInstruktur" runat="server" EnableFlattening="False" EntitySetName="instrukturs" OnSelected="EntityDataSourceInstruktur_Selected" Where="@KodeInstruktur IN (SELECT VALUE kuliah.kode_pengajaran  FROM it.pengajarans AS kuliah)" OnContextCreating="EntityDataSourceInstruktur_ContextCreating" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities">
        <WhereParameters>          
            <asp:ControlParameter ControlID="GridViewPengajaran" Name="KodeInstruktur" PropertyName="SelectedValue" Type="Int32" />        
        </WhereParameters>     
    </asp:EntityDataSource> 
    <asp:DetailsView ID="DetailsViewInsruktur" runat="server" Height="50px" Width="200px" AutoGenerateRows="False" 
        DataKeyNames="kode_instruktur" DataSourceID="EntityDataSourceInstruktur">      
        <EmptyDataTemplate>      
            <p>Tidak ada data instruktur.</p>     
        </EmptyDataTemplate>     
        <Fields>      
            <asp:BoundField DataField="kode_instruktur" HeaderText="Kode Instruktur" ReadOnly="True" SortExpression="kode_instruktur" HeaderStyle-Width="200px" HeaderStyle-Wrap="False" 
                HeaderStyle-BorderWidth="1px" HeaderStyle-BorderColor="#CC6600" ItemStyle-BorderColor="#CC6600" ItemStyle-BorderWidth="1px"     
                ItemStyle-Wrap="False" ItemStyle-Width="200px" />         
            <asp:BoundField DataField="nama" HeaderText="Nama" SortExpression="nama" HeaderStyle-Wrap="False" HeaderStyle-BorderWidth="1px" 
                HeaderStyle-BorderColor="#CC6600" ItemStyle-BorderColor="#CC6600" ItemStyle-BorderWidth="1px" 
                ItemStyle-Wrap="False" />        
            <asp:BoundField DataField="alamat" HeaderText="Alamat" SortExpression="alamat" HeaderStyle-Wrap="False" HeaderStyle-BorderWidth="1px" 
                HeaderStyle-BorderColor="#CC6600" ItemStyle-BorderColor="#CC6600" ItemStyle-BorderWidth="1px" ItemStyle-Wrap="False" />       
            <asp:BoundField DataField="telp" HeaderText="Telp" SortExpression="telp" HeaderStyle-Wrap="False" HeaderStyle-BorderWidth="1px" 
                HeaderStyle-BorderColor="#CC6600" ItemStyle-BorderColor="#CC6600" ItemStyle-BorderWidth="1px" ItemStyle-Wrap="False" />    
        </Fields> 
    </asp:DetailsView> 
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">
</asp:Content>
