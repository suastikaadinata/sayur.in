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
                <div class="col-lg-3">
                    <h3>Manage transaksi</h3>
                </div>
                <div class="col-lg-7"></div>
            </div>
        </div>
    </div>
    <div class="section-content">
        <div class="container">
            <div class="row">
            @for($i = 0; $i < 6; $i++)
                <div class="col-lg-12">
                    <div class="manage-sayur-container">
                        <a href="/manage-transaksi/detail-transaksi" style="text-decoration: none;" >
                        <div class="row">
                        <div class="col-lg-2">
                        <span style="margin-top: 15px; color: #e67e22; font-weight: bold;">nama</span>
                        <br>
                         <span style="margin-top: 15px; color: #e67e22">083111</span>
                         <br>
                         <span style="margin-top: 15px; color: #e67e22">@gmail.com</span>
                        </div>
                        <div class="col-lg-8"></div>
                        <div class="col-lg-2 text-right">
                        <span style="margin-top: 15px; color: #e67e22; font-weight: bold; ">Total transaksi</span> 
                        <br>
                        <span style="margin-top: 15px; color: #e67e22 ">30000</span>
                        <br>
                        <span style="margin-top: 15px; color: #e67e22 ">Pengiriman</span>
                    </div>
                    </div>
                        </a>
                        
                    </div>
                </div>
               @endfor
            </div>
        </div>
    </div>  
@endsection