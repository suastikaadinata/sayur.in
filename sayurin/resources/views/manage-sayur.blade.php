@extends('layout')

@section('title', 'Manage Sayur')

@section('content')
    <div style="margin-bottom: 20px;" class="all-header">
        <div class="container">
            <div class="row">
                <div style="margin-bottom: 20px;"class="col-lg-6">
                    <h1>Manage Sayur</h1>
                </div>
                <div class="col-lg-2"></div>
                <div class="col-lg-4 manage-sayur-header-search">
                    <div class="input-group">
                        <input type="text" class="form-control input-lg" name="search" id="search" required autofocus placeholder="Cari sayur...">
                        <span class="input-group-btn">
                            <button class="btn btn-default btn-lg submit-btn" type="submit">
                                <img src="{{ asset('img/search.png') }}">
                            </button>
                        </span>                     
                    </div>  
                </div>
                <div class="col-lg-2">
                    <h3>Sayuran</h3>
                </div>
                <div class="col-lg-3">
                    <a href="/"><button class="btn btn-default btn-lg">
                        Tambah Sayuran
                    </button></a>
                </div>
                <div class="col-lg-7"></div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            @for($i = 0; $i < 12; $i++)
            <div class="col-lg-3">
                <div class="manage-sayur-container">
                    <h4 style="text-align: center;">Bayam</h4>
                    <div class="sayur-home-img" style="background-image: url({{ asset('img/sayur1.png') }})"></div>
                    <h5 style="margin-top: 15px; color: #e67e22">Stok: 20</h5>
                    <h6>Kuantitas: 1 ikat</h6>
                    <h6>Harga: Rp. 12.000</h6>
                </div>
            </div>
            @endfor
        </div>
    </div>
@endsection