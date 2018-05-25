@extends('layout')

@section('title', 'Manage User')

@section('content')
    <div style="margin-bottom: 20px;" class="all-header">
        <div class="container">
            <div class="row">
                <div style="margin-bottom: 20px;"class="col-lg-6">
                    <h1>Manage User</h1>
                </div>
                <div class="col-lg-2"></div>
                <div class="col-lg-4 manage-sayur-header-search">
                    <div class="input-group">
                        <input type="text" class="form-control input-lg" name="search" id="search" required autofocus placeholder="Cari user...">
                        <span class="input-group-btn">
                            <button class="btn btn-default btn-lg submit-btn" type="submit">
                                <img src="{{ asset('img/search.png') }}">
                            </button>
                        </span>                     
                    </div>  
                </div>
                <div class="col-lg-12">
                    <h3>User</h3>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="table-responsive-lg">
            <table style="text-align: center;" class="table table-bordered table-hover table-light">
                <thead>
                    <tr class="table-success">
                        <th scope="col">Nama</th>
                        <th scope="col">Email</th>
                        <th scope="col">No Telp</th>
                    </tr>
                </thead>
                <tbody>
                @for($i = 0; $i < 6; $i++)
                    <tr>
                        <td>Suastika Adinata</td>
                        <td>suastika@gmail.com</td>
                        <td>081333111</td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
    </div>
@endsection