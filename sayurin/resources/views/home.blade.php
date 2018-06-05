@extends('layout')

@section('title', 'Home Sayur')

@section('content')
    <div class="all-header">
        <div class="container">
            <h1 style="margin-left: 20px;">Home</h1>
        </div>
    </div>
    <div class="section-content">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="status-pesanan-container">
                        <h4>10 Pesanan menunggu pembayaran</h4>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="status-pesanan-container">
                        <h4>9 Menunggu kiriman</h4>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="status-pesanan-container">
                        <h4>10 Pemesanan Selesai</h4>
                    </div>
                </div>
            </div>
            <h3 style="margin-top: 30px; margin-bottom: 15px;">Sisa Sayur</h3>
            <div class="row">
                @foreach($sayur as $s)
                <div class="col-lg-3">
                    <div class="sayur-home-container">
                        <h4 style="text-align: center;">{{ $s->nama }}</h4>
                        <div class="sayur-home-img" style="background-image: url({{ $s->foto() }})"></div>
                        <h5 style="margin-top: 15px; color: #e67e22">Stok: {{ $s->jumlah }}</h5>
                        <h6>Kuantitas: {{ $s->berat }}</h6>
                        <h6>Harga: Rp. {{ $s->harga }}</h6>
                    </div>
                </div>
                @endforeach
            </div>
            <h3 style="margin-top: 30px; margin-bottom: 15px;">User Terbaru</h3>
            <div class="row">
                @for($i = 0; $i < 4; $i++)
                <div class="col-lg-3">
                    <div class="user-home-container">
                        <div class="user-home-img" style="background-image: url({{ asset('img/atomix_user31.png') }})"></div>
                        <h5 style="margin-top: 15px;">Username</h5>
                    </div>
                </div>
                @endfor
            </div>
        </div>
    </div>
@endsection