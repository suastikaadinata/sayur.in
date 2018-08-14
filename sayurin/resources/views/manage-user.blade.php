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
                    <form action="/manage-user/search" method="GET">
                        <div class="input-group">
                            <input type="text" class="form-control input-lg" name="search" id="search" required autofocus placeholder="Cari user...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default btn-lg btn-modif submit-btn" type="submit">
                                        <img src="{{ asset('img/search.png') }}">
                                    </button>
                                </span>                     
                        </div>  
                    </form>
                </div>
                <div class="col-lg-12">
                    <h3>User</h3>
                </div>
            </div>
        </div>
    </div>
    <div class="section-content">
        <div class="container">
            <div class="table-responsive-lg">
                <table style="text-align: center;" class="table table-bordered table-hover table-light">
                    <thead>
                        <tr class="table-success">
                            <th scope="col">Nama</th>
                            <th scope="col">Email</th>
                            <th scope="col">No Telp</th>
                            <th scope="col">Hapus</th>
                        </tr>
                    </thead>
                    <tbody>
                    @foreach($user as $u)
                        <tr>
                            <td>{{ $u->name }}</td>
                            <td>{{ $u->email }}</td>
                            <td>{{ $u->nomor_telepon }}</td>
                            <td><button data-id="{{ $u->id }}" class="btn btn-default hapus-user-btn" data-toggle="modal" 
                                data-target=".hapus-user" style="background-color: #e67e22; color: white;">
                                Hapus
                            </button></td>
                        </tr>
                    @endforeach
                    </tbody>
                </table>
                
                    <div class="modal fade hapus-user" role="dialog" style="position: fixed; top: 50%;left: 50%;
                        transform: translate(-50%, -50%);
                        ">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title"></h4>
                                </div>
                                <div class="modal-body">
                                    <p>anda yakin ingin menghapus user ini</p>
                                </div>
                                <div class="modal-footer">
                                    <form data-url="{{ url('/manage-user/delete') }}" method="POST" action="">
                                        {{ csrf_field() }}
                                        <button type="submit" class="btn btn-default">
                                            Yakin
                                        </button>
                                        <button type="button" class="btn btn-default btn-warning" data-dismiss="modal">Batal</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>      
@endsection