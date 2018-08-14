@extends('layout')

@section('title', 'Home Sayur')

@section('content')
    <div class="all-header">
        <div class="container">
            <h2 style="margin-left: 20px; padding-top: 20px;">Halaman utama</h2>
        </div>
    </div>
    <div class="section-content">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="status-pesanan-container">
                        <img src="{{ asset('img/transaksi-wait.png') }}" style="width: 60px; float: left; margin: 0px 5px 10px 5px;">
                        <h4>10 Pesanan 
                            <br>
                        belum dibayar</h4>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="status-pesanan-container">
                        <img src="{{ asset('img/success-ok.png') }}" style="width: 60px; float: left; margin: 0px 5px 10px 5px;">
                        <h4>9 
                            <br>
                        Transaksi sukses</h4>
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
                        <table class="table table-borderless" style="text-align: center; color: #e67e22" >
                            <thead>
                                <tr>
                                    <th scope="col">Stok</th>
                                    <th scope="col">Satuan</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr >
                                    <td>{{ $s->jumlah }}</td>
                                    <td>{{ $s->berat }}</td>
                                </tr>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="2">Rp. {{ $s->harga }} ,-</td>
                                </tr>
                            </tfoot>

                        </table>
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