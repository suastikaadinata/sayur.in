<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>@yield('title') - {{ config('app.name') }}</title>
    <link href="https://fonts.googleapis.com/css?family=Cabin:400,600|Raleway:400,700" rel="stylesheet">
    <link rel="stylesheet" href="{{ asset('/css/bootstrap.min.css') }}">
    <link rel="stylesheet" href="{{ asset('/css/style.css') }}">
</head>
<body>
    <header>
    </header>
    <section>
        <div class="row">
            <div class="col-lg-2">
                <div class="section-left-side">
                    <a href="/"><h5>Home</h5></a>
                    <a href="/manage-sayur"><h5>Manage Sayur</h5></a>
                    <a href="/manage-user"><h5>Manage User</h5></a>
                    <a href=""><h5>Manage Transaksi</h5></a>
                    <a href="/logout"><h5>Logout</h5></a>
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
<script src="{{ asset('/js/jquery.min.js') }}"></script>
<script src="{{ asset('/js/bootstrap.min.js') }}"></script>
<script src="{{ asset('/js/manage-sayur.js') }}"></script>
</html>