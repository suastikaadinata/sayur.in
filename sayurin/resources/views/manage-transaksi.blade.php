@extends('layout')

@section('title', 'Manage Sayur')

@section('content')
    <div style="margin-bottom: 20px;" class="all-header">
        <div class="container">
            <div class="row">
                <div style="margin-bottom: 20px;"class="col-lg-6">
                    <h1>Manage Transaksi</h1>
                </div>
                <div class="col-lg-2"></div>
                    <div class="col-lg-4 manage-sayur-header-search">
                        <form action="/manage-sayur/search" method="GET">
                            <div class="input-group">
                                <input type="text" class="form-control input-lg" name="search" id="search" required autofocus placeholder="Cari sayur...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default btn-lg btn-modif submit-btn" type="submit">
                                        <img src="{{ asset('img/search.png') }}">
                                    </button>
                                </span>                     
                            </div> 
                        </form> 
                    </div>  
                <div class="col-lg-7"></div>
            </div>
        </div>
    </div>
    <div class="section-content">
        <div class="container">
            <table style="text-align: center;" class="table table-bordered table-hover table-light table-striped" >
                    <thead>
                        <tr class="table-success">
                            <th scope="col">Nama</th>
                            <th scope="col">Jumlah</th>
                            <th scope="col">Total belanja</th>
                        </tr>
                    </thead>
                    <tbody>
                    @for($i = 0; $i < 6; $i++)
                        <tr>
                            <td><a href="/manage-transaksi/detail-transaksi" style="text-decoration:none; color: black;">Suastika Adinata</a> </td>
                            <td><a href="/manage-transaksi/detail-transaksi" style="text-decoration: none; color: black;">3</a></td>
                            <td><a href="/manage-transaksi/detail-transaksi" style="text-decoration:none; color: black;">15000</a></td>
                        </tr>
                    @endfor
                    </a>
                    </tbody>
                </table>
        </div>
    </div> 
    
@endsection