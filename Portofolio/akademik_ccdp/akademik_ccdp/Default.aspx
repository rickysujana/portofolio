<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="akademik_ccdp._Default" %>

<asp:Content runat="server" ID="FeaturedContent" ContentPlaceHolderID="FeaturedContent">
    <section class="featured">
        <div class="content-wrapper">
            <hgroup class="title">
                <%--<h1><%: Title %>.</h1>--%>
                <h2>Merupakan aplikasi pengolahan data berbasis web untuk mengolah data Akademik CCDP Program</h2>
            </hgroup>
            <p>
                Data Akademik yang diolah meliputi data mahasiswa, mata kuliah dan instruktur
            </p>
        </div>
    </section>
</asp:Content>
<asp:Content runat="server" ID="BodyContent" ContentPlaceHolderID="MainContent">
    <h3>Aplikasi memiliki beberapa menu utama, diantaranya:</h3>
    <ol class="round">
        <li class="one">
            <h5>Mahasiswa</h5>
            Menu Mahasiswa digunakan untuk menambahkan data mahasiswa.
        </li>
        <li class="two">
            <h5>Mata Kuliah</h5>
            Menu Mata Kuliah digunakan untuk menambahkan data mata kuliah.
        </li>
        <li class="three">
            <h5>Instruktur</h5>
            Menu Instruktur digunakan menyimpan data pengajaran dan penugasan instruktur.
        </li>
    </ol>
</asp:Content>
