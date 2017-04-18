<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="tambah_matakuliah.aspx.cs" Inherits="akademik_ccdp.tambah_matakuliah" %>
<asp:Content ID="Content1" ContentPlaceHolderID="HeadContent" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
    <h2>Tambah Mata Kuliah</h2>    
    <asp:EntityDataSource ID="EntityDataSourceMatakuliah" runat="server" EnableFlattening="False" EntitySetName="matakuliahs" EnableDelete="True" EnableInsert="True" ContextTypeName="akademik_ccdp.DAL.akademik_dbEntities" OnContextCreating="EntityDataSourceMatakuliah_ContextCreating" >  
    </asp:EntityDataSource>
     <asp:DetailsView ID="DetailsViewMatakuliah" runat="server" Height="50px" Width="532px" AutoGenerateRows="False" DataKeyNames="kode_matakuliah"    
         DataSourceID="EntityDataSourceMatakuliah" DefaultMode="Insert"    
         OnItemInserting="DetailsViewMatakuliah_ItemInserting"    
         GridLines="None" >
         
         <Fields>          
             <asp:TemplateField HeaderText="Kode Mata Kuliah" SortExpression="kode_matakuliah">
                 <InsertItemTemplate>
                     <asp:DynamicControl ID="KodeMatakuliahTextBox" runat="server" DataField="kode_matakuliah" Mode="Edit" /> 
                 </InsertItemTemplate>
                 <ItemTemplate>
                     <asp:Label ID="Label1" runat="server" Text='<%# Bind("kode_matakuliah") %>'></asp:Label>
                 </ItemTemplate>
             </asp:TemplateField>
              <asp:TemplateField HeaderText="Program" SortExpression="kode_program"> 
                  <InsertItemTemplate>      
                      <asp:EntityDataSource ID="EntityDataSourceProgram" runat="server" EnableDelete="True" EnableFlattening="False" EntitySetName="programs" EntityTypeFilter="program"        
                          ConnectionString="akademik_ccdp.DAL.akademik_dbEntities" OnContextCreating="EntityDataSourceProgram_ContextCreating" >      
                      </asp:EntityDataSource>                    
                      <asp:DropDownList ID="DropDownListProgram" runat="server" DataSourceID="EntityDataSourceProgram" DataTextField="kode_program" DataValueField="kode_program" 
                          OnInit="DropDownListProgram_Init">
                      </asp:DropDownList>           
                  </InsertItemTemplate>          
              </asp:TemplateField>             
             <asp:BoundField DataField="nama_matakuliah" HeaderText="Nama Mata Kuliah"      
                 SortExpression="nama_matakuliah" />   
             <asp:BoundField DataField="sks" HeaderText="SKS" SortExpression="sks" />         
             <asp:BoundField DataField="semester" HeaderText="Semester" SortExpression="semester" />        
             <asp:CommandField ShowInsertButton="True" />      
         </Fields>  
     </asp:DetailsView>
    <asp:ValidationSummary ID="ValidationSummaryMatakuliah" runat="server" ShowSummary="true" DisplayMode="BulletList" Style="color: red"/>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="MainContent" runat="server">
</asp:Content>
