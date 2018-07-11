<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>@yield('title') - {{ config('app.name') }}</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">

    
    <link href="https://fonts.googleapis.com/css?family=Cabin:400,600|Raleway:400,700" rel="stylesheet">
    <link rel="stylesheet" href="{{ asset('/css/bootstrap.min.css') }}">
    <link rel="stylesheet" href="{{ asset('/css/style.css') }}">
    
<body>
    <header>
        <div class="row">
            <div class="col-lg-1">
                <a href="/"><img src="{{ asset('img/logo.png') }}" style="width: 30px; margin: 0px 20px 20px 20px"></a>
            </div>
            <div class="col-lg-8"></div>
            <div class="col-lg-3">
                <a href="/chat"><img src="{{ asset('img/notification.png') }}" style="width: 50px; margin: 10px 20px 20px 20px; float: left; "></a> 
                 <div class="btn-group" style="margin-top: 15px">
  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Hello {{ Auth::User()->name }}
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="/logout">Logout</a>
  </div>
</div>

            </div>
            
        </div>  
</div>
    </header>
    <section>
        <div class="row">
            <div class="col-lg-2">
                <div class="section-left-side">
                    <a href="/manage-sayur"><h5>Manage Sayur</h5></a>
                    <a href="/manage-user"><h5>Manage User</h5></a>
                    <a href="/manage-transaksi"><h5>Manage Transaksi</h5></a>
                </div>
            </div>
            <div class="col-lg-10">
                <div class="section-core">
                    @yield('content')
                </div>
            </div>
        </div>
    </section>
    <footer>
        <h1>Copyright sayur.in 2018</h1>
    </footer>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="{{ asset('/js/manage-sayur.js') }}"></script>

</html>